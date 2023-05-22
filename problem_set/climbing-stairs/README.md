
| [English](README_EN.md) | 简体中文 |

# [70. 爬楼梯](https://leetcode.cn//problems/climbing-stairs/)

## 题目描述

<p>假设你正在爬楼梯。需要 <code>n</code>&nbsp;阶你才能到达楼顶。</p>

<p>每次你可以爬 <code>1</code> 或 <code>2</code> 个台阶。你有多少种不同的方法可以爬到楼顶呢？</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>n = 2
<strong>输出：</strong>2
<strong>解释：</strong>有两种方法可以爬到楼顶。
1. 1 阶 + 1 阶
2. 2 阶</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>n = 3
<strong>输出：</strong>3
<strong>解释：</strong>有三种方法可以爬到楼顶。
1. 1 阶 + 1 阶 + 1 阶
2. 1 阶 + 2 阶
3. 2 阶 + 1 阶
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 45</code></li>
</ul>


## 题解


### Java

```Java
// @Title: 爬楼梯 (Climbing Stairs)
// @Author: robert.sunq
// @Date: 2021-06-05 00:01:59
// @Runtime: 0 ms
// @Memory: 35 MB

class Solution {
    public int climbStairs(int n) {
        if ( n <= 0 ) return 0;
        int f0 = 1,f1= 1;
        for(int i = 0;i<n;i++){
            int temp = f0+f1;
            f0 = f1;
            f1 = temp;
        }
        return f0;
    }
}
```



## 相关话题

- [记忆化搜索](https://leetcode.cn//tag/memoization)
- [数学](https://leetcode.cn//tag/math)
- [动态规划](https://leetcode.cn//tag/dynamic-programming)

## 相似题目


- [使用最小花费爬楼梯](../min-cost-climbing-stairs/README.md)
- [斐波那契数](../fibonacci-number/README.md)
- [第 N 个泰波那契数](../n-th-tribonacci-number/README.md)
