
| [English](README_EN.md) | 简体中文 |

# [1926. 迷宫中离入口最近的出口](https://leetcode.cn//problems/nearest-exit-from-entrance-in-maze/)

## 题目描述

<p>给你一个 <code>m x n</code> 的迷宫矩阵 <code>maze</code> （<strong>下标从 0 开始</strong>），矩阵中有空格子（用 <code>'.'</code> 表示）和墙（用 <code>'+'</code> 表示）。同时给你迷宫的入口 <code>entrance</code> ，用 <code>entrance = [entrance<sub>row</sub>, entrance<sub>col</sub>]</code> 表示你一开始所在格子的行和列。</p>

<p>每一步操作，你可以往 <strong>上</strong>，<strong>下</strong>，<strong>左</strong> 或者 <strong>右</strong> 移动一个格子。你不能进入墙所在的格子，你也不能离开迷宫。你的目标是找到离 <code>entrance</code> <strong>最近</strong> 的出口。<strong>出口</strong> 的含义是 <code>maze</code> <strong>边界</strong> 上的 <strong>空格子</strong>。<code>entrance</code> 格子 <strong>不算</strong> 出口。</p>

<p>请你返回从 <code>entrance</code> 到最近出口的最短路径的 <strong>步数</strong> ，如果不存在这样的路径，请你返回 <code>-1</code> 。</p>

<p> </p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/06/04/nearest1-grid.jpg" style="width: 333px; height: 253px;">
<pre><b>输入：</b>maze = [["+","+",".","+"],[".",".",".","+"],["+","+","+","."]], entrance = [1,2]
<b>输出：</b>1
<b>解释：</b>总共有 3 个出口，分别位于 (1,0)，(0,2) 和 (2,3) 。
一开始，你在入口格子 (1,2) 处。
- 你可以往左移动 2 步到达 (1,0) 。
- 你可以往上移动 1 步到达 (0,2) 。
从入口处没法到达 (2,3) 。
所以，最近的出口是 (0,2) ，距离为 1 步。
</pre>

<p><strong>示例 2：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/06/04/nearesr2-grid.jpg" style="width: 253px; height: 253px;">
<pre><b>输入：</b>maze = [["+","+","+"],[".",".","."],["+","+","+"]], entrance = [1,0]
<b>输出：</b>2
<b>解释：</b>迷宫中只有 1 个出口，在 (1,2) 处。
(1,0) 不算出口，因为它是入口格子。
初始时，你在入口与格子 (1,0) 处。
- 你可以往右移动 2 步到达 (1,2) 处。
所以，最近的出口为 (1,2) ，距离为 2 步。
</pre>

<p><strong>示例 3：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/06/04/nearest3-grid.jpg" style="width: 173px; height: 93px;">
<pre><b>输入：</b>maze = [[".","+"]], entrance = [0,0]
<b>输出：</b>-1
<b>解释：</b>这个迷宫中没有出口。
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>maze.length == m</code></li>
	<li><code>maze[i].length == n</code></li>
	<li><code>1 &lt;= m, n &lt;= 100</code></li>
	<li><code>maze[i][j]</code> 要么是 <code>'.'</code> ，要么是 <code>'+'</code> 。</li>
	<li><code>entrance.length == 2</code></li>
	<li><code>0 &lt;= entrance<sub>row</sub> &lt; m</code></li>
	<li><code>0 &lt;= entrance<sub>col</sub> &lt; n</code></li>
	<li><code>entrance</code> 一定是空格子。</li>
</ul>


## 题解


### Java

```Java
// @Title: 迷宫中离入口最近的出口 (Nearest Exit from Entrance in Maze)
// @Author: robert.sunq
// @Date: 2023-09-11 22:18:14
// @Runtime: 8 ms
// @Memory: 43.2 MB

class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        LinkedList<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{entrance[0], entrance[1]});

        int m = maze.length;
        int n = maze[0].length;
        // 堵住入口
        maze[entrance[0]][entrance[1]] = '+';
        int[][] dir = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        int step = -1;
        while(!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] now = queue.poll();
                for (int j = 0; j < dir.length; j++) {
                    int row = now[0] + dir[j][0];
                    int col = now[1] + dir[j][1];
                    if (row < 0 || row >= m || col < 0 || col >= n || maze[row][col] == '+') {
                        continue;
                    }
                    // bfs  所以一定是最近的最先到达
                    if (row == 0 || row == m -1 || col == 0 || col == n - 1) {
                        return step + 1;
                    }
                    // 标记访问过了
                    maze[row][col] = '+';
                    queue.offer(new int[]{row, col});
                }
            }
        }

        return -1;
    }
}
```



## 相关话题

- [广度优先搜索](https://leetcode.cn//tag/breadth-first-search)
- [数组](https://leetcode.cn//tag/array)
- [矩阵](https://leetcode.cn//tag/matrix)

## 相似题目



