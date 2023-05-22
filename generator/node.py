import json
import re
import time
from .constants import LANGS, TAG_FORMAT


class problem_info_node:
    """解析问题基本信息"""
    def __init__(self, json_data):
        self.difficulty = json_data['difficulty']['level']
        self.is_favor = self.__form_favor(json_data['is_favor'])
        self.paid_only = self.__form_paid(json_data['paid_only'])
        self.status = json_data['status']
        self.id = json_data['stat']['question_id']
        # self.frontend_id = self.__formId(
        #     json_data['stat']['frontend_question_id'])
        self.frontend_id = json_data['stat']['frontend_question_id']
        self.title_en = json_data['stat']['question__title']
        self.title_slug = json_data['stat']['question__title_slug']
        self.total_acs = json_data['stat']['total_acs']
        self.total_submitted = json_data['stat']['total_submitted']

    @property
    def ac_rate(self):
        return '{:.1%}'.format(self.total_acs / (self.total_submitted + 1))

    def __form_favor(self, is_favor):
        return '❤️' if is_favor else ''

    def __form_paid(self, paid_only):
        return '🔒' if paid_only else ''

    def __form_id(self, id):
        return '{:0>4d}'.format(id)


class problem_desc_node:
    """解析问题描述信息"""
    def __init__(self, json_data):
        self.id = json_data['data']['question']['questionId']
        self.content_en = self.__form_content_en(json_data['data']['question']['content'])
        self.title_cn = json_data['data']['question']['translatedTitle']
        self.content_cn = self.__form_content_cn(json_data['data']['question']['translatedContent'])
        self.similar_questions_cn, self.similar_questions_en = self.__form_similar_questions(
            json_data['data']['question']['similarQuestions'])
        self.tags_cn, self.tags_en = self.__form_tags(json_data['data']['question']['topicTags'])
        # self.hints = '\n'.join(json_data['data']['question']['hints'])

    def __form_similar_questions(self, similar_questions):
        question_list = re.findall(r'{.*?}', similar_questions)
        similar_questions_cn, similar_questions_en = [], []
        if question_list:
            for q in question_list:
                data = json.loads(q)
                similar_questions_cn.append('- [{}](../{}/README.md)'.format(
                    data['translatedTitle'], data['titleSlug']))
                similar_questions_en.append(
                    '- [{}](../{}/README_EN.md)'.format(
                        data['title'], data['titleSlug']))
        return '\n'.join(similar_questions_cn), '\n'.join(similar_questions_en)

    def __form_tags(self, tags):
        tags_cn, tags_en = [], []
        for tag in tags:
            tags_cn.append(
                f'- [{tag["translatedName"]}]({TAG_FORMAT.format(tag["slug"])})'
            )
            tags_en.append(
                f'- [{tag["name"]}]({TAG_FORMAT.format(tag["slug"])})')
        return '\n'.join(tags_cn), '\n'.join(tags_en)

    def __form_content_cn(self, content):
        if not content:
            return
        return content.replace('↵↵', '').replace('↵', '\n')

    def __form_content_en(self, content):
        if not content:
            return
        return content.replace('↵', '').replace('\r\n', '\n')


class submission_node:
    """解析提交的代码信息"""
    def __init__(self, dic):
        self.submission_id = dic['id']
        self.lang = dic['lang']
        self.memory = dic['memory']
        self.runtime = dic['runtime']
        self.timestamp = self.__form_time(int(dic['timestamp']))
        self.title_slug = dic['title_slug']

    @property
    def language(self):
        return LANGS[self.lang]['lang']

    def __form_time(self, timeStamp):
        return time.strftime("%Y-%m-%d %H:%M:%S", time.localtime(timeStamp))

    def __form_code(self, code):
        return code.replace('↵', '\n')


class info_node:
    """解析用户基本信息"""
    def __init__(self, json_data):
        self.user_name = json_data.get('user_name')
        self.ac_easy = json_data.get('ac_easy')
        self.ac_medium = json_data.get('ac_medium')
        self.ac_hard = json_data.get('ac_hard')
        self.num_solved = json_data.get('num_solved')
        self.num_total = json_data.get('num_total')

    def __repr__(self):
        return (
            f'user_name: {self.user_name}\nac_easy: {self.ac_easy}\nac_medium: {self.ac_medium}\nac_hard: {self.ac_hard}\nnum_solved: {self.num_solved}\nnum_total: {self.num_total}'
        )
