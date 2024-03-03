
| [English](README_EN.md) | 简体中文 |

# [689. 三个无重叠子数组的最大和](https://leetcode.cn//problems/maximum-sum-of-3-non-overlapping-subarrays/)

## 题目描述

<p>给你一个整数数组 <code>nums</code> 和一个整数 <code>k</code> ，找出三个长度为 <code>k</code> 、互不重叠、且全部数字和（<code>3 * k</code> 项）最大的子数组，并返回这三个子数组。</p>

<p>以下标的数组形式返回结果，数组中的每一项分别指示每个子数组的起始位置（下标从 <strong>0</strong> 开始）。如果有多个结果，返回字典序最小的一个。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,1,2,6,7,5,1], k = 2
<strong>输出：</strong>[0,3,5]
<strong>解释：</strong>子数组 [1, 2], [2, 6], [7, 5] 对应的起始下标为 [0, 3, 5]。
也可以取 [2, 1], 但是结果 [1, 3, 5] 在字典序上更大。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,1,2,1,2,1,2,1], k = 2
<strong>输出：</strong>[0,2,4]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 2 * 10<sup>4</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;&nbsp;2<sup>16</sup></code></li>
	<li><code>1 &lt;= k &lt;= floor(nums.length / 3)</code></li>
</ul>


## 题解


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



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [动态规划](https://leetcode.cn//tag/dynamic-programming)

## 相似题目


- [买卖股票的最佳时机 III](../best-time-to-buy-and-sell-stock-iii/README.md)
