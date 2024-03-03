
| [English](README_EN.md) | 简体中文 |

# [318. 最大单词长度乘积](https://leetcode.cn//problems/maximum-product-of-word-lengths/)

## 题目描述

<p>给你一个字符串数组&nbsp;<code>words</code> ，找出并返回 <code>length(words[i]) * length(words[j])</code>&nbsp;的最大值，并且这两个单词不含有公共字母。如果不存在这样的两个单词，返回 <code>0</code> 。</p>

<p>&nbsp;</p>

<p><strong>示例&nbsp;1：</strong></p>

<pre>
<strong>输入：</strong>words = <code>["abcw","baz","foo","bar","xtfn","abcdef"]</code>
<strong>输出：</strong><code>16 
<strong>解释</strong></code><strong>：</strong><code>这两个单词为<strong> </strong>"abcw", "xtfn"</code>。</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>words = <code>["a","ab","abc","d","cd","bcd","abcd"]</code>
<strong>输出：</strong><code>4 
<strong>解释</strong></code><strong>：</strong>这两个单词为 <code>"ab", "cd"</code>。</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>words = <code>["a","aa","aaa","aaaa"]</code>
<strong>输出：</strong><code>0 
<strong>解释</strong></code><strong>：</strong><code>不存在这样的两个单词。</code>
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>2 &lt;= words.length &lt;= 1000</code></li>
	<li><code>1 &lt;= words[i].length &lt;= 1000</code></li>
	<li><code>words[i]</code>&nbsp;仅包含小写字母</li>
</ul>


## 题解


### Java

```Java
// @Title: 最大单词长度乘积 (Maximum Product of Word Lengths)
// @Author: robert.sunq
// @Date: 2023-11-06 22:12:39
// @Runtime: 10 ms
// @Memory: 43 MB

class Solution {
    public int maxProduct(String[] words) {
        int ans = 0;
        int n = words.length;

        int[] masks = new int[n];

        for (int i = 0; i < n; i++) {
            String word = words[i];
            int strN = word.length();
            for (int j = 0; j < strN; j++) {
                // 位运算， 使用int 的0 - 25 位 来表示这个字母的存在
                masks[i] = masks[i] | (1 << (word.charAt(j) - 'a'));
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((masks[i] & masks[j]) == 0) {
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }

        return ans;
    }
}
```



## 相关话题

- [位运算](https://leetcode.cn//tag/bit-manipulation)
- [数组](https://leetcode.cn//tag/array)
- [字符串](https://leetcode.cn//tag/string)

## 相似题目



