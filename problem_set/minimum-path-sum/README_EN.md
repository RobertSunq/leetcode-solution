
| English | [简体中文](README.md) |

# [64. Minimum Path Sum](https://leetcode.cn//problems/minimum-path-sum/)

## Description

<p>Given a <code>m x n</code> <code>grid</code> filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.</p>

<p><strong>Note:</strong> You can only move either down or right at any point in time.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/05/minpath.jpg" style="width: 242px; height: 242px;" />
<pre>
<strong>Input:</strong> grid = [[1,3,1],[1,5,1],[4,2,1]]
<strong>Output:</strong> 7
<strong>Explanation:</strong> Because the path 1 &rarr; 3 &rarr; 1 &rarr; 1 &rarr; 1 minimizes the sum.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> grid = [[1,2,3],[4,5,6]]
<strong>Output:</strong> 12
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m == grid.length</code></li>
	<li><code>n == grid[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 200</code></li>
	<li><code>0 &lt;= grid[i][j] &lt;= 100</code></li>
</ul>


## Solutions


### Java

```Java
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
```



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Dynamic Programming](https://leetcode.cn//tag/dynamic-programming)
- [Matrix](https://leetcode.cn//tag/matrix)

## Similar Questions

- [Unique Paths](../unique-paths/README_EN.md)
- [Dungeon Game](../dungeon-game/README_EN.md)
- [Cherry Pickup](../cherry-pickup/README_EN.md)
