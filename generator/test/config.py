import os
import configparser
import argparse


root_dir = os.getcwd()
config_file = os.path.join(root_dir, '../config', 'config.ini')
conf = configparser.ConfigParser()
conf.read(config_file, encoding='utf-8')


# project
blog_url = conf.get('blog', 'url', fallback='')
blog_sub_url = conf.get('blog', 'sub_url', fallback='')
blog_name = conf.get('blog', 'name', fallback='')

# git
git_user = conf.get('git', 'user', fallback='')
git_email = conf.get('git', 'email', fallback='')
git_current_branch = conf.get('git', 'current_branch', fallback='')
git_ssh = conf.getboolean('git', 'use_ssh', fallback=False)

# leetcode
leetcode_use_country = conf.get('leetcode', 'use_country', fallback="cn")
leetcode_us_url = conf.get('leetcode', 'us_url', fallback="https://leetcode.com")
leetcode_cn_url = conf.get('leetcode', 'cn_url', fallback="https://leetcode.cn/")
leetcode_url = conf.get('leetcode', leetcode_use_country.join('_url'), fallback=leetcode_cn_url)
leetcode_user_name = conf.get('leetcode', 'user_name', fallback="")
leetcode_user_password = conf.get('leetcode', 'user_password', fallback="")


# 输出配置值
output_dir =  conf.get('output', 'dir', fallback="./target")
output_day =  conf.getint('output', 'day', fallback=1)
output_overwrite =  conf.getboolean('output', 'overwrite', fallback=False)


if __name__ == "__main__":
    parser = argparse.ArgumentParser()
    parser.add_argument('-cf', '--config_file', default=os.getcwd(), help='config file path')
    args = parser.parse_args()

    config_file = args.config_file
    print(config_file)
    print(leetcode_url)