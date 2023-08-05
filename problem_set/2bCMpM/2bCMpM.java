
```
// @Title: 01 矩阵 (01 矩阵)
// @Author: robert.sunq
// @Date: 2023-08-04 00:44:54
// @Runtime: 1928 ms
// @Memory: 46.2 MB

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] ans = new int[n][m];
        int[][] move = {{-1, 0},{0, -1},{ 1, 0},{0, 1}};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[i][j] = mat[i][j] == 0 ? 0 : Integer.MAX_VALUE;
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i,j});
                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        for (int mo = 0; mo < 4; mo++) {
                            int ii = cur[0] + move[mo][0];
                            int jj = cur[1] + move[mo][1];
                            if (ii < n && ii >= 0 && jj < m && jj >= 0) {
                                if (ans[ii][jj] > ans[cur[0]][cur[1]] + 1) {
                                    ans[ii][jj] = ans[cur[0]][cur[1]] + 1;
                                    q.offer(new int[]{ii,jj});
                                }
                            }
                        }
                    }
                }
            }
        }

        return ans;
    }
}
