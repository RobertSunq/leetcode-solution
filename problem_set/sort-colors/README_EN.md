
| English | [简体中文](README.md) |

# [75. Sort Colors](https://leetcode.cn//problems/sort-colors/)

## Description

<p>Given an array <code>nums</code> with <code>n</code> objects colored red, white, or blue, sort them <strong><a href="https://en.wikipedia.org/wiki/In-place_algorithm" target="_blank">in-place</a> </strong>so that objects of the same color are adjacent, with the colors in the order red, white, and blue.</p>

<p>We will use the integers <code>0</code>, <code>1</code>, and <code>2</code> to represent the color red, white, and blue, respectively.</p>

<p>You must solve this problem without using the library&#39;s sort function.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [2,0,2,1,1,0]
<strong>Output:</strong> [0,0,1,1,2,2]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [2,0,1]
<strong>Output:</strong> [0,1,2]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == nums.length</code></li>
	<li><code>1 &lt;= n &lt;= 300</code></li>
	<li><code>nums[i]</code> is either <code>0</code>, <code>1</code>, or <code>2</code>.</li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong>&nbsp;Could you come up with a one-pass algorithm using only&nbsp;constant extra space?</p>


## Solutions


### Java

```Java
// @Title: 颜色分类 (Sort Colors)
// @Author: robert.sunq
// @Date: 2021-06-05 22:20:06
// @Runtime: 0 ms
// @Memory: 36.6 MB

class Solution {
    public void sortColors(int[] nums) {
        int i = 0 , j = nums.length - 1;
        int index = 0;
        while(i <= j && index <= j){
            if(nums[index] == 0){
                nums[index] = nums[i];
                nums[i] = 0;
                i++;
            }else if(nums[index] == 2){
                nums[index] = nums[j];
                nums[j] = 2;
                j--;
            } else {
                index++;
            }
            if(index < i){
                index = i;
            }
        }
        return;
    }
}
```



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Two Pointers](https://leetcode.cn//tag/two-pointers)
- [Sorting](https://leetcode.cn//tag/sorting)

## Similar Questions

- [Sort List](../sort-list/README_EN.md)
- [Wiggle Sort](../wiggle-sort/README_EN.md)
- [Wiggle Sort II](../wiggle-sort-ii/README_EN.md)
