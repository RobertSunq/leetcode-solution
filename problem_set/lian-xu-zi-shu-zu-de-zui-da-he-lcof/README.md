
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer 42. 连续子数组的最大和](https://leetcode.cn//problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/)

## 题目描述

<p>输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。</p>

<p>要求时间复杂度为O(n)。</p>

<p>&nbsp;</p>

<p><strong>示例1:</strong></p>

<pre><strong>输入:</strong> nums = [-2,1,-3,4,-1,2,1,-5,4]
<strong>输出:</strong> 6
<strong>解释:</strong>&nbsp;连续子数组&nbsp;[4,-1,2,1] 的和最大，为&nbsp;6。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;=&nbsp;arr.length &lt;= 10^5</code></li>
	<li><code>-100 &lt;= arr[i] &lt;= 100</code></li>
</ul>

<p>注意：本题与主站 53 题相同：<a href="https://leetcode-cn.com/problems/maximum-subarray/">https://leetcode-cn.com/problems/maximum-subarray/</a></p>

<p>&nbsp;</p>


## 题解


### Java

```Java
// @Title: 连续子数组的最大和 (连续子数组的最大和  LCOF)
// @Author: robert.sunq
// @Date: 2021-05-29 00:20:06
// @Runtime: 2 ms
// @Memory: 44.9 MB

class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        // dp[i]  = Math.max(nums[i],dp[i-1]+nums[i] 
        // 及长度为I时,如果加上前面的最大值产生负增益效果，则新的连续串从当前位置开始
        // dp[i] 是以nums[i] 结尾的连续子数组最大值，以nums[i] 结尾是为了保证下一个状态组是连续的
        if (len <= 0) return -1;
        for(int i=1;i<len;i++){
            dp[i] = Math.max(nums[i],dp[i-1]+nums[i]);
        } 
        int res = dp[0];
        for(int i=1;i<len;i++){
            res = Math.max(dp[i],res);
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



