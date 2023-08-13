
| [English](README_EN.md) | 简体中文 |

# [334. 递增的三元子序列](https://leetcode.cn//problems/increasing-triplet-subsequence/)

## 题目描述

<p>给你一个整数数组&nbsp;<code>nums</code> ，判断这个数组中是否存在长度为 <code>3</code> 的递增子序列。</p>

<p>如果存在这样的三元组下标 <code>(i, j, k)</code>&nbsp;且满足 <code>i &lt; j &lt; k</code> ，使得&nbsp;<code>nums[i] &lt; nums[j] &lt; nums[k]</code> ，返回 <code>true</code> ；否则，返回 <code>false</code> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,3,4,5]
<strong>输出：</strong>true
<strong>解释：</strong>任何 i &lt; j &lt; k 的三元组都满足题意
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [5,4,3,2,1]
<strong>输出：</strong>false
<strong>解释：</strong>不存在满足题意的三元组</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = [2,1,5,0,4,6]
<strong>输出：</strong>true
<strong>解释：</strong>三元组 (3, 4, 5) 满足题意，因为 nums[3] == 0 &lt; nums[4] == 4 &lt; nums[5] == 6
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 5 * 10<sup>5</sup></code></li>
	<li><code>-2<sup>31</sup> &lt;= nums[i] &lt;= 2<sup>31</sup> - 1</code></li>
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong>你能实现时间复杂度为 <code>O(n)</code> ，空间复杂度为 <code>O(1)</code> 的解决方案吗？</p>


## 题解


### Java

```Java
// @Title: 递增的三元子序列 (Increasing Triplet Subsequence)
// @Author: robert.sunq
// @Date: 2023-08-11 21:47:49
// @Runtime: 2 ms
// @Memory: 126.7 MB

class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        boolean[] bs = new boolean[n];

        int min = nums[0];
        for (int i = 1; i<n; i++) {
            if (min < nums[i]) {
                bs[i] = true;
            } else {
                min = nums[i];
            }
        }

        min = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (min > nums[i]) {
                if (bs[i]) {
                    return true;
                }
            } else {
                min = nums[i];
            }
        }

        return false;
    }
}
```



## 相关话题

- [贪心](https://leetcode.cn//tag/greedy)
- [数组](https://leetcode.cn//tag/array)

## 相似题目


- [最长递增子序列](../longest-increasing-subsequence/README.md)
