
| English | [简体中文](README.md) |

# [1493. Longest Subarray of 1's After Deleting One Element](https://leetcode.cn//problems/longest-subarray-of-1s-after-deleting-one-element/)

## Description

<p>Given a binary array <code>nums</code>, you should delete one element from it.</p>

<p>Return <em>the size of the longest non-empty subarray containing only </em><code>1</code><em>&#39;s in the resulting array</em>. Return <code>0</code> if there is no such subarray.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,1,0,1]
<strong>Output:</strong> 3
<strong>Explanation:</strong> After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1&#39;s.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [0,1,1,1,0,1,1,0,1]
<strong>Output:</strong> 5
<strong>Explanation:</strong> After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1&#39;s is [1,1,1,1,1].
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,1,1]
<strong>Output:</strong> 2
<strong>Explanation:</strong> You must delete one element.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>nums[i]</code> is either <code>0</code> or <code>1</code>.</li>
</ul>


## Solutions


### Java

```Java
// @Title: 删掉一个元素以后全为 1 的最长子数组 (Longest Subarray of 1's After Deleting One Element)
// @Author: robert.sunq
// @Date: 2023-08-19 17:54:08
// @Runtime: 2 ms
// @Memory: 54.3 MB

class Solution {
    // https://leetcode.cn/problems/max-consecutive-ones-iii/?envType=study-plan-v2&envId=leetcode-75
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int left = 0;
        int lsum = 0;
        int rsum = 0;
        int ans = 0;
        for (int rigth = 0; rigth < n; rigth++) {
            rsum = rsum + (1 - nums[rigth]);
            while (lsum < rsum - 1) {
                lsum = lsum + (1 - nums[left]);
                left++;
            }
            ans = Math.max(ans, rigth - left);
        }

        return ans;
    }
}
```



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Dynamic Programming](https://leetcode.cn//tag/dynamic-programming)
- [Sliding Window](https://leetcode.cn//tag/sliding-window)

## Similar Questions


