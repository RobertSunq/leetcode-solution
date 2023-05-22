
| English | [简体中文](README.md) |

# [32. Longest Valid Parentheses](https://leetcode.cn//problems/longest-valid-parentheses/)

## Description

<p>Given a string containing just the characters <code>&#39;(&#39;</code> and <code>&#39;)&#39;</code>, return <em>the length of the longest valid (well-formed) parentheses </em><span data-keyword="substring-nonempty"><em>substring</em></span>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;(()&quot;
<strong>Output:</strong> 2
<strong>Explanation:</strong> The longest valid parentheses substring is &quot;()&quot;.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;)()())&quot;
<strong>Output:</strong> 4
<strong>Explanation:</strong> The longest valid parentheses substring is &quot;()()&quot;.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;&quot;
<strong>Output:</strong> 0
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= s.length &lt;= 3 * 10<sup>4</sup></code></li>
	<li><code>s[i]</code> is <code>&#39;(&#39;</code>, or <code>&#39;)&#39;</code>.</li>
</ul>


## Solutions


### Java

```Java
// @Title: 最长有效括号 (Longest Valid Parentheses)
// @Author: robert.sunq
// @Date: 2021-07-11 23:40:47
// @Runtime: 1 ms
// @Memory: 38.2 MB

class Solution {
    public int longestValidParentheses(String s) {
        if(s.length() <= 0) return 0;
        // 表示 i位置时候可以匹配的括号长度
        int[] dp = new int[s.length()];
        int res = 0;
        dp[0] = 0;
        for(int i = 1;i<s.length();i++){
            // 为右括号，则该位置不可匹配
            if(s.charAt(i) == '('){
                dp[i] = 0;
            }else{
                // 如果和i-1匹配
                if(s.charAt(i-1) == '('){
                    // 前面的有效长度 + 2
                    if(i - 2 >= 0){
                        dp[i] = dp[i-2]+2;
                    }else{
                        dp[i] = 2;
                    }
                // 和 位置  i - dp[i-1] -1 位置上匹配
                // dp[i-1]>0 表示前一个字符匹配了
                }else if(dp[i-1]>0 && i-dp[i-1]-1>=0 && s.charAt(i-dp[i-1]-1) == '('){
                    // 位置  i - dp[i-1] -1 前还有，则当前位置应该要加上其之前匹配的长度
                    if(i - dp[i-1] -1 >0){
                        dp[i] = dp[i - dp[i-1] - 2] + dp[i-1]+ 2;
                    }else{
                        dp[i] = dp[i-1]+ 2;
                    }
                }
            }
            // 保存可以匹配的最大长度
            res = Math.max(dp[i] , res);
        }
        return res;
    }
}
```



## Related Topics

- [Stack](https://leetcode.cn//tag/stack)
- [String](https://leetcode.cn//tag/string)
- [Dynamic Programming](https://leetcode.cn//tag/dynamic-programming)

## Similar Questions

- [Valid Parentheses](../valid-parentheses/README_EN.md)
