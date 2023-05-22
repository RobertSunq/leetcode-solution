
| English | [简体中文](README.md) |

# [287. Find the Duplicate Number](https://leetcode.cn//problems/find-the-duplicate-number/)

## Description

<p>Given an array of integers <code>nums</code> containing&nbsp;<code>n + 1</code> integers where each integer is in the range <code>[1, n]</code> inclusive.</p>

<p>There is only <strong>one repeated number</strong> in <code>nums</code>, return <em>this&nbsp;repeated&nbsp;number</em>.</p>

<p>You must solve the problem <strong>without</strong> modifying the array <code>nums</code>&nbsp;and uses only constant extra space.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,3,4,2,2]
<strong>Output:</strong> 2
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [3,1,3,4,2]
<strong>Output:</strong> 3
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>nums.length == n + 1</code></li>
	<li><code>1 &lt;= nums[i] &lt;= n</code></li>
	<li>All the integers in <code>nums</code> appear only <strong>once</strong> except for <strong>precisely one integer</strong> which appears <strong>two or more</strong> times.</li>
</ul>

<p>&nbsp;</p>
<p><b>Follow up:</b></p>

<ul>
	<li>How can we prove that at least one duplicate number must exist in <code>nums</code>?</li>
	<li>Can you solve the problem in linear runtime complexity?</li>
</ul>


## Solutions


### Java

```Java
// @Title: 寻找重复数 (Find the Duplicate Number)
// @Author: robert.sunq
// @Date: 2021-07-11 16:50:25
// @Runtime: 4 ms
// @Memory: 54.3 MB

class Solution {
    public int findDuplicate(int[] nums) {
        int i = 0;
        while(i<nums.length){
            if(nums[i] == i){
                i++;
                continue;
            }
            if(nums[i] == nums[nums[i]]) return nums[i];
            int temp = nums[i];
            nums[i] = nums[temp];
            nums[temp] = temp;
        }
        return -1;
    }
}
```



## Related Topics

- [Bit Manipulation](https://leetcode.cn//tag/bit-manipulation)
- [Array](https://leetcode.cn//tag/array)
- [Two Pointers](https://leetcode.cn//tag/two-pointers)
- [Binary Search](https://leetcode.cn//tag/binary-search)

## Similar Questions

- [First Missing Positive](../first-missing-positive/README_EN.md)
- [Single Number](../single-number/README_EN.md)
- [Linked List Cycle II](../linked-list-cycle-ii/README_EN.md)
- [Missing Number](../missing-number/README_EN.md)
- [Set Mismatch](../set-mismatch/README_EN.md)
