
| English | [简体中文](README.md) |

# [994. Rotting Oranges](https://leetcode.cn//problems/rotting-oranges/)

## Description

<p>You are given an <code>m x n</code> <code>grid</code> where each cell can have one of three values:</p>

<ul>
	<li><code>0</code> representing an empty cell,</li>
	<li><code>1</code> representing a fresh orange, or</li>
	<li><code>2</code> representing a rotten orange.</li>
</ul>

<p>Every minute, any fresh orange that is <strong>4-directionally adjacent</strong> to a rotten orange becomes rotten.</p>

<p>Return <em>the minimum number of minutes that must elapse until no cell has a fresh orange</em>. If <em>this is impossible, return</em> <code>-1</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2019/02/16/oranges.png" style="width: 650px; height: 137px;" />
<pre>
<strong>Input:</strong> grid = [[2,1,1],[1,1,0],[0,1,1]]
<strong>Output:</strong> 4
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> grid = [[2,1,1],[0,1,1],[1,0,1]]
<strong>Output:</strong> -1
<strong>Explanation:</strong> The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> grid = [[0,2]]
<strong>Output:</strong> 0
<strong>Explanation:</strong> Since there are already no fresh oranges at minute 0, the answer is just 0.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m == grid.length</code></li>
	<li><code>n == grid[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 10</code></li>
	<li><code>grid[i][j]</code> is <code>0</code>, <code>1</code>, or <code>2</code>.</li>
</ul>


## Solutions


### Java

```Java
// @Title: 腐烂的橘子 (Rotting Oranges)
// @Author: robert.sunq
// @Date: 2023-09-12 22:11:55
// @Runtime: 1 ms
// @Memory: 40.1 MB

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        LinkedList<int[]> queue = new LinkedList<>();
        int[][] dir = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i,j});
                }
            }
        }
        int step = -1;
        while(!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] tmp = queue.poll();
                for (int j = 0; j < dir.length; j++) {
                    int row = tmp[0] + dir[j][0];
                    int col = tmp[1] + dir[j][1];
                    if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == 2 || grid[row][col] == 0) {
                        continue;
                    }
                    queue.offer(new int[]{row, col});
                    grid[row][col] = 2;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        // 当没有橘子需要腐烂的时候[[0]]，即没有橘子时，返回 0
        return step < 0 ? 0 : step;
    }
}
```



## Related Topics

- [Breadth-First Search](https://leetcode.cn//tag/breadth-first-search)
- [Array](https://leetcode.cn//tag/array)
- [Matrix](https://leetcode.cn//tag/matrix)

## Similar Questions

- [Walls and Gates](../walls-and-gates/README_EN.md)
