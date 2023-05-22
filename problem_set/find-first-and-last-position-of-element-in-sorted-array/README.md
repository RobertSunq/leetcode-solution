
| [English](README_EN.md) | 简体中文 |

# [34. 在排序数组中查找元素的第一个和最后一个位置](https://leetcode.cn//problems/find-first-and-last-position-of-element-in-sorted-array/)

## 题目描述

<p>给你一个按照非递减顺序排列的整数数组 <code>nums</code>，和一个目标值 <code>target</code>。请你找出给定目标值在数组中的开始位置和结束位置。</p>

<p>如果数组中不存在目标值 <code>target</code>，返回&nbsp;<code>[-1, -1]</code>。</p>

<p>你必须设计并实现时间复杂度为&nbsp;<code>O(log n)</code>&nbsp;的算法解决此问题。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [<code>5,7,7,8,8,10]</code>, target = 8
<strong>输出：</strong>[3,4]</pre>

<p><strong>示例&nbsp;2：</strong></p>

<pre>
<strong>输入：</strong>nums = [<code>5,7,7,8,8,10]</code>, target = 6
<strong>输出：</strong>[-1,-1]</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = [], target = 0
<strong>输出：</strong>[-1,-1]</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>0 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>-10<sup>9</sup>&nbsp;&lt;= nums[i]&nbsp;&lt;= 10<sup>9</sup></code></li>
	<li><code>nums</code>&nbsp;是一个非递减数组</li>
	<li><code>-10<sup>9</sup>&nbsp;&lt;= target&nbsp;&lt;= 10<sup>9</sup></code></li>
</ul>


## 题解


### Java

```Java
// @Title: 在排序数组中查找元素的第一个和最后一个位置 (Find First and Last Position of Element in Sorted Array)
// @Author: robert.sunq
// @Date: 2021-08-08 15:38:57
// @Runtime: 0 ms
// @Memory: 41.5 MB

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0,right = nums.length-1;
        int temp = 0;;
        while(left <= right){
            temp = (left+right)/2;
            // System.out.println(temp);
            if(nums[temp] == target) break;
            else if(nums[temp] > target) {
                right = temp-1;
            }else{
                left =temp+1;
            }
        }
        if(temp < 0 || temp >= nums.length ||nums[temp] != target ) return new int[]{-1,-1};
        left = temp;
        right = temp;
        while(left>=0 && nums[left] == target) left--;
        while(right<nums.length && nums[right] == target) right++;
        return new int[]{left+1,right-1};
    }
}
```



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [二分查找](https://leetcode.cn//tag/binary-search)

## 相似题目


- [第一个错误的版本](../first-bad-version/README.md)
