
```
// @Title: 二维数组中的查找 (二维数组中的查找 LCOF)
// @Author: robert.sunq
// @Date: 2023-02-02 22:44:08
// @Runtime: 0 ms
// @Memory: 47.6 MB

class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int i = matrix.length-1;
        int j = 0;
        while(i > -1 && j<matrix[i].length){

                if (target == matrix[i][j]) {
                    return true;
                } else if (target > matrix[i][j]) {
                    j++;
                } else {
                    i--;
                }

        }
        return false;
    }
}
