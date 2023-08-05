import sys

import requests
from .constants import LEETCODE, LOGIN, HEADERS


class login:
    '''
    登录 LeetCode-cn, 获取 cookies 值
    '''
    def __init__(self, username, password):
        self.username = username
        self.password = password
        self.__cookies = ''
        self.__headers = ''
        self.status = False

    def do_login(self):
        client = requests.session()
        client.encoding = "utf-8"
        resp = requests.get(LEETCODE, headers=HEADERS)
        # token = resp.cookies['csrftoken']
        token = ""
        headers = HEADERS.copy()
        headers.update({
            'referer': LOGIN,
            'x-csrftoken': token,
            'x-requested-with': 'XMLHttpRequest'
        })
        # todo 修改为从浏览器获取的真实 cookie
        headers.update({
            'Cookie': ''
        })
        payload = {
            'login': self.username,
            'password': self.password,
            'csrfmiddlewaretoken': token
        }
        cookies = {'csrftoken': token}
        # client.get(LOGIN, verify=False)
        resp = client.post(
            LOGIN, data=payload, headers=headers, cookies=cookies)
        if resp.status_code == 200:
            self.status = True
            self.__cookies = resp.cookies
            self.__headers = headers
            # user = resp.json()['form']['fields']['login']['value']
        if self.status:
            print(f'{self.username} 登录成功！')
        else:
            print('登录失败！')
            print('请检查用户名和密码！')
            sys.exit()

    @property
    def cookies(self):
        if not self.status:
            self.do_login()
        return self.__cookies

    @property
    def headers(self):
        if not self.status:
            self.do_login()
        return self.__headers
