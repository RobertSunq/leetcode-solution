
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer 64. 求1+2+…+n](https://leetcode.cn//problems/qiu-12n-lcof/)

## 题目描述

<p>求 <code>1+2+...+n</code> ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入:</strong> n = 3
<strong>输出:&nbsp;</strong>6
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入:</strong> n = 9
<strong>输出:&nbsp;</strong>45
</pre>

<p>&nbsp;</p>

<p><strong>限制：</strong></p>

<ul>
	<li><code>1 &lt;= n&nbsp;&lt;= 10000</code></li>
</ul>


## 题解


### Java

```Java
// @Title: 求1+2+…+n (求1+2+…+n LCOF)
// @Author: robert.sunq
// @Date: 2021-05-30 23:09:33
// @Runtime: 1 ms
// @Memory: 35.8 MB

class Solution {
    public int sumNums(int n) {
        return n == 1? 1: n + sumNums(n-1);
    }
}
```



## 相关话题

- [位运算](https://leetcode.cn//tag/bit-manipulation)
- [递归](https://leetcode.cn//tag/recursion)
- [脑筋急转弯](https://leetcode.cn//tag/brainteaser)

## 相似题目



