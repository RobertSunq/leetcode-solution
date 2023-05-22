
| English | [简体中文](README.md) |

# [41. First Missing Positive](https://leetcode.cn//problems/first-missing-positive/)

## Description

<p>Given an unsorted integer array <code>nums</code>, return the smallest missing positive integer.</p>

<p>You must implement an algorithm that runs in <code>O(n)</code> time and uses constant extra space.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,2,0]
<strong>Output:</strong> 3
<strong>Explanation:</strong> The numbers in the range [1,2] are all in the array.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [3,4,-1,1]
<strong>Output:</strong> 2
<strong>Explanation:</strong> 1 is in the array but 2 is missing.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [7,8,9,11,12]
<strong>Output:</strong> 1
<strong>Explanation:</strong> The smallest positive integer 1 is missing.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>-2<sup>31</sup> &lt;= nums[i] &lt;= 2<sup>31</sup> - 1</code></li>
</ul>


## Solutions


### Java

```Java
// @Title: 缺失的第一个正数 (First Missing Positive)
// @Author: robert.sunq
// @Date: 2021-07-11 21:25:09
// @Runtime: 3 ms
// @Memory: 94 MB

class Solution {
    public int firstMissingPositive(int[] nums) {
        int i  = 0;
        // 使用元素自身作为hash表
        // 将元素 i位置放上数字 i + 1;
        // 
        while (i < nums.length){
            // 只处理可以映射到 nums上的正整数，因为大于nums.length的 其最小正整数肯定小于数组长度
            if(nums[i] < 1 || nums[i] > nums.length || nums[i] -1 == i || nums[nums[i] -1] == nums[i]){
                i++;
                continue;
            }
            // 将nums[i] 放到nums[ nums[i] - 1] 上
            int temp = nums[nums[i]-1];
            nums[nums[i]-1] = nums[i];
            nums[i] = temp; 
        }
        i = 0;
        // 此时 再数据中，value和下标不对应的 就是第一个最小正整数
        while(i < nums.length){
            if(nums[i] -1 != i){
                return i+1;
            }
            i++;
        }
        return i+1;
    }
}
```



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Hash Table](https://leetcode.cn//tag/hash-table)

## Similar Questions

- [Missing Number](../missing-number/README_EN.md)
- [Find the Duplicate Number](../find-the-duplicate-number/README_EN.md)
- [Find All Numbers Disappeared in an Array](../find-all-numbers-disappeared-in-an-array/README_EN.md)
- [Couples Holding Hands](../couples-holding-hands/README_EN.md)
