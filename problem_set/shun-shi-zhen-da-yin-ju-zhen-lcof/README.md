
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer 29. 顺时针打印矩阵](https://leetcode.cn//problems/shun-shi-zhen-da-yin-ju-zhen-lcof/)

## 题目描述

<p>输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>matrix = [[1,2,3],[4,5,6],[7,8,9]]
<strong>输出：</strong>[1,2,3,6,9,8,7,4,5]
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>matrix =&nbsp;[[1,2,3,4],[5,6,7,8],[9,10,11,12]]
<strong>输出：</strong>[1,2,3,4,8,12,11,10,9,5,6,7]
</pre>

<p>&nbsp;</p>

<p><strong>限制：</strong></p>

<ul>
	<li><code>0 &lt;= matrix.length &lt;= 100</code></li>
	<li><code>0 &lt;= matrix[i].length&nbsp;&lt;= 100</code></li>
</ul>

<p>注意：本题与主站 54 题相同：<a href="https://leetcode-cn.com/problems/spiral-matrix/">https://leetcode-cn.com/problems/spiral-matrix/</a></p>


## 题解


### Java

```Java
// @Title: 顺时针打印矩阵 (顺时针打印矩阵  LCOF)
// @Author: robert.sunq
// @Date: 2021-05-27 00:28:10
// @Runtime: 1 ms
// @Memory: 39.8 MB

class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int[] result = new int[matrix.length*matrix[0].length];
        int m = matrix.length;
        int n = matrix[0].length;
        int u=0,d=m-1,l=0,r=n-1,x=0;
        while(true){
            // 上边界 行
            for(int i=l;i<=r;i++){
                result[x++] = matrix[u][i];
            }
            u++;
            if(u>d) break;
            // 右边界 列
            for(int i=u;i<=d;i++){
                result[x++] = matrix[i][r];
            }
            r--;
            if(r < l) break;
            // 下边界 行
            for(int i=r;i>=l;i--){
                result[x++] = matrix[d][i];
            }
            d--;
            if(d < u) break;
            // 左边界 列
            for(int i=d;i>=u;i--){
                result[x++] = matrix[i][l];
            }
            l++;
            if(r < l) break;
        }
        return result;
    }
}
```



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [矩阵](https://leetcode.cn//tag/matrix)
- [模拟](https://leetcode.cn//tag/simulation)

## 相似题目



