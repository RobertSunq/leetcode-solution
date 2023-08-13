
| [English](README_EN.md) | 简体中文 |

# [1768. 交替合并字符串](https://leetcode.cn//problems/merge-strings-alternately/)

## 题目描述

<p>给你两个字符串 <code>word1</code> 和 <code>word2</code> 。请你从 <code>word1</code> 开始，通过交替添加字母来合并字符串。如果一个字符串比另一个字符串长，就将多出来的字母追加到合并后字符串的末尾。</p>

<p>返回 <strong>合并后的字符串</strong> 。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>word1 = "abc", word2 = "pqr"
<strong>输出：</strong>"apbqcr"
<strong>解释：</strong>字符串合并情况如下所示：
word1：  a   b   c
word2：    p   q   r
合并后：  a p b q c r
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>word1 = "ab", word2 = "pqrs"
<strong>输出：</strong>"apbqrs"
<strong>解释：</strong>注意，word2 比 word1 长，"rs" 需要追加到合并后字符串的末尾。
word1：  a   b 
word2：    p   q   r   s
合并后：  a p b q   r   s
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>word1 = "abcd", word2 = "pq"
<strong>输出：</strong>"apbqcd"
<strong>解释：</strong>注意，word1 比 word2 长，"cd" 需要追加到合并后字符串的末尾。
word1：  a   b   c   d
word2：    p   q 
合并后：  a p b q c   d
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= word1.length, word2.length <= 100</code></li>
	<li><code>word1</code> 和 <code>word2</code> 由小写英文字母组成</li>
</ul>


## 题解


### Java

```Java
// @Title: 交替合并字符串 (Merge Strings Alternately)
// @Author: robert.sunq
// @Date: 2023-08-08 21:39:43
// @Runtime: 1 ms
// @Memory: 39.1 MB

class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        StringBuffer str = new StringBuffer();
        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            str.append(word1.charAt(i++));
            str.append(word2.charAt(j++));
        }

        while (i < n1) {
            str.append(word1.charAt(i++));
        }

        while (j < n2) {
            str.append(word2.charAt(j++));
        }

        return str.toString();
    }
}
```



## 相关话题

- [双指针](https://leetcode.cn//tag/two-pointers)
- [字符串](https://leetcode.cn//tag/string)

## 相似题目



