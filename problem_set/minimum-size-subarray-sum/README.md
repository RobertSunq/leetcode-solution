
| [English](README_EN.md) | 简体中文 |

# [209. 长度最小的子数组](https://leetcode.cn//problems/minimum-size-subarray-sum/)

## 题目描述

<p>给定一个含有 <code>n</code><strong> </strong>个正整数的数组和一个正整数 <code>target</code><strong> 。</strong></p>

<p>找出该数组中满足其和<strong> </strong><code>≥ target</code><strong> </strong>的长度最小的 <strong>连续子数组</strong> <code>[nums<sub>l</sub>, nums<sub>l+1</sub>, ..., nums<sub>r-1</sub>, nums<sub>r</sub>]</code> ，并返回其长度<strong>。</strong>如果不存在符合条件的子数组，返回 <code>0</code> 。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>target = 7, nums = [2,3,1,2,4,3]
<strong>输出：</strong>2
<strong>解释：</strong>子数组 <code>[4,3]</code> 是该条件下的长度最小的子数组。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>target = 4, nums = [1,4,4]
<strong>输出：</strong>1
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>target = 11, nums = [1,1,1,1,1,1,1,1]
<strong>输出：</strong>0
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= target <= 10<sup>9</sup></code></li>
	<li><code>1 <= nums.length <= 10<sup>5</sup></code></li>
	<li><code>1 <= nums[i] <= 10<sup>5</sup></code></li>
</ul>

<p> </p>

<p><strong>进阶：</strong></p>

<ul>
	<li>如果你已经实现<em> </em><code>O(n)</code> 时间复杂度的解法, 请尝试设计一个 <code>O(n log(n))</code> 时间复杂度的解法。</li>
</ul>


## 题解


### Java

```Java
// @Title: 长度最小的子数组 (Minimum Size Subarray Sum)
// @Author: robert.sunq
// @Date: 2021-07-18 16:43:56
// @Runtime: 1 ms
// @Memory: 38.4 MB

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l=0,r=0;
        int len = nums.length;
        int res = len+5;
        int sum = 0;
        while(r<len){
            sum = sum+nums[r];
            // 如果和大于目标值，则移动左侧指针
            if(sum >= target){
                while(sum >= target){
                    sum = sum - nums[l];
                    res = Math.min(res,r-l+1);
                    l++;
                }
            }
            r++;
        }
        return res == len+5?0:res;
    }
}
```



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [二分查找](https://leetcode.cn//tag/binary-search)
- [前缀和](https://leetcode.cn//tag/prefix-sum)
- [滑动窗口](https://leetcode.cn//tag/sliding-window)

## 相似题目


- [最小覆盖子串](../minimum-window-substring/README.md)
- [和等于 k 的最长子数组长度](../maximum-size-subarray-sum-equals-k/README.md)
- [最长重复子数组](../maximum-length-of-repeated-subarray/README.md)
