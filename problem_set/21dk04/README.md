
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer II 097. 子序列的数目](https://leetcode.cn//problems/21dk04/)

## 题目描述

<p>给定一个字符串 <code>s</code><strong> </strong>和一个字符串 <code>t</code> ，计算在 <code>s</code> 的子序列中 <code>t</code> 出现的个数。</p>

<p>字符串的一个 <strong>子序列</strong> 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，<code>&quot;ACE&quot;</code>&nbsp;是&nbsp;<code>&quot;ABCDE&quot;</code>&nbsp;的一个子序列，而&nbsp;<code>&quot;AEC&quot;</code>&nbsp;不是）</p>

<p>题目数据保证答案符合 32 位带符号整数范围。</p>

<p>&nbsp;</p>

<p><strong>示例&nbsp;1：</strong></p>

<pre>
<strong>输入：</strong>s = &quot;rabbbit&quot;, t = &quot;rabbit&quot;<code>
<strong>输出</strong></code><strong>：</strong><code>3
</code><strong>解释：</strong>
如下图所示, 有 3 种可以从 s 中得到 <code>&quot;rabbit&quot; 的方案</code>。
<code><strong><u>rabb</u></strong>b<strong><u>it</u></strong></code>
<code><strong><u>ra</u></strong>b<strong><u>bbit</u></strong></code>
<code><strong><u>rab</u></strong>b<strong><u>bit</u></strong></code></pre>

<p><strong>示例&nbsp;2：</strong></p>

<pre>
<strong>输入：</strong>s = &quot;babgbag&quot;, t = &quot;bag&quot;
<code><strong>输出</strong></code><strong>：</strong><code>5
</code><strong>解释：</strong>
如下图所示, 有 5 种可以从 s 中得到 <code>&quot;bag&quot; 的方案</code>。 
<code><strong><u>ba</u></strong>b<u><strong>g</strong></u>bag</code>
<code><strong><u>ba</u></strong>bgba<strong><u>g</u></strong></code>
<code><u><strong>b</strong></u>abgb<strong><u>ag</u></strong></code>
<code>ba<u><strong>b</strong></u>gb<u><strong>ag</strong></u></code>
<code>babg<strong><u>bag</u></strong></code>
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>0 &lt;= s.length, t.length &lt;= 1000</code></li>
	<li><code>s</code> 和 <code>t</code> 由英文字母组成</li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 115&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/distinct-subsequences/">https://leetcode-cn.com/problems/distinct-subsequences/</a></p>


## 题解


### Java

```Java
// @Title: 子序列的数目 (子序列的数目)
// @Author: robert.sunq
// @Date: 2023-07-30 23:30:09
// @Runtime: 10 ms
// @Memory: 43.7 MB

class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (m > n) {
            return 0;
        }

        int[][] dp = new int[n+1][m+1];
        for(int i = 0; i <= n; i++) {
            for (int j =0; j <= i && j <= m; j++) {
                if (i ==0 && j == 0 ) {
                    dp[i][j] = 1;
                } else if (i == 0 || j == 0) {
                    // 第二个长度为0，则 空字符串是任何字符串的子序列
                    dp[i][j] = j == 0 ? 1 : 0;
                } else {
                    
                    if (s.charAt(i - 1) == t.charAt(j - 1)) {
                        // s[i] == t[j], 则当前 前缀 i长的字符串包含 t中前缀j长字符串的个数
                        // 等于 子序列对比中如果 s[i] 对应 t[j] 则 其个数为 dp[i - 1][j -1]
                        // 加上 子序列对比中 d[i] 不对应 t[j] 则 个数为 dp[i - 1][j] 
                        dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                    } else {
                        // 那么s_i中的所有t_j子序列，必不包含s[i]，即s_i-1和s_i中tj的数量是一样的
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
        return dp[n][m];
    }
}
```



## 相关话题

- [字符串](https://leetcode.cn//tag/string)
- [动态规划](https://leetcode.cn//tag/dynamic-programming)

## 相似题目



