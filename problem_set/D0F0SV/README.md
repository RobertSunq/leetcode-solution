
| [English](README_EN.md) | 简体中文 |

# [LCR 104. 组合总和 Ⅳ](https://leetcode.cn//problems/D0F0SV/)

## 题目描述

<p>给定一个由 <strong>不同</strong>&nbsp;正整数组成的数组 <code>nums</code> ，和一个目标整数 <code>target</code> 。请从 <code>nums</code> 中找出并返回总和为 <code>target</code> 的元素组合的个数。数组中的数字可以在一次排列中出现任意次，但是顺序不同的序列被视作不同的组合。</p>

<p>题目数据保证答案符合 32 位整数范围。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,3], target = 4
<strong>输出：</strong>7
<strong>解释：</strong>
所有可能的组合为：
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)
请注意，顺序不同的序列被视作不同的组合。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [9], target = 3
<strong>输出：</strong>0
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 200</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 1000</code></li>
	<li><code>nums</code> 中的所有元素 <strong>互不相同</strong></li>
	<li><code>1 &lt;= target &lt;= 1000</code></li>
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong>如果给定的数组中含有负数会发生什么？问题会产生何种变化？如果允许负数出现，需要向题目中添加哪些限制条件？</p>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 377&nbsp;题相同：<a href="https://leetcode-cn.com/problems/combination-sum-iv/">https://leetcode-cn.com/problems/combination-sum-iv/</a></p>


## 题解


### Java

```Java
// @Title: 组合总和 Ⅳ (组合总和 Ⅳ)
// @Author: robert.sunq
// @Date: 2023-08-02 23:44:14
// @Runtime: 1 ms
// @Memory: 38.5 MB

class Solution {
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target + 1];
        // 不选元素的时候，和才是 0， 所以只有一种情况
        dp[0] = 1;

        // 当和为 i 时， 如果存在一种排列，其中的元素之后等于 i， 则该排列的最后一个元素一定是数组中第一个
        // 所以，dp[i] ，就是所有的 dp[i - num] 的和
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) {
                    // 当最后一位时 num 时， 则dp[i] 的个数应该加上 和为 i - num 的个数
                    dp[i] = dp[i] +  dp[i - num];
                }
            }
        }

        return dp[target];

    }
}
```



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [动态规划](https://leetcode.cn//tag/dynamic-programming)

## 相似题目



