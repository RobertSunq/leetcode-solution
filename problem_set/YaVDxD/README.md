
| [English](README_EN.md) | 简体中文 |

# [LCR 102. 目标和](https://leetcode.cn//problems/YaVDxD/)

## 题目描述

<p>给定一个正整数数组 <code>nums</code> 和一个整数 <code>target</code> 。</p>

<p>向数组中的每个整数前添加&nbsp;<code>&#39;+&#39;</code> 或 <code>&#39;-&#39;</code> ，然后串联起所有整数，可以构造一个 <strong>表达式</strong> ：</p>

<ul>
	<li>例如，<code>nums = [2, 1]</code> ，可以在 <code>2</code> 之前添加 <code>&#39;+&#39;</code> ，在 <code>1</code> 之前添加 <code>&#39;-&#39;</code> ，然后串联起来得到表达式 <code>&quot;+2-1&quot;</code> 。</li>
</ul>

<p>返回可以通过上述方法构造的、运算结果等于 <code>target</code> 的不同 <strong>表达式</strong> 的数目。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,1,1,1,1], target = 3
<strong>输出：</strong>5
<strong>解释：</strong>一共有 5 种方法让最终目标和为 3 。
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [1], target = 1
<strong>输出：</strong>1
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 20</code></li>
	<li><code>0 &lt;= nums[i] &lt;= 1000</code></li>
	<li><code>0 &lt;= sum(nums[i]) &lt;= 1000</code></li>
	<li><code>-1000 &lt;= target &lt;= 1000</code></li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 494&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/target-sum/">https://leetcode-cn.com/problems/target-sum/</a></p>


## 题解


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



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [动态规划](https://leetcode.cn//tag/dynamic-programming)
- [回溯](https://leetcode.cn//tag/backtracking)

## 相似题目



