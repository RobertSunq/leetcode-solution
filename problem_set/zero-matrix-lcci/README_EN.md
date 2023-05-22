
| English | [简体中文](README.md) |

# [面试题 01.08. Zero Matrix LCCI](https://leetcode.cn//problems/zero-matrix-lcci/)

## Description

<p>Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.</p>

<p>&nbsp;</p>

<p><strong>Example 1: </strong></p>

<pre>
<strong>Input: </strong>
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
<strong>Output: </strong>
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
</pre>

<p><strong>Example 2: </strong></p>

<pre>
<strong>Input: </strong>
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
<strong>Output: </strong>
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]
</pre>


## Solutions


### C++

```C++
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
```



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Hash Table](https://leetcode.cn//tag/hash-table)
- [Matrix](https://leetcode.cn//tag/matrix)

## Similar Questions


