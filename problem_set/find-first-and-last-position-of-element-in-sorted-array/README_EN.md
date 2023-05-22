
| English | [简体中文](README.md) |

# [34. Find First and Last Position of Element in Sorted Array](https://leetcode.cn//problems/find-first-and-last-position-of-element-in-sorted-array/)

## Description

<p>Given an array of integers <code>nums</code> sorted in non-decreasing order, find the starting and ending position of a given <code>target</code> value.</p>

<p>If <code>target</code> is not found in the array, return <code>[-1, -1]</code>.</p>

<p>You must&nbsp;write an algorithm with&nbsp;<code>O(log n)</code> runtime complexity.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> nums = [5,7,7,8,8,10], target = 8
<strong>Output:</strong> [3,4]
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> nums = [5,7,7,8,8,10], target = 6
<strong>Output:</strong> [-1,-1]
</pre><p><strong class="example">Example 3:</strong></p>
<pre><strong>Input:</strong> nums = [], target = 0
<strong>Output:</strong> [-1,-1]
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>-10<sup>9</sup>&nbsp;&lt;= nums[i]&nbsp;&lt;= 10<sup>9</sup></code></li>
	<li><code>nums</code> is a non-decreasing array.</li>
	<li><code>-10<sup>9</sup>&nbsp;&lt;= target&nbsp;&lt;= 10<sup>9</sup></code></li>
</ul>


## Solutions


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



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Binary Search](https://leetcode.cn//tag/binary-search)

## Similar Questions

- [First Bad Version](../first-bad-version/README_EN.md)
