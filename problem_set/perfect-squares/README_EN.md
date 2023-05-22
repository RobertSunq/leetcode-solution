
| English | [简体中文](README.md) |

# [279. Perfect Squares](https://leetcode.cn//problems/perfect-squares/)

## Description

<p>Given an integer <code>n</code>, return <em>the least number of perfect square numbers that sum to</em> <code>n</code>.</p>

<p>A <strong>perfect square</strong> is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, <code>1</code>, <code>4</code>, <code>9</code>, and <code>16</code> are perfect squares while <code>3</code> and <code>11</code> are not.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = 12
<strong>Output:</strong> 3
<strong>Explanation:</strong> 12 = 4 + 4 + 4.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 13
<strong>Output:</strong> 2
<strong>Explanation:</strong> 13 = 4 + 9.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 10<sup>4</sup></code></li>
</ul>


## Solutions


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



## Related Topics

- [Breadth-First Search](https://leetcode.cn//tag/breadth-first-search)
- [Math](https://leetcode.cn//tag/math)
- [Dynamic Programming](https://leetcode.cn//tag/dynamic-programming)

## Similar Questions

- [Count Primes](../count-primes/README_EN.md)
- [Ugly Number II](../ugly-number-ii/README_EN.md)
