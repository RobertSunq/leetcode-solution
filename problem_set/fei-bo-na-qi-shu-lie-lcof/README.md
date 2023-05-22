
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer 10- I. 斐波那契数列](https://leetcode.cn//problems/fei-bo-na-qi-shu-lie-lcof/)

## 题目描述

<p>写一个函数，输入 <code>n</code> ，求斐波那契（Fibonacci）数列的第 <code>n</code> 项（即 <code>F(N)</code>）。斐波那契数列的定义如下：</p>

<pre>
F(0) = 0,   F(1) = 1
F(N) = F(N - 1) + F(N - 2), 其中 N > 1.</pre>

<p>斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。</p>

<p>答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>n = 2
<strong>输出：</strong>1
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>n = 5
<strong>输出：</strong>5
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>0 <= n <= 100</code></li>
</ul>


## 题解


### Java

```Java
// @Title: 斐波那契数列 (斐波那契数列  LCOF)
// @Author: robert.sunq
// @Date: 2021-05-24 23:08:06
// @Runtime: 0 ms
// @Memory: 35.3 MB

class Solution {
    // 迭代模式会超时，选择使用循环（又称动态规划）
    public int fib(int n) {
        
        int min = 0,max = 1,sum ;
        for (int i = 0; i<n; i++){
            sum = (min + max) % 1000000007;
            min = max;
            max = sum ;
        }
        return min ;
    }
}
```



## 相关话题

- [记忆化搜索](https://leetcode.cn//tag/memoization)
- [数学](https://leetcode.cn//tag/math)
- [动态规划](https://leetcode.cn//tag/dynamic-programming)

## 相似题目



