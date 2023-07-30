
| English | [简体中文](README.md) |

# [剑指 Offer II 099. 最小路径之和](https://leetcode.cn//problems/0i0mDW/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 最小路径之和 (最小路径之和)
// @Author: robert.sunq
// @Date: 2023-07-30 23:46:43
// @Runtime: 2 ms
// @Memory: 42.5 MB

class Solution {
    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                } else if ( j == 0) {
                    dp[i][j] = dp[i -1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] , dp[i] [ j -1]) + grid[i][j];
                }
            }
        }

        return dp[m - 1][ n - 1];

    }
}
```



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Dynamic Programming](https://leetcode.cn//tag/dynamic-programming)
- [Matrix](https://leetcode.cn//tag/matrix)

## Similar Questions


