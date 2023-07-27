
| English | [简体中文](README.md) |

# [剑指 Offer II 092. 翻转字符](https://leetcode.cn//problems/cyJERH/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 翻转字符 (翻转字符)
// @Author: robert.sunq
// @Date: 2023-07-27 23:22:15
// @Runtime: 4 ms
// @Memory: 40.2 MB

class Solution {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int dp0 = 0;
        int dp1 = 0;

        // 如果要当前位为 0
        // dp[i][0]=dp[i−1][0]+I(s[i]=‘1’)

        // 如果要当前为为1
        // dp[i][1]=min(dp[i−1][0],dp[i−1][1])+I(s[i]=‘0’)
        for (int i = 0; i<n; i++) {
            char c = s.charAt(i);
            int dp0New = dp0;
            int dp1New = Math.min(dp0, dp1);
            if (c == '1') {
                // 想使得当前位为0， 所以真是为1需要反转下
                dp0New++;
                // 想要使得为1，不用处理
            } else {
                // 想使得当前位为1， 所以真是为0需要反转下
                dp1New++;

                // 想要使得为0，不用处理
            }
            dp0 = dp0New;
            dp1 = dp1New;
        }

        return Math.min(dp0, dp1);
    }
}
```



## Related Topics

- [String](https://leetcode.cn//tag/string)
- [Dynamic Programming](https://leetcode.cn//tag/dynamic-programming)

## Similar Questions


