
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer II 099. 最小路径之和](https://leetcode.cn//problems/0i0mDW/)

## 题目描述

<p>给定一个包含非负整数的 <code><em>m</em>&nbsp;x&nbsp;<em>n</em></code>&nbsp;网格&nbsp;<code>grid</code> ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。</p>

<p><strong>说明：</strong>一个机器人每次只能向下或者向右移动一步。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2020/11/05/minpath.jpg" style="width: 242px; height: 242px;" /></p>

<pre>
<strong>输入：</strong>grid = [[1,3,1],[1,5,1],[4,2,1]]
<strong>输出：</strong>7
<strong>解释：</strong>因为路径 1&rarr;3&rarr;1&rarr;1&rarr;1 的总和最小。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>grid = [[1,2,3],[4,5,6]]
<strong>输出：</strong>12
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>m == grid.length</code></li>
	<li><code>n == grid[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 200</code></li>
	<li><code>0 &lt;= grid[i][j] &lt;= 100</code></li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 64&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/minimum-path-sum/">https://leetcode-cn.com/problems/minimum-path-sum/</a></p>


## 题解


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



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [动态规划](https://leetcode.cn//tag/dynamic-programming)
- [矩阵](https://leetcode.cn//tag/matrix)

## 相似题目



