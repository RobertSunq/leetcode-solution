
| English | [简体中文](README.md) |

# [剑指 Offer II 095. 最长公共子序列](https://leetcode.cn//problems/qJnOS7/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 最长公共子序列 (最长公共子序列)
// @Author: robert.sunq
// @Date: 2023-07-29 23:19:00
// @Runtime: 12 ms
// @Memory: 43.6 MB

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();

        // 表示 text1的长度为i的前缀 和 text2的长度为j的前缀 
        int[][] dp = new int[n1 + 1][n2 + 1];
        int ans = 0;

        for (int i =0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                // 任意一个前缀长度为0， 则结果为 0
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    // 如果当前字符相等，则可以在上一个前缀的基础上 + 1
                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        // 否则，则是一个前缀长度不变，另一个的前缀 - 1的
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }

        return ans;

    }
}
```



## Related Topics

- [String](https://leetcode.cn//tag/string)
- [Dynamic Programming](https://leetcode.cn//tag/dynamic-programming)

## Similar Questions


