
| English | [简体中文](README.md) |

# [300. Longest Increasing Subsequence](https://leetcode.cn//problems/longest-increasing-subsequence/)

## Description

<p>Given an integer array <code>nums</code>, return <em>the length of the longest <strong>strictly increasing </strong></em><span data-keyword="subsequence-array"><em><strong>subsequence</strong></em></span>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [10,9,2,5,3,7,101,18]
<strong>Output:</strong> 4
<strong>Explanation:</strong> The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [0,1,0,3,2,3]
<strong>Output:</strong> 4
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [7,7,7,7,7,7,7]
<strong>Output:</strong> 1
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 2500</code></li>
	<li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
</ul>

<p>&nbsp;</p>
<p><b>Follow up:</b>&nbsp;Can you come up with an algorithm that runs in&nbsp;<code>O(n log(n))</code> time complexity?</p>


## Solutions


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



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Binary Search](https://leetcode.cn//tag/binary-search)
- [Dynamic Programming](https://leetcode.cn//tag/dynamic-programming)

## Similar Questions

- [Increasing Triplet Subsequence](../increasing-triplet-subsequence/README_EN.md)
- [Russian Doll Envelopes](../russian-doll-envelopes/README_EN.md)
- [Maximum Length of Pair Chain](../maximum-length-of-pair-chain/README_EN.md)
- [Number of Longest Increasing Subsequence](../number-of-longest-increasing-subsequence/README_EN.md)
- [Minimum ASCII Delete Sum for Two Strings](../minimum-ascii-delete-sum-for-two-strings/README_EN.md)
