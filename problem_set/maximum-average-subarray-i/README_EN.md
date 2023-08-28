
| English | [简体中文](README.md) |

# [643. Maximum Average Subarray I](https://leetcode.cn//problems/maximum-average-subarray-i/)

## Description

<p>You are given an integer array <code>nums</code> consisting of <code>n</code> elements, and an integer <code>k</code>.</p>

<p>Find a contiguous subarray whose <strong>length is equal to</strong> <code>k</code> that has the maximum average value and return <em>this value</em>. Any answer with a calculation error less than <code>10<sup>-5</sup></code> will be accepted.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,12,-5,-6,50,3], k = 4
<strong>Output:</strong> 12.75000
<strong>Explanation:</strong> Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [5], k = 1
<strong>Output:</strong> 5.00000
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == nums.length</code></li>
	<li><code>1 &lt;= k &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
</ul>


## Solutions


### Java

```Java
// @Title: 子数组最大平均数 I (Maximum Average Subarray I)
// @Author: robert.sunq
// @Date: 2023-08-16 22:16:15
// @Runtime: 6 ms
// @Memory: 54.1 MB

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double max = Integer.MIN_VALUE;
        int n = nums.length;
        int preSum[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = nums[i - 1] + preSum[i - 1];
        }
        double kk = (double) k;
        for (int i = k; i <= n ; i++) {
            max = Math.max(max, (preSum[i] - preSum[i - k]) / kk);
        }

        return max;
        
    }
}
```



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Sliding Window](https://leetcode.cn//tag/sliding-window)

## Similar Questions

- [Maximum Average Subarray II](../maximum-average-subarray-ii/README_EN.md)
