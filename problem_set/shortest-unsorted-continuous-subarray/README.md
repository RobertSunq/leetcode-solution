
| [English](README_EN.md) | 简体中文 |

# [581. 最短无序连续子数组](https://leetcode.cn//problems/shortest-unsorted-continuous-subarray/)

## 题目描述

<p>给你一个整数数组 <code>nums</code> ，你需要找出一个 <strong>连续子数组</strong> ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。</p>

<p>请你找出符合题意的 <strong>最短</strong> 子数组，并输出它的长度。</p>

<p> </p>

<div class="original__bRMd">
<div>
<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [2,6,4,8,10,9,15]
<strong>输出：</strong>5
<strong>解释：</strong>你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,3,4]
<strong>输出：</strong>0
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = [1]
<strong>输出：</strong>0
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= nums.length <= 10<sup>4</sup></code></li>
	<li><code>-10<sup>5</sup> <= nums[i] <= 10<sup>5</sup></code></li>
</ul>

<p> </p>

<p><strong>进阶：</strong>你可以设计一个时间复杂度为 <code>O(n)</code> 的解决方案吗？</p>
</div>
</div>


## 题解


### Java

```Java
// @Title: 最短无序连续子数组 (Shortest Unsorted Continuous Subarray)
// @Author: robert.sunq
// @Date: 2021-06-23 22:39:00
// @Runtime: 2 ms
// @Memory: 39.9 MB

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int res = 0;
        // 从左往右走找到第一个逆序的位置
        int left = 1;
        while(left<len && nums[left-1] <= nums[left]){
            left++;
        }
        //  如果走到最后都没有找到，那就不需要调整
        if(left == len) return res;
        // 存在逆序，则找逆序后最小的元素位置
        int temp = left;
        while(temp<len){
            if(nums[temp] < nums[left]){
                left = temp;
            }
            temp++;
        }
        // 找到 left 应该存在的位置
        temp = 0;
        while(temp<=left && nums[temp] <= nums[left]){
            temp++;
        }
        // 表示要插入的位置
        left = temp;
        // 否则 从右往左走 找
        int right = len -2;
        while(right>0 && nums[right] <= nums[right+1]){
            right--;
        }
        // 找到逆序后的最大元素
        temp = right;
        while(temp>=0){
            if(nums[temp]>nums[right]){
                right = temp;
            }
            temp--;
        }
        // 找到 right 应该存在的位置
        temp = len-1;
        while(temp>=right && nums[right] <= nums[temp]){
            temp--;
        }
        right = temp;
        return right - left +1;
    }
}
```



## 相关话题

- [栈](https://leetcode.cn//tag/stack)
- [贪心](https://leetcode.cn//tag/greedy)
- [数组](https://leetcode.cn//tag/array)
- [双指针](https://leetcode.cn//tag/two-pointers)
- [排序](https://leetcode.cn//tag/sorting)
- [单调栈](https://leetcode.cn//tag/monotonic-stack)

## 相似题目



