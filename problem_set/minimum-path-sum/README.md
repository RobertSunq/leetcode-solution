
| [English](README_EN.md) | 简体中文 |

# [64. 最小路径和](https://leetcode.cn//problems/minimum-path-sum/)

## 题目描述

<p>给定一个包含非负整数的 <code><em>m</em>&nbsp;x&nbsp;<em>n</em></code>&nbsp;网格&nbsp;<code>grid</code> ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。</p>

<p><strong>说明：</strong>每次只能向下或者向右移动一步。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/05/minpath.jpg" style="width: 242px; height: 242px;" />
<pre>
<strong>输入：</strong>grid = [[1,3,1],[1,5,1],[4,2,1]]
<strong>输出：</strong>7
<strong>解释：</strong>因为路径 1→3→1→1→1 的总和最小。
</pre>

<p><strong class="example">示例 2：</strong></p>

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
	<li><code>0 &lt;= grid[i][j] &lt;= 200</code></li>
</ul>


## 题解


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



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [动态规划](https://leetcode.cn//tag/dynamic-programming)
- [矩阵](https://leetcode.cn//tag/matrix)

## 相似题目


- [不同路径](../unique-paths/README.md)
- [地下城游戏](../dungeon-game/README.md)
- [摘樱桃](../cherry-pickup/README.md)
