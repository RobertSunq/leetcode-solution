
| English | [简体中文](README.md) |

# [137. Single Number II](https://leetcode.cn//problems/single-number-ii/)

## Description

<p>Given an integer array <code>nums</code> where&nbsp;every element appears <strong>three times</strong> except for one, which appears <strong>exactly once</strong>. <em>Find the single element and return it</em>.</p>

<p>You must&nbsp;implement a solution with a linear runtime complexity and use&nbsp;only constant&nbsp;extra space.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> nums = [2,2,3,2]
<strong>Output:</strong> 3
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> nums = [0,1,0,1,0,1,99]
<strong>Output:</strong> 99
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 3 * 10<sup>4</sup></code></li>
	<li><code>-2<sup>31</sup> &lt;= nums[i] &lt;= 2<sup>31</sup> - 1</code></li>
	<li>Each element in <code>nums</code> appears exactly <strong>three times</strong> except for one element which appears <strong>once</strong>.</li>
</ul>


## Solutions


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



## Related Topics

- [Bit Manipulation](https://leetcode.cn//tag/bit-manipulation)
- [Array](https://leetcode.cn//tag/array)

## Similar Questions

- [Single Number](../single-number/README_EN.md)
- [Single Number III](../single-number-iii/README_EN.md)
