
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer II 094. 最少回文分割](https://leetcode.cn//problems/omKAoA/)

## 题目描述

<p>给定一个字符串 <code>s</code>，请将 <code>s</code> 分割成一些子串，使每个子串都是回文串。</p>

<p>返回符合要求的 <strong>最少分割次数</strong> 。</p>

<div class="original__bRMd">
<div>
<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = &quot;aab&quot;
<strong>输出：</strong>1
<strong>解释：</strong>只需一次分割就可将&nbsp;s<em> </em>分割成 [&quot;aa&quot;,&quot;b&quot;] 这样两个回文子串。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = &quot;a&quot;
<strong>输出：</strong>0
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>s = &quot;ab&quot;
<strong>输出：</strong>1
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 2000</code></li>
	<li><code>s</code> 仅由小写英文字母组成</li>
</ul>
</div>
</div>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 132&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/palindrome-partitioning-ii/">https://leetcode-cn.com/problems/palindrome-partitioning-ii/</a></p>


## 题解


### Java

```Java
// @Title: 最少回文分割 (最少回文分割)
// @Author: robert.sunq
// @Date: 2023-07-28 23:28:08
// @Runtime: 20 ms
// @Memory: 47.5 MB

class Solution {

    boolean[][] dp;
    int ans;
    int n;

    public int minCut(String s) {
        n = s.length();
        ans = n;

        // 保存i -- j 的字符串是不是回文子串
        dp = new boolean[n][n];

        for (int i = 0; i< n; i++) {
            for (int j = 0; j<n; j++) {
                dp[i][j] = true;
            }
        }
        for (int i = n - 1; i >=0; i--) {
            for (int j = i + 1; j < n ; j++) {
                dp[i][j] = dp[i+1][j - 1] && (s.charAt(i) == s.charAt(j));
            }
        }

        
        // 记录 0 - i 的最小分割次数
        int[] f = new int[n];
        Arrays.fill(f, Integer.MAX_VALUE);
        for (int i = 0; i<n; i++) {
            // 到当前位置是一个回文串，此时不用分割是最小的
            if (dp[0][i]) {
                f[i] = 0;
            } else {
                // 如果 j+1 --- i 是一个回文串，则 f[i] = f[j] + 1, 因此用递归的形式找最小的f[j]
                for (int j = 0; j < i; j++) {
                    if (dp[j+1][i]) {
                        f[i] = Math.min(f[j] + 1, f[i]);
                    }
                }
            }
        }
        return f[n - 1];
    }

    // 查看https://leetcode.cn/problems/M99OJA/
}
```



## 相关话题

- [字符串](https://leetcode.cn//tag/string)
- [动态规划](https://leetcode.cn//tag/dynamic-programming)

## 相似题目



