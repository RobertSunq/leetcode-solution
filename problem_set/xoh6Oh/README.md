
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer II 001. 整数除法](https://leetcode.cn//problems/xoh6Oh/)

## 题目描述

<p>给定两个整数 <code>a</code> 和 <code>b</code> ，求它们的除法的商 <code>a/b</code> ，要求不得使用乘号 <code>&#39;*&#39;</code>、除号 <code>&#39;/&#39;</code> 以及求余符号 <code>&#39;%&#39;</code>&nbsp;。</p>

<p>&nbsp;</p>

<p><strong>注意：</strong></p>

<ul>
	<li>整数除法的结果应当截去（<code>truncate</code>）其小数部分，例如：<code>truncate(8.345) = 8</code>&nbsp;以及&nbsp;<code>truncate(-2.7335) = -2</code></li>
	<li>假设我们的环境只能存储 32 位有符号整数，其数值范围是 <code>[&minus;2<sup>31</sup>,&nbsp;2<sup>31</sup>&minus;1]</code>。本题中，如果除法结果溢出，则返回 <code>2<sup>31&nbsp;</sup>&minus; 1</code></li>
</ul>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>a = 15, b = 2
<strong>输出：</strong>7
<strong><span style="white-space: pre-wrap;">解释：</span></strong>15/2 = truncate(7.5) = 7
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>a = 7, b = -3
<strong>输出：</strong><span style="white-space: pre-wrap;">-2</span>
<strong><span style="white-space: pre-wrap;">解释：</span></strong>7/-3 = truncate(-2.33333..) = -2</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>a = 0, b = 1
<strong>输出：</strong><span style="white-space: pre-wrap;">0</span></pre>

<p><strong>示例 4：</strong></p>

<pre>
<strong>输入：</strong>a = 1, b = 1
<strong>输出：</strong><span style="white-space: pre-wrap;">1</span></pre>

<p>&nbsp;</p>

<p><strong>提示:</strong></p>

<ul>
	<li><code>-2<sup>31</sup>&nbsp;&lt;= a, b &lt;= 2<sup>31</sup>&nbsp;- 1</code></li>
	<li><code>b != 0</code></li>
</ul>

<p>&nbsp;</p>

<p>注意：本题与主站 29&nbsp;题相同：<a href="https://leetcode-cn.com/problems/divide-two-integers/">https://leetcode-cn.com/problems/divide-two-integers/</a></p>

<p>&nbsp;</p>


## 题解


### Java

```Java
// @Title: 整数除法 (整数除法)
// @Author: robert.sunq
// @Date: 2023-05-25 00:59:19
// @Runtime: 1 ms
// @Memory: 38.6 MB

class Solution {
    public int divide(int a, int b) {
        if ( a == 0) {
            return 0;
        }
        // 判断是不是相同符号， 同符号相加，不同号相减
        int sameSymbol = sameSymbol(a, b);

        int result = 0;
        
        // 记录 b 的放大倍数
        int i = 1;
        int bi = b;
        int is_bi_max = -1;
        int max_bi = Integer.MAX_VALUE >> 1;
        // 同号相减去，求和之后变符号了，则说明被除数大
        while ( 
            canSub(sameSymbol, a, b) > 0
        ) {
            if ((bi < 0 && -bi >= max_bi) || (bi > 0 && bi >= max_bi)) {
                is_bi_max = 1;
            }
            // a 的剩余量仍大于 bi， 则b做减法，bi可以直接放大  加速计算
            if (canSub(sameSymbol, a, bi) > 0) {
                if (sameSymbol > 0) {
                    // 判断结果是不是在取值范围， 即做操作后超限
                    if (result + i < 0) {
                        return Integer.MAX_VALUE;
                    }
                    a = a - bi;
                    result = result + i;
                } else {
                    if (result - i > 0) {
                        return Integer.MAX_VALUE;
                    }
                    a = a + bi;
                    // 不同符 做减法来计数， 负数可以达到 - 2^31
                    result = result - i;
                }
                // 达到最大值之后就没必要增加了
                if (is_bi_max < 0) {
                    bi = bi + bi;
                    i = i + i;
                }
            } else {
                // a 的剩余量不足 bi  则 bi 右移做缩小，i 也右移动
                bi = bi >> 1;
                i = i >> 1;
                is_bi_max = 1;
            }
        }
        return result;
    }

    // 判断是否同符号
    private int sameSymbol(int a, int b) {
        int status = 1;
        if (a < 0) {
            status = 0 - status;
        }
        if (b < 0) {
            status = 0 - status;
        }
        return status;
    }

    // 判断 a 的绝对值是否大于b， 即 a 除以 b 大于1
    private int canSub(int sameSymbol, int a , int b) {
        // 同符号下，如果相减，被减数与结果同符号（或者是 0 相等），则可以除法
        // 不同符号下，相加，....
        if (
            (a != 0 && sameSymbol > 0 && (sameSymbol(a, a - b) > 0 || (a - b) ==0))
            || (a != 0 && sameSymbol < 0 && (sameSymbol(a, a + b) > 0 || (a + b) ==0))
        ) {
            return 1;
        } else {
            return -1;
        }
    }
}
```



## 相关话题

- [位运算](https://leetcode.cn//tag/bit-manipulation)
- [数学](https://leetcode.cn//tag/math)

## 相似题目



