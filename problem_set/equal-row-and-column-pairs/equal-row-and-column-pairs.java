
```
// @Title: 相等行列对 (Equal Row and Column Pairs)
// @Author: robert.sunq
// @Date: 2023-08-24 22:25:24
// @Runtime: 31 ms
// @Memory: 47 MB

class Solution {
    public int equalPairs(int[][] grid) {

        int row = grid.length;
        int col = grid.length;
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int tmp = 0;
                while (tmp < row) {
                    if (grid[i][tmp] != grid[tmp][j]) {
                        break;
                    }
                    tmp++;
                }
                if (tmp == row) {
                    ans++;
                }
            }
        }

        return ans;

    }
}
