
| English | [简体中文](README.md) |

# [1456. Maximum Number of Vowels in a Substring of Given Length](https://leetcode.cn//problems/maximum-number-of-vowels-in-a-substring-of-given-length/)

## Description

<p>Given a string <code>s</code> and an integer <code>k</code>, return <em>the maximum number of vowel letters in any substring of </em><code>s</code><em> with length </em><code>k</code>.</p>

<p><strong>Vowel letters</strong> in English are <code>&#39;a&#39;</code>, <code>&#39;e&#39;</code>, <code>&#39;i&#39;</code>, <code>&#39;o&#39;</code>, and <code>&#39;u&#39;</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;abciiidef&quot;, k = 3
<strong>Output:</strong> 3
<strong>Explanation:</strong> The substring &quot;iii&quot; contains 3 vowel letters.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;aeiou&quot;, k = 2
<strong>Output:</strong> 2
<strong>Explanation:</strong> Any substring of length 2 contains 2 vowels.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;leetcode&quot;, k = 3
<strong>Output:</strong> 2
<strong>Explanation:</strong> &quot;lee&quot;, &quot;eet&quot; and &quot;ode&quot; contain 2 vowels.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
	<li><code>s</code> consists of lowercase English letters.</li>
	<li><code>1 &lt;= k &lt;= s.length</code></li>
</ul>


## Solutions


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



## Related Topics

- [String](https://leetcode.cn//tag/string)
- [Sliding Window](https://leetcode.cn//tag/sliding-window)

## Similar Questions


