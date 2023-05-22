
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer 58 - II. 左旋转字符串](https://leetcode.cn//problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/)

## 题目描述

<p>字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串&quot;abcdefg&quot;和数字2，该函数将返回左旋转两位得到的结果&quot;cdefgab&quot;。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入:</strong> s = &quot;abcdefg&quot;, k = 2
<strong>输出:&nbsp;</strong>&quot;cdefgab&quot;
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入:</strong> s = &quot;lrloseumgh&quot;, k = 6
<strong>输出:&nbsp;</strong>&quot;umghlrlose&quot;
</pre>

<p>&nbsp;</p>

<p><strong>限制：</strong></p>

<ul>
	<li><code>1 &lt;= k &lt; s.length &lt;= 10000</code></li>
</ul>


## 题解


### Java

```Java
// @Title: 左旋转字符串 (左旋转字符串 LCOF)
// @Author: robert.sunq
// @Date: 2021-08-04 22:36:31
// @Runtime: 6 ms
// @Memory: 38.3 MB

class Solution {
    public String reverseLeftWords(String s, int n) {
        // return s.substring(n,s.length()) + s.substring(0,n);
        StringBuilder res = new StringBuilder();
        for(int i=0;i<s.length();i++){
            res.append(s.charAt((n + i) % s.length()));
        }
        return res.toString();
    }
}
```



## 相关话题

- [数学](https://leetcode.cn//tag/math)
- [双指针](https://leetcode.cn//tag/two-pointers)
- [字符串](https://leetcode.cn//tag/string)

## 相似题目



