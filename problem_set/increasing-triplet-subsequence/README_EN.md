
| English | [简体中文](README.md) |

# [334. Increasing Triplet Subsequence](https://leetcode.cn//problems/increasing-triplet-subsequence/)

## Description

<p>Given an integer array <code>nums</code>, return <code>true</code><em> if there exists a triple of indices </em><code>(i, j, k)</code><em> such that </em><code>i &lt; j &lt; k</code><em> and </em><code>nums[i] &lt; nums[j] &lt; nums[k]</code>. If no such indices exists, return <code>false</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,2,3,4,5]
<strong>Output:</strong> true
<strong>Explanation:</strong> Any triplet where i &lt; j &lt; k is valid.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [5,4,3,2,1]
<strong>Output:</strong> false
<strong>Explanation:</strong> No triplet exists.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [2,1,5,0,4,6]
<strong>Output:</strong> true
<strong>Explanation:</strong> The triplet (3, 4, 5) is valid because nums[3] == 0 &lt; nums[4] == 4 &lt; nums[5] == 6.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 5 * 10<sup>5</sup></code></li>
	<li><code>-2<sup>31</sup> &lt;= nums[i] &lt;= 2<sup>31</sup> - 1</code></li>
</ul>

<p>&nbsp;</p>
<strong>Follow up:</strong> Could you implement a solution that runs in <code>O(n)</code> time complexity and <code>O(1)</code> space complexity?

## Solutions


### Java

```Java
// @Title: 递增的三元子序列 (Increasing Triplet Subsequence)
// @Author: robert.sunq
// @Date: 2023-08-11 21:47:49
// @Runtime: 2 ms
// @Memory: 126.7 MB

class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        boolean[] bs = new boolean[n];

        int min = nums[0];
        for (int i = 1; i<n; i++) {
            if (min < nums[i]) {
                bs[i] = true;
            } else {
                min = nums[i];
            }
        }

        min = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (min > nums[i]) {
                if (bs[i]) {
                    return true;
                }
            } else {
                min = nums[i];
            }
        }

        return false;
    }
}
```



## Related Topics

- [Greedy](https://leetcode.cn//tag/greedy)
- [Array](https://leetcode.cn//tag/array)

## Similar Questions

- [Longest Increasing Subsequence](../longest-increasing-subsequence/README_EN.md)
