
| [English](README_EN.md) | 简体中文 |

# [69. x 的平方根 ](https://leetcode.cn//problems/sqrtx/)

## 题目描述

<p>给你一个非负整数 <code>x</code> ，计算并返回&nbsp;<code>x</code>&nbsp;的 <strong>算术平方根</strong> 。</p>

<p>由于返回类型是整数，结果只保留 <strong>整数部分 </strong>，小数部分将被 <strong>舍去 。</strong></p>

<p><strong>注意：</strong>不允许使用任何内置指数函数和算符，例如 <code>pow(x, 0.5)</code> 或者 <code>x ** 0.5</code> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>x = 4
<strong>输出：</strong>2
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>x = 8
<strong>输出：</strong>2
<strong>解释：</strong>8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>0 &lt;= x &lt;= 2<sup>31</sup> - 1</code></li>
</ul>


## 题解


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



## 相关话题

- [数学](https://leetcode.cn//tag/math)
- [二分查找](https://leetcode.cn//tag/binary-search)

## 相似题目


- [Pow(x, n)](../powx-n/README.md)
- [有效的完全平方数](../valid-perfect-square/README.md)
