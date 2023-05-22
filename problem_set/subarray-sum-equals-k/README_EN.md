
| English | [简体中文](README.md) |

# [560. Subarray Sum Equals K](https://leetcode.cn//problems/subarray-sum-equals-k/)

## Description

<p>Given an array of integers <code>nums</code> and an integer <code>k</code>, return <em>the total number of subarrays whose sum equals to</em> <code>k</code>.</p>

<p>A subarray is a contiguous <strong>non-empty</strong> sequence of elements within an array.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> nums = [1,1,1], k = 2
<strong>Output:</strong> 2
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> nums = [1,2,3], k = 3
<strong>Output:</strong> 2
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 2 * 10<sup>4</sup></code></li>
	<li><code>-1000 &lt;= nums[i] &lt;= 1000</code></li>
	<li><code>-10<sup>7</sup> &lt;= k &lt;= 10<sup>7</sup></code></li>
</ul>


## Solutions


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



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Hash Table](https://leetcode.cn//tag/hash-table)
- [Prefix Sum](https://leetcode.cn//tag/prefix-sum)

## Similar Questions

- [Two Sum](../two-sum/README_EN.md)
- [Continuous Subarray Sum](../continuous-subarray-sum/README_EN.md)
- [Subarray Product Less Than K](../subarray-product-less-than-k/README_EN.md)
- [Find Pivot Index](../find-pivot-index/README_EN.md)
- [Subarray Sums Divisible by K](../subarray-sums-divisible-by-k/README_EN.md)
