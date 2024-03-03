
```
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
