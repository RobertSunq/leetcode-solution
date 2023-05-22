
| English | [简体中文](README.md) |

# [剑指 Offer 29. 顺时针打印矩阵  LCOF](https://leetcode.cn//problems/shun-shi-zhen-da-yin-ju-zhen-lcof/)

## Description

English description is not available for the problem. Please switch to Chinese.

## Solutions


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



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Matrix](https://leetcode.cn//tag/matrix)
- [Simulation](https://leetcode.cn//tag/simulation)

## Similar Questions


