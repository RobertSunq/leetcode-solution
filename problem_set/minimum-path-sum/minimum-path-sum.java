
```
// @Title: 最小路径和 (Minimum Path Sum)
// @Author: robert.sunq
// @Date: 2021-06-04 23:58:29
// @Runtime: 4 ms
// @Memory: 40.9 MB

class Solution {
    public int minPathSum(int[][] grid) {
        // 思路同62题
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for(int i = 1; i<grid.length;i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for(int j = 1;j<grid[0].length;j++){
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }
        for(int i = 1;i<grid.length;i++){
            for(int j = 1;j<grid[0].length;j++){
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
}
