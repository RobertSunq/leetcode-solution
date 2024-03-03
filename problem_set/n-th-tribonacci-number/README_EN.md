
| English | [简体中文](README.md) |

# [1137. N-th Tribonacci Number](https://leetcode.cn//problems/n-th-tribonacci-number/)

## Description

<p>The Tribonacci sequence T<sub>n</sub> is defined as follows:&nbsp;</p>

<p>T<sub>0</sub> = 0, T<sub>1</sub> = 1, T<sub>2</sub> = 1, and T<sub>n+3</sub> = T<sub>n</sub> + T<sub>n+1</sub> + T<sub>n+2</sub> for n &gt;= 0.</p>

<p>Given <code>n</code>, return the value of T<sub>n</sub>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = 4
<strong>Output:</strong> 4
<strong>Explanation:</strong>
T_3 = 0 + 1 + 1 = 2
T_4 = 1 + 1 + 2 = 4
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 25
<strong>Output:</strong> 1389537
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= n &lt;= 37</code></li>
	<li>The answer is guaranteed to fit within a 32-bit integer, ie. <code>answer &lt;= 2^31 - 1</code>.</li>
</ul>

## Solutions


### Java

```Java
// @Title: 第 N 个泰波那契数 (N-th Tribonacci Number)
// @Author: robert.sunq
// @Date: 2023-09-20 21:21:03
// @Runtime: 0 ms
// @Memory: 38.1 MB

class Solution {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }

        int t0 = 0;
        int t1 = 1;
        int t2 = 1;
        while (n-- > 2) {
            int t = t0 + t1 + t2;
            t0 = t1;
            t1 = t2;
            t2 = t;
        }

        return t2;
    }
}
```



## Related Topics

- [Memoization](https://leetcode.cn//tag/memoization)
- [Math](https://leetcode.cn//tag/math)
- [Dynamic Programming](https://leetcode.cn//tag/dynamic-programming)

## Similar Questions

- [Climbing Stairs](../climbing-stairs/README_EN.md)
