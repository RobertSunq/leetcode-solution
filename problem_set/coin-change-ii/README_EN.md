
| English | [简体中文](README.md) |

# [518. Coin Change II](https://leetcode.cn//problems/coin-change-ii/)

## Description

<p>You are given an integer array <code>coins</code> representing coins of different denominations and an integer <code>amount</code> representing a total amount of money.</p>

<p>Return <em>the number of combinations that make up that amount</em>. If that amount of money cannot be made up by any combination of the coins, return <code>0</code>.</p>

<p>You may assume that you have an infinite number of each kind of coin.</p>

<p>The answer is <strong>guaranteed</strong> to fit into a signed <strong>32-bit</strong> integer.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> amount = 5, coins = [1,2,5]
<strong>Output:</strong> 4
<strong>Explanation:</strong> there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> amount = 3, coins = [2]
<strong>Output:</strong> 0
<strong>Explanation:</strong> the amount of 3 cannot be made up just with coins of 2.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> amount = 10, coins = [10]
<strong>Output:</strong> 1
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= coins.length &lt;= 300</code></li>
	<li><code>1 &lt;= coins[i] &lt;= 5000</code></li>
	<li>All the values of <code>coins</code> are <strong>unique</strong>.</li>
	<li><code>0 &lt;= amount &lt;= 5000</code></li>
</ul>


## Solutions


### Java

```Java
// @Title: 零钱兑换 II (Coin Change II)
// @Author: robert.sunq
// @Date: 2021-07-18 18:56:59
// @Runtime: 2 ms
// @Memory: 35.9 MB

class Solution {
    public int change(int amount, int[] coins) {
        // 表示金额amount有多少种组成方式
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int i=0;i<coins.length;i++){
            // 每添加一个硬币，各个总金额组成情况的变化
            for(int j=coins[i];j<=amount;j++){
                // 当前添加可选硬币下，需要组成的金额需要大于硬币值
                dp[j] = dp[j] + dp[j-coins[i]];
            }
        }
        return dp[amount];
    }
}
```



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Dynamic Programming](https://leetcode.cn//tag/dynamic-programming)

## Similar Questions


