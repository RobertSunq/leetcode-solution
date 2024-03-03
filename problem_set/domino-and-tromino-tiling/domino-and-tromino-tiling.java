
```
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
