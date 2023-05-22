
| English | [简体中文](README.md) |

# [53. Maximum Subarray](https://leetcode.cn//problems/maximum-subarray/)

## Description

<p>Given an integer array <code>nums</code>, find the <span data-keyword="subarray-nonempty">subarray</span> with the largest sum, and return <em>its sum</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [-2,1,-3,4,-1,2,1,-5,4]
<strong>Output:</strong> 6
<strong>Explanation:</strong> The subarray [4,-1,2,1] has the largest sum 6.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [1]
<strong>Output:</strong> 1
<strong>Explanation:</strong> The subarray [1] has the largest sum 1.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [5,4,-1,7,8]
<strong>Output:</strong> 23
<strong>Explanation:</strong> The subarray [5,4,-1,7,8] has the largest sum 23.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong> If you have figured out the <code>O(n)</code> solution, try coding another solution using the <strong>divide and conquer</strong> approach, which is more subtle.</p>


## Solutions


### Java

```Java
// @Title: 最大子数组和 (Maximum Subarray)
// @Author: robert.sunq
// @Date: 2021-08-08 15:59:00
// @Runtime: 1 ms
// @Memory: 38.5 MB

class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        // 表示连续数组的长度
        int len = nums.length;
        // temp 前一个串中的连续串最大值
        int temp = nums[0];
        // int[] dp = new int[len];
        // dp[0] = nums[0];
        // dp[i] 以i为结尾的最大连续子数组和， 且必须包含当前位。
        for(int i=1;i<len;i++){
            // 前一串的最大值加上当前位， 对当前位产生负增益，则当前为位置的最大值位当前值
            temp = Math.max(nums[i],temp+nums[i]);
            res = Math.max(res,temp);
        }
        return res;

    }
}
```



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Divide and Conquer](https://leetcode.cn//tag/divide-and-conquer)
- [Dynamic Programming](https://leetcode.cn//tag/dynamic-programming)

## Similar Questions

- [Best Time to Buy and Sell Stock](../best-time-to-buy-and-sell-stock/README_EN.md)
- [Maximum Product Subarray](../maximum-product-subarray/README_EN.md)
- [Degree of an Array](../degree-of-an-array/README_EN.md)
- [Longest Turbulent Subarray](../longest-turbulent-subarray/README_EN.md)
