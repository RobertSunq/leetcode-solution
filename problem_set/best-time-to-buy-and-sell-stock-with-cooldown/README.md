
| [English](README_EN.md) | 简体中文 |

# [309. 最佳买卖股票时机含冷冻期](https://leetcode.cn//problems/best-time-to-buy-and-sell-stock-with-cooldown/)

## 题目描述

<p>给定一个整数数组<meta charset="UTF-8" /><code>prices</code>，其中第&nbsp;<em>&nbsp;</em><code>prices[i]</code>&nbsp;表示第&nbsp;<code><em>i</em></code>&nbsp;天的股票价格 。​</p>

<p>设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:</p>

<ul>
	<li>卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。</li>
</ul>

<p><strong>注意：</strong>你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> prices = [1,2,3,0,2]
<strong>输出: </strong>3 
<strong>解释:</strong> 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> prices = [1]
<strong>输出:</strong> 0
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= prices.length &lt;= 5000</code></li>
	<li><code>0 &lt;= prices[i] &lt;= 1000</code></li>
</ul>


## 题解


### Java

```Java
// @Title: 最佳买卖股票时机含冷冻期 (Best Time to Buy and Sell Stock with Cooldown)
// @Author: robert.sunq
// @Date: 2021-06-19 21:22:41
// @Runtime: 1 ms
// @Memory: 37.9 MB

class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length <= 0 ) return 0;
        int[][] dp = new int[prices.length][3];
        // dp[i][0] 表示不持有股票且属于冷冻期
        dp[0][0] = 0;
        // dp[i][1] 表示当前持有股票
        dp[0][1] = -prices[0];
        // dp[i][2] 表示不持有股票且不属于冷冻期
        dp[0][2] = 0;
        for(int i=1;i<prices.length;i++){
            // 当前冷冻期不持有股票，前一天的不持有，或 将当前股票卖出
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            // 当前冷冻期持有股票 , 冷冻期外买入 或者 保存和前一天状态相同
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][2] - prices[i]);
            // 不属于冷冻期
            dp[i][2] = dp[i-1][0];
        }

        return Math.max(dp[prices.length-1][0],dp[prices.length-1][2]);
    }
}
```



### C++

```C++
// @Title: 最佳买卖股票时机含冷冻期 (Best Time to Buy and Sell Stock with Cooldown)
// @Author: robert.sunq
// @Date: 2020-05-12 23:50:37
// @Runtime: 4 ms
// @Memory: 11 MB

class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int n= prices.size();
        int dp_i0 = 0,dp_i1 = INT_MIN;
        int dp_pre_0 = 0;
        for (int i=0;i<n;i++){
            int temp = dp_i0;
            dp_i0 = max(dp_i0,dp_i1+prices[i]);
            dp_i1 = max(dp_i1,dp_pre_0 - prices[i]);
            dp_pre_0 = temp;
        }
        return dp_i0;

    }
};
```



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [动态规划](https://leetcode.cn//tag/dynamic-programming)

## 相似题目


- [买卖股票的最佳时机](../best-time-to-buy-and-sell-stock/README.md)
- [买卖股票的最佳时机 II](../best-time-to-buy-and-sell-stock-ii/README.md)
