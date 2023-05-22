
| English | [简体中文](README.md) |

# [1. Two Sum](https://leetcode.cn//problems/two-sum/)

## Description

<p>Given an array of integers <code>nums</code>&nbsp;and an integer <code>target</code>, return <em>indices of the two numbers such that they add up to <code>target</code></em>.</p>

<p>You may assume that each input would have <strong><em>exactly</em> one solution</strong>, and you may not use the <em>same</em> element twice.</p>

<p>You can return the answer in any order.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [2,7,11,15], target = 9
<strong>Output:</strong> [0,1]
<strong>Explanation:</strong> Because nums[0] + nums[1] == 9, we return [0, 1].
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [3,2,4], target = 6
<strong>Output:</strong> [1,2]
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [3,3], target = 6
<strong>Output:</strong> [0,1]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
	<li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
	<li><code>-10<sup>9</sup> &lt;= target &lt;= 10<sup>9</sup></code></li>
	<li><strong>Only one valid answer exists.</strong></li>
</ul>

<p>&nbsp;</p>
<strong>Follow-up:&nbsp;</strong>Can you come up with an algorithm that is less than&nbsp;<code>O(n<sup>2</sup>)&nbsp;</code>time complexity?

## Solutions


### Java

```Java
// @Title: 两数之和 (Two Sum)
// @Author: robert.sunq
// @Date: 2021-06-01 00:19:00
// @Runtime: 2 ms
// @Memory: 38.5 MB

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i =0 ;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{i,map.get(target-nums[i])};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }

    void quickSort(int[] nums , int start,int end){
        if(start >= end) return;
        // 哨兵
        int i = start,j=end;
        int temp = nums[i];
        while(i < j){
            while(j>i && nums[j]>=temp) j--;
            if(j>i) nums[i] = nums[j];
            while(i<j && nums[i] <= temp) i++;
            if(i < j) nums[j] = nums[i];
        }

    }
}
```



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Hash Table](https://leetcode.cn//tag/hash-table)

## Similar Questions

- [3Sum](../3sum/README_EN.md)
- [4Sum](../4sum/README_EN.md)
- [Two Sum II - Input Array Is Sorted](../two-sum-ii-input-array-is-sorted/README_EN.md)
- [Two Sum III - Data structure design](../two-sum-iii-data-structure-design/README_EN.md)
- [Subarray Sum Equals K](../subarray-sum-equals-k/README_EN.md)
- [Two Sum IV - Input is a BST](../two-sum-iv-input-is-a-bst/README_EN.md)
- [Two Sum Less Than K](../two-sum-less-than-k/README_EN.md)
