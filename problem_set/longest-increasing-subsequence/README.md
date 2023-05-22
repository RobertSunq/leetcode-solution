
| [English](README_EN.md) | 简体中文 |

# [300. 最长递增子序列](https://leetcode.cn//problems/longest-increasing-subsequence/)

## 题目描述

<p>给你一个整数数组 <code>nums</code> ，找到其中最长严格递增子序列的长度。</p>

<p><strong>子序列&nbsp;</strong>是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，<code>[3,6,2,7]</code> 是数组 <code>[0,3,1,6,2,2,7]</code> 的子序列。</p>
&nbsp;

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [10,9,2,5,3,7,101,18]
<strong>输出：</strong>4
<strong>解释：</strong>最长递增子序列是 [2,3,7,101]，因此长度为 4 。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [0,1,0,3,2,3]
<strong>输出：</strong>4
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = [7,7,7,7,7,7,7]
<strong>输出：</strong>1
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 2500</code></li>
	<li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
</ul>

<p>&nbsp;</p>

<p><b>进阶：</b></p>

<ul>
	<li>你能将算法的时间复杂度降低到&nbsp;<code>O(n log(n))</code> 吗?</li>
</ul>


## 题解


### Java

```Java
// @Title: 最长递增子序列 (Longest Increasing Subsequence)
// @Author: robert.sunq
// @Date: 2021-06-19 17:26:33
// @Runtime: 71 ms
// @Memory: 37.8 MB

class Solution {
    public int lengthOfLIS(int[] nums) {
        int res = 0;
        // 保存当前位置的最大序列长度
        int[] dp = new int[nums.length];
        for(int i = 0 ;i<nums.length;i++){
            dp[i] = 1;
            // 状态方程是  当前位置的长度，为此之前小于该位置的最大序列长度 + 1
            for(int j=i-1;j>=0;j--){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
```



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [二分查找](https://leetcode.cn//tag/binary-search)
- [动态规划](https://leetcode.cn//tag/dynamic-programming)

## 相似题目


- [递增的三元子序列](../increasing-triplet-subsequence/README.md)
- [俄罗斯套娃信封问题](../russian-doll-envelopes/README.md)
- [最长数对链](../maximum-length-of-pair-chain/README.md)
- [最长递增子序列的个数](../number-of-longest-increasing-subsequence/README.md)
- [两个字符串的最小ASCII删除和](../minimum-ascii-delete-sum-for-two-strings/README.md)
