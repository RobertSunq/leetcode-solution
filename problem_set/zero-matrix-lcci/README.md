
| [English](README_EN.md) | 简体中文 |

# [面试题 01.08. 零矩阵](https://leetcode.cn//problems/zero-matrix-lcci/)

## 题目描述

<p>编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
<strong>输出：</strong>
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
<strong>输出：</strong>
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]
</pre>


## 题解


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



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [哈希表](https://leetcode.cn//tag/hash-table)
- [矩阵](https://leetcode.cn//tag/matrix)

## 相似题目



