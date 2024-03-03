
```
// @Title: 网格中的最小路径代价 (Minimum Path Cost in a Grid)
// @Author: robert.sunq
// @Date: 2023-11-22 21:19:50
// @Runtime: 7 ms
// @Memory: 64.9 MB

class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (i == 0) {
                for (int j = 0; j < n; j++) {
                    dp[i][j] = grid[i][j];
                }
            } else {
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + moveCost[grid[i - 1][k]][j]);
                }
                dp[i][j] = dp[i][j] + grid[i][j];
                if (i == m - 1) {
                    ans = Math.min(ans, dp[i][j]);
                }   
            }

        }

        return ans;
    }
}
