
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer 05. 替换空格](https://leetcode.cn//problems/ti-huan-kong-ge-lcof/)

## 题目描述

<p>请实现一个函数，把字符串 <code>s</code> 中的每个空格替换成&quot;%20&quot;。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>s = &quot;We are happy.&quot;
<strong>输出：</strong>&quot;We%20are%20happy.&quot;</pre>

<p>&nbsp;</p>

<p><strong>限制：</strong></p>

<p><code>0 &lt;= s 的长度 &lt;= 10000</code></p>


## 题解


### C++

```C++
// @Title: 替换空格 (替换空格 LCOF)
// @Author: robert.sunq
// @Date: 2020-03-21 15:17:24
// @Runtime: 0 ms
// @Memory: 7.6 MB

class Solution {
public:
    string replaceSpace(string s) {
        string :: iterator it = s.begin();
        string str = "%20";
        string str_1 = "";
        while(it != s.end()){
            if(*it == ' '){
                str_1 += str;
                it++;
            }
            else{
                str_1+=(*it);
               it++;  
            }
             
        }

        return str_1;
    }
};
```



### Java

```Java
// @Title: 替换空格 (替换空格 LCOF)
// @Author: robert.sunq
// @Date: 2023-02-05 22:59:59
// @Runtime: 0 ms
// @Memory: 39.5 MB

class Solution {
    public String replaceSpace(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        char ch;
        for(int i = 0;i < s.length();i++) {
            ch = s.charAt(i);
            if (ch == ' '){
                stringBuilder.append("%20");
            }else {
                stringBuilder.append(ch);
            }
        }
        return stringBuilder.toString();
    }
}
```



## 相关话题

- [字符串](https://leetcode.cn//tag/string)

## 相似题目



