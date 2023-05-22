
| English | [简体中文](README.md) |

# [剑指 Offer 04. 二维数组中的查找 LCOF](https://leetcode.cn//problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### C++

```C++
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
```



### Java

```Java
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
```



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Binary Search](https://leetcode.cn//tag/binary-search)
- [Divide and Conquer](https://leetcode.cn//tag/divide-and-conquer)
- [Matrix](https://leetcode.cn//tag/matrix)

## Similar Questions


