
| [English](README_EN.md) | 简体中文 |

# [213. 打家劫舍 II](https://leetcode.cn//problems/house-robber-ii/)

## 题目描述

<p>你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 <strong>围成一圈</strong> ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，<strong>如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警</strong> 。</p>

<p>给定一个代表每个房屋存放金额的非负整数数组，计算你 <strong>在不触动警报装置的情况下</strong> ，今晚能够偷窃到的最高金额。</p>

<p>&nbsp;</p>

<p><strong>示例&nbsp;1：</strong></p>

<pre>
<strong>输入：</strong>nums = [2,3,2]
<strong>输出：</strong>3
<strong>解释：</strong>你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,3,1]
<strong>输出：</strong>4
<strong>解释：</strong>你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
&nbsp;    偷窃到的最高金额 = 1 + 3 = 4 。</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,3]
<strong>输出：</strong>3
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 100</code></li>
	<li><code>0 &lt;= nums[i] &lt;= 1000</code></li>
</ul>


## 题解


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



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [动态规划](https://leetcode.cn//tag/dynamic-programming)

## 相似题目


- [打家劫舍](../house-robber/README.md)
- [粉刷房子](../paint-house/README.md)
- [栅栏涂色](../paint-fence/README.md)
- [打家劫舍 III](../house-robber-iii/README.md)
- [不含连续1的非负整数](../non-negative-integers-without-consecutive-ones/README.md)
- [金币路径](../coin-path/README.md)
