
| English | [简体中文](README.md) |

# [169. Majority Element](https://leetcode.cn//problems/majority-element/)

## Description

<p>Given an array <code>nums</code> of size <code>n</code>, return <em>the majority element</em>.</p>

<p>The majority element is the element that appears more than <code>&lfloor;n / 2&rfloor;</code> times. You may assume that the majority element always exists in the array.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> nums = [3,2,3]
<strong>Output:</strong> 3
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> nums = [2,2,1,1,1,2,2]
<strong>Output:</strong> 2
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == nums.length</code></li>
	<li><code>1 &lt;= n &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
</ul>

<p>&nbsp;</p>
<strong>Follow-up:</strong> Could you solve the problem in linear time and in <code>O(1)</code> space?

## Solutions


### Java

```Java
// @Title: 多数元素 (Majority Element)
// @Author: robert.sunq
// @Date: 2021-06-14 22:30:48
// @Runtime: 1 ms
// @Memory: 44.3 MB

class Solution {
    public int majorityElement(int[] nums) {
        if (nums.length <= 0) return -1;
        int temp = nums[0] , n = 0;
        for(int i = 0;i<nums.length;i++){
            if(n == 0) {
               temp=nums[i]; 
               n++;
            }
            else{
                if(nums[i] == temp){
                    n++;
                }else{
                    n--;
                }
            }
        } 
        return temp;
    }
}
```



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Hash Table](https://leetcode.cn//tag/hash-table)
- [Divide and Conquer](https://leetcode.cn//tag/divide-and-conquer)
- [Counting](https://leetcode.cn//tag/counting)
- [Sorting](https://leetcode.cn//tag/sorting)

## Similar Questions

- [Majority Element II](../majority-element-ii/README_EN.md)
- [Check If a Number Is Majority Element in a Sorted Array](../check-if-a-number-is-majority-element-in-a-sorted-array/README_EN.md)
