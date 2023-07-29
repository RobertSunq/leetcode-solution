
```
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
