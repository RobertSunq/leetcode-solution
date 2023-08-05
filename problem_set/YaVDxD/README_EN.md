
| English | [简体中文](README.md) |

# [LCR 102. 目标和](https://leetcode.cn//problems/YaVDxD/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 目标和 (目标和)
// @Author: robert.sunq
// @Date: 2023-08-01 23:40:23
// @Runtime: 2 ms
// @Memory: 39.1 MB

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum+=nums[i];
        }

        if (target > sum || target < -sum) {
            return 0;
        }

        // 转化为所有的正数和的2倍
        int targetSum = target + sum;
        if ((targetSum & 1) == 1) {
            return 0;
        }

        // 这样就是从nums中选取多个数 和为 targetSum. 0 背包问题/ 1
        targetSum = targetSum / 2;

        // 计算方式二，0/1 背包问题
        int[] dp = new int[targetSum + 1];
        // 一个都不选
        dp[0] = 1;
        for (int i = 0; i<n; i++) {
            for(int j = targetSum; j >= nums[i]; j--) {
                // j 是剩余容量
                // dp[i][j] = dp[i-1][j] (不选)  +  dp[i-1][j - nums[i]] (选) 

                // 因为用一维数组缓存中间状态， j 从小到大的计算的话， 计算大值的时候，小值的数据已经是当前轮次了，无法缩减
                // 所以从左往右计算，这样可以正确的获取的上一轮的值
                dp[j] = dp[j] + dp[j - nums[i]];
            }
        }

        return dp[targetSum];



        // 计算方式一， 就是选取问题的动态规划，
        // j 是 和， 取值范围 -n .... 0 .... n， 为了在数组中有效，所以左平移 + sum
        // i 是前 i + 1 个数
        // int[][] dp = new int[n][2*sum + 1];
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < 2 * sum + 1; j++) {
        //         if (i == 0) {
        //             if(nums[0] == 0) {
        //                 // +0, - 0
        //                 dp[i][sum] = 2;
        //             } else {
        //                 dp[i][sum + nums[0]] = 1;
        //                 dp[i][sum - nums[0]] = 1;
        //             }
        //             break;
        //         }

        //         if (j + nums[i] < 2 * sum + 1) {
        //             dp[i][j] = dp[ i - 1][j + nums[i]];
        //         }
        //         if (j - nums[i] > -1) {
        //             dp[i][j] = dp[i][j] + dp[i - 1][j - nums[i]];
        //         }
        //     }
        // }
        // return dp[n - 1][ sum + target];
    }
}
```



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Dynamic Programming](https://leetcode.cn//tag/dynamic-programming)
- [Backtracking](https://leetcode.cn//tag/backtracking)

## Similar Questions


