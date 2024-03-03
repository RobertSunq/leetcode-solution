
| English | [简体中文](README.md) |

# [2258. Escape the Spreading Fire](https://leetcode.cn//problems/escape-the-spreading-fire/)

## Description

<p>You are given a <strong>0-indexed</strong> 2D integer array <code>grid</code> of size <code>m x n</code> which represents a field. Each cell has one of three values:</p>

<ul>
	<li><code>0</code> represents grass,</li>
	<li><code>1</code> represents fire,</li>
	<li><code>2</code> represents a wall that you and fire cannot pass through.</li>
</ul>

<p>You are situated in the top-left cell, <code>(0, 0)</code>, and you want to travel to the safehouse at the bottom-right cell, <code>(m - 1, n - 1)</code>. Every minute, you may move to an <strong>adjacent</strong> grass cell. <strong>After</strong> your move, every fire cell will spread to all <strong>adjacent</strong> cells that are not walls.</p>

<p>Return <em>the <strong>maximum</strong> number of minutes that you can stay in your initial position before moving while still safely reaching the safehouse</em>. If this is impossible, return <code>-1</code>. If you can <strong>always</strong> reach the safehouse regardless of the minutes stayed, return <code>10<sup>9</sup></code>.</p>

<p>Note that even if the fire spreads to the safehouse immediately after you have reached it, it will be counted as safely reaching the safehouse.</p>

<p>A cell is <strong>adjacent</strong> to another cell if the former is directly north, east, south, or west of the latter (i.e., their sides are touching).</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2022/03/10/ex1new.jpg" style="width: 650px; height: 404px;" />
<pre>
<strong>Input:</strong> grid = [[0,2,0,0,0,0,0],[0,0,0,2,2,1,0],[0,2,0,0,1,2,0],[0,0,2,2,2,0,2],[0,0,0,0,0,0,0]]
<strong>Output:</strong> 3
<strong>Explanation:</strong> The figure above shows the scenario where you stay in the initial position for 3 minutes.
You will still be able to safely reach the safehouse.
Staying for more than 3 minutes will not allow you to safely reach the safehouse.</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2022/03/10/ex2new2.jpg" style="width: 515px; height: 150px;" />
<pre>
<strong>Input:</strong> grid = [[0,0,0,0],[0,1,2,0],[0,2,0,0]]
<strong>Output:</strong> -1
<strong>Explanation:</strong> The figure above shows the scenario where you immediately move towards the safehouse.
Fire will spread to any cell you move towards and it is impossible to safely reach the safehouse.
Thus, -1 is returned.
</pre>

<p><strong class="example">Example 3:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2022/03/10/ex3new.jpg" style="width: 174px; height: 150px;" />
<pre>
<strong>Input:</strong> grid = [[0,0,0],[2,2,0],[1,2,0]]
<strong>Output:</strong> 1000000000
<strong>Explanation:</strong> The figure above shows the initial grid.
Notice that the fire is contained by walls and you will always be able to safely reach the safehouse.
Thus, 10<sup>9</sup> is returned.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m == grid.length</code></li>
	<li><code>n == grid[i].length</code></li>
	<li><code>2 &lt;= m, n &lt;= 300</code></li>
	<li><code>4 &lt;= m * n &lt;= 2 * 10<sup>4</sup></code></li>
	<li><code>grid[i][j]</code> is either <code>0</code>, <code>1</code>, or <code>2</code>.</li>
	<li><code>grid[0][0] == grid[m - 1][n - 1] == 0</code></li>
</ul>


## Solutions


### Java

```Java
// @Title: 逃离火灾 (Escape the Spreading Fire)
// @Author: robert.sunq
// @Date: 2023-11-09 23:28:02
// @Runtime: 13 ms
// @Memory: 45.6 MB

class Solution {
    // 从起点到格子 (i, j) 的最短时间为 arriveTime[1, j]
    // 火烧到格子(i, j) 的时间为 fireTime[i, j] 
    // 那么可以在起点带的最长的时间为 stayTime < fireTime[i][j] - arriveTime[i][j]

    // 注意 想明白一件事，为什么格子(i, j) 满足 stayTime 之后，在此之前的格子也满足呢。 
    // 因为蔓延速度为都为1， 所以当人后退 k 格到前面的时候，火也是后退 k 各。

    // 这样可以直接引申到 (m - 1, n - 1)， 
    // 如果待得时间 stayTime = fireTime[m - 1][n - 1] - arriveTime[m - 1][n - 1] 时
    // 因为是人和火同时到达的，如果存在除了终点外其他格子是可以通过就可以 返回 stayTime
    // 如果有一个格子，那么待的时间就应是 stayTime - 1， 火始终慢我一步（哈哈哈）， 因为人进火也进，人退火也退

    private static final int INF = 1000000000;
    private static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int maximumMinutes(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] fireTime = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(fireTime[i], INF);
        }

        // 通过 bFS 求出每个格子着火的时间
        bfs(grid, fireTime);
        // 找到起点到终点的最短时间
        int arriveTime = getArriveTime(grid, fireTime, 0);

        // 安全屋不可到达
        if (arriveTime < 0) {
            return -1;
        }
        // 火不会到达安全屋
        if (fireTime[m - 1][n - 1] == INF) {
            return INF;
        }
        int ans = fireTime[m - 1][ n - 1] - arriveTime;
        return getArriveTime(grid, fireTime, ans) >= 0 ? ans : (ans - 1);
    }   


    private void bfs(int[][] grid, int[][] fireTime) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<int[]>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    fireTime[i][j] = 0;
                }
            }
        }

        int time = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] arr = queue.poll();
                int cx = arr[0], cy = arr[1];
                for (int j = 0; j < 4; j++) {
                    int nx = cx + dirs[j][0];
                    int ny = cy + dirs[j][1];
                    if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                        if (grid[nx][ny] == 2 || fireTime[nx][ny] != INF) {
                            continue;
                        }
                        queue.offer(new int[]{nx, ny});
                        fireTime[nx][ny] = time;
                    }
                }
            }
            time++;
        }
    }

    private int getArriveTime(int[][] grid, int[][] fireTime, int stayTime) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visit = new boolean[m][n];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0, stayTime});
        visit[0][0] = true;

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int cx = arr[0], cy = arr[1], time = arr[2];
            for (int j = 0;  j < 4; j++) {
                int nx = cx + dirs[j][0];
                int ny = cy + dirs[j][1];
                if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                    if (grid[nx][ny] == 2 || visit[nx][ny]) {
                        continue;
                    }
                    if (nx == m - 1 && ny == n - 1) {
                        return time + 1;
                    }
                    if (fireTime[nx][ny] > time + 1) {
                        visit[nx][ny] = true;
                        queue.offer(new int[]{nx, ny, time + 1});
                    }
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
- [Binary Search](https://leetcode.cn//tag/binary-search)
- [Matrix](https://leetcode.cn//tag/matrix)

## Similar Questions


