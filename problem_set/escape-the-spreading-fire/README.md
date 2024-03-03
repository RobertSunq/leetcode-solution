
| [English](README_EN.md) | 简体中文 |

# [2258. 逃离火灾](https://leetcode.cn//problems/escape-the-spreading-fire/)

## 题目描述

<p>给你一个下标从 <strong>0</strong>&nbsp;开始大小为 <code>m x n</code>&nbsp;的二维整数数组&nbsp;<code>grid</code>&nbsp;，它表示一个网格图。每个格子为下面 3 个值之一：</p>

<ul>
	<li><code>0</code> 表示草地。</li>
	<li><code>1</code> 表示着火的格子。</li>
	<li><code>2</code>&nbsp;表示一座墙，你跟火都不能通过这个格子。</li>
</ul>

<p>一开始你在最左上角的格子&nbsp;<code>(0, 0)</code>&nbsp;，你想要到达最右下角的安全屋格子&nbsp;<code>(m - 1, n - 1)</code>&nbsp;。每一分钟，你可以移动到&nbsp;<strong>相邻</strong>&nbsp;的草地格子。每次你移动 <strong>之后</strong>&nbsp;，着火的格子会扩散到所有不是墙的 <strong>相邻</strong>&nbsp;格子。</p>

<p>请你返回你在初始位置可以停留的 <strong>最多 </strong>分钟数，且停留完这段时间后你还能安全到达安全屋。如果无法实现，请你返回 <code>-1</code>&nbsp;。如果不管你在初始位置停留多久，你 <strong>总是</strong>&nbsp;能到达安全屋，请你返回&nbsp;<code>10<sup>9</sup></code>&nbsp;。</p>

<p>注意，如果你到达安全屋后，火马上到了安全屋，这视为你能够安全到达安全屋。</p>

<p>如果两个格子有共同边，那么它们为 <strong>相邻</strong>&nbsp;格子。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2022/03/10/ex1new.jpg" style="width: 650px; height: 404px;"></p>

<pre><b>输入：</b>grid = [[0,2,0,0,0,0,0],[0,0,0,2,2,1,0],[0,2,0,0,1,2,0],[0,0,2,2,2,0,2],[0,0,0,0,0,0,0]]
<b>输出：</b>3
<b>解释：</b>上图展示了你在初始位置停留 3 分钟后的情形。
你仍然可以安全到达安全屋。
停留超过 3 分钟会让你无法安全到达安全屋。</pre>

<p><strong>示例 2：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2022/03/10/ex2new2.jpg" style="width: 515px; height: 150px;"></p>

<pre><b>输入：</b>grid = [[0,0,0,0],[0,1,2,0],[0,2,0,0]]
<b>输出：</b>-1
<b>解释：</b>上图展示了你马上开始朝安全屋移动的情形。
火会蔓延到你可以移动的所有格子，所以无法安全到达安全屋。
所以返回 -1 。
</pre>

<p><strong>示例 3：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2022/03/10/ex3new.jpg" style="width: 174px; height: 150px;"></p>

<pre><b>输入：</b>grid = [[0,0,0],[2,2,0],[1,2,0]]
<b>输出：</b>1000000000
<b>解释：</b>上图展示了初始网格图。
注意，由于火被墙围了起来，所以无论如何你都能安全到达安全屋。
所以返回 10<sup>9</sup> 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>m == grid.length</code></li>
	<li><code>n == grid[i].length</code></li>
	<li><code>2 &lt;= m, n &lt;= 300</code></li>
	<li><code>4 &lt;= m * n &lt;= 2 * 10<sup>4</sup></code></li>
	<li><code>grid[i][j]</code>&nbsp;是&nbsp;<code>0</code>&nbsp;，<code>1</code>&nbsp;或者&nbsp;<code>2</code>&nbsp;。</li>
	<li><code>grid[0][0] == grid[m - 1][n - 1] == 0</code></li>
</ul>


## 题解


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



## 相关话题

- [广度优先搜索](https://leetcode.cn//tag/breadth-first-search)
- [数组](https://leetcode.cn//tag/array)
- [二分查找](https://leetcode.cn//tag/binary-search)
- [矩阵](https://leetcode.cn//tag/matrix)

## 相似题目



