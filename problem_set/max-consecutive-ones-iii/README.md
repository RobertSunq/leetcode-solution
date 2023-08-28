
| [English](README_EN.md) | 简体中文 |

# [1004. 最大连续1的个数 III](https://leetcode.cn//problems/max-consecutive-ones-iii/)

## 题目描述

<p>给定一个二进制数组&nbsp;<code>nums</code>&nbsp;和一个整数 <code>k</code>，如果可以翻转最多 <code>k</code> 个 <code>0</code> ，则返回 <em>数组中连续 <code>1</code> 的最大个数</em> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
<strong>输出：</strong>6
<strong>解释：</strong>[1,1,1,0,0,<strong>1</strong>,1,1,1,1,<strong>1</strong>]
粗体数字从 0 翻转到 1，最长的子数组长度为 6。</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
<strong>输出：</strong>10
<strong>解释：</strong>[0,0,1,1,<strong>1</strong>,<strong>1</strong>,1,1,1,<strong>1</strong>,1,1,0,0,0,1,1,1,1]
粗体数字从 0 翻转到 1，最长的子数组长度为 10。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>nums[i]</code>&nbsp;不是&nbsp;<code>0</code>&nbsp;就是&nbsp;<code>1</code></li>
	<li><code>0 &lt;= k &lt;= nums.length</code></li>
</ul>


## 题解


### Java

```Java
// @Title: 最大连续1的个数 III (Max Consecutive Ones III)
// @Author: robert.sunq
// @Date: 2023-08-18 22:19:12
// @Runtime: 3 ms
// @Memory: 45.1 MB

class Solution {

    /**
    转化为 在区间  [left,right]  内。
    对于任意的右端点 right，希望找到最小的左端点 left，使得 [left,right] 包含不超过 k 个 0。
    通过枚举所有可能的右断电，将得到的区间长度取最大值，即可得到答案。

    将 数组中 0 1 翻转，则前缀和就是需要翻转的次数
     */
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;

        int left = 0;
        int lsum = 0;
        int rsum = 0;
        int ans = 0;
        for (int right = 0; right < n; right++) {
            // 1 - nums[right] 表示当前位置需要翻转一次
            rsum = rsum + ( 1 - nums[right]);
            // 如果窗口之内的翻转次数，大于K， 则需要移动左端点，来降低翻转次数
            while (lsum < rsum - k) {
                // 窗口下线的位置，需要翻转 的次数
                lsum = lsum + (1-nums[left]);
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}
```



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [二分查找](https://leetcode.cn//tag/binary-search)
- [前缀和](https://leetcode.cn//tag/prefix-sum)
- [滑动窗口](https://leetcode.cn//tag/sliding-window)

## 相似题目


- [至多包含 K 个不同字符的最长子串](../longest-substring-with-at-most-k-distinct-characters/README.md)
- [替换后的最长重复字符](../longest-repeating-character-replacement/README.md)
- [最大连续 1 的个数](../max-consecutive-ones/README.md)
- [最大连续1的个数 II](../max-consecutive-ones-ii/README.md)
