
| [English](README_EN.md) | 简体中文 |

# [790. 多米诺和托米诺平铺](https://leetcode.cn//problems/domino-and-tromino-tiling/)

## 题目描述

<p>有两种形状的瓷砖：一种是&nbsp;<code>2 x 1</code> 的多米诺形，另一种是形如&nbsp;"L" 的托米诺形。两种形状都可以旋转。</p>

<p><img src="https://assets.leetcode.com/uploads/2021/07/15/lc-domino.jpg" style="height: 195px; width: 362px;" /></p>

<p>给定整数 n ，返回可以平铺&nbsp;<code>2 x n</code> 的面板的方法的数量。<strong>返回对</strong>&nbsp;<code>10<sup>9</sup>&nbsp;+ 7</code>&nbsp;<strong>取模&nbsp;</strong>的值。</p>

<p>平铺指的是每个正方形都必须有瓷砖覆盖。两个平铺不同，当且仅当面板上有四个方向上的相邻单元中的两个，使得恰好有一个平铺有一个瓷砖占据两个正方形。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<p><img src="https://assets.leetcode.com/uploads/2021/07/15/lc-domino1.jpg" style="height: 226px; width: 500px;" /></p>

<pre>
<strong>输入:</strong> n = 3
<strong>输出:</strong> 5
<strong>解释:</strong> 五种不同的方法如上所示。
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> n = 1
<strong>输出:</strong> 1
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 1000</code></li>
</ul>


## 题解


### Java

```Java
// @Title: 多米诺和托米诺平铺 (Domino and Tromino Tiling)
// @Author: robert.sunq
// @Date: 2023-09-23 20:20:30
// @Runtime: 1 ms
// @Memory: 38.6 MB

class Solution {

    static final int MOD = 1000000007;

    public int numTilings(int n) {

        // link https://leetcode.cn/problems/domino-and-tromino-tiling/solutions/1962465/duo-mi-nuo-he-tuo-mi-nuo-ping-pu-by-leet-7n0j/

        
        // 在第 i 列前面的正方形都被瓷砖覆盖，在第 i 列后面的正方形都没有被瓷砖覆盖（i 从 1 开始计数）。
        // 那么第 i 列的正方形有四种被覆盖的情况:
        // 一个正方形都没有被覆盖， 记作状态 0
        // 只有上方的正方形被覆盖， 记作状态 1
        // 只有下方的正方形被覆盖， 记作状态 2
        // 上下两个正方形都被覆盖， 记作状态 3
        int[][]  dp = new int[n+1][4];

        dp[0][3] = 1;
        for (int i = 1; i <= n ; i++) {
            dp[i][0] = dp[i - 1][3];
            dp[i][1] = (dp[i - 1][0] + dp[i -1][2]) % MOD;
            dp[i][2] = (dp[i-1][0] + dp[i - 1][1]) % MOD;
            dp[i][3] = (((dp[i - 1][0] + dp[i - 1][1]) % MOD + dp[i - 1][2]) % MOD + dp[i - 1][3]) % MOD;
        }
        return dp[n][3];
    }
}
```



## 相关话题

- [动态规划](https://leetcode.cn//tag/dynamic-programming)

## 相似题目



