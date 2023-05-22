
| [English](README_EN.md) | 简体中文 |

# [518. 零钱兑换 II](https://leetcode.cn//problems/coin-change-ii/)

## 题目描述

<p>给你一个整数数组 <code>coins</code> 表示不同面额的硬币，另给一个整数 <code>amount</code> 表示总金额。</p>

<p>请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 <code>0</code> 。</p>

<p>假设每一种面额的硬币有无限个。 </p>

<p>题目数据保证结果符合 32 位带符号整数。</p>

<p> </p>

<ul>
</ul>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>amount = 5, coins = [1, 2, 5]
<strong>输出：</strong>4
<strong>解释：</strong>有四种方式可以凑成总金额：
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>amount = 3, coins = [2]
<strong>输出：</strong>0
<strong>解释：</strong>只用面额 2 的硬币不能凑成总金额 3 。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>amount = 10, coins = [10] 
<strong>输出：</strong>1
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= coins.length <= 300</code></li>
	<li><code>1 <= coins[i] <= 5000</code></li>
	<li><code>coins</code> 中的所有值 <strong>互不相同</strong></li>
	<li><code>0 <= amount <= 5000</code></li>
</ul>


## 题解


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



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [动态规划](https://leetcode.cn//tag/dynamic-programming)

## 相似题目



