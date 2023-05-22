
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer 65. 不用加减乘除做加法](https://leetcode.cn//problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/)

## 题目描述

<p>写一个函数，求两个整数之和，要求在函数体内不得使用 &ldquo;+&rdquo;、&ldquo;-&rdquo;、&ldquo;*&rdquo;、&ldquo;/&rdquo; 四则运算符号。</p>

<p>&nbsp;</p>

<p><strong>示例:</strong></p>

<pre><strong>输入:</strong> a = 1, b = 1
<strong>输出:</strong> 2</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>a</code>,&nbsp;<code>b</code>&nbsp;均可能是负数或 0</li>
	<li>结果不会溢出 32 位整数</li>
</ul>


## 题解


### Java

```Java
// @Title: 不用加减乘除做加法 (不用加减乘除做加法 LCOF)
// @Author: robert.sunq
// @Date: 2021-05-31 21:23:26
// @Runtime: 0 ms
// @Memory: 35.3 MB

class Solution {
    public int add(int a, int b) {
        // 位加
        // 每位上的进位为当前位的 与   &
        // 每位上的当前值为 异或 ^
        while(b != 0){
            // 进位值，需要将每位左移一位
            int c = (a & b) << 1;
            // 不加进位的求和
            a = a ^ b;
            // 将进位值赋予 b， 用于一下次的计算
            b = c;
        }
        // 最终结果保存在a
        return a;
    }
}
```



## 相关话题

- [位运算](https://leetcode.cn//tag/bit-manipulation)
- [数学](https://leetcode.cn//tag/math)

## 相似题目



