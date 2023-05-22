
| English | [简体中文](README.md) |

# [122. Best Time to Buy and Sell Stock II](https://leetcode.cn//problems/best-time-to-buy-and-sell-stock-ii/)

## Description

<p>You are given an integer array <code>prices</code> where <code>prices[i]</code> is the price of a given stock on the <code>i<sup>th</sup></code> day.</p>

<p>On each day, you may decide to buy and/or sell the stock. You can only hold <strong>at most one</strong> share of the stock at any time. However, you can buy it then immediately sell it on the <strong>same day</strong>.</p>

<p>Find and return <em>the <strong>maximum</strong> profit you can achieve</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> prices = [7,1,5,3,6,4]
<strong>Output:</strong> 7
<strong>Explanation:</strong> Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Total profit is 4 + 3 = 7.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> prices = [1,2,3,4,5]
<strong>Output:</strong> 4
<strong>Explanation:</strong> Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Total profit is 4.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> prices = [7,6,4,3,1]
<strong>Output:</strong> 0
<strong>Explanation:</strong> There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= prices.length &lt;= 3 * 10<sup>4</sup></code></li>
	<li><code>0 &lt;= prices[i] &lt;= 10<sup>4</sup></code></li>
</ul>


## Solutions


### Java

```Java
// @Title: 买卖股票的最佳时机 II (Best Time to Buy and Sell Stock II)
// @Author: robert.sunq
// @Date: 2021-07-12 00:37:22
// @Runtime: 2 ms
// @Memory: 38.4 MB

class Solution {
    public int maxProfit(int[] prices) {
        // 贪心算法
        // int res = 0;
        // for(int i = 1;i<prices.length;i++){
        //     // 利润的最大值，当前股价必前一天高，则设定前一天买入，今天卖出
        //     // 当前下一天大于今天，可用假设今天卖出后 右买入了 所以只用计算每一次的增加
        //     if(prices[i] > prices[i-1]){
        //         res = res + prices[i]-prices[i-1];
        //     }
        // }
        // return res;
        // 不持有股票的最大利润
        int dp0 = 0;
        // 持有股票的最大利润
        int dp1 = -prices[0];
        for(int i = 0;i<prices.length;i++){
            // 不持有股票的最大利润，为前一天不持有，或者前一天持有今天卖出
            dp0 = Math.max(dp0,dp1 + prices[i]);
            // 持有股票的  ， 为前一天也持有，或者而前一天不持有今天买入
            dp1 = Math.max(dp1,dp0-prices[i]);
        }
        return dp0;
    }
}
```



### C++

```C++
// @Title: 买卖股票的最佳时机 II (Best Time to Buy and Sell Stock II)
// @Author: robert.sunq
// @Date: 2020-05-12 22:37:41
// @Runtime: 8 ms
// @Memory: 7 MB

class Solution {
public:
    int maxProfit(vector<int>& prices) {
        
        int temp[2] = {0};
        int out = 0;
        for(int i=1;i<prices.size();i++){
            if((prices[i]-prices[i-1])>0) out=out+prices[i]-prices[i-1];
        }
        return out;
    }
};
```



## Related Topics

- [Greedy](https://leetcode.cn//tag/greedy)
- [Array](https://leetcode.cn//tag/array)
- [Dynamic Programming](https://leetcode.cn//tag/dynamic-programming)

## Similar Questions

- [Best Time to Buy and Sell Stock](../best-time-to-buy-and-sell-stock/README_EN.md)
- [Best Time to Buy and Sell Stock III](../best-time-to-buy-and-sell-stock-iii/README_EN.md)
- [Best Time to Buy and Sell Stock IV](../best-time-to-buy-and-sell-stock-iv/README_EN.md)
- [Best Time to Buy and Sell Stock with Cooldown](../best-time-to-buy-and-sell-stock-with-cooldown/README_EN.md)
- [Best Time to Buy and Sell Stock with Transaction Fee](../best-time-to-buy-and-sell-stock-with-transaction-fee/README_EN.md)
