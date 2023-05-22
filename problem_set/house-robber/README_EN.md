
| English | [简体中文](README.md) |

# [198. House Robber](https://leetcode.cn//problems/house-robber/)

## Description

<p>You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and <b>it will automatically contact the police if two adjacent houses were broken into on the same night</b>.</p>

<p>Given an integer array <code>nums</code> representing the amount of money of each house, return <em>the maximum amount of money you can rob tonight <b>without alerting the police</b></em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,2,3,1]
<strong>Output:</strong> 4
<strong>Explanation:</strong> Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [2,7,9,3,1]
<strong>Output:</strong> 12
<strong>Explanation:</strong> Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 100</code></li>
	<li><code>0 &lt;= nums[i] &lt;= 400</code></li>
</ul>


## Solutions


### Java

```Java
// @Title: 打家劫舍 (House Robber)
// @Author: robert.sunq
// @Date: 2021-06-15 01:04:35
// @Runtime: 0 ms
// @Memory: 35.7 MB

class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1],nums[0]);
        for(int i = 2;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[nums.length-1];
    }
}
```



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Dynamic Programming](https://leetcode.cn//tag/dynamic-programming)

## Similar Questions

- [Maximum Product Subarray](../maximum-product-subarray/README_EN.md)
- [House Robber II](../house-robber-ii/README_EN.md)
- [Paint House](../paint-house/README_EN.md)
- [Paint Fence](../paint-fence/README_EN.md)
- [House Robber III](../house-robber-iii/README_EN.md)
- [Non-negative Integers without Consecutive Ones](../non-negative-integers-without-consecutive-ones/README_EN.md)
- [Coin Path](../coin-path/README_EN.md)
- [Delete and Earn](../delete-and-earn/README_EN.md)
