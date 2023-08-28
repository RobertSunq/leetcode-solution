
| English | [简体中文](README.md) |

# [1004. Max Consecutive Ones III](https://leetcode.cn//problems/max-consecutive-ones-iii/)

## Description

<p>Given a binary array <code>nums</code> and an integer <code>k</code>, return <em>the maximum number of consecutive </em><code>1</code><em>&#39;s in the array if you can flip at most</em> <code>k</code> <code>0</code>&#39;s.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
<strong>Output:</strong> 6
<strong>Explanation:</strong> [1,1,1,0,0,<u><strong>1</strong>,1,1,1,1,<strong>1</strong></u>]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
<strong>Output:</strong> 10
<strong>Explanation:</strong> [0,0,<u>1,1,<strong>1</strong>,<strong>1</strong>,1,1,1,<strong>1</strong>,1,1</u>,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>nums[i]</code> is either <code>0</code> or <code>1</code>.</li>
	<li><code>0 &lt;= k &lt;= nums.length</code></li>
</ul>


## Solutions


### Java

```Java
// @Title: 最大连续1的个数 III (Max Consecutive Ones III)
// @Author: robert.sunq
// @Date: 2023-08-18 22:19:12
// @Runtime: 3 ms
// @Memory: 45.1 MB

class Solution {

    /**
    转化为 在区间  [left,right]  内。
    对于任意的右端点 right，希望找到最小的左端点 left，使得 [left,right] 包含不超过 k 个 0。
    通过枚举所有可能的右断电，将得到的区间长度取最大值，即可得到答案。

    将 数组中 0 1 翻转，则前缀和就是需要翻转的次数
     */
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;

        int left = 0;
        int lsum = 0;
        int rsum = 0;
        int ans = 0;
        for (int right = 0; right < n; right++) {
            // 1 - nums[right] 表示当前位置需要翻转一次
            rsum = rsum + ( 1 - nums[right]);
            // 如果窗口之内的翻转次数，大于K， 则需要移动左端点，来降低翻转次数
            while (lsum < rsum - k) {
                // 窗口下线的位置，需要翻转 的次数
                lsum = lsum + (1-nums[left]);
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}
```



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Binary Search](https://leetcode.cn//tag/binary-search)
- [Prefix Sum](https://leetcode.cn//tag/prefix-sum)
- [Sliding Window](https://leetcode.cn//tag/sliding-window)

## Similar Questions

- [Longest Substring with At Most K Distinct Characters](../longest-substring-with-at-most-k-distinct-characters/README_EN.md)
- [Longest Repeating Character Replacement](../longest-repeating-character-replacement/README_EN.md)
- [Max Consecutive Ones](../max-consecutive-ones/README_EN.md)
- [Max Consecutive Ones II](../max-consecutive-ones-ii/README_EN.md)
