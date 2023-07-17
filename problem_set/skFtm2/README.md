
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer II 070. 排序数组中只出现一次的数字](https://leetcode.cn//problems/skFtm2/)

## 题目描述

<p>给定一个只包含整数的有序数组 <code>nums</code>&nbsp;，每个元素都会出现两次，唯有一个数只会出现一次，请找出这个唯一的数字。</p>

<p>你设计的解决方案必须满足 <code>O(log n)</code> 时间复杂度和 <code>O(1)</code> 空间复杂度。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> nums = [1,1,2,3,3,4,4,8,8]
<strong>输出:</strong> 2
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> nums =  [3,3,7,7,10,11,11]
<strong>输出:</strong> 10
</pre>

<p>&nbsp;</p>

<p><meta charset="UTF-8" /></p>

<p><strong>提示:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= nums[i]&nbsp;&lt;= 10<sup>5</sup></code></li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 540&nbsp;题相同：<a href="https://leetcode-cn.com/problems/single-element-in-a-sorted-array/">https://leetcode-cn.com/problems/single-element-in-a-sorted-array/</a></p>


## 题解


### Java

```Java
// @Title: 排序数组中只出现一次的数字 (排序数组中只出现一次的数字)
// @Author: robert.sunq
// @Date: 2023-07-17 22:20:20
// @Runtime: 0 ms
// @Memory: 41.8 MB

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int middle = left + ((right - left) >> 1);
            // 左侧为偶数个, 
            if (((middle - left) & 1) == 0) {
                // 中间值和左侧相邻相等，则证明结果在左区间
                if (nums[middle] == nums[middle - 1]) {
                    // 注意 保证区间个数为 奇数 个
                    right = middle;
                } else {
                    left = middle;
                }
            } else {
                // 左侧为奇数个
                if (nums[middle] == nums[middle - 1]) {
                    // 结果在右侧区间， 保证区间个数为奇数个
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }
        return nums[left];
    }
}
```



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [二分查找](https://leetcode.cn//tag/binary-search)

## 相似题目



