
| [English](README_EN.md) | 简体中文 |

# [1493. 删掉一个元素以后全为 1 的最长子数组](https://leetcode.cn//problems/longest-subarray-of-1s-after-deleting-one-element/)

## 题目描述

<p>给你一个二进制数组&nbsp;<code>nums</code>&nbsp;，你需要从中删掉一个元素。</p>

<p>请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。</p>

<p>如果不存在这样的子数组，请返回 0 。</p>

<p>&nbsp;</p>

<p><strong>提示 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,1,0,1]
<strong>输出：</strong>3
<strong>解释：</strong>删掉位置 2 的数后，[1,1,1] 包含 3 个 1 。</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [0,1,1,1,0,1,1,0,1]
<strong>输出：</strong>5
<strong>解释：</strong>删掉位置 4 的数字后，[0,1,1,1,1,1,0,1] 的最长全 1 子数组为 [1,1,1,1,1] 。</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,1,1]
<strong>输出：</strong>2
<strong>解释：</strong>你必须要删除一个元素。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>nums[i]</code>&nbsp;要么是&nbsp;<code>0</code>&nbsp;要么是&nbsp;<code>1</code> 。</li>
</ul>


## 题解


### Java

```Java
// @Title: 删掉一个元素以后全为 1 的最长子数组 (Longest Subarray of 1's After Deleting One Element)
// @Author: robert.sunq
// @Date: 2023-08-19 17:54:08
// @Runtime: 2 ms
// @Memory: 54.3 MB

class Solution {
    // https://leetcode.cn/problems/max-consecutive-ones-iii/?envType=study-plan-v2&envId=leetcode-75
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int left = 0;
        int lsum = 0;
        int rsum = 0;
        int ans = 0;
        for (int rigth = 0; rigth < n; rigth++) {
            rsum = rsum + (1 - nums[rigth]);
            while (lsum < rsum - 1) {
                lsum = lsum + (1 - nums[left]);
                left++;
            }
            ans = Math.max(ans, rigth - left);
        }

        return ans;
    }
}
```



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [动态规划](https://leetcode.cn//tag/dynamic-programming)
- [滑动窗口](https://leetcode.cn//tag/sliding-window)

## 相似题目



