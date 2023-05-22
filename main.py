# This is a sample Python script.

# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.

import sys
sys.path.append("")
from generator.problems import problems
import asyncio


class main:
    '''主程序'''
    def __init__(self):
        self.problems = problems()

    def __info(self):
        print(self.problems.info)

    def update(self):
        '''更新数据'''
        self.__info()
        loop = asyncio.get_event_loop()
        loop.run_until_complete(self.problems.update())

    def rebuild(self):
        '''重建数据'''
        self.__info()
        self.problems.clear_db()
        self.problems.init_table()
        self.problems.copy_images()
        self.update()

# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    while True:
        print('欢迎使用 leetcode generator, 请选择: ')
        print('1. 更新')
        print('2. 重建')
        print('q. 退出')
        key = input()
        if key == 'q':
            break
        elif key == '1':
            main().update()
            break
        elif key == '2':
            main().rebuild()
            break
        else:
            print('请重新选择！')

