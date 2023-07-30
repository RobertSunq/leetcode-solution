
| English | [简体中文](README.md) |

# [剑指 Offer II 097. 子序列的数目](https://leetcode.cn//problems/21dk04/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 子序列的数目 (子序列的数目)
// @Author: robert.sunq
// @Date: 2023-07-30 23:30:09
// @Runtime: 10 ms
// @Memory: 43.7 MB

class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (m > n) {
            return 0;
        }

        int[][] dp = new int[n+1][m+1];
        for(int i = 0; i <= n; i++) {
            for (int j =0; j <= i && j <= m; j++) {
                if (i ==0 && j == 0 ) {
                    dp[i][j] = 1;
                } else if (i == 0 || j == 0) {
                    // 第二个长度为0，则 空字符串是任何字符串的子序列
                    dp[i][j] = j == 0 ? 1 : 0;
                } else {
                    
                    if (s.charAt(i - 1) == t.charAt(j - 1)) {
                        // s[i] == t[j], 则当前 前缀 i长的字符串包含 t中前缀j长字符串的个数
                        // 等于 子序列对比中如果 s[i] 对应 t[j] 则 其个数为 dp[i - 1][j -1]
                        // 加上 子序列对比中 d[i] 不对应 t[j] 则 个数为 dp[i - 1][j] 
                        dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                    } else {
                        // 那么s_i中的所有t_j子序列，必不包含s[i]，即s_i-1和s_i中tj的数量是一样的
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
        return dp[n][m];
    }
}
```



## Related Topics

- [String](https://leetcode.cn//tag/string)
- [Dynamic Programming](https://leetcode.cn//tag/dynamic-programming)

## Similar Questions


