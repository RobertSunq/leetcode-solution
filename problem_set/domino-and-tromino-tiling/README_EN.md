
| English | [简体中文](README.md) |

# [790. Domino and Tromino Tiling](https://leetcode.cn//problems/domino-and-tromino-tiling/)

## Description

<p>You have two types of tiles: a <code>2 x 1</code> domino shape and a tromino shape. You may rotate these shapes.</p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/07/15/lc-domino.jpg" style="width: 362px; height: 195px;" />
<p>Given an integer n, return <em>the number of ways to tile an</em> <code>2 x n</code> <em>board</em>. Since the answer may be very large, return it <strong>modulo</strong> <code>10<sup>9</sup> + 7</code>.</p>

<p>In a tiling, every square must be covered by a tile. Two tilings are different if and only if there are two 4-directionally adjacent cells on the board such that exactly one of the tilings has both squares occupied by a tile.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/07/15/lc-domino1.jpg" style="width: 500px; height: 226px;" />
<pre>
<strong>Input:</strong> n = 3
<strong>Output:</strong> 5
<strong>Explanation:</strong> The five different ways are show above.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 1
<strong>Output:</strong> 1
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 1000</code></li>
</ul>


## Solutions


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



## Related Topics

- [Dynamic Programming](https://leetcode.cn//tag/dynamic-programming)

## Similar Questions


