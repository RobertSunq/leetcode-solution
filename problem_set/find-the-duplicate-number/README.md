
| [English](README_EN.md) | 简体中文 |

# [287. 寻找重复数](https://leetcode.cn//problems/find-the-duplicate-number/)

## 题目描述

<p>给定一个包含&nbsp;<code>n + 1</code> 个整数的数组&nbsp;<code>nums</code> ，其数字都在&nbsp;<code>[1, n]</code>&nbsp;范围内（包括 <code>1</code> 和 <code>n</code>），可知至少存在一个重复的整数。</p>

<p>假设 <code>nums</code> 只有 <strong>一个重复的整数</strong> ，返回&nbsp;<strong>这个重复的数</strong> 。</p>

<p>你设计的解决方案必须 <strong>不修改</strong> 数组 <code>nums</code> 且只用常量级 <code>O(1)</code> 的额外空间。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,3,4,2,2]
<strong>输出：</strong>2
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [3,1,3,4,2]
<strong>输出：</strong>3
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>nums.length == n + 1</code></li>
	<li><code>1 &lt;= nums[i] &lt;= n</code></li>
	<li><code>nums</code> 中 <strong>只有一个整数</strong> 出现 <strong>两次或多次</strong> ，其余整数均只出现 <strong>一次</strong></li>
</ul>

<p>&nbsp;</p>

<p><b>进阶：</b></p>

<ul>
	<li>如何证明 <code>nums</code> 中至少存在一个重复的数字?</li>
	<li>你可以设计一个线性级时间复杂度 <code>O(n)</code> 的解决方案吗？</li>
</ul>


## 题解


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



## 相关话题

- [位运算](https://leetcode.cn//tag/bit-manipulation)
- [数组](https://leetcode.cn//tag/array)
- [双指针](https://leetcode.cn//tag/two-pointers)
- [二分查找](https://leetcode.cn//tag/binary-search)

## 相似题目


- [缺失的第一个正数](../first-missing-positive/README.md)
- [只出现一次的数字](../single-number/README.md)
- [环形链表 II](../linked-list-cycle-ii/README.md)
- [丢失的数字](../missing-number/README.md)
- [错误的集合](../set-mismatch/README.md)
