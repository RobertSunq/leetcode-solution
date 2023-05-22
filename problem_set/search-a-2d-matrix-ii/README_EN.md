
| English | [简体中文](README.md) |

# [240. Search a 2D Matrix II](https://leetcode.cn//problems/search-a-2d-matrix-ii/)

## Description

<p>Write an efficient algorithm that searches for a value <code>target</code> in an <code>m x n</code> integer matrix <code>matrix</code>. This matrix has the following properties:</p>

<ul>
	<li>Integers in each row are sorted in ascending from left to right.</li>
	<li>Integers in each column are sorted in ascending from top to bottom.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/24/searchgrid2.jpg" style="width: 300px; height: 300px;" />
<pre>
<strong>Input:</strong> matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
<strong>Output:</strong> true
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/24/searchgrid.jpg" style="width: 300px; height: 300px;" />
<pre>
<strong>Input:</strong> matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
<strong>Output:</strong> false
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m == matrix.length</code></li>
	<li><code>n == matrix[i].length</code></li>
	<li><code>1 &lt;= n, m &lt;= 300</code></li>
	<li><code>-10<sup>9</sup> &lt;= matrix[i][j] &lt;= 10<sup>9</sup></code></li>
	<li>All the integers in each row are <strong>sorted</strong> in ascending order.</li>
	<li>All the integers in each column are <strong>sorted</strong> in ascending order.</li>
	<li><code>-10<sup>9</sup> &lt;= target &lt;= 10<sup>9</sup></code></li>
</ul>


## Solutions


### Java

```Java
// @Title: 搜索二维矩阵 II (Search a 2D Matrix II)
// @Author: robert.sunq
// @Date: 2021-06-18 00:50:18
// @Runtime: 5 ms
// @Memory: 43.9 MB

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0,j = matrix[0].length-1;
        while(i < matrix.length && j >=0){
            if(matrix[i][j] == target) return true;
            if(matrix[i][j] < target){
                i++;
            }else{
                j--;
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

- [Search a 2D Matrix](../search-a-2d-matrix/README_EN.md)
