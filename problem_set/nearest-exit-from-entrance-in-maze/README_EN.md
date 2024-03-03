
| English | [简体中文](README.md) |

# [1926. Nearest Exit from Entrance in Maze](https://leetcode.cn//problems/nearest-exit-from-entrance-in-maze/)

## Description

<p>You are given an <code>m x n</code> matrix <code>maze</code> (<strong>0-indexed</strong>) with empty cells (represented as <code>&#39;.&#39;</code>) and walls (represented as <code>&#39;+&#39;</code>). You are also given the <code>entrance</code> of the maze, where <code>entrance = [entrance<sub>row</sub>, entrance<sub>col</sub>]</code> denotes the row and column of the cell you are initially standing at.</p>

<p>In one step, you can move one cell <strong>up</strong>, <strong>down</strong>, <strong>left</strong>, or <strong>right</strong>. You cannot step into a cell with a wall, and you cannot step outside the maze. Your goal is to find the <strong>nearest exit</strong> from the <code>entrance</code>. An <strong>exit</strong> is defined as an <strong>empty cell</strong> that is at the <strong>border</strong> of the <code>maze</code>. The <code>entrance</code> <strong>does not count</strong> as an exit.</p>

<p>Return <em>the <strong>number of steps</strong> in the shortest path from the </em><code>entrance</code><em> to the nearest exit, or </em><code>-1</code><em> if no such path exists</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/06/04/nearest1-grid.jpg" style="width: 333px; height: 253px;" />
<pre>
<strong>Input:</strong> maze = [[&quot;+&quot;,&quot;+&quot;,&quot;.&quot;,&quot;+&quot;],[&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;+&quot;],[&quot;+&quot;,&quot;+&quot;,&quot;+&quot;,&quot;.&quot;]], entrance = [1,2]
<strong>Output:</strong> 1
<strong>Explanation:</strong> There are 3 exits in this maze at [1,0], [0,2], and [2,3].
Initially, you are at the entrance cell [1,2].
- You can reach [1,0] by moving 2 steps left.
- You can reach [0,2] by moving 1 step up.
It is impossible to reach [2,3] from the entrance.
Thus, the nearest exit is [0,2], which is 1 step away.
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/06/04/nearesr2-grid.jpg" style="width: 253px; height: 253px;" />
<pre>
<strong>Input:</strong> maze = [[&quot;+&quot;,&quot;+&quot;,&quot;+&quot;],[&quot;.&quot;,&quot;.&quot;,&quot;.&quot;],[&quot;+&quot;,&quot;+&quot;,&quot;+&quot;]], entrance = [1,0]
<strong>Output:</strong> 2
<strong>Explanation:</strong> There is 1 exit in this maze at [1,2].
[1,0] does not count as an exit since it is the entrance cell.
Initially, you are at the entrance cell [1,0].
- You can reach [1,2] by moving 2 steps right.
Thus, the nearest exit is [1,2], which is 2 steps away.
</pre>

<p><strong class="example">Example 3:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/06/04/nearest3-grid.jpg" style="width: 173px; height: 93px;" />
<pre>
<strong>Input:</strong> maze = [[&quot;.&quot;,&quot;+&quot;]], entrance = [0,0]
<strong>Output:</strong> -1
<strong>Explanation:</strong> There are no exits in this maze.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>maze.length == m</code></li>
	<li><code>maze[i].length == n</code></li>
	<li><code>1 &lt;= m, n &lt;= 100</code></li>
	<li><code>maze[i][j]</code> is either <code>&#39;.&#39;</code> or <code>&#39;+&#39;</code>.</li>
	<li><code>entrance.length == 2</code></li>
	<li><code>0 &lt;= entrance<sub>row</sub> &lt; m</code></li>
	<li><code>0 &lt;= entrance<sub>col</sub> &lt; n</code></li>
	<li><code>entrance</code> will always be an empty cell.</li>
</ul>


## Solutions


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



## Related Topics

- [Breadth-First Search](https://leetcode.cn//tag/breadth-first-search)
- [Array](https://leetcode.cn//tag/array)
- [Matrix](https://leetcode.cn//tag/matrix)

## Similar Questions


