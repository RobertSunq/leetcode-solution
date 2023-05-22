
```
// @Title: 旋转矩阵 (Rotate Matrix LCCI)
// @Author: robert.sunq
// @Date: 2020-03-24 23:05:42
// @Runtime: 0 ms
// @Memory: 6.9 MB

class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
        int rows = matrix.size();
        int cols = matrix[0].size();
        for(int i=0;i<rows;i++){
            int row = i+1,col = i+1;
            while(row<rows && col < cols){
                int temp = matrix[row][i];
                matrix[row][i] = matrix[i][col];
                matrix[i][col] = temp;
                row++;
                col++;
            }
        }
        for(int i=0;i<rows;i++){
            int col_front = 0;
            int col_back = cols-1;
            while(col_front < col_back){
                int temp = matrix[i][col_front];
                matrix[i][col_front] = matrix[i][col_back];
                matrix[i][col_back] = temp;
                col_front++;
                col_back--;
            }
        }
        return ;
    }
};
