import os
import configparser
import argparse

class config:
    def __init__(self, config_path = ""):
        if not config_path:
            dir_path = os.path.dirname(os.path.realpath(__file__))
            config_path = os.path.join(dir_path, 'config', 'config.ini')
        conf = configparser.ConfigParser()
        conf.read(config_path, encoding='utf-8')

        # project
        self.blog_url = conf.get('blog', 'url', fallback='')
        self.blog_sub_url = conf.get('blog', 'sub_url', fallback='')
        self.blog_name = conf.get('blog', 'name', fallback='')

        # git
        self.git_user = conf.get('git', 'user', fallback='')
        self.git_email = conf.get('git', 'email', fallback='')
        self.git_current_branch = conf.get('git', 'current_branch', fallback='')
        self.git_repository = conf.get('git', 'repository', fallback='')
        self.git_ssh = conf.getboolean('git', 'use_ssh', fallback=False)

        # leetcode
        self.leetcode_use_country = conf.get('leetcode', 'use_country', fallback="cn")
        self.leetcode_us_url = conf.get('leetcode', 'us_url', fallback="https://leetcode.com")
        self.leetcode_cn_url = conf.get('leetcode', 'cn_url', fallback="https://leetcode.cn/")
        self.leetcode_url = conf.get('leetcode', self.leetcode_use_country.join('_url'), fallback=self.leetcode_cn_url)
        self.leetcode_user_name = conf.get('leetcode', 'user_name', fallback="")
        self.leetcode_user_password = conf.get('leetcode', 'user_password', fallback="")

        # 输出配置值
        self.output_dir = conf.get('output', 'dir', fallback="./target")
        self.output_day = conf.getint('output', 'day', fallback=1)
        self.output_overwrite = conf.getboolean('output', 'overwrite', fallback=False)
        self.output_author = conf.get('output', 'author', fallback=self.leetcode_user_name)

        # 数据库设置
        self.db_type = conf.get('database', 'type', fallback="sqlite3")
        self.db_user_name = conf.get('database', 'user_name', fallback="xxx")
        self.db_user_password = conf.get('database', 'user_password', fallback="xxx")
        self.db_host = conf.get('database', 'host', fallback="127.0.0.1")
        self.db_port = conf.getint('database', 'port', fallback=3306)
        self.db_database = conf.get('database', 'database', fallback="leetcode")
        self.db_sqlite3_path = conf.get('database', 'sqlite3_path', fallback="./database")

        # task
        self.task_time_interval = conf.getfloat('task', 'time_interval', fallback="0.1")

default_config = config()

if __name__ == "__main__":
    parser = argparse.ArgumentParser()
    parser.add_argument('-cf', '--config_file', default=os.getcwd(), help='config file path')
    args = parser.parse_args()

    config_file = args.config_file
    print(config_file)
    print(config(config_file).leetcode_url)
