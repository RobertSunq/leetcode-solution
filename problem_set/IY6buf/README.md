
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer II 096. 字符串交织](https://leetcode.cn//problems/IY6buf/)

## 题目描述

<p>给定三个字符串&nbsp;<code>s1</code>、<code>s2</code>、<code>s3</code>，请判断&nbsp;<code>s3</code>&nbsp;能不能由&nbsp;<code>s1</code>&nbsp;和&nbsp;<code>s2</code><em>&nbsp;</em><strong>交织（交错）</strong>&nbsp;组成。</p>

<p>两个字符串 <code>s</code> 和 <code>t</code> <strong>交织</strong>&nbsp;的定义与过程如下，其中每个字符串都会被分割成若干 <strong>非空</strong> 子字符串：</p>

<ul>
	<li><code>s = s<sub>1</sub> + s<sub>2</sub> + ... + s<sub>n</sub></code></li>
	<li><code>t = t<sub>1</sub> + t<sub>2</sub> + ... + t<sub>m</sub></code></li>
	<li><code>|n - m| &lt;= 1</code></li>
	<li><b>交织</b> 是 <code>s<sub>1</sub> + t<sub>1</sub> + s<sub>2</sub> + t<sub>2</sub> + s<sub>3</sub> + t<sub>3</sub> + ...</code> 或者 <code>t<sub>1</sub> + s<sub>1</sub> + t<sub>2</sub> + s<sub>2</sub> + t<sub>3</sub> + s<sub>3</sub> + ...</code></li>
</ul>

<p><strong>提示：</strong><code>a + b</code> 意味着字符串 <code>a</code> 和 <code>b</code> 连接。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2020/09/02/interleave.jpg" style="width: 561px; height: 203px;" /></p>

<pre>
<strong>输入：</strong>s1 = &quot;aabcc&quot;, s2 = &quot;dbbca&quot;, s3 = &quot;aadbbcbcac&quot;
<strong>输出：</strong>true
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s1 = &quot;aabcc&quot;, s2 = &quot;dbbca&quot;, s3 = &quot;aadbbbaccc&quot;
<strong>输出：</strong>false
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>s1 = &quot;&quot;, s2 = &quot;&quot;, s3 = &quot;&quot;
<strong>输出：</strong>true
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>0 &lt;= s1.length, s2.length &lt;= 100</code></li>
	<li><code>0 &lt;= s3.length &lt;= 200</code></li>
	<li><code>s1</code>、<code>s2</code>、和 <code>s3</code> 都由小写英文字母组成</li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 97&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/interleaving-string/">https://leetcode-cn.com/problems/interleaving-string/</a></p>


## 题解


### Java

```Java
// @Title: 字符串交织 (字符串交织)
// @Author: robert.sunq
// @Date: 2023-07-29 23:48:05
// @Runtime: 7 ms
// @Memory: 39.8 MB

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();
        
        if (n3 != n2 + n1) {
            return false;
        }

        // 表示 长度为s1 的 i 前缀 和 s2 的 j 前缀能否合并 s3的前缀 i + j
        boolean[][] dp = new boolean[n1 + 1][n2 + 1];
        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                if (i ==0 && j == 0) {
                    dp[i][j] = true;
                } else {

                    // dp[i][j] =  (s1[i] == s3[i + j] and dp[i - 1][j]) OR   (s2[j] == s3[i + j] and dp[i][j - 1])
                    if ( i > 0) {
                        dp[i][j] = dp[i][j] || (s1.charAt(i - 1) == s3.charAt( i + j - 1) && dp[i - 1][j]);
                    }
                    if (j > 0) {
                        dp[i][j] = dp[i][j] || (s2.charAt(j - 1) == s3.charAt( i + j - 1) && dp[i][j - 1]);
                    }
                    
                }
            }
        }

        return dp[n1][n2];
    }
}
```



## 相关话题

- [字符串](https://leetcode.cn//tag/string)
- [动态规划](https://leetcode.cn//tag/dynamic-programming)

## 相似题目



