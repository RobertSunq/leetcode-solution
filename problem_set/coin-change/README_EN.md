
| English | [简体中文](README.md) |

# [322. Coin Change](https://leetcode.cn//problems/coin-change/)

## Description

<p>You are given an integer array <code>coins</code> representing coins of different denominations and an integer <code>amount</code> representing a total amount of money.</p>

<p>Return <em>the fewest number of coins that you need to make up that amount</em>. If that amount of money cannot be made up by any combination of the coins, return <code>-1</code>.</p>

<p>You may assume that you have an infinite number of each kind of coin.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> coins = [1,2,5], amount = 11
<strong>Output:</strong> 3
<strong>Explanation:</strong> 11 = 5 + 5 + 1
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> coins = [2], amount = 3
<strong>Output:</strong> -1
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> coins = [1], amount = 0
<strong>Output:</strong> 0
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= coins.length &lt;= 12</code></li>
	<li><code>1 &lt;= coins[i] &lt;= 2<sup>31</sup> - 1</code></li>
	<li><code>0 &lt;= amount &lt;= 10<sup>4</sup></code></li>
</ul>


## Solutions


### Java

```Java
// @Title: 零钱兑换 (Coin Change)
// @Author: robert.sunq
// @Date: 2021-06-19 22:46:51
// @Runtime: 25 ms
// @Memory: 37.8 MB

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        Arrays.sort(coins);
        int[] dp = new int[amount+1];
        for(int i=0;i<=amount;i++){
            dp[i] = i+5;
            for(int j = coins.length-1;j>=0;j--){
                // 当前数值，与硬币中的一个数目相等 则需要的数量为 1
                if(i == coins[j]) {
                    dp[i] = 1;
                    continue;
                }
                // 当前数值需要硬币的最小数目，等于去除一个硬币后，的数目 + 1
                // 需要排除 不能由硬币组成的数字 
                if(i - coins[j] >=0 && dp[i - coins[j]] -5 != i-coins[j]){
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        return dp[amount] -5 == amount ? -1:dp[amount];
    }
}
```



## Related Topics

- [Breadth-First Search](https://leetcode.cn//tag/breadth-first-search)
- [Array](https://leetcode.cn//tag/array)
- [Dynamic Programming](https://leetcode.cn//tag/dynamic-programming)

## Similar Questions

- [Minimum Cost For Tickets](../minimum-cost-for-tickets/README_EN.md)
