
| English | [简体中文](README.md) |

# [260. Single Number III](https://leetcode.cn//problems/single-number-iii/)

## Description

<p>Given an integer array <code>nums</code>, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once. You can return the answer in <strong>any order</strong>.</p>

<p>You must write an&nbsp;algorithm that runs in linear runtime complexity and uses&nbsp;only constant extra space.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,2,1,3,2,5]
<strong>Output:</strong> [3,5]
<strong>Explanation: </strong> [5, 3] is also a valid answer.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [-1,0]
<strong>Output:</strong> [-1,0]
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [0,1]
<strong>Output:</strong> [1,0]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= nums.length &lt;= 3 * 10<sup>4</sup></code></li>
	<li><code>-2<sup>31</sup> &lt;= nums[i] &lt;= 2<sup>31</sup> - 1</code></li>
	<li>Each integer in <code>nums</code> will appear twice, only two integers will appear once.</li>
</ul>


## Solutions


### Java

```Java
// @Title: 只出现一次的数字 III (Single Number III)
// @Author: robert.sunq
// @Date: 2023-10-16 23:21:55
// @Runtime: 0 ms
// @Memory: 42.6 MB

class Solution {
    public int[] singleNumber(int[] nums) {
        // 所有的元素异或起来， 得到最终两个独立数字的 异或结果
        // 从最终的结果可以得知， 某一位为 1 时， 表示这两个独立的数字，在这一位上分别为 0 和 1
        // 所以可以通过这个规律来判断将 nums 分为两个数组，这两个独立的数字就会分别属于两个数组，
        // 之后在将两组数进行异或就得到结果


        int result = 0;
        for (int n : nums) {
            result = result ^ n;
        }

        // 防止溢出, 因为 result != 0，所以 可以 result & -result 来获取最低位的1的位置
        result = (result == Integer.MIN_VALUE) ? result : (result & (-result));

        int group1 = 0;
        int group2 = 0;
        for (int n : nums) {
            if ((n & result) != 0) {
                group1 = group1 ^ n;
            } else {
                group2 = group2 ^ n;
            }
        }

        return new int[]{group1, group2};
    }
}
```



## Related Topics

- [Bit Manipulation](https://leetcode.cn//tag/bit-manipulation)
- [Array](https://leetcode.cn//tag/array)

## Similar Questions

- [Single Number](../single-number/README_EN.md)
- [Single Number II](../single-number-ii/README_EN.md)
