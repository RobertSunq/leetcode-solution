
| English | [简体中文](README.md) |

# [689. Maximum Sum of 3 Non-Overlapping Subarrays](https://leetcode.cn//problems/maximum-sum-of-3-non-overlapping-subarrays/)

## Description

<p>Given an integer array <code>nums</code> and an integer <code>k</code>, find three non-overlapping subarrays of length <code>k</code> with maximum sum and return them.</p>

<p>Return the result as a list of indices representing the starting position of each interval (<strong>0-indexed</strong>). If there are multiple answers, return the lexicographically smallest one.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,2,1,2,6,7,5,1], k = 2
<strong>Output:</strong> [0,3,5]
<strong>Explanation:</strong> Subarrays [1, 2], [2, 6], [7, 5] correspond to the starting indices [0, 3, 5].
We could have also taken [2, 1], but an answer of [1, 3, 5] would be lexicographically larger.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,2,1,2,1,2,1,2,1], k = 2
<strong>Output:</strong> [0,2,4]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 2 * 10<sup>4</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;&nbsp;2<sup>16</sup></code></li>
	<li><code>1 &lt;= k &lt;= floor(nums.length / 3)</code></li>
</ul>


## Solutions


### Java

```Java
// @Title: 三个无重叠子数组的最大和 (Maximum Sum of 3 Non-Overlapping Subarrays)
// @Author: robert.sunq
// @Date: 2023-11-19 20:48:39
// @Runtime: 3 ms
// @Memory: 44.7 MB

class Solution {


    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] ans = new int[3];
        int sum1 = 0, maxSum1 = 0, maxSum1Idx = 0;
        int sum2 = 0, maxSum12 = 0, maxSum12Idx1 = 0, maxSum12Idx2 = 0;
        int sum3 = 0, maxTotal = 0;

        for (int i = k * 2; i < nums.length; i++) {
            sum1 = sum1 + nums[i -  k * 2];
            sum2 = sum2 + nums[i - k];
            sum3 = sum3 + nums[i];

            // 三个数组都补全了 k 个元素
            if (i >= k * 3 - 1) {
                // 第一个组和最大时， 索引位置
                if (sum1 > maxSum1) {
                    maxSum1 = sum1;
                    maxSum1Idx = i - k * 3 + 1;
                }
                // 当前两个数组和最大时， 两个数组的索引
                if (maxSum1 + sum2 > maxSum12) {
                    maxSum12 = maxSum1 + sum2;
                    maxSum12Idx1 = maxSum1Idx;
                    maxSum12Idx2 = i - k * 2 + 1;
                }

                if (maxSum12 + sum3 > maxTotal) {
                    maxTotal = maxSum12 + sum3;
                    ans[0] = maxSum12Idx1;
                    ans[1] = maxSum12Idx2;
                    ans[2] = i - k + 1;
                }
                sum1 = sum1 - nums[i - k * 3 + 1];
                sum2 = sum2 - nums[i - k * 2 + 1];
                sum3 = sum3 - nums[i - k + 1];
            }
        }

        return ans;
    }
}
```



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Dynamic Programming](https://leetcode.cn//tag/dynamic-programming)

## Similar Questions

- [Best Time to Buy and Sell Stock III](../best-time-to-buy-and-sell-stock-iii/README_EN.md)
