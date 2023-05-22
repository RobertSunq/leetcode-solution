
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer 16. 数值的整数次方](https://leetcode.cn//problems/shu-zhi-de-zheng-shu-ci-fang-lcof/)

## 题目描述

<p>实现 <a href="https://www.cplusplus.com/reference/valarray/pow/">pow(<em>x</em>, <em>n</em>)</a> ，即计算 x 的 n 次幂函数（即，x<sup>n</sup>）。不得使用库函数，同时不需要考虑大数问题。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>x = 2.00000, n = 10
<strong>输出：</strong>1024.00000
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>x = 2.10000, n = 3
<strong>输出：</strong>9.26100</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>x = 2.00000, n = -2
<strong>输出：</strong>0.25000
<strong>解释：</strong>2<sup>-2</sup> = 1/2<sup>2</sup> = 1/4 = 0.25</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>-100.0 < x < 100.0</code></li>
	<li><code>-2<sup>31</sup> <= n <= 2<sup>31</sup>-1</code></li>
	<li><code>-10<sup>4</sup> <= x<sup>n</sup> <= 10<sup>4</sup></code></li>
</ul>

<p> </p>

<p>注意：本题与主站 50 题相同：<a href="https://leetcode-cn.com/problems/powx-n/">https://leetcode-cn.com/problems/powx-n/</a></p>


## 题解


### Java

```Java
// @Title: 数值的整数次方 (数值的整数次方 LCOF)
// @Author: robert.sunq
// @Date: 2021-05-25 23:08:15
// @Runtime: 1 ms
// @Memory: 37.6 MB

class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        boolean flag = false;
        if (n<0) {
          flag = true; 
          n = -n; 
        }
        double powNum = x;
        n--;
        while(n > 0) {
            // 奇数时，算一次；
            if((n%2) == 1) {
                powNum = powNum*x;
                n--;
            }else{
                // 偶数时将，可将幂低放大（注意这里时幂低，而不是积）
                x = x*x;
                n>>=1;
            }
            
        }
        if(flag) return 1/powNum;
        return powNum;
    }
}
```



## 相关话题

- [递归](https://leetcode.cn//tag/recursion)
- [数学](https://leetcode.cn//tag/math)

## 相似题目



