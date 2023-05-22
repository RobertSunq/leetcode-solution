
| [English](README_EN.md) | 简体中文 |

# [面试题 01.07. 旋转矩阵](https://leetcode.cn//problems/rotate-matrix-lcci/)

## 题目描述

<p>给你一幅由 <code>N × N</code> 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。</p>

<p>不占用额外内存空间能否做到？</p>

<p> </p>

<p><strong>示例 1:</strong></p>

<pre>
给定 <strong>matrix</strong> = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

<strong>原地</strong>旋转输入矩阵，使其变为:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
</pre>

<p><strong>示例 2:</strong></p>

<pre>
给定 <strong>matrix</strong> =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
], 

<strong>原地</strong>旋转输入矩阵，使其变为:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]
</pre>

<p><strong>注意</strong>：本题与主站 48 题相同：<a href="https://leetcode-cn.com/problems/rotate-image/">https://leetcode-cn.com/problems/rotate-image/</a></p>


## 题解


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



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [数学](https://leetcode.cn//tag/math)
- [矩阵](https://leetcode.cn//tag/matrix)

## 相似题目



