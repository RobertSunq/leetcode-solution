
```
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
