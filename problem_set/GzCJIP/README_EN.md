
| English | [简体中文](README.md) |

# [剑指 Offer II 088. 爬楼梯的最少成本](https://leetcode.cn//problems/GzCJIP/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 爬楼梯的最少成本 (爬楼梯的最少成本)
// @Author: robert.sunq
// @Date: 2023-07-25 23:20:44
// @Runtime: 1 ms
// @Memory: 41.3 MB

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int step0 = 0;
        int step1 = 0;
        int step;

        // dp[i] = min(dp[i -1] + coust[i - 1], dp[i - 2] + cost[i -2])

        // 注意 这里是等于 length， 因为要上到最顶层之上。
        for (int i = 2 ; i <= cost.length; i++) {
            step = Math.min(step0 + cost[i - 2], step1 + cost[i - 1]);
            step0 = step1;
            step1 = step;
        }

        return step1;
    }
}
```



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Dynamic Programming](https://leetcode.cn//tag/dynamic-programming)

## Similar Questions


