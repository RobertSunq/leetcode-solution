
| [English](README_EN.md) | 简体中文 |

# [322. 零钱兑换](https://leetcode.cn//problems/coin-change/)

## 题目描述

<p>给你一个整数数组 <code>coins</code> ，表示不同面额的硬币；以及一个整数 <code>amount</code> ，表示总金额。</p>

<p>计算并返回可以凑成总金额所需的 <strong>最少的硬币个数</strong> 。如果没有任何一种硬币组合能组成总金额，返回&nbsp;<code>-1</code> 。</p>

<p>你可以认为每种硬币的数量是无限的。</p>

<p>&nbsp;</p>

<p><strong>示例&nbsp;1：</strong></p>

<pre>
<strong>输入：</strong>coins = <code>[1, 2, 5]</code>, amount = <code>11</code>
<strong>输出：</strong><code>3</code> 
<strong>解释：</strong>11 = 5 + 5 + 1</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>coins = <code>[2]</code>, amount = <code>3</code>
<strong>输出：</strong>-1</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>coins = [1], amount = 0
<strong>输出：</strong>0
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= coins.length &lt;= 12</code></li>
	<li><code>1 &lt;= coins[i] &lt;= 2<sup>31</sup> - 1</code></li>
	<li><code>0 &lt;= amount &lt;= 10<sup>4</sup></code></li>
</ul>


## 题解


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



## 相关话题

- [广度优先搜索](https://leetcode.cn//tag/breadth-first-search)
- [数组](https://leetcode.cn//tag/array)
- [动态规划](https://leetcode.cn//tag/dynamic-programming)

## 相似题目


- [最低票价](../minimum-cost-for-tickets/README.md)
