
| [English](README_EN.md) | 简体中文 |

# [33. 搜索旋转排序数组](https://leetcode.cn//problems/search-in-rotated-sorted-array/)

## 题目描述

<p>整数数组 <code>nums</code> 按升序排列，数组中的值 <strong>互不相同</strong> 。</p>

<p>在传递给函数之前，<code>nums</code> 在预先未知的某个下标 <code>k</code>（<code>0 &lt;= k &lt; nums.length</code>）上进行了 <strong>旋转</strong>，使数组变为 <code>[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]</code>（下标 <strong>从 0 开始</strong> 计数）。例如， <code>[0,1,2,4,5,6,7]</code> 在下标 <code>3</code> 处经旋转后可能变为&nbsp;<code>[4,5,6,7,0,1,2]</code> 。</p>

<p>给你 <strong>旋转后</strong> 的数组 <code>nums</code> 和一个整数 <code>target</code> ，如果 <code>nums</code> 中存在这个目标值 <code>target</code> ，则返回它的下标，否则返回&nbsp;<code>-1</code>&nbsp;。</p>

<p>你必须设计一个时间复杂度为 <code>O(log n)</code> 的算法解决此问题。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [<code>4,5,6,7,0,1,2]</code>, target = 0
<strong>输出：</strong>4
</pre>

<p><strong>示例&nbsp;2：</strong></p>

<pre>
<strong>输入：</strong>nums = [<code>4,5,6,7,0,1,2]</code>, target = 3
<strong>输出：</strong>-1</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = [1], target = 0
<strong>输出：</strong>-1
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 5000</code></li>
	<li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
	<li><code>nums</code> 中的每个值都 <strong>独一无二</strong></li>
	<li>题目数据保证 <code>nums</code> 在预先未知的某个下标上进行了旋转</li>
	<li><code>-10<sup>4</sup> &lt;= target &lt;= 10<sup>4</sup></code></li>
</ul>


## 题解


### Java

```Java
// @Title: 搜索旋转排序数组 (Search in Rotated Sorted Array)
// @Author: robert.sunq
// @Date: 2021-06-03 01:07:23
// @Runtime: 0 ms
// @Memory: 37.8 MB

class Solution {
    public int search(int[] nums, int target) {
        int i = 0 , j = nums.length-1,temp;
        while(i<=j){
            temp = (i+j)/2;
            if(nums[temp] == target) return temp;
            //  则此时中间点在 左半边排序数组中
            // 左半边有序
            if(nums[temp] >= nums[j]){
                // 在左侧中
                if (target >= nums[i] && target< nums[temp]) {
                    j=temp;
                }else{
                    i = temp+1;
                }
            }else{
                // 此时中间点 在右半边
                // 右半边有序
                if (target <= nums[j] && target> nums[temp]) {
                    i=temp+1;
                }else{
                    j = temp;
                }
            }
        }
        return -1;
    }
}
```



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [二分查找](https://leetcode.cn//tag/binary-search)

## 相似题目


- [搜索旋转排序数组 II](../search-in-rotated-sorted-array-ii/README.md)
- [寻找旋转排序数组中的最小值](../find-minimum-in-rotated-sorted-array/README.md)
