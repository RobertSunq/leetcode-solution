
| English | [简体中文](README.md) |

# [70. Climbing Stairs](https://leetcode.cn//problems/climbing-stairs/)

## Description

<p>You are climbing a staircase. It takes <code>n</code> steps to reach the top.</p>

<p>Each time you can either climb <code>1</code> or <code>2</code> steps. In how many distinct ways can you climb to the top?</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = 2
<strong>Output:</strong> 2
<strong>Explanation:</strong> There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 3
<strong>Output:</strong> 3
<strong>Explanation:</strong> There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 45</code></li>
</ul>


## Solutions


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



## Related Topics

- [Memoization](https://leetcode.cn//tag/memoization)
- [Math](https://leetcode.cn//tag/math)
- [Dynamic Programming](https://leetcode.cn//tag/dynamic-programming)

## Similar Questions

- [Min Cost Climbing Stairs](../min-cost-climbing-stairs/README_EN.md)
- [Fibonacci Number](../fibonacci-number/README_EN.md)
- [N-th Tribonacci Number](../n-th-tribonacci-number/README_EN.md)
