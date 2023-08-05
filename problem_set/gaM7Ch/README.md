
| [English](README_EN.md) | 简体中文 |

# [LCR 103. 零钱兑换](https://leetcode.cn//problems/gaM7Ch/)

## 题目描述

<p>给定不同面额的硬币 <code>coins</code> 和一个总金额 <code>amount</code>。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回&nbsp;<code>-1</code>。</p>

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

<p><strong>示例 4：</strong></p>

<pre>
<strong>输入：</strong>coins = [1], amount = 1
<strong>输出：</strong>1
</pre>

<p><strong>示例 5：</strong></p>

<pre>
<strong>输入：</strong>coins = [1], amount = 2
<strong>输出：</strong>2
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= coins.length &lt;= 12</code></li>
	<li><code>1 &lt;= coins[i] &lt;= 2<sup>31</sup> - 1</code></li>
	<li><code>0 &lt;= amount &lt;= 10<sup>4</sup></code></li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 322&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/coin-change/">https://leetcode-cn.com/problems/coin-change/</a></p>


## 题解


### Java

```Java
// @Title: 零钱兑换 (零钱兑换)
// @Author: robert.sunq
// @Date: 2023-08-02 00:17:12
// @Runtime: 17 ms
// @Memory: 41.7 MB

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) {
            return 0;
        }

        Arrays.sort(coins);
        int n = coins.length; 

        int[] dp = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            // 从大到小开始兑换，因为金额每轮+1， 所以每次对于硬币相对于上轮最多也是+1
            for (int j = n - 1; j>=0; j--) {
                if (i == coins[j]) {
                    dp[i] = 1;
                    break;
                } 

                // 注意排除非法值，就是兑换一个当前硬币后，剩余的钱，在之前的轮次中依旧无法兑换
                if (i - coins[j] > 0 && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
```



## 相关话题

- [广度优先搜索](https://leetcode.cn//tag/breadth-first-search)
- [数组](https://leetcode.cn//tag/array)
- [动态规划](https://leetcode.cn//tag/dynamic-programming)

## 相似题目



