
| English | [简体中文](README.md) |

# [152. Maximum Product Subarray](https://leetcode.cn//problems/maximum-product-subarray/)

## Description

<p>Given an integer array <code>nums</code>, find a <span data-keyword="subarray-nonempty">subarray</span> that has the largest product, and return <em>the product</em>.</p>

<p>The test cases are generated so that the answer will fit in a <strong>32-bit</strong> integer.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [2,3,-2,4]
<strong>Output:</strong> 6
<strong>Explanation:</strong> [2,3] has the largest product 6.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [-2,0,-1]
<strong>Output:</strong> 0
<strong>Explanation:</strong> The result cannot be 2, because [-2,-1] is not a subarray.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 2 * 10<sup>4</sup></code></li>
	<li><code>-10 &lt;= nums[i] &lt;= 10</code></li>
	<li>The product of any prefix or suffix of <code>nums</code> is <strong>guaranteed</strong> to fit in a <strong>32-bit</strong> integer.</li>
</ul>


## Solutions


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



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Dynamic Programming](https://leetcode.cn//tag/dynamic-programming)

## Similar Questions

- [Maximum Subarray](../maximum-subarray/README_EN.md)
- [House Robber](../house-robber/README_EN.md)
- [Product of Array Except Self](../product-of-array-except-self/README_EN.md)
- [Maximum Product of Three Numbers](../maximum-product-of-three-numbers/README_EN.md)
- [Subarray Product Less Than K](../subarray-product-less-than-k/README_EN.md)
