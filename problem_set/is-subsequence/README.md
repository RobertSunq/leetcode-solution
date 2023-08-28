
| [English](README_EN.md) | 简体中文 |

# [392. 判断子序列](https://leetcode.cn//problems/is-subsequence/)

## 题目描述

<p>给定字符串 <strong>s</strong> 和 <strong>t</strong> ，判断 <strong>s</strong> 是否为 <strong>t</strong> 的子序列。</p>

<p>字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，<code>"ace"</code>是<code>"abcde"</code>的一个子序列，而<code>"aec"</code>不是）。</p>

<p><strong>进阶：</strong></p>

<p>如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？</p>

<p><strong>致谢：</strong></p>

<p>特别感谢<strong> </strong><a href="https://leetcode.com/pbrother/">@pbrother </a>添加此问题并且创建所有测试用例。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = "abc", t = "ahbgdc"
<strong>输出：</strong>true
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = "axc", t = "ahbgdc"
<strong>输出：</strong>false
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>0 <= s.length <= 100</code></li>
	<li><code>0 <= t.length <= 10^4</code></li>
	<li>两个字符串都只由小写字符组成。</li>
</ul>


## 题解


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



## 相关话题

- [双指针](https://leetcode.cn//tag/two-pointers)
- [字符串](https://leetcode.cn//tag/string)
- [动态规划](https://leetcode.cn//tag/dynamic-programming)

## 相似题目


- [匹配子序列的单词数](../number-of-matching-subsequences/README.md)
- [形成字符串的最短路径](../shortest-way-to-form-string/README.md)
