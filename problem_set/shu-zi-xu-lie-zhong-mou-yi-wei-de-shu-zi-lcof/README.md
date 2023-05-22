
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer 44. 数字序列中某一位的数字](https://leetcode.cn//problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/)

## 题目描述

<p>数字以0123456789101112131415&hellip;的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。</p>

<p>请写一个函数，求任意第n位对应的数字。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>n = 3
<strong>输出：</strong>3
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>n = 11
<strong>输出：</strong>0</pre>

<p>&nbsp;</p>

<p><strong>限制：</strong></p>

<ul>
	<li><code>0 &lt;= n &lt;&nbsp;2^31</code></li>
</ul>

<p>注意：本题与主站 400 题相同：<a href="https://leetcode-cn.com/problems/nth-digit/">https://leetcode-cn.com/problems/nth-digit/</a></p>


## 题解


### Java

```Java
// @Title: 数字序列中某一位的数字 (数字序列中某一位的数字  LCOF)
// @Author: robert.sunq
// @Date: 2021-05-29 20:40:53
// @Runtime: 0 ms
// @Memory: 35.5 MB

class Solution {
    public int findNthDigit(int n) {
        int di = 1;
        // 使用long 是位了当N 接近与最大值，一下为的数量会超限
        long count = 9;
        long start = 1;
        // 检验是否是 在下一位中
        while(n > count){
            // 减去当前位数里 的 数字数量
            n = n - (int)count;
            // 下一位数的开始 数字
            start = start * 10;
            // 下一位
            di = di + 1;
            // 下一位的数量
            count = di * start * 9;  
        }
        // 当前位 的 第n -1个数， 剪1时去除整个数列的第一位 “0”
        long num = start + (n-1) / di;
        // 在当前数字种的第 (n-1) % di 位
        // return Long.toString(num).charAt((n-1) % di) - '0';
        return String.valueOf(num).charAt((n-1) % di) - '0';
    }
}
```



## 相关话题

- [数学](https://leetcode.cn//tag/math)
- [二分查找](https://leetcode.cn//tag/binary-search)

## 相似题目



