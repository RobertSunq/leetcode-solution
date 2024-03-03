
| English | [简体中文](README.md) |

# [1318. Minimum Flips to Make a OR b Equal to c](https://leetcode.cn//problems/minimum-flips-to-make-a-or-b-equal-to-c/)

## Description

<p>Given 3 positives numbers <code>a</code>, <code>b</code> and <code>c</code>. Return the minimum flips required in some bits of <code>a</code> and <code>b</code> to make (&nbsp;<code>a</code> OR <code>b</code> == <code>c</code>&nbsp;). (bitwise OR operation).<br />
Flip operation&nbsp;consists of change&nbsp;<strong>any</strong>&nbsp;single bit 1 to 0 or change the bit 0 to 1&nbsp;in their binary representation.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2020/01/06/sample_3_1676.png" style="width: 260px; height: 87px;" /></p>

<pre>
<strong>Input:</strong> a = 2, b = 6, c = 5
<strong>Output:</strong> 3
<strong>Explanation: </strong>After flips a = 1 , b = 4 , c = 5 such that (<code>a</code> OR <code>b</code> == <code>c</code>)</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> a = 4, b = 2, c = 7
<strong>Output:</strong> 1
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> a = 1, b = 2, c = 3
<strong>Output:</strong> 0
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= a &lt;= 10^9</code></li>
	<li><code>1 &lt;= b&nbsp;&lt;= 10^9</code></li>
	<li><code>1 &lt;= c&nbsp;&lt;= 10^9</code></li>
</ul>

## Solutions


### Java

```Java
// @Title: 或运算的最小翻转次数 (Minimum Flips to Make a OR b Equal to c)
// @Author: robert.sunq
// @Date: 2023-09-26 21:40:22
// @Runtime: 0 ms
// @Memory: 38.1 MB

class Solution {
    public int minFlips(int a, int b, int c) {
        int ans = 0;
        while (c != 0) {
            int ai = a % 2;
            int bi = b % 2;
            int ci = c % 2;

            a = a / 2;
            b = b / 2;
            c = c / 2;

            if ((ai | bi) != ci) {
                if (ci == 0) {
                    ans = ans + bi + ai;
                } else {
                    ans = ans  + 1;
                }
            }
        }

        while (a != 0) {
            int ai = a % 2;
            a = a / 2;
            ans = ans + ai;
        }

        while (b != 0) {
            int bi = b % 2;
            b = b / 2;
            ans = ans + bi;
        }

        return ans;
    }
}
```



## Related Topics

- [Bit Manipulation](https://leetcode.cn//tag/bit-manipulation)

## Similar Questions


