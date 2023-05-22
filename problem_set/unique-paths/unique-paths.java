
```
// @Title: 不同路径 (Unique Paths)
// @Author: robert.sunq
// @Date: 2021-06-04 23:51:00
// @Runtime: 0 ms
// @Memory: 35.2 MB

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // 到上边界个点的 左边界个点的 路径均只有有一种
        for(int i = 0 ; i<m;i++){
            dp[i][0] = 1;
        }
        for(int j = 0 ; j<n;j++){
            dp[0][j] = 1;
        }

        // 动态规划  到达位置do[i][j] 的路径为 dp[i-1][j] + dp[i][j-1]的和
        for(int i = 1 ; i<m;i++){
            for(int j = 1;j<n;j++){
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }

        return dp[m-1][n-1];
    }
}
