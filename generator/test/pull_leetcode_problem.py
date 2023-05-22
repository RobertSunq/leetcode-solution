import requests
from bs4 import BeautifulSoup

# 在这里替换为您自己的LeetCode账号和密码
username = "130612450665"
password = "leetcode@SUN0217"

# 在这里替换为您想要拉取题目的ID以及您的个人题解
problem_id = "two-sum"  # 这里以第一题为例
solution = "这是我的题解"

# 登录LeetCode
session = requests.Session()
login_url = "https://leetcode.cn/accounts/login/"
login_data = {"login": username, "password": password}
session.post(login_url, data=login_data)

# 获取题目信息
problem_url = "https://leetcode.cn/problems/{problem_id}"
problem_page = session.get(problem_url)
problem_soup = BeautifulSoup(problem_page.content, "html.parser")
problem_title = problem_soup.find("h4", class_="css-v3d350").text.strip()
problem_description = problem_soup.find("div", class_="content__u3I1 question-content__JfgR").prettify()

# 生成HTML文件
with open(f"{problem_title}.html", "w") as f:
    f.write(f"<h1>{problem_title}</h1>")
    f.write(f"<p>{problem_description}</p>")
    f.write(f"<h2>My Solution</h2>")
    f.write(f"<p>{solution}</p>")