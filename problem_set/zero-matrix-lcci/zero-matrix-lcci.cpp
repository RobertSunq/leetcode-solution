
```
// @Title: 零矩阵 (Zero Matrix LCCI)
// @Author: robert.sunq
// @Date: 2020-03-24 23:31:06
// @Runtime: 16 ms
// @Memory: 11.9 MB

class Solution {
public:
    void setZeroes(vector<vector<int>>& matrix) {

         vector<int> an;
         int rows =  matrix.size();
         int cols = matrix[0].size();
         for(int i=0;i<rows;i++){
             for(int j=0;j<cols;j++){
                if(matrix[i][j] == 0){
                    an.push_back(i);
                    an.push_back(j);
                }

             }
         }

         int len = an.size();
         for(int i = 0;i<len; ){
             for(int j=0;j<cols;j++)
                matrix[an[i]][j] =0;
            for(int j =0;j<rows;j++)
                matrix[j][an[i+1]]=0;
            i+=2;
         }

         return ;
    }
};
