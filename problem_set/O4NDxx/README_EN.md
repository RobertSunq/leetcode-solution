
| English | [简体中文](README.md) |

# [剑指 Offer II 013. 二维子矩阵的和](https://leetcode.cn//problems/O4NDxx/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 二维子矩阵的和 (二维子矩阵的和)
// @Author: robert.sunq
// @Date: 2023-06-11 17:40:25
// @Runtime: 44 ms
// @Memory: 59.6 MB

class NumMatrix {
    
    int[][] preSumMatrix;

    public NumMatrix(int[][] matrix) {
        this.preSumMatrix = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 && j ==  0) {
                    preSumMatrix[i][j] = matrix[i][j];
                    continue;
                }
                if (i == 0) {
                    preSumMatrix[i][j] = preSumMatrix[i][j-1] + matrix[i][j];
                    continue;
                }
                if (j == 0) {
                    preSumMatrix[i][j] = preSumMatrix[i-1][j] + matrix[i][j];
                    continue;
                }
                preSumMatrix[i][j] = preSumMatrix[i][j - 1] + preSumMatrix[i - 1][j] - preSumMatrix[i - 1][j - 1] + matrix[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans = preSumMatrix[row2][col2];
        if (row1 - 1 >= 0) {
            ans = ans - preSumMatrix[row1 - 1][col2];
        }
        if (col1 - 1 >= 0) {
            ans = ans - preSumMatrix[row2][col1 - 1];
        }
        if (row1 - 1 >=0 && col1 - 1 >= 0) {
            ans = ans + preSumMatrix[row1-1][col1-1];
        }
        return ans;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
```



## Related Topics

- [Design](https://leetcode.cn//tag/design)
- [Array](https://leetcode.cn//tag/array)
- [Matrix](https://leetcode.cn//tag/matrix)
- [Prefix Sum](https://leetcode.cn//tag/prefix-sum)

## Similar Questions


