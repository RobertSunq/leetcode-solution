
```
// @Title: 二维数组中的查找 (二维数组中的查找 LCOF)
// @Author: robert.sunq
// @Date: 2020-03-21 15:00:15
// @Runtime: 36 ms
// @Memory: 14.1 MB

class Solution {
public:
    bool findNumberIn2DArray(vector<vector<int>>& matrix, int target) {
            if(matrix.empty()) return false;
           int rows = matrix.size();
           int cols = matrix[0].size();
           int i=0;
           int j = cols-1;
           while(i<rows && j>=0){
               if(matrix[i][j] == target) return true;
               if(matrix[i][j] > target) j--;
               else i++; 
           }
           return false;
    }
};
