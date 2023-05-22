
| [English](README_EN.md) | 简体中文 |

# [面试题 01.03. URL化](https://leetcode.cn//problems/string-to-url-lcci/)

## 题目描述

<p>URL化。编写一种方法，将字符串中的空格全部替换为<code>%20</code>。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：用<code>Java</code>实现的话，请使用字符数组实现，以便直接在数组上操作。）</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入</strong>："Mr John Smith    ", 13
<strong>输出</strong>："Mr%20John%20Smith"
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入</strong>："               ", 5
<strong>输出</strong>："%20%20%20%20%20"
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li>字符串长度在 [0, 500000] 范围内。</li>
</ul>


## 题解


### C++

```C++
// @Title: URL化 (String to URL LCCI)
// @Author: robert.sunq
// @Date: 2020-03-22 00:28:57
// @Runtime: 80 ms
// @Memory: 26.7 MB

class Solution {
public:
    string replaceSpaces(string S, int length) {
        string :: iterator it = S.begin();
        string str = "%20";
        string str_1 = "";
        while(it != S.begin()+length){
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



## 相关话题

- [字符串](https://leetcode.cn//tag/string)

## 相似题目



