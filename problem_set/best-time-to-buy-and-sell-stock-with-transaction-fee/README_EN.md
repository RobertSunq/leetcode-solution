
| English | [简体中文](README.md) |

# [714. Best Time to Buy and Sell Stock with Transaction Fee](https://leetcode.cn//problems/best-time-to-buy-and-sell-stock-with-transaction-fee/)

## Description

<p>You are given an array <code>prices</code> where <code>prices[i]</code> is the price of a given stock on the <code>i<sup>th</sup></code> day, and an integer <code>fee</code> representing a transaction fee.</p>

<p>Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.</p>

<p><strong>Note:</strong> You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> prices = [1,3,2,8,4,9], fee = 2
<strong>Output:</strong> 8
<strong>Explanation:</strong> The maximum profit can be achieved by:
- Buying at prices[0] = 1
- Selling at prices[3] = 8
- Buying at prices[4] = 4
- Selling at prices[5] = 9
The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> prices = [1,3,7,5,10,3], fee = 3
<strong>Output:</strong> 6
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= prices.length &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>1 &lt;= prices[i] &lt; 5 * 10<sup>4</sup></code></li>
	<li><code>0 &lt;= fee &lt; 5 * 10<sup>4</sup></code></li>
</ul>


## Solutions


### Java

```Java
// @Title: 买卖股票的最佳时机含手续费 (Best Time to Buy and Sell Stock with Transaction Fee)
// @Author: robert.sunq
// @Date: 2021-07-12 01:13:00
// @Runtime: 4 ms
// @Memory: 47.7 MB

class Solution {
    public int maxProfit(int[] prices, int fee) {
        // 当前不持有股票，且处于冷冻期
        int dp_0 = 0;
        // 当前持有股票
        int dp_1 = 0 - prices[0] - fee;
        // 当前不持有股票，不属于冷冻期
        int dp_2 = 0;
        for(int i = 0;i<prices.length;i++){
            int temp = dp_0;
            // 当天，是前一天不持有股票的最大值，和将之前买入的股票卖出
            dp_0 = Math.max(dp_0,dp_1 + prices[i]);
            // 当天，是前一天继续持有股票，或者不属于冷冻期的买入
            dp_1 = Math.max(dp_1,dp_0- prices[i] - fee);
            // 当天，不属于冷冻期 则是 上一个冷冻期
            dp_2 = temp;
        }
        // 最后的最大值，肯定是没有买入的
        return Math.max(dp_0,dp_2);
    }
}
```



### C++

```C++
// @Title: 买卖股票的最佳时机含手续费 (Best Time to Buy and Sell Stock with Transaction Fee)
// @Author: robert.sunq
// @Date: 2020-05-12 23:54:10
// @Runtime: 224 ms
// @Memory: 50.5 MB

class Solution {
public:
    int maxProfit(vector<int>& prices, int fee) {
        int n= prices.size();
        int dp_i0 = 0,dp_i1 = INT_MIN;
        for (int i=0;i<n;i++){
            int temp = dp_i0;
            dp_i0 = max(dp_i0,dp_i1+prices[i]);
            dp_i1 = max(dp_i1,temp-prices[i]-fee);
        }
        return dp_i0;

    }
};
```



## Related Topics

- [Greedy](https://leetcode.cn//tag/greedy)
- [Array](https://leetcode.cn//tag/array)
- [Dynamic Programming](https://leetcode.cn//tag/dynamic-programming)

## Similar Questions

- [Best Time to Buy and Sell Stock II](../best-time-to-buy-and-sell-stock-ii/README_EN.md)
