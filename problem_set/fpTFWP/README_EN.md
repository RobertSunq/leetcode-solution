
| English | [简体中文](README.md) |

# [LCR 112. 矩阵中的最长递增路径](https://leetcode.cn//problems/fpTFWP/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 矩阵中的最长递增路径 (矩阵中的最长递增路径)
// @Author: robert.sunq
// @Date: 2023-08-06 16:13:31
// @Runtime: 8 ms
// @Memory: 42.6 MB

class Solution {

    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int row, col;
    public int longestIncreasingPath(int[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        row = matrix.length;
        col = matrix[0].length;

        // 记忆数组，避免大量重复计算
        int[][] memo = new int[row][col];
        int ans = 0;
        for (int i =0; i < row; i++) {
            for (int j =0; j < col; j++) {
                ans = Math.max(ans, dfs(matrix, i , j , memo));
            }
        }

        return ans;

    }

    private int dfs(int[][] matrix, int i, int j, int[][] memo) {
        if (memo[i][j] != 0) {
            return memo[i][j];
        }

        memo[i][j] = 1;
        for (int[] dir : dirs) {
            int nextI = i + dir[0];
            int nextJ = j + dir[1];
            if (nextI >= 0 && nextI < row && nextJ >= 0 && nextJ < col && matrix[i][j] > matrix[nextI][nextJ]) {
                memo[i][j] = Math.max(memo[i][j], dfs(matrix, nextI, nextJ, memo) + 1);
            }
        }

        return memo[i][j];
    }
}
```



## Related Topics

- [Depth-First Search](https://leetcode.cn//tag/depth-first-search)
- [Breadth-First Search](https://leetcode.cn//tag/breadth-first-search)
- [Graph](https://leetcode.cn//tag/graph)
- [Topological Sort](https://leetcode.cn//tag/topological-sort)
- [Memoization](https://leetcode.cn//tag/memoization)
- [Array](https://leetcode.cn//tag/array)
- [Dynamic Programming](https://leetcode.cn//tag/dynamic-programming)
- [Matrix](https://leetcode.cn//tag/matrix)

## Similar Questions


