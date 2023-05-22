
| English | [简体中文](README.md) |

# [213. House Robber II](https://leetcode.cn//problems/house-robber-ii/)

## Description

<p>You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are <strong>arranged in a circle.</strong> That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and&nbsp;<b>it will automatically contact the police if two adjacent houses were broken into on the same night</b>.</p>

<p>Given an integer array <code>nums</code> representing the amount of money of each house, return <em>the maximum amount of money you can rob tonight <strong>without alerting the police</strong></em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [2,3,2]
<strong>Output:</strong> 3
<strong>Explanation:</strong> You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,2,3,1]
<strong>Output:</strong> 4
<strong>Explanation:</strong> Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,2,3]
<strong>Output:</strong> 3
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 100</code></li>
	<li><code>0 &lt;= nums[i] &lt;= 1000</code></li>
</ul>


## Solutions


### Java

```Java
// @Title: 打家劫舍 II (House Robber II)
// @Author: robert.sunq
// @Date: 2021-07-11 23:23:46
// @Runtime: 0 ms
// @Memory: 35.9 MB

class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        // 0 第一间房子偷 1 第一间房子不偷
        int[][] dp = new int[nums.length][2];
        dp[0][0] = nums[0];
        dp[1][0] = Math.max(nums[0],nums[1]);
        dp[0][1] = 0;
        dp[1][1] = nums[1];
        // 
        for(int i = 2;i<nums.length;i++){
            // 最后一间房子
            if(i == nums.length-1){
                dp[i][0] = dp[i-1][0];
                dp[i][1] = Math.max(dp[i-2][1] + nums[i],dp[i-1][1]);
            }else{
                dp[i][0] = Math.max(dp[i-2][0]+nums[i],dp[i-1][0]);
                dp[i][1] = Math.max(dp[i-2][1]+nums[i],dp[i-1][1]);
            }
        }
        return Math.max(dp[nums.length-1][0],dp[nums.length-1][1]);
    }
}
```



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Dynamic Programming](https://leetcode.cn//tag/dynamic-programming)

## Similar Questions

- [House Robber](../house-robber/README_EN.md)
- [Paint House](../paint-house/README_EN.md)
- [Paint Fence](../paint-fence/README_EN.md)
- [House Robber III](../house-robber-iii/README_EN.md)
- [Non-negative Integers without Consecutive Ones](../non-negative-integers-without-consecutive-ones/README_EN.md)
- [Coin Path](../coin-path/README_EN.md)
