
| [English](README_EN.md) | 简体中文 |

# [238. 除自身以外数组的乘积](https://leetcode.cn//problems/product-of-array-except-self/)

## 题目描述

<p>给你一个整数数组&nbsp;<code>nums</code>，返回 <em>数组&nbsp;<code>answer</code>&nbsp;，其中&nbsp;<code>answer[i]</code>&nbsp;等于&nbsp;<code>nums</code>&nbsp;中除&nbsp;<code>nums[i]</code>&nbsp;之外其余各元素的乘积</em>&nbsp;。</p>

<p>题目数据 <strong>保证</strong> 数组&nbsp;<code>nums</code>之中任意元素的全部前缀元素和后缀的乘积都在&nbsp; <strong>32 位</strong> 整数范围内。</p>

<p>请<strong>不要使用除法，</strong>且在&nbsp;<code>O(<em>n</em>)</code> 时间复杂度内完成此题。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> nums = <code>[1,2,3,4]</code>
<strong>输出:</strong> <code>[24,12,8,6]</code>
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> nums = [-1,1,0,-3,3]
<strong>输出:</strong> [0,0,9,0,0]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>2 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>-30 &lt;= nums[i] &lt;= 30</code></li>
	<li><strong>保证</strong> 数组&nbsp;<code>nums</code>之中任意元素的全部前缀元素和后缀的乘积都在&nbsp; <strong>32 位</strong> 整数范围内</li>
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong>你可以在 <code>O(1)</code>&nbsp;的额外空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组<strong>不被视为</strong>额外空间。）</p>


## 题解


### Java

```Java
// @Title: 除自身以外数组的乘积 (Product of Array Except Self)
// @Author: robert.sunq
// @Date: 2021-06-17 23:26:30
// @Runtime: 1 ms
// @Memory: 48.7 MB

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        if(nums.length == 0) return res;
        int temp = 1;
        for(int i=0;i<nums.length;i++){
            res[i] =  temp;
            temp = temp*nums[i];
        }
        temp = 1;
        for (int i = nums.length-1;i>=0;i--){
            res[i] = res[i]*temp;
            temp = temp*nums[i];
        }
        return res;
    }
}
```



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [前缀和](https://leetcode.cn//tag/prefix-sum)

## 相似题目


- [接雨水](../trapping-rain-water/README.md)
- [乘积最大子数组](../maximum-product-subarray/README.md)
- [粉刷房子 II](../paint-house-ii/README.md)
