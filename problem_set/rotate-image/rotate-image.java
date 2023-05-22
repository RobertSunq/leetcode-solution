
```
// @Title: 旋转图像 (Rotate Image)
// @Author: robert.sunq
// @Date: 2021-06-03 23:32:03
// @Runtime: 0 ms
// @Memory: 38.1 MB

class Solution {
    public void rotate(int[][] matrix) {
        // 沿着对角线反转
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<i;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 左右翻转
        for(int i=0;i<matrix.length;i++){
            int left = 0 ; int right = matrix[0].length-1;
            while(left < right){
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            } 
        }
    }
}
