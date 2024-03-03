
| [English](README_EN.md) | 简体中文 |

# [137. 只出现一次的数字 II](https://leetcode.cn//problems/single-number-ii/)

## 题目描述

<p>给你一个整数数组&nbsp;<code>nums</code> ，除某个元素仅出现 <strong>一次</strong> 外，其余每个元素都恰出现 <strong>三次 。</strong>请你找出并返回那个只出现了一次的元素。</p>

<p>你必须设计并实现线性时间复杂度的算法且使用常数级空间来解决此问题。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [2,2,3,2]
<strong>输出：</strong>3
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [0,1,0,1,0,1,99]
<strong>输出：</strong>99
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 3 * 10<sup>4</sup></code></li>
	<li><code>-2<sup>31</sup> &lt;= nums[i] &lt;= 2<sup>31</sup> - 1</code></li>
	<li><code>nums</code> 中，除某个元素仅出现 <strong>一次</strong> 外，其余每个元素都恰出现 <strong>三次</strong></li>
</ul>


## 题解


### Java

```Java
// @Title: 只出现一次的数字 II (Single Number II)
// @Author: robert.sunq
// @Date: 2023-10-15 22:05:08
// @Runtime: 2 ms
// @Memory: 42.3 MB

class Solution {
    public int singleNumber(int[] nums) {
        // 计算每一位1的数量， 然后对每一位进行对3趋于

        int[] count = new int[32];

        for (int n : nums) {
            int i = 0;
            while(n != 0) {
                count[i] = (count[i] + (n & 1)) % 3;
                n = n >>> 1;
                i++;
            }
        }

        int ans = 0;
        for (int i = 31; i > -1; i--) {
            ans = ans  + (count[i] << i);
        }

        return ans;
    }
}
```



## 相关话题

- [位运算](https://leetcode.cn//tag/bit-manipulation)
- [数组](https://leetcode.cn//tag/array)

## 相似题目


- [只出现一次的数字](../single-number/README.md)
- [只出现一次的数字 III](../single-number-iii/README.md)
