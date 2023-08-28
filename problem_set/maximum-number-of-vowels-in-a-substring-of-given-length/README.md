
| [English](README_EN.md) | 简体中文 |

# [1456. 定长子串中元音的最大数目](https://leetcode.cn//problems/maximum-number-of-vowels-in-a-substring-of-given-length/)

## 题目描述

<p>给你字符串 <code>s</code> 和整数 <code>k</code> 。</p>

<p>请返回字符串 <code>s</code> 中长度为 <code>k</code> 的单个子字符串中可能包含的最大元音字母数。</p>

<p>英文中的 <strong>元音字母 </strong>为（<code>a</code>, <code>e</code>, <code>i</code>, <code>o</code>, <code>u</code>）。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>s = &quot;abciiidef&quot;, k = 3
<strong>输出：</strong>3
<strong>解释：</strong>子字符串 &quot;iii&quot; 包含 3 个元音字母。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>s = &quot;aeiou&quot;, k = 2
<strong>输出：</strong>2
<strong>解释：</strong>任意长度为 2 的子字符串都包含 2 个元音字母。
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>s = &quot;leetcode&quot;, k = 3
<strong>输出：</strong>2
<strong>解释：</strong>&quot;lee&quot;、&quot;eet&quot; 和 &quot;ode&quot; 都包含 2 个元音字母。
</pre>

<p><strong>示例 4：</strong></p>

<pre><strong>输入：</strong>s = &quot;rhythms&quot;, k = 4
<strong>输出：</strong>0
<strong>解释：</strong>字符串 s 中不含任何元音字母。
</pre>

<p><strong>示例 5：</strong></p>

<pre><strong>输入：</strong>s = &quot;tryhard&quot;, k = 4
<strong>输出：</strong>1
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10^5</code></li>
	<li><code>s</code> 由小写英文字母组成</li>
	<li><code>1 &lt;= k &lt;= s.length</code></li>
</ul>


## 题解


### Java

```Java
// @Title: 定长子串中元音的最大数目 (Maximum Number of Vowels in a Substring of Given Length)
// @Author: robert.sunq
// @Date: 2023-08-17 22:25:33
// @Runtime: 22 ms
// @Memory: 42.6 MB

class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> o = new HashSet<>();
        o.add('a');
        o.add('e');
        o.add('i');
        o.add('o');
        o.add('u');

        int max = 0;
        int count = 0;
        int left = 0;
        int right = 0;
        int n = s.length();
        while (right < n) {
            if (o.contains(s.charAt(right))) {
                count++;
            }
            if (right >= k) {
                if (o.contains(s.charAt(left))) {
                    count--;
                }
                left++;
            }
            right++;
            if (right >= k) {
                max = Math.max(max, count);
            }
        }
        return max;
    }
}
```



## 相关话题

- [字符串](https://leetcode.cn//tag/string)
- [滑动窗口](https://leetcode.cn//tag/sliding-window)

## 相似题目



