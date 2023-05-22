import sys
import os
import sqlite3
import time

import requests
import asyncio
import aiohttp
from .config import default_config as config
from .login import login
from .extractor import extractor
from .utils import handle_tasks
from .node import info_node, problem_info_node, problem_desc_node, submission_node
from .constants import PROBLEMS, HEADERS, GRAPHQL, CODE_FORMAT, SQLITE3
from .db import db
import shutil
from mysql.connector.errors import ProgrammingError


class problems:
    """核心逻辑"""

    def __init__(self):
        self.login = login(config.leetcode_user_name, config.leetcode_user_password)
        self.__cookies = self.login.cookies
        self.problems_json = self.__get_problems_json()
        self.db = db()
        self.sql_placeholder = "?" if self.db.type == SQLITE3 else "%s"

    def __get_problems_json(self):
        resp = requests.get(PROBLEMS, headers=HEADERS, cookies=self.__cookies)
        if resp.status_code == 200:
            return resp.json()

    @property
    def info(self):
        """获取用户基本信息"""
        return info_node(self.problems_json)

    def __dict_factory(self, cursor, row):
        """修改 SQLite 数据呈现方式"""
        d = {}
        for idx, col in enumerate(cursor.description):
            d[col[0]] = row[idx]
        return d

    def update_problems_info(self):
        """更新问题基本信息"""
        problems_list = self.problems_json.get('stat_status_pairs')
        # 清理数据
        conn = self.db.create_conn()
        cursor = conn.cursor()
        cursor.execute('delete from problem')
        # 重新写入数据
        for problem in problems_list:
            p = problem_info_node(problem)
            cursor.execute(
                '''
                INSERT INTO problem (
                    id, frontend_id, title_en, title_slug, difficulty, 
                    paid_only, is_favor, status, total_acs, total_submitted, 
                    ac_rate
                )
                VALUES (
                    {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}
                )
                '''.format(self.sql_placeholder), (p.id, p.frontend_id, p.title_en, p.title_slug,
                                                   p.difficulty if p.difficulty else None,
                                                   p.paid_only, p.is_favor , p.status,
                                                   p.total_acs if p.total_acs else None,
                                                   p.total_submitted if p.total_submitted else None,
                                                   p.ac_rate))
        conn.commit()
        conn.close()

    async def __get_problem_desc(self, title_slug):
        # 获取题目表述
        payload = {
            'query': '''
            query questionData($titleSlug: String!) {
                question(titleSlug: $titleSlug) {
                    questionId
                    content
                    translatedTitle
                    translatedContent
                    similarQuestions
                    topicTags {
                        name
                        slug
                        translatedName
                    }
                    hints
                }
            }
            ''',
            'operationName': 'questionData',
            'variables': {
                'titleSlug': title_slug
            }
        }
        async with aiohttp.ClientSession(cookies=self.__cookies) as session:
            async with session.post(GRAPHQL, json=payload,
                                    headers=HEADERS) as resp:
                return await resp.json()

    async def store_problems_desc(self):
        '''存储 AC 问题描述信息'''
        conn = self.db.create_conn()
        cursor = conn.cursor()
        cursor.execute("SELECT title_slug FROM problem WHERE status = 'ac'")
        res = cursor.fetchall()
        if not res:
            return
        loop = asyncio.get_event_loop()
        problems_list = await handle_tasks(
            loop, self.__get_problem_desc, [dict(title_slug=t[0]) for t in res])
        for problem in problems_list:
            p = problem_desc_node(problem)
            if self.db.type == SQLITE3:
                cursor.execute(
                    '''
                    INSERT OR IGNORE INTO description (
                        id, content_en, title_cn, content_cn, 
                        similar_questions_cn, similar_questions_en, 
                        tags_cn, tags_en
                    )
                    VALUES (
                        {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}
                    )
                    '''.format(self.sql_placeholder), (p.id, p.content_en, p.title_cn, p.content_cn,
                          p.similar_questions_cn, p.similar_questions_en,
                          p.tags_cn, p.tags_en))
            else:
                cursor.execute(
                    '''
                    INSERT IGNORE INTO description (
                        id, content_en, title_cn, content_cn, 
                        similar_questions_cn, similar_questions_en, 
                        tags_cn, tags_en
                    )
                    VALUES (
                        {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}
                    )
                    '''.format(self.sql_placeholder), (p.id, p.content_en, p.title_cn, p.content_cn,
                          p.similar_questions_cn, p.similar_questions_en,
                          p.tags_cn, p.tags_en))
        conn.commit()
        conn.close()

    def update_problems_desc(self):
        conn = self.db.create_conn()
        cursor = conn.cursor()
        cursor.execute('UPDATE description SET d_stored=1')
        conn.commit()
        conn.close()

    async def __get_submissions(self, title_slug, offset=0, limit=500):
        payload = {
            'query': '''
            query submissions($offset: Int!, $limit: Int!, $lastKey: String, $questionSlug: String!) {
                submissionList(offset: $offset, limit: $limit, lastKey: $lastKey, questionSlug: $questionSlug) {
                    lastKey
                    hasNext
                    submissions {
                        id
                        statusDisplay
                        lang
                        runtime
                        timestamp
                        url
                        isPending
                        memory
                        __typename
                    }
                __typename
                }
            }
            ''',
            'operationName': 'submissions',
            'variables': {
                'limit': limit,
                'offset': offset,
                'questionSlug': title_slug
            }
        }
        async with aiohttp.ClientSession(cookies=self.__cookies) as session:
            async with session.post(GRAPHQL, json=payload,
                                    headers=HEADERS) as resp:
                return await resp.json(), title_slug

    async def __get_code(self, qid, lang):
        url = CODE_FORMAT.format(qid, lang)
        async with aiohttp.ClientSession(cookies=self.__cookies) as session:
            async with session.get(url, headers=HEADERS) as resp:
                return await resp.json(), qid, lang

    async def store_submissions(self):
        '''存储提交的代码信息'''
        conn = self.db.create_conn()
        cursor = conn.cursor()
        cursor.execute("SELECT title_slug FROM problem WHERE status = 'ac'")
        res = cursor.fetchall()
        if not res:
            return
        loop = asyncio.get_event_loop()
        submissions_list = await handle_tasks(
            loop, self.__get_submissions, [dict(title_slug=t[0]) for t in res])
        data = []
        for submissions, title_slug in submissions_list:
            dic = set()
            for submission in submissions['data']['submissionList'][
                'submissions']:
                status = submission['statusDisplay']
                key = submission['lang']
                if status == 'Accepted' and key not in dic:
                    data.append(submission)
                    data[-1]['title_slug'] = title_slug
                    dic.add(key)
        for submission in data:
            s = submission_node(submission)
            if self.db.type == SQLITE3:
                cursor.execute(
                    '''
                    INSERT OR IGNORE INTO submission (
                        submission_id, lang, language, memory, runtime, timestamp, title_slug
                    )
                    VALUES (
                        {0}, {0}, {0}, {0}, {0}, {0}, {0}
                    )
                    '''.format(self.sql_placeholder), (s.submission_id, s.lang, s.language, s.memory, s.runtime,
                      s.timestamp, s.title_slug))
            else:
                cursor.execute(
                    '''
                    INSERT IGNORE INTO submission (
                        submission_id, lang, language, memory, runtime, timestamp, title_slug
                    )
                    VALUES (
                        {0}, {0}, {0}, {0}, {0}, {0}, {0}
                    )
                    '''.format(self.sql_placeholder), (s.submission_id, s.lang, s.language, s.memory, s.runtime,
                      s.timestamp, s.title_slug))
        conn.commit()
        conn.close()

    async def store_codes(self):
        '''存储提交的代码'''
        conn = self.db.create_conn()
        cursor = conn.cursor()
        cursor.execute(
            "SELECT p.id, lang FROM submission s LEFT JOIN problem p ON s.title_slug=p.title_slug"
        )
        res = cursor.fetchall()
        if not res:
            return
        loop = asyncio.get_event_loop()
        print("get code size", len(res))
        codes_list = await handle_tasks(
            loop, self.__get_code, [dict(qid=t[0], lang=t[1]) for t in res])
        try:
            cursor.execute("ALTER TABLE submission ADD COLUMN code TEXT")
        except sqlite3.OperationalError:
            pass
        except ProgrammingError:
            pass
        for code, qid, lang in codes_list:
            cursor.execute(
                """
                UPDATE submission SET code = {0}
                WHERE title_slug=(SELECT title_slug
                                FROM problem
                                WHERE id={0})
                AND lang={0}""".format(self.sql_placeholder), (code.get("code", ""), qid, lang))
        conn.commit()
        conn.close()

    def update_submissions(self):
        '''更新处理后的 submission 数据库'''
        conn = self.db.create_conn()
        cursor = conn.cursor()
        cursor.execute('UPDATE submission SET s_stored=1')
        conn.commit()
        conn.close()

    async def update(self):
        '''增量式更新数据'''
        output_dir = os.path.abspath(os.path.join(config.output_dir))
        print("output is ", output_dir)
        if not os.path.exists(output_dir):
            os.makedirs(output_dir)
        extra = extractor(output_dir, config.output_author, config.git_repository, config.git_current_branch)
        self.update_problems_info()
        await self.store_problems_desc()
        print("wait store_problems_desc success")
        await self.store_submissions()
        print("wait store_submissions success")
        await self.store_codes()
        print("wait store_codes success")
        conn = self.db.create_conn()
        if self.db.type == SQLITE3:
            conn.row_factory = self.__dict_factory
        cursor = conn.cursor() if self.db.type == SQLITE3 else conn.cursor(dictionary=True)
        # 获取新的数据
        cursor.execute('''
            SELECT *
            FROM description d
            JOIN problem p
            ON p.id=d.id
            JOIN submission s
            ON p.title_slug=s.title_slug
            WHERE (d.d_stored=0 OR s.s_stored=0)
            ORDER BY p.id DESC
            ''')
        data = cursor.fetchall()
        if data:
            extra.extract_desc(data)
            self.update_problems_desc()
            extra.extract_code(data)
            self.update_submissions()
            await self.store_codes()
            print("wait store_codes success")
        cursor.execute('''
            SELECT *
            FROM description d
            JOIN problem p
            ON p.id=d.id
            JOIN submission s
            ON p.title_slug=s.title_slug
            ORDER BY p.id DESC
            ''')
        data = cursor.fetchall()
        extra.extract_info(self.info, data)
        print('数据已更新！')
        conn.close()

    def clear_db(self):
        '''重建数据'''
        conn = self.db.create_conn()
        cursor = conn.cursor()
        # 删除 problem 表
        cursor.execute('DROP TABLE IF EXISTS problem')
        # 删除 description 表
        cursor.execute('DROP TABLE IF EXISTS description')
        # 删除 submission 表
        cursor.execute('DROP TABLE IF EXISTS submission')
        conn.commit()
        conn.close()

    def init_table(self):
        conn = self.db.create_conn()
        cursor = conn.cursor()
        cursor.execute('''
            CREATE TABLE IF NOT EXISTS problem (
                id INTEGER,
                frontend_id TEXT,
                title_en TEXT,
                title_slug TEXT,
                difficulty INTEGER,
                paid_only {0},
                is_favor {0},
                status TEXT,
                total_acs INTEGER,
                total_submitted INTEGER,
                ac_rate TEXT,
                PRIMARY KEY(id)
            )
            '''.format('INTEGER' if self.db.type == SQLITE3 else 'TEXT'))
        cursor.execute('''
            CREATE TABLE IF NOT EXISTS description (
                id INTEGER,
                content_en TEXT,
                title_cn TEXT,
                content_cn TEXT,
                similar_questions_cn TEXT,
                similar_questions_en TEXT,
                tags_cn TEXT,
                tags_en TEXT,
                d_stored INTEGER DEFAULT 0,
                PRIMARY KEY(id)
            )
            ''')

        cursor.execute('''
                    CREATE TABLE IF NOT EXISTS submission (
                        submission_id INTEGER,
                        lang TEXT,
                        language TEXT,
                        memory TEXT,
                        runtime TEXT,
                        timestamp TEXT,
                        title_slug TEXT,
                        s_stored INTEGER DEFAULT 0,
                        PRIMARY KEY(submission_id)
                    )
                    ''')
        conn.commit()
        conn.close()

    def copy_images(self):
        output_dir = os.path.abspath(os.path.join(config.output_dir, "images"))

        if not os.path.exists(os.path.join(output_dir, "leetcode-logo.png")):
            if not os.path.exists(output_dir):
                print("create dir ", output_dir)
                os.makedirs(output_dir, exist_ok=True)
            source_path = os.path.abspath(os.path.join(
                os.path.dirname(os.path.abspath(__file__)),
                "images", "leetcode-logo.png"))
            shutil.copy(source_path, os.path.join(output_dir, "leetcode-logo.png"))
