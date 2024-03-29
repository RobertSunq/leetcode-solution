
| [English](README_EN.md) | 简体中文 |

# [2656. K 个元素的最大和](https://leetcode.cn//problems/maximum-sum-with-exactly-k-elements/)

## 题目描述

<p>给你一个下标从 <strong>0</strong>&nbsp;开始的整数数组&nbsp;<code>nums</code> 和一个整数&nbsp;<code>k</code>&nbsp;。你需要执行以下操作<strong>&nbsp;恰好</strong> <code>k</code>&nbsp;次，最大化你的得分：</p>

<ol>
	<li>从 <code>nums</code>&nbsp;中选择一个元素&nbsp;<code>m</code>&nbsp;。</li>
	<li>将选中的元素&nbsp;<code>m</code>&nbsp;从数组中删除。</li>
	<li>将新元素&nbsp;<code>m + 1</code>&nbsp;添加到数组中。</li>
	<li>你的得分增加&nbsp;<code>m</code>&nbsp;。</li>
</ol>

<p>请你返回执行以上操作恰好 <code>k</code>&nbsp;次后的最大得分。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<b>输入：</b>nums = [1,2,3,4,5], k = 3
<b>输出：</b>18
<b>解释：</b>我们需要从 nums 中恰好选择 3 个元素并最大化得分。
第一次选择 5 。和为 5 ，nums = [1,2,3,4,6] 。
第二次选择 6 。和为 6 ，nums = [1,2,3,4,7] 。
第三次选择 7 。和为 5 + 6 + 7 = 18 ，nums = [1,2,3,4,8] 。
所以我们返回 18 。
18 是可以得到的最大答案。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<b>输入：</b>nums = [5,5,5], k = 2
<b>输出：</b>11
<b>解释：</b>我们需要从 nums 中恰好选择 2 个元素并最大化得分。
第一次选择 5 。和为 5 ，nums = [5,5,6] 。
第二次选择 6 。和为 6 ，nums = [5,5,7] 。
所以我们返回 11 。
11 是可以得到的最大答案。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 100</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 100</code></li>
	<li><code>1 &lt;= k &lt;= 100</code></li>
</ul>


## 题解


### Java

```Java
// @Title: K 个元素的最大和 (Maximum Sum With Exactly K Elements )
// @Author: robert.sunq
// @Date: 2023-11-15 22:28:27
// @Runtime: 1 ms
// @Memory: 42.1 MB

class Solution {
    public int maximizeSum(int[] nums, int k) {
        int max = 0;
        for (int i : nums) {
            max = Math.max(i, max);
        }

        return (max + (max + k - 1)) * k / 2;
    }
}
```



## 相关话题

- [贪心](https://leetcode.cn//tag/greedy)
- [数组](https://leetcode.cn//tag/array)

## 相似题目



