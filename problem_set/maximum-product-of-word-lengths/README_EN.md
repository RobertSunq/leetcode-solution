
| English | [简体中文](README.md) |

# [318. Maximum Product of Word Lengths](https://leetcode.cn//problems/maximum-product-of-word-lengths/)

## Description

<p>Given a string array <code>words</code>, return <em>the maximum value of</em> <code>length(word[i]) * length(word[j])</code> <em>where the two words do not share common letters</em>. If no such two words exist, return <code>0</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> words = [&quot;abcw&quot;,&quot;baz&quot;,&quot;foo&quot;,&quot;bar&quot;,&quot;xtfn&quot;,&quot;abcdef&quot;]
<strong>Output:</strong> 16
<strong>Explanation:</strong> The two words can be &quot;abcw&quot;, &quot;xtfn&quot;.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> words = [&quot;a&quot;,&quot;ab&quot;,&quot;abc&quot;,&quot;d&quot;,&quot;cd&quot;,&quot;bcd&quot;,&quot;abcd&quot;]
<strong>Output:</strong> 4
<strong>Explanation:</strong> The two words can be &quot;ab&quot;, &quot;cd&quot;.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> words = [&quot;a&quot;,&quot;aa&quot;,&quot;aaa&quot;,&quot;aaaa&quot;]
<strong>Output:</strong> 0
<strong>Explanation:</strong> No such pair of words.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= words.length &lt;= 1000</code></li>
	<li><code>1 &lt;= words[i].length &lt;= 1000</code></li>
	<li><code>words[i]</code> consists only of lowercase English letters.</li>
</ul>


## Solutions


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



## Related Topics

- [Bit Manipulation](https://leetcode.cn//tag/bit-manipulation)
- [Array](https://leetcode.cn//tag/array)
- [String](https://leetcode.cn//tag/string)

## Similar Questions


