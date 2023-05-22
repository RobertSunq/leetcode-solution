
| English | [简体中文](README.md) |

# [283. Move Zeroes](https://leetcode.cn//problems/move-zeroes/)

## Description

<p>Given an integer array <code>nums</code>, move all <code>0</code>&#39;s to the end of it while maintaining the relative order of the non-zero elements.</p>

<p><strong>Note</strong> that you must do this in-place without making a copy of the array.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> nums = [0,1,0,3,12]
<strong>Output:</strong> [1,3,12,0,0]
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> nums = [0]
<strong>Output:</strong> [0]
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
	<li><code>-2<sup>31</sup> &lt;= nums[i] &lt;= 2<sup>31</sup> - 1</code></li>
</ul>

<p>&nbsp;</p>
<strong>Follow up:</strong> Could you minimize the total number of operations done?

## Solutions


### Java

```Java
// @Title: 移动零 (Move Zeroes)
// @Author: robert.sunq
// @Date: 2021-06-18 23:26:33
// @Runtime: 0 ms
// @Memory: 38.6 MB

class Solution {
    public void moveZeroes(int[] nums) {
        // 双指针，left 指向当前不包含零的元素位置，i 移动指针，
        int left = 0,i=0;
        while(left < nums.length && i<nums.length){
            // i位置不为0 将其交换到 left位置
            if( nums[i] != 0){
                nums[left] = nums[i];
                i++;
                
                left++;
            }else{
                i++;
            }
        }
        // left 之前的元素 均为不为零，故将left之后的全部置换为0 即可
        for( ;left<nums.length;left++){
            nums[left] = 0;
        }
        
    }
}
```



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Two Pointers](https://leetcode.cn//tag/two-pointers)

## Similar Questions

- [Remove Element](../remove-element/README_EN.md)
