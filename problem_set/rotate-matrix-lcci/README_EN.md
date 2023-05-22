
| English | [简体中文](README.md) |

# [面试题 01.07. Rotate Matrix LCCI](https://leetcode.cn//problems/rotate-matrix-lcci/)

## Description

<p>Given an image represented by an N x N matrix, where each pixel in the image is 4 bytes, write a method to rotate the image by 90 degrees. Can you do this in place?</p>

<p>&nbsp;</p>

<p><strong>Example 1:</strong></p>

<pre>
Given <strong>matrix</strong> = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

Rotate the matrix <strong>in place. </strong>It becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
</pre>

<p><strong>Example 2:</strong></p>

<pre>
Given <strong>matrix</strong> =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
], 

Rotate the matrix <strong>in place. </strong>It becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]
</pre>


## Solutions


### C++

```C++
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
```



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Math](https://leetcode.cn//tag/math)
- [Matrix](https://leetcode.cn//tag/matrix)

## Similar Questions


