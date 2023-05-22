
| English | [简体中文](README.md) |

# [309. Best Time to Buy and Sell Stock with Cooldown](https://leetcode.cn//problems/best-time-to-buy-and-sell-stock-with-cooldown/)

## Description

<p>You are given an array <code>prices</code> where <code>prices[i]</code> is the price of a given stock on the <code>i<sup>th</sup></code> day.</p>

<p>Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:</p>

<ul>
	<li>After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).</li>
</ul>

<p><strong>Note:</strong> You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> prices = [1,2,3,0,2]
<strong>Output:</strong> 3
<strong>Explanation:</strong> transactions = [buy, sell, cooldown, buy, sell]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> prices = [1]
<strong>Output:</strong> 0
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= prices.length &lt;= 5000</code></li>
	<li><code>0 &lt;= prices[i] &lt;= 1000</code></li>
</ul>


## Solutions


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



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Dynamic Programming](https://leetcode.cn//tag/dynamic-programming)

## Similar Questions

- [Best Time to Buy and Sell Stock](../best-time-to-buy-and-sell-stock/README_EN.md)
- [Best Time to Buy and Sell Stock II](../best-time-to-buy-and-sell-stock-ii/README_EN.md)
