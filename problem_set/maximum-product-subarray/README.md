
| [English](README_EN.md) | 简体中文 |

# [152. 乘积最大子数组](https://leetcode.cn//problems/maximum-product-subarray/)

## 题目描述

<p>给你一个整数数组 <code>nums</code>&nbsp;，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。</p>

<p>测试用例的答案是一个&nbsp;<strong>32-位</strong> 整数。</p>

<p><strong>子数组</strong> 是数组的连续子序列。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> nums = [2,3,-2,4]
<strong>输出:</strong> <code>6</code>
<strong>解释:</strong>&nbsp;子数组 [2,3] 有最大乘积 6。
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> nums = [-2,0,-1]
<strong>输出:</strong> 0
<strong>解释:</strong>&nbsp;结果不能为 2, 因为 [-2,-1] 不是子数组。</pre>

<p>&nbsp;</p>

<p><strong>提示:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 2 * 10<sup>4</sup></code></li>
	<li><code>-10 &lt;= nums[i] &lt;= 10</code></li>
	<li><code>nums</code> 的任何前缀或后缀的乘积都 <strong>保证</strong>&nbsp;是一个 <strong>32-位</strong> 整数</li>
</ul>


## 题解


### Java

```Java
// @Title: 乘积最大子数组 (Maximum Product Subarray)
// @Author: robert.sunq
// @Date: 2021-06-12 01:22:32
// @Runtime: 2 ms
// @Memory: 38.2 MB

class Solution {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        if(len <= 0) return 0;
        int cur = nums[0];
        // 由于有正负，所以保存最大值，最小值。
        int tempMax = 1;
        int tempMin = 1;
        for(int i=0;i<len;i++){
            // 由于负数，会导致最大变最小，最小变最大，所以当前值为负数的时候，交换最大最小
            if (nums[i] < 0){
                int temp = tempMax;
                tempMax = tempMin;
                tempMin = temp;
            }
            // 当前位置最大值，两种状态， 乘以前面的最大值时正收益，否则到这里的最大连续时本身
            tempMax = Math.max(tempMax*nums[i],nums[i]);
            // 最小值同理
            tempMin = Math.min(tempMin*nums[i],nums[i]);
            cur = Math.max(tempMax,cur);
        }

        return cur;

    }
}
```



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [动态规划](https://leetcode.cn//tag/dynamic-programming)

## 相似题目


- [最大子数组和](../maximum-subarray/README.md)
- [打家劫舍](../house-robber/README.md)
- [除自身以外数组的乘积](../product-of-array-except-self/README.md)
- [三个数的最大乘积](../maximum-product-of-three-numbers/README.md)
- [乘积小于 K 的子数组](../subarray-product-less-than-k/README.md)
