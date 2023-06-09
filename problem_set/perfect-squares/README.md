
| [English](README_EN.md) | 简体中文 |

# [279. 完全平方数](https://leetcode.cn//problems/perfect-squares/)

## 题目描述

<p>给你一个整数 <code>n</code> ，返回 <em>和为 <code>n</code> 的完全平方数的最少数量</em> 。</p>

<p><strong>完全平方数</strong> 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，<code>1</code>、<code>4</code>、<code>9</code> 和 <code>16</code> 都是完全平方数，而 <code>3</code> 和 <code>11</code> 不是。</p>

<p>&nbsp;</p>

<p><strong>示例&nbsp;1：</strong></p>

<pre>
<strong>输入：</strong>n = <code>12</code>
<strong>输出：</strong>3 
<strong>解释：</strong><code>12 = 4 + 4 + 4</code></pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>n = <code>13</code>
<strong>输出：</strong>2
<strong>解释：</strong><code>13 = 4 + 9</code></pre>
&nbsp;

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 10<sup>4</sup></code></li>
</ul>


## 题解


### Java

```Java
// @Title: 完全平方数 (Perfect Squares)
// @Author: robert.sunq
// @Date: 2021-06-18 23:02:16
// @Runtime: 1262 ms
// @Memory: 37.4 MB

class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for (int i =0;i<=n;i++){
            // 假设全部都是 1 组成
            dp[i] = i;
            // // j 代表组成当前数的一个 平方根  即 i = J*J + k  
            // for(int j=1;j*j<=i;j++){
            //     dp[i] = Math.min(dp[i],dp[i - j*j] +1);
            // }
            
            // 此时 j 表示 当前数的一个组成 i = j + k
            for(int j = 1; j * 2<= i;j++){
                if(i == j*j ){
                    dp[i] = 1;
                    break;
                } 
                else dp[i] = Math.min(dp[i] , dp[i-j]+dp[j]);
            }
        }
        return dp[n];
    }
}
```



## 相关话题

- [广度优先搜索](https://leetcode.cn//tag/breadth-first-search)
- [数学](https://leetcode.cn//tag/math)
- [动态规划](https://leetcode.cn//tag/dynamic-programming)

## 相似题目


- [计数质数](../count-primes/README.md)
- [丑数 II](../ugly-number-ii/README.md)
