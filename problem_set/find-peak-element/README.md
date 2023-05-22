
| [English](README_EN.md) | 简体中文 |

# [162. 寻找峰值](https://leetcode.cn//problems/find-peak-element/)

## 题目描述

<p>峰值元素是指其值严格大于左右相邻值的元素。</p>

<p>给你一个整数数组&nbsp;<code>nums</code>，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 <strong>任何一个峰值</strong> 所在位置即可。</p>

<p>你可以假设&nbsp;<code>nums[-1] = nums[n] = -∞</code> 。</p>

<p>你必须实现时间复杂度为 <code>O(log n)</code><em> </em>的算法来解决此问题。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = <code>[1,2,3,1]</code>
<strong>输出：</strong>2
<strong>解释：</strong>3 是峰值元素，你的函数应该返回其索引 2。</pre>

<p><strong>示例&nbsp;2：</strong></p>

<pre>
<strong>输入：</strong>nums = <code>[</code>1,2,1,3,5,6,4]
<strong>输出：</strong>1 或 5 
<strong>解释：</strong>你的函数可以返回索引 1，其峰值元素为 2；
&nbsp;    或者返回索引 5， 其峰值元素为 6。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 1000</code></li>
	<li><code>-2<sup>31</sup> &lt;= nums[i] &lt;= 2<sup>31</sup> - 1</code></li>
	<li>对于所有有效的 <code>i</code> 都有 <code>nums[i] != nums[i + 1]</code></li>
</ul>


## 题解


### Java

```Java
// @Title: 寻找峰值 (Find Peak Element)
// @Author: robert.sunq
// @Date: 2021-07-18 16:15:36
// @Runtime: 0 ms
// @Memory: 38.1 MB

class Solution {
    public int findPeakElement(int[] nums) {
        // 因为左右边界可以认定为-无穷，则整个数组种必定存在一个峰值
        // 因为中间可假想为连续函数，且不全相等，则必然存在倒数为0点，即峰值，因为左右为负无穷，所以存在大峰值

        int l = 0,r = nums.length-1;
        // 故可以使用双指针，区间查找，中点大于右边，则峰值，必然存在于左边区间
        while(l<r){
            int mid = (l+r)/2;
            if( mid== nums.length-1){
                break;
            }
            if(nums[mid] >= nums[mid+1]){
                r = mid;
            }else{
                l = mid+1;
            }
        }

        return l;
    }
}
```



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [二分查找](https://leetcode.cn//tag/binary-search)

## 相似题目


- [山脉数组的峰顶索引](../peak-index-in-a-mountain-array/README.md)
