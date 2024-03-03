
```
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
