
```
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
