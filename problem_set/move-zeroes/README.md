
| [English](README_EN.md) | 简体中文 |

# [283. 移动零](https://leetcode.cn//problems/move-zeroes/)

## 题目描述

<p>给定一个数组 <code>nums</code>，编写一个函数将所有 <code>0</code> 移动到数组的末尾，同时保持非零元素的相对顺序。</p>

<p><strong>请注意</strong>&nbsp;，必须在不复制数组的情况下原地对数组进行操作。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> nums = <code>[0,1,0,3,12]</code>
<strong>输出:</strong> <code>[1,3,12,0,0]</code>
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> nums = <code>[0]</code>
<strong>输出:</strong> <code>[0]</code></pre>

<p>&nbsp;</p>

<p><strong>提示</strong>:</p>
<meta charset="UTF-8" />

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
	<li><code>-2<sup>31</sup>&nbsp;&lt;= nums[i] &lt;= 2<sup>31</sup>&nbsp;- 1</code></li>
</ul>

<p>&nbsp;</p>

<p><b>进阶：</b>你能尽量减少完成的操作次数吗？</p>


## 题解


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



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [双指针](https://leetcode.cn//tag/two-pointers)

## 相似题目


- [移除元素](../remove-element/README.md)
