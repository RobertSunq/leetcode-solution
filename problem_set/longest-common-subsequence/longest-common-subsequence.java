
```
// @Title: 最长公共子序列 (Longest Common Subsequence)
// @Author: robert.sunq
// @Date: 2023-09-24 14:26:45
// @Runtime: 21 ms
// @Memory: 47.2 MB

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();

        int[][] dp = new int[n1 + 1][n2 + 1];

        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j -1], dp[i - 1][j]);
                }
            }
        }

        return dp[n1][n2];
    }
}
