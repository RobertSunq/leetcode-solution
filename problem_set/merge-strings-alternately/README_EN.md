
| English | [简体中文](README.md) |

# [1768. Merge Strings Alternately](https://leetcode.cn//problems/merge-strings-alternately/)

## Description

<p>You are given two strings <code>word1</code> and <code>word2</code>. Merge the strings by adding letters in alternating order, starting with <code>word1</code>. If a string is longer than the other, append the additional letters onto the end of the merged string.</p>

<p>Return <em>the merged string.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> word1 = &quot;abc&quot;, word2 = &quot;pqr&quot;
<strong>Output:</strong> &quot;apbqcr&quot;
<strong>Explanation:</strong>&nbsp;The merged string will be merged as so:
word1:  a   b   c
word2:    p   q   r
merged: a p b q c r
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> word1 = &quot;ab&quot;, word2 = &quot;pqrs&quot;
<strong>Output:</strong> &quot;apbqrs&quot;
<strong>Explanation:</strong>&nbsp;Notice that as word2 is longer, &quot;rs&quot; is appended to the end.
word1:  a   b 
word2:    p   q   r   s
merged: a p b q   r   s
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> word1 = &quot;abcd&quot;, word2 = &quot;pq&quot;
<strong>Output:</strong> &quot;apbqcd&quot;
<strong>Explanation:</strong>&nbsp;Notice that as word1 is longer, &quot;cd&quot; is appended to the end.
word1:  a   b   c   d
word2:    p   q 
merged: a p b q c   d
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= word1.length, word2.length &lt;= 100</code></li>
	<li><code>word1</code> and <code>word2</code> consist of lowercase English letters.</li>
</ul>

## Solutions


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



## Related Topics

- [Two Pointers](https://leetcode.cn//tag/two-pointers)
- [String](https://leetcode.cn//tag/string)

## Similar Questions


