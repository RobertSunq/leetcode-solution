
| [English](README_EN.md) | 简体中文 |

# [2304. 网格中的最小路径代价](https://leetcode.cn//problems/minimum-path-cost-in-a-grid/)

## 题目描述

<p>给你一个下标从 <strong>0</strong> 开始的整数矩阵&nbsp;<code>grid</code> ，矩阵大小为 <code>m x n</code> ，由从 <code>0</code> 到 <code>m * n - 1</code> 的不同整数组成。你可以在此矩阵中，从一个单元格移动到 <strong>下一行</strong> 的任何其他单元格。如果你位于单元格 <code>(x, y)</code> ，且满足 <code>x &lt; m - 1</code> ，你可以移动到 <code>(x + 1, 0)</code>, <code>(x + 1, 1)</code>, ..., <code>(x + 1, n - 1)</code><strong> </strong>中的任何一个单元格。<strong>注意：</strong>&nbsp;在最后一行中的单元格不能触发移动。</p>

<p>每次可能的移动都需要付出对应的代价，代价用一个下标从 <strong>0</strong> 开始的二维数组 <code>moveCost</code> 表示，该数组大小为 <code>(m * n) x n</code> ，其中 <code>moveCost[i][j]</code> 是从值为 <code>i</code> 的单元格移动到下一行第 <code>j</code> 列单元格的代价。从&nbsp;<code>grid</code> 最后一行的单元格移动的代价可以忽略。</p>

<p><code>grid</code> 一条路径的代价是：所有路径经过的单元格的 <strong>值之和</strong> 加上 所有移动的 <strong>代价之和 </strong>。从 <strong>第一行</strong> 任意单元格出发，返回到达 <strong>最后一行</strong> 任意单元格的最小路径代价<em>。</em></p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2022/04/28/griddrawio-2.png" style="width: 301px; height: 281px;" /></p>

<pre>
<strong>输入：</strong>grid = [[5,3],[4,0],[2,1]], moveCost = [[9,8],[1,5],[10,12],[18,6],[2,4],[14,3]]
<strong>输出：</strong>17
<strong>解释：</strong>最小代价的路径是 5 -&gt; 0 -&gt; 1 。
- 路径途经单元格值之和 5 + 0 + 1 = 6 。
- 从 5 移动到 0 的代价为 3 。
- 从 0 移动到 1 的代价为 8 。
路径总代价为 6 + 3 + 8 = 17 。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>grid = [[5,1,2],[4,0,3]], moveCost = [[12,10,15],[20,23,8],[21,7,1],[8,1,13],[9,10,25],[5,3,2]]
<strong>输出：</strong>6
<strong>解释：</strong>
最小代价的路径是 2 -&gt; 3 。 
- 路径途经单元格值之和 2 + 3 = 5 。 
- 从 2 移动到 3 的代价为 1 。 
路径总代价为 5 + 1 = 6 。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>m == grid.length</code></li>
	<li><code>n == grid[i].length</code></li>
	<li><code>2 &lt;= m, n &lt;= 50</code></li>
	<li><code>grid</code> 由从 <code>0</code> 到 <code>m * n - 1</code> 的不同整数组成</li>
	<li><code>moveCost.length == m * n</code></li>
	<li><code>moveCost[i].length == n</code></li>
	<li><code>1 &lt;= moveCost[i][j] &lt;= 100</code></li>
</ul>


## 题解


### Java

```Java
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
```



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [动态规划](https://leetcode.cn//tag/dynamic-programming)
- [矩阵](https://leetcode.cn//tag/matrix)

## 相似题目



