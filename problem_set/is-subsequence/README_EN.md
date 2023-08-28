
| English | [简体中文](README.md) |

# [392. Is Subsequence](https://leetcode.cn//problems/is-subsequence/)

## Description

<p>Given two strings <code>s</code> and <code>t</code>, return <code>true</code><em> if </em><code>s</code><em> is a <strong>subsequence</strong> of </em><code>t</code><em>, or </em><code>false</code><em> otherwise</em>.</p>

<p>A <strong>subsequence</strong> of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., <code>&quot;ace&quot;</code> is a subsequence of <code>&quot;<u>a</u>b<u>c</u>d<u>e</u>&quot;</code> while <code>&quot;aec&quot;</code> is not).</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> s = "abc", t = "ahbgdc"
<strong>Output:</strong> true
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> s = "axc", t = "ahbgdc"
<strong>Output:</strong> false
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= s.length &lt;= 100</code></li>
	<li><code>0 &lt;= t.length &lt;= 10<sup>4</sup></code></li>
	<li><code>s</code> and <code>t</code> consist only of lowercase English letters.</li>
</ul>

<p>&nbsp;</p>
<strong>Follow up:</strong> Suppose there are lots of incoming <code>s</code>, say <code>s<sub>1</sub>, s<sub>2</sub>, ..., s<sub>k</sub></code> where <code>k &gt;= 10<sup>9</sup></code>, and you want to check one by one to see if <code>t</code> has its subsequence. In this scenario, how would you change your code?

## Solutions


### Java

```Java
// @Title: 判断子序列 (Is Subsequence)
// @Author: robert.sunq
// @Date: 2023-08-14 21:21:30
// @Runtime: 1 ms
// @Memory: 39.4 MB

class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }

        if (t.length() == 0) {
            return false;
        }

        int i = 0;
        int j = 0;
        int ns = s.length() , nt = t.length();
        while (i < ns && j < nt) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

        return i >= ns;
    }
}
```



## Related Topics

- [Two Pointers](https://leetcode.cn//tag/two-pointers)
- [String](https://leetcode.cn//tag/string)
- [Dynamic Programming](https://leetcode.cn//tag/dynamic-programming)

## Similar Questions

- [Number of Matching Subsequences](../number-of-matching-subsequences/README_EN.md)
- [Shortest Way to Form String](../shortest-way-to-form-string/README_EN.md)
