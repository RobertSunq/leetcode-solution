
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer 53 - II. 0～n-1中缺失的数字](https://leetcode.cn//problems/que-shi-de-shu-zi-lcof/)

## 题目描述

<p>一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<pre><strong>输入:</strong> [0,1,3]
<strong>输出:</strong> 2
</pre>

<p><strong>示例&nbsp;2:</strong></p>

<pre><strong>输入:</strong> [0,1,2,3,4,5,6,7,9]
<strong>输出:</strong> 8</pre>

<p>&nbsp;</p>

<p><strong>限制：</strong></p>

<p><code>1 &lt;= 数组长度 &lt;= 10000</code></p>


## 题解


### Java

```Java
// @Title: 0～n-1中缺失的数字 (缺失的数字  LCOF)
// @Author: robert.sunq
// @Date: 2021-05-30 03:16:00
// @Runtime: 0 ms
// @Memory: 39 MB

class Solution {
    public int missingNumber(int[] nums) {
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] == m) i = m + 1;
            else j = m - 1;
        }
        return i;
    }
}
```



## 相关话题

- [位运算](https://leetcode.cn//tag/bit-manipulation)
- [数组](https://leetcode.cn//tag/array)
- [哈希表](https://leetcode.cn//tag/hash-table)
- [数学](https://leetcode.cn//tag/math)
- [二分查找](https://leetcode.cn//tag/binary-search)

## 相似题目



