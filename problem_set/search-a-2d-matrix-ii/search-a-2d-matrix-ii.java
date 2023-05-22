
```
// @Title: 搜索二维矩阵 II (Search a 2D Matrix II)
// @Author: robert.sunq
// @Date: 2021-06-18 00:50:18
// @Runtime: 5 ms
// @Memory: 43.9 MB

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0,j = matrix[0].length-1;
        while(i < matrix.length && j >=0){
            if(matrix[i][j] == target) return true;
            if(matrix[i][j] < target){
                i++;
            }else{
                j--;
            }
        }
        return false;
    }
}
