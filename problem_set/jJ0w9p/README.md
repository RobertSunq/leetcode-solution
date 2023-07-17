
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer II 072. 求平方根](https://leetcode.cn//problems/jJ0w9p/)

## 题目描述

<p>给定一个非负整数 <code>x</code> ，计算并返回 <code>x</code> 的平方根，即实现&nbsp;<code>int sqrt(int x)</code>&nbsp;函数。</p>

<p>正数的平方根有两个，只输出其中的正数平方根。</p>

<p>如果平方根不是整数，输出只保留整数的部分，小数部分将被舍去。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> x = 4
<strong>输出:</strong> 2
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> x = 8
<strong>输出:</strong> 2
<strong>解释:</strong> 8 的平方根是 2.82842...，由于小数部分将被舍去，所以返回 2
</pre>

<p>&nbsp;</p>

<p><strong>提示:</strong></p>

<ul>
	<li><meta charset="UTF-8" /><code>0 &lt;= x &lt;= 2<sup>31</sup>&nbsp;- 1</code></li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 69&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/sqrtx/">https://leetcode-cn.com/problems/sqrtx/</a></p>


## 题解


### Java

```Java
// @Title: 求平方根 (求平方根)
// @Author: robert.sunq
// @Date: 2023-07-17 22:50:52
// @Runtime: 1 ms
// @Memory: 38.6 MB

class Solution {
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int  ans = -1; 
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if ((long) mid * mid <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
```



## 相关话题

- [数学](https://leetcode.cn//tag/math)
- [二分查找](https://leetcode.cn//tag/binary-search)

## 相似题目



