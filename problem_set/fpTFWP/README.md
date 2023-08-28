
| [English](README_EN.md) | 简体中文 |

# [LCR 112. 矩阵中的最长递增路径](https://leetcode.cn//problems/fpTFWP/)

## 题目描述

<p>给定一个&nbsp;<code>m x n</code> 整数矩阵&nbsp;<code>matrix</code> ，找出其中 <strong>最长递增路径</strong> 的长度。</p>

<p>对于每个单元格，你可以往上，下，左，右四个方向移动。 <strong>不能</strong> 在 <strong>对角线</strong> 方向上移动或移动到 <strong>边界外</strong>（即不允许环绕）。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2021/01/05/grid1.jpg" style="width: 242px; height: 242px;" /></p>

<pre>
<strong>输入：</strong>matrix = [[9,9,4],[6,6,8],[2,1,1]]
<strong>输出：</strong>4 
<strong>解释：</strong>最长递增路径为&nbsp;<code>[1, 2, 6, 9]</code>。</pre>

<p><strong>示例 2：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2021/01/27/tmp-grid.jpg" style="width: 253px; height: 253px;" /></p>

<pre>
<strong>输入：</strong>matrix = [[3,4,5],[3,2,6],[2,2,1]]
<strong>输出：</strong>4 
<strong>解释：</strong>最长递增路径是&nbsp;<code>[3, 4, 5, 6]</code>。注意不允许在对角线方向上移动。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>matrix = [[1]]
<strong>输出：</strong>1
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>m == matrix.length</code></li>
	<li><code>n == matrix[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 200</code></li>
	<li><code>0 &lt;= matrix[i][j] &lt;= 2<sup>31</sup> - 1</code></li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 329&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix/">https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix/</a></p>


## 题解


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



## 相关话题

- [深度优先搜索](https://leetcode.cn//tag/depth-first-search)
- [广度优先搜索](https://leetcode.cn//tag/breadth-first-search)
- [图](https://leetcode.cn//tag/graph)
- [拓扑排序](https://leetcode.cn//tag/topological-sort)
- [记忆化搜索](https://leetcode.cn//tag/memoization)
- [数组](https://leetcode.cn//tag/array)
- [动态规划](https://leetcode.cn//tag/dynamic-programming)
- [矩阵](https://leetcode.cn//tag/matrix)

## 相似题目


