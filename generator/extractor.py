import os
import time
import concurrent.futures
from .templates import *
from .constants import *


class extractor:
    """
    高速并发导出数据类
    """

    def __init__(self, output_dir, author, git_repository = None, git_current_branch = None):
        self.output_dir = output_dir
        self.author = author
        self.git_repository = git_repository
        self.git_current_branch = git_current_branch
        self.solutions_md = {}

    def extract_info(self, info, datas):
        """导出 leetcode README 文件"""
        # 当前时间
        cur_time = time.strftime("%Y-%m-%d %H:%M:%S", time.localtime())
        readme_cn_path = os.path.join(self.output_dir, 'README.md')
        with open(readme_cn_path, 'w', encoding='utf-8') as f:
            f.write(
                TEMPLATE_README_CN.format(
                    user_name=info.user_name,
                    num_solved=info.num_solved,
                    num_total=info.num_total,
                    ac_easy=info.ac_easy,
                    ac_medium=info.ac_medium,
                    ac_hard=info.ac_hard,
                    time=cur_time))
            solutions = []
            for i, data in enumerate(datas):
                solutions.append('[{0}](problem_set/{1}/{1}.{2})'.format(
                    data["language"], data["title_slug"],
                    LANGS[data["lang"]]["ext"]))
                title = '[{}](problem_set/{}/README.md)'.format(
                    data["title_cn"], data["title_slug"])
                # 判断同一问题是否有多个解
                if i == len(datas) - 1 or datas[i]['title_en'] != datas[i + 1]['title_en']:
                    f.write(
                        TEMPLATE_README_APPEND.format(
                            frontend_id=data['frontend_id'],
                            title=title,
                            paid_only=data['paid_only'],
                            is_favor=data['is_favor'],
                            solutions='<br>'.join(solutions),
                            ac_rate=data['ac_rate'],
                            difficulty=DIFFICULTY_CN[data['difficulty']],
                            tags=data['tags_cn'].replace('- ', '').replace(
                                '\n', '<br>')))
                    solutions = []
        print(f'{os.path.abspath(readme_cn_path)} done!')
        readme_en_path = os.path.join(self.output_dir, 'README_EN.md')
        with open(readme_en_path, 'w', encoding='utf-8') as f:
            f.write(
                TEMPLATE_README_EN.format(
                    user_name=info.user_name,
                    num_solved=info.num_solved,
                    num_total=info.num_total,
                    ac_easy=info.ac_easy,
                    ac_medium=info.ac_medium,
                    ac_hard=info.ac_hard,
                    time=cur_time))
            solutions = []
            for i, data in enumerate(datas):
                solutions.append('[{0}](problem_set/{1}/{1}.{2})'.format(
                    data["language"], data["title_slug"],
                    LANGS[data["lang"]]["ext"]))
                title = '[{}](problem_set/{}/README_EN.md)'.format(
                    data["title_en"], data["title_slug"])
                if i == len(datas) - 1 or datas[i]['title_en'] != datas[i + 1]['title_en']:
                    f.write(
                        TEMPLATE_README_APPEND.format(
                            frontend_id=data['frontend_id'],
                            title=title,
                            paid_only=data['paid_only'],
                            is_favor=data['is_favor'],
                            solutions='<br>'.join(solutions),
                            ac_rate=data['ac_rate'],
                            difficulty=DIFFICULTY_EN[data['difficulty']],
                            tags=data['tags_en'].replace('- ', '').replace(
                                '\n', '<br>')))
                    solutions = []
        print(f'{os.path.abspath(readme_en_path)} done!')
        if not self.git_current_branch or not self.git_repository:
            return

        readme_cn_blog_path = os.path.join(self.output_dir, 'README_CN_BLOG.md')
        with open(readme_cn_blog_path, 'w+', encoding='utf-8') as f:
            f.write(
                TEMPLATE_README_CN_BLOG.format(
                    user_name=info.user_name,
                    num_solved=info.num_solved,
                    num_total=info.num_total,
                    ac_easy=info.ac_easy,
                    ac_medium=info.ac_medium,
                    ac_hard=info.ac_hard,
                    time=cur_time))
            solutions = []
            for i, data in enumerate(datas):
                solutions.append('[{0}]({3}/blob/{4}/problem_set/{1}/{1}.{2})'.format(
                    data["language"], data["title_slug"],
                    LANGS[data["lang"]]["ext"], self.git_repository, self.git_current_branch))
                title = '[{}]({}/blob/{}/problem_set/{}/README.md)'.format(
                    data["title_cn"], self.git_repository, self.git_current_branch, data["title_slug"])
                # 判断同一问题是否有多个解
                if i == len(datas) - 1 or datas[i]['title_en'] != datas[i + 1]['title_en']:
                    f.write(
                        TEMPLATE_README_APPEND.format(
                            frontend_id=data['frontend_id'],
                            title=title,
                            paid_only=data['paid_only'],
                            is_favor=data['is_favor'],
                            solutions='<br>'.join(solutions),
                            ac_rate=data['ac_rate'],
                            difficulty=DIFFICULTY_CN[data['difficulty']],
                            tags=data['tags_cn'].replace('- ', '').replace(
                                '\n', '<br>')))
                    solutions = []
        print(f'{os.path.abspath(readme_cn_blog_path)} done!')

    def __extract_desc(self, data):
        if data['d_stored'] == 1:
            return
        folder_path = os.path.join(self.output_dir, 'problem_set',
                                   data['title_slug'])
        if not os.path.exists(folder_path):
            # 创建问题文件夹
            os.makedirs(folder_path, exist_ok=True)
        readme_cn_path = os.path.join(folder_path, 'README.md')
        title_cn = '[{}. {}]({})'.format(
            data['frontend_id'], data['title_cn'],
            PROBLEM_FORMAT.format(data['title_slug']))
        solutions = self.solutions_md.get(data['title_en'])
        print("generate", readme_cn_path)
        with open(readme_cn_path, 'w', encoding='utf-8') as f:
            f.write(
                TEMPLATE_DESC_CN.format(
                    title_cn=title_cn,
                    content_cn=data['content_cn'],
                    solutions='\n'.join(solutions),
                    tags_cn=data['tags_cn'],
                    similar_questions_cn=data['similar_questions_cn']))
        print(f'{os.path.abspath(readme_cn_path)} done!')

        readme_en_path = os.path.join(folder_path, 'README_EN.md')
        title_en = '[{}. {}]({})'.format(
            data['frontend_id'], data['title_en'],
            PROBLEM_FORMAT.format(data['title_slug']))
        with open(readme_en_path, 'w', encoding='utf-8') as f:
            f.write(
                TEMPLATE_DESC_EN.format(
                    title_en=title_en,
                    content_en=data['content_en'],
                    solutions='\n'.join(solutions),
                    tags_en=data['tags_en'],
                    similar_questions_en=data['similar_questions_en']))
        print(f'{os.path.abspath(readme_en_path)} done!')

    def extract_desc(self, datas):
        # 缓存题解
        self.extract_code_md(datas)
        """导出问题描述"""
        with concurrent.futures.ThreadPoolExecutor(max_workers=20) as executor:
            # futures = {executor.submit(self.__extractDesc, data): data for data in datas}
            # for future in concurrent.futures.as_completed(futures):
            #     data = futures[future]
            for _ in executor.map(self.__extract_desc, datas):
                pass

    def __extract_code(self, data):
        # 渲染代码模板
        if data['s_stored'] == 1:
            return
        folder_path = os.path.join(self.output_dir, 'problem_set',
                                   data['title_slug'])
        if not os.path.exists(folder_path):
            os.makedirs(folder_path)
        code_path = os.path.join(
            folder_path, f'{data["title_slug"]}.{LANGS[data["lang"]]["ext"]}')
        with open(code_path, 'w', encoding='utf-8') as f:
            f.write(
                TEMPLATE_CODE.format(
                    lang=LANGS[data["lang"]]["lang"],
                    style=LANGS[data['lang']]['style'],
                    title_cn=data['title_cn'],
                    title_en=data['title_en'],
                    author=self.author,
                    timestamp=data['timestamp'],
                    runtime=data['runtime'],
                    memory=data['memory'],
                    code=data['code']))
        print(f'{os.path.abspath(code_path)} done!')

    def extract_code(self, datas):
        """导出代码"""
        with concurrent.futures.ThreadPoolExecutor(max_workers=20) as executor:
            for _ in executor.map(self.__extract_code, datas):
                pass

    def extract_code_md(self, datas):
        for i, data in enumerate(datas):
            try:
                if not self.solutions_md.get(datas[i]['title_en']):
                    self.solutions_md[datas[i]['title_en']] = []
            except Exception as e:
                print(e)
            solutions = self.solutions_md.get(datas[i]['title_en'])
            if data['s_stored'] == 1:
                continue
            solutions.append(TEMPLATE_CODE_IN_DESC_MD.format(
                lang=LANGS[data["lang"]]["lang"],
                style=LANGS[data['lang']]['style'],
                title_cn=data['title_cn'],
                title_en=data['title_en'],
                author=self.author,
                timestamp=data['timestamp'],
                runtime=data['runtime'],
                memory=data['memory'],
                code=data['code']))
            self.solutions_md[datas[i]['title_en']] = solutions
