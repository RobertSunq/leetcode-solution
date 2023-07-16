
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer II 068. 查找插入位置](https://leetcode.cn//problems/N6YdxV/)

## 题目描述

<p>给定一个排序的整数数组 <code>nums</code>&nbsp;和一个整数目标值<code> target</code> ，请在数组中找到&nbsp;<code>target&nbsp;</code>，并返回其下标。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。</p>

<p>请必须使用时间复杂度为 <code>O(log n)</code> 的算法。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> nums = [1,3,5,6], target = 5
<strong>输出:</strong> 2
</pre>

<p><strong>示例&nbsp;2:</strong></p>

<pre>
<strong>输入:</strong> nums = [1,3,5,6], target = 2
<strong>输出:</strong> 1
</pre>

<p><strong>示例 3:</strong></p>

<pre>
<strong>输入:</strong> nums = [1,3,5,6], target = 7
<strong>输出:</strong> 4
</pre>

<p><strong>示例 4:</strong></p>

<pre>
<strong>输入:</strong> nums = [1,3,5,6], target = 0
<strong>输出:</strong> 0
</pre>

<p><strong>示例 5:</strong></p>

<pre>
<strong>输入:</strong> nums = [1], target = 0
<strong>输出:</strong> 0
</pre>

<p>&nbsp;</p>

<p><strong>提示:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
	<li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
	<li><code>nums</code> 为<strong>无重复元素</strong>的<strong>升序</strong>排列数组</li>
	<li><code>-10<sup>4</sup> &lt;= target &lt;= 10<sup>4</sup></code></li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 35&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/search-insert-position/">https://leetcode-cn.com/problems/search-insert-position/</a></p>


## 题解


### Java

```Java
// @Title: 查找插入位置 (查找插入位置)
// @Author: robert.sunq
// @Date: 2023-07-16 21:54:18
// @Runtime: 0 ms
// @Memory: 42.3 MB

class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int tmp = 0;
        while (start <= end) {
            tmp = (start + end) /2;
            if (nums[tmp] == target) {
                return tmp;
            } else if (nums[tmp] > target) {
                end = tmp - 1;
            } else {
                start = tmp + 1;
            }
        }

        // 注意这里，
        // 如果 target 不在数组中，此时，start 指针和 end 指针就会相遇。因此，最终我们只用考虑 target 插入的位置和 middle 的关系即可
        return nums[tmp] < target ? tmp + 1: tmp;

    }
}
```



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [二分查找](https://leetcode.cn//tag/binary-search)

## 相似题目



