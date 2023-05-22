
| [English](README_EN.md) | 简体中文 |

# [面试题 01.06. 字符串压缩](https://leetcode.cn//problems/compress-string-lcci/)

## 题目描述

<p>字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串<code>aabcccccaaa</code>会变为<code>a2b1c5a3</code>。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。</p>

<p> <strong>示例1:</strong></p>

<pre>
<strong> 输入</strong>："aabcccccaaa"
<strong> 输出</strong>："a2b1c5a3"
</pre>

<p> <strong>示例2:</strong></p>

<pre>
<strong> 输入</strong>："abbccd"
<strong> 输出</strong>："abbccd"
<strong> 解释</strong>："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
</pre>

<p><strong>提示：</strong></p>

<ol>
<li>字符串长度在[0, 50000]范围内。</li>
</ol>


## 题解


### C++

```C++
// @Title: 字符串压缩 (Compress String LCCI)
// @Author: robert.sunq
// @Date: 2020-03-24 00:15:41
// @Runtime: 16 ms
// @Memory: 8.5 MB

class Solution {
public:
    string compressString(string S) {
        string s = "";
        int counts = 0;
        int len = S.length();
        int i=0;
        int same_counts = 0;
         int j;
        while(i<len){
            j=i+1;
            same_counts = 1;
            while(S[i] == S[j]){
                same_counts++;
                j++;

            }
            s += S[i]+to_string(same_counts);
            i = j;
        }
        if(s.size() >= len) return S;
        else return s;
    }
};
```



## 相关话题

- [双指针](https://leetcode.cn//tag/two-pointers)
- [字符串](https://leetcode.cn//tag/string)

## 相似题目



