
| [English](README_EN.md) | 简体中文 |

# [面试题 01.09. 字符串轮转](https://leetcode.cn//problems/string-rotation-lcci/)

## 题目描述

<p>字符串轮转。给定两个字符串<code>s1</code>和<code>s2</code>，请编写代码检查<code>s2</code>是否为<code>s1</code>旋转而成（比如，<code>waterbottle</code>是<code>erbottlewat</code>旋转后的字符串）。</p>

<p><strong>示例1:</strong></p>

<pre><strong> 输入</strong>：s1 = &quot;waterbottle&quot;, s2 = &quot;erbottlewat&quot;
<strong> 输出</strong>：True
</pre>

<p><strong>示例2:</strong></p>

<pre><strong> 输入</strong>：s1 = &quot;aa&quot;, s2 = &quot;aba&quot;
<strong> 输出</strong>：False
</pre>

<ol>
</ol>

<p><strong>提示：</strong></p>

<ol>
	<li>字符串长度在[0, 100000]范围内。</li>
</ol>

<p><strong>说明:</strong></p>

<ol>
	<li>你能只调用一次检查子串的方法吗？</li>
</ol>


## 题解


### C++

```C++
// @Title: 字符串轮转 (String Rotation LCCI)
// @Author: robert.sunq
// @Date: 2020-03-24 23:55:21
// @Runtime: 0 ms
// @Memory: 7.4 MB

class Solution {
public:
    bool isFlipedString(string s1, string s2) {
        int len_1 = s1.length();
        int len_2 = s2.length();

        if(len_1-len_2) return false;
        if(len_2 == 0) return true;
        //int indexs_2 = 0;
        for(int i=0;i<len_1;i++){
            if(s1[i] == s2[0]){
                int indexs_1 = i;
                bool falg = true;
                for(int j =0;j<len_2;j++){
                    if(s1[indexs_1] != s2[j]){
                        falg = false;
                        break;
                    }
                      
                    indexs_1 = (indexs_1+1)%len_1;
                }
                if(falg) return true;
            }
        }

        return false;

    }
};
```



## 相关话题

- [字符串](https://leetcode.cn//tag/string)
- [字符串匹配](https://leetcode.cn//tag/string-matching)

## 相似题目



