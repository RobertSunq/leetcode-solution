
| English | [简体中文](README.md) |

# [581. Shortest Unsorted Continuous Subarray](https://leetcode.cn//problems/shortest-unsorted-continuous-subarray/)

## Description

<p>Given an integer array <code>nums</code>, you need to find one <b>continuous subarray</b> such that if you only sort this subarray in non-decreasing order, then the whole array will be sorted in non-decreasing order.</p>

<p>Return <em>the shortest such subarray and output its length</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [2,6,4,8,10,9,15]
<strong>Output:</strong> 5
<strong>Explanation:</strong> You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,2,3,4]
<strong>Output:</strong> 0
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [1]
<strong>Output:</strong> 0
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
	<li><code>-10<sup>5</sup> &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
</ul>

<p>&nbsp;</p>
<strong>Follow up:</strong> Can you solve it in <code>O(n)</code> time complexity?

## Solutions


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



## Related Topics

- [Stack](https://leetcode.cn//tag/stack)
- [Greedy](https://leetcode.cn//tag/greedy)
- [Array](https://leetcode.cn//tag/array)
- [Two Pointers](https://leetcode.cn//tag/two-pointers)
- [Sorting](https://leetcode.cn//tag/sorting)
- [Monotonic Stack](https://leetcode.cn//tag/monotonic-stack)

## Similar Questions


