
| English | [简体中文](README.md) |

# [剑指 Offer II 098. 路径的数目](https://leetcode.cn//problems/2AoeFn/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 路径的数目 (路径的数目)
// @Author: robert.sunq
// @Date: 2023-07-30 23:37:29
// @Runtime: 0 ms
// @Memory: 37.7 MB

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1];
                } else if ( j == 0) {
                    dp[i][j] = dp[i -1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i] [ j -1];
                }
            }
        }

        return dp[m - 1][ n - 1];
    }
}
```



## Related Topics

- [Math](https://leetcode.cn//tag/math)
- [Dynamic Programming](https://leetcode.cn//tag/dynamic-programming)
- [Combinatorics](https://leetcode.cn//tag/combinatorics)

## Similar Questions


