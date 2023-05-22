
| [English](README_EN.md) | 简体中文 |

# [10. 正则表达式匹配](https://leetcode.cn//problems/regular-expression-matching/)

## 题目描述

<p>给你一个字符串&nbsp;<code>s</code>&nbsp;和一个字符规律&nbsp;<code>p</code>，请你来实现一个支持 <code>'.'</code>&nbsp;和&nbsp;<code>'*'</code>&nbsp;的正则表达式匹配。</p>

<ul>
	<li><code>'.'</code> 匹配任意单个字符</li>
	<li><code>'*'</code> 匹配零个或多个前面的那一个元素</li>
</ul>

<p>所谓匹配，是要涵盖&nbsp;<strong>整个&nbsp;</strong>字符串&nbsp;<code>s</code>的，而不是部分字符串。</p>
&nbsp;

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = "aa", p = "a"
<strong>输出：</strong>false
<strong>解释：</strong>"a" 无法匹配 "aa" 整个字符串。
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入：</strong>s = "aa", p = "a*"
<strong>输出：</strong>true
<strong>解释：</strong>因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
</pre>

<p><strong>示例&nbsp;3：</strong></p>

<pre>
<strong>输入：</strong>s = "ab", p = ".*"
<strong>输出：</strong>true
<strong>解释：</strong>".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= s.length&nbsp;&lt;= 20</code></li>
	<li><code>1 &lt;= p.length&nbsp;&lt;= 20</code></li>
	<li><code>s</code>&nbsp;只包含从&nbsp;<code>a-z</code>&nbsp;的小写字母。</li>
	<li><code>p</code>&nbsp;只包含从&nbsp;<code>a-z</code>&nbsp;的小写字母，以及字符&nbsp;<code>.</code>&nbsp;和&nbsp;<code>*</code>。</li>
	<li>保证每次出现字符&nbsp;<code>*</code> 时，前面都匹配到有效的字符</li>
</ul>


## 题解


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



## 相关话题

- [递归](https://leetcode.cn//tag/recursion)
- [字符串](https://leetcode.cn//tag/string)
- [动态规划](https://leetcode.cn//tag/dynamic-programming)

## 相似题目


- [通配符匹配](../wildcard-matching/README.md)
