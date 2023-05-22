
| English | [简体中文](README.md) |

# [69. Sqrt(x)](https://leetcode.cn//problems/sqrtx/)

## Description

<p>Given a non-negative integer <code>x</code>, return <em>the square root of </em><code>x</code><em> rounded down to the nearest integer</em>. The returned integer should be <strong>non-negative</strong> as well.</p>

<p>You <strong>must not use</strong> any built-in exponent function or operator.</p>

<ul>
	<li>For example, do not use <code>pow(x, 0.5)</code> in c++ or <code>x ** 0.5</code> in python.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> x = 4
<strong>Output:</strong> 2
<strong>Explanation:</strong> The square root of 4 is 2, so we return 2.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> x = 8
<strong>Output:</strong> 2
<strong>Explanation:</strong> The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= x &lt;= 2<sup>31</sup> - 1</code></li>
</ul>


## Solutions


### Java

```Java
// @Title: x 的平方根  (Sqrt(x))
// @Author: robert.sunq
// @Date: 2021-07-07 00:02:57
// @Runtime: 1 ms
// @Memory: 35.4 MB

class Solution {
    public int mySqrt(int x) {
        if(x == 1) return 1;
        int min = 0;
        int max = x;
        // 通过左右逼近，
        while(max - min > 1){
            // 判断上下线中位数，是否是符合要求
            int m = (max+min)/2;
            // 采用除法，避免乘法的溢出
            if(x/m < m){
                // 此时M比 x 实际平方根大  ， 上线下移
                max = m;
            }else{
                min = m;
            }
        }
        return min;
    }
}
```



## Related Topics

- [Math](https://leetcode.cn//tag/math)
- [Binary Search](https://leetcode.cn//tag/binary-search)

## Similar Questions

- [Pow(x, n)](../powx-n/README_EN.md)
- [Valid Perfect Square](../valid-perfect-square/README_EN.md)
