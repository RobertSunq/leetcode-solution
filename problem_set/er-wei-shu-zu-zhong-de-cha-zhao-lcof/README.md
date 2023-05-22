
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer 04. 二维数组中的查找](https://leetcode.cn//problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/)

## 题目描述

<p>在一个 n * m 的二维数组中，每一行都按照从左到右&nbsp;<strong>非递减&nbsp;</strong>的顺序排序，每一列都按照从上到下&nbsp;<strong>非递减&nbsp;</strong>的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。</p>

<p>&nbsp;</p>

<p><strong>示例:</strong></p>

<p>现有矩阵 matrix 如下：</p>

<pre>
[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
</pre>

<p>给定 target&nbsp;=&nbsp;<code>5</code>，返回&nbsp;<code>true</code>。</p>

<p>给定&nbsp;target&nbsp;=&nbsp;<code>20</code>，返回&nbsp;<code>false</code>。</p>

<p>&nbsp;</p>

<p><strong>限制：</strong></p>

<p><code>0 &lt;= n &lt;= 1000</code></p>

<p><code>0 &lt;= m &lt;= 1000</code></p>

<p>&nbsp;</p>

<p><strong>注意：</strong>本题与主站 240 题相同：<a href="https://leetcode-cn.com/problems/search-a-2d-matrix-ii/">https://leetcode-cn.com/problems/search-a-2d-matrix-ii/</a></p>


## 题解


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



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [二分查找](https://leetcode.cn//tag/binary-search)
- [分治](https://leetcode.cn//tag/divide-and-conquer)
- [矩阵](https://leetcode.cn//tag/matrix)

## 相似题目



