
| English | [简体中文](README.md) |

# [10. Regular Expression Matching](https://leetcode.cn//problems/regular-expression-matching/)

## Description

<p>Given an input string <code>s</code>&nbsp;and a pattern <code>p</code>, implement regular expression matching with support for <code>&#39;.&#39;</code> and <code>&#39;*&#39;</code> where:</p>

<ul>
	<li><code>&#39;.&#39;</code> Matches any single character.​​​​</li>
	<li><code>&#39;*&#39;</code> Matches zero or more of the preceding element.</li>
</ul>

<p>The matching should cover the <strong>entire</strong> input string (not partial).</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;aa&quot;, p = &quot;a&quot;
<strong>Output:</strong> false
<strong>Explanation:</strong> &quot;a&quot; does not match the entire string &quot;aa&quot;.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;aa&quot;, p = &quot;a*&quot;
<strong>Output:</strong> true
<strong>Explanation:</strong> &#39;*&#39; means zero or more of the preceding element, &#39;a&#39;. Therefore, by repeating &#39;a&#39; once, it becomes &quot;aa&quot;.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;ab&quot;, p = &quot;.*&quot;
<strong>Output:</strong> true
<strong>Explanation:</strong> &quot;.*&quot; means &quot;zero or more (*) of any character (.)&quot;.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length&nbsp;&lt;= 20</code></li>
	<li><code>1 &lt;= p.length&nbsp;&lt;= 20</code></li>
	<li><code>s</code> contains only lowercase English letters.</li>
	<li><code>p</code> contains only lowercase English letters, <code>&#39;.&#39;</code>, and&nbsp;<code>&#39;*&#39;</code>.</li>
	<li>It is guaranteed for each appearance of the character <code>&#39;*&#39;</code>, there will be a previous valid character to match.</li>
</ul>


## Solutions


### Java

```Java
// @Title: 正则表达式匹配 (Regular Expression Matching)
// @Author: robert.sunq
// @Date: 2021-06-01 23:52:04
// @Runtime: 2 ms
// @Memory: 38.2 MB

class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        // 表示 s的0——i , 是否可以与P 的 0 —— j匹配
        boolean[][] dp = new boolean[n+1][m+1];
        for(int i=0; i<=n;i++){
            for(int j=0;j<=m;j++){
                // 边界设定，及匹配式为空
                if(j == 0){
                    // 此时 只有代匹配式也为空时，可以匹配
                    dp[i][j] = i==0;
                }else{
                    // 是否匹配 *  j-1 即为 当前状态在p中的位置
                    // 当前位置表达式不为*
                    if(p.charAt(j-1) != '*'){
                        // i>0 且 当前字符可以匹配 或者 表达式中为 .
                        if(i >=1 &&  (p.charAt(j-1) == s.charAt(i-1)|| p.charAt(j-1) == '.' ) ){
                            // 则该状态与前面的状态相同
                            dp[i][j] = dp[i-1][j-1];
                        }
                    }else{
                        // 当 当前位置为* 确定匹配次数
                        // 注意 是两个if 不是 if else
                        // 不看  零次
                        if(j >=2){
                            // 注意这里为 || 的关系，表示 其可以看 也可以不看
                            dp[i][j] |= dp[i][j-2];
                        }
                        // 看 多次   j>2 为了 j-2 跳过 当前位置的 *
                        if(i>=1 && j>=2 && (p.charAt(j-2) == s.charAt(i-1)|| p.charAt(j-2) == '.' )){
                            dp[i][j] |= dp[i-1][j];
                        }
                    }
                }
            }
        }
        return dp[n][m];

    }
}
```



## Related Topics

- [Recursion](https://leetcode.cn//tag/recursion)
- [String](https://leetcode.cn//tag/string)
- [Dynamic Programming](https://leetcode.cn//tag/dynamic-programming)

## Similar Questions

- [Wildcard Matching](../wildcard-matching/README_EN.md)
