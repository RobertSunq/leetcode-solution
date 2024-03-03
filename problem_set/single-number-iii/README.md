
| [English](README_EN.md) | 简体中文 |

# [260. 只出现一次的数字 III](https://leetcode.cn//problems/single-number-iii/)

## 题目描述

<p>给你一个整数数组&nbsp;<code>nums</code>，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 <strong>任意顺序</strong> 返回答案。</p>

<p>你必须设计并实现线性时间复杂度的算法且仅使用常量额外空间来解决此问题。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,1,3,2,5]
<strong>输出：</strong>[3,5]
<strong>解释：</strong>[5, 3] 也是有效的答案。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [-1,0]
<strong>输出：</strong>[-1,0]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = [0,1]
<strong>输出：</strong>[1,0]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>2 &lt;= nums.length &lt;= 3 * 10<sup>4</sup></code></li>
	<li><code>-2<sup>31</sup> &lt;= nums[i] &lt;= 2<sup>31</sup> - 1</code></li>
	<li>除两个只出现一次的整数外，<code>nums</code> 中的其他数字都出现两次</li>
</ul>


## 题解


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



## 相关话题

- [位运算](https://leetcode.cn//tag/bit-manipulation)
- [数组](https://leetcode.cn//tag/array)

## 相似题目


- [只出现一次的数字](../single-number/README.md)
- [只出现一次的数字 II](../single-number-ii/README.md)
