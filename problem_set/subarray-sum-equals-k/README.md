
| [English](README_EN.md) | 简体中文 |

# [560. 和为 K 的子数组](https://leetcode.cn//problems/subarray-sum-equals-k/)

## 题目描述

<p>给你一个整数数组 <code>nums</code> 和一个整数&nbsp;<code>k</code> ，请你统计并返回 <em>该数组中和为&nbsp;<code>k</code><strong>&nbsp;</strong>的连续子数组的个数&nbsp;</em>。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,1,1], k = 2
<strong>输出：</strong>2
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,3], k = 3
<strong>输出：</strong>2
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 2 * 10<sup>4</sup></code></li>
	<li><code>-1000 &lt;= nums[i] &lt;= 1000</code></li>
	<li><code>-10<sup>7</sup> &lt;= k &lt;= 10<sup>7</sup></code></li>
</ul>


## 题解


### Java

```Java
// @Title: 和为 K 的子数组 (Subarray Sum Equals K)
// @Author: robert.sunq
// @Date: 2021-06-22 00:23:36
// @Runtime: 28 ms
// @Memory: 41.7 MB

class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int sum = 0;
        // Map 用来保存，从0 到当前某一位，期间和 sum 的出现次数
        Map<Integer,Integer> mp = new HashMap<>();
        // mp初始化，即开始循环之前
        mp.put(0,1);
        for(int i =  0 ;i<nums.length;i++){
            // 从零到当前元素的和
            sum  = sum + nums[i];
            // 即之前有 sum - k 这个和的存在n次，则由那n个数字的下标起，到当前数值的和为 k     sum - （sum - k） = k
            res = res + mp.getOrDefault(sum - k , 0);
            // 将当前序列的和保存到Map中
            mp.put(sum,mp.getOrDefault(sum, 0)+1);
        }
        return res;
    }
}
```



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [哈希表](https://leetcode.cn//tag/hash-table)
- [前缀和](https://leetcode.cn//tag/prefix-sum)

## 相似题目


- [两数之和](../two-sum/README.md)
- [连续的子数组和](../continuous-subarray-sum/README.md)
- [乘积小于 K 的子数组](../subarray-product-less-than-k/README.md)
- [寻找数组的中心下标](../find-pivot-index/README.md)
- [和可被 K 整除的子数组](../subarray-sums-divisible-by-k/README.md)
