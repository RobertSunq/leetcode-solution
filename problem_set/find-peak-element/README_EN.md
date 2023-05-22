
| English | [简体中文](README.md) |

# [162. Find Peak Element](https://leetcode.cn//problems/find-peak-element/)

## Description

<p>A peak element is an element that is strictly greater than its neighbors.</p>

<p>Given a <strong>0-indexed</strong> integer array <code>nums</code>, find a peak element, and return its index. If the array contains multiple peaks, return the index to <strong>any of the peaks</strong>.</p>

<p>You may imagine that <code>nums[-1] = nums[n] = -&infin;</code>. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.</p>

<p>You must write an algorithm that runs in <code>O(log n)</code> time.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,2,3,1]
<strong>Output:</strong> 2
<strong>Explanation:</strong> 3 is a peak element and your function should return the index number 2.</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,2,1,3,5,6,4]
<strong>Output:</strong> 5
<strong>Explanation:</strong> Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 1000</code></li>
	<li><code>-2<sup>31</sup> &lt;= nums[i] &lt;= 2<sup>31</sup> - 1</code></li>
	<li><code>nums[i] != nums[i + 1]</code> for all valid <code>i</code>.</li>
</ul>


## Solutions


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



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Binary Search](https://leetcode.cn//tag/binary-search)

## Similar Questions

- [Peak Index in a Mountain Array](../peak-index-in-a-mountain-array/README_EN.md)
