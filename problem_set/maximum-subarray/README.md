
| [English](README_EN.md) | 简体中文 |

# [53. 最大子数组和](https://leetcode.cn//problems/maximum-subarray/)

## 题目描述

<p>给你一个整数数组 <code>nums</code> ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。</p>

<p><strong>子数组 </strong>是数组中的一个连续部分。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [-2,1,-3,4,-1,2,1,-5,4]
<strong>输出：</strong>6
<strong>解释：</strong>连续子数组&nbsp;[4,-1,2,1] 的和最大，为&nbsp;6 。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [1]
<strong>输出：</strong>1
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = [5,4,-1,7,8]
<strong>输出：</strong>23
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong>如果你已经实现复杂度为 <code>O(n)</code> 的解法，尝试使用更为精妙的 <strong>分治法</strong> 求解。</p>


## 题解


### Java

```Java
// @Title: 最大子数组和 (Maximum Subarray)
// @Author: robert.sunq
// @Date: 2021-08-08 15:59:00
// @Runtime: 1 ms
// @Memory: 38.5 MB

class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        // 表示连续数组的长度
        int len = nums.length;
        // temp 前一个串中的连续串最大值
        int temp = nums[0];
        // int[] dp = new int[len];
        // dp[0] = nums[0];
        // dp[i] 以i为结尾的最大连续子数组和， 且必须包含当前位。
        for(int i=1;i<len;i++){
            // 前一串的最大值加上当前位， 对当前位产生负增益，则当前为位置的最大值位当前值
            temp = Math.max(nums[i],temp+nums[i]);
            res = Math.max(res,temp);
        }
        return res;

    }
}
```



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [分治](https://leetcode.cn//tag/divide-and-conquer)
- [动态规划](https://leetcode.cn//tag/dynamic-programming)

## 相似题目


- [买卖股票的最佳时机](../best-time-to-buy-and-sell-stock/README.md)
- [乘积最大子数组](../maximum-product-subarray/README.md)
- [数组的度](../degree-of-an-array/README.md)
- [最长湍流子数组](../longest-turbulent-subarray/README.md)
