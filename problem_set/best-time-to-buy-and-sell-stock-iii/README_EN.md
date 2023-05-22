
| English | [简体中文](README.md) |

# [123. Best Time to Buy and Sell Stock III](https://leetcode.cn//problems/best-time-to-buy-and-sell-stock-iii/)

## Description

<p>You are given an array <code>prices</code> where <code>prices[i]</code> is the price of a given stock on the <code>i<sup>th</sup></code> day.</p>

<p>Find the maximum profit you can achieve. You may complete <strong>at most two transactions</strong>.</p>

<p><strong>Note:</strong> You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> prices = [3,3,5,0,0,3,1,4]
<strong>Output:</strong> 6
<strong>Explanation:</strong> Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> prices = [1,2,3,4,5]
<strong>Output:</strong> 4
<strong>Explanation:</strong> Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> prices = [7,6,4,3,1]
<strong>Output:</strong> 0
<strong>Explanation:</strong> In this case, no transaction is done, i.e. max profit = 0.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= prices.length &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= prices[i] &lt;= 10<sup>5</sup></code></li>
</ul>


## Solutions


### C++

```C++
// @Title: 买卖股票的最佳时机 III (Best Time to Buy and Sell Stock III)
// @Author: robert.sunq
// @Date: 2020-05-12 23:07:49
// @Runtime: 16 ms
// @Memory: 12.7 MB

class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int dp_i10 = 0,dp_i11 =  INT_MIN;
        int dp_i20 = 0,dp_i21 =  INT_MIN;
        for(int i = 0;i<prices.size();i++){
            dp_i20 = max(dp_i20,dp_i21+prices[i]);
            dp_i21 = max(dp_i21,dp_i10 - prices[i]);
            dp_i10 = max(dp_i10,dp_i11 + prices[i]);
            dp_i11 = max(dp_i11,-prices[i]);
        }
        return dp_i20;

    }
};

```



### Java

```Java
// @Title: 买卖股票的最佳时机 III (Best Time to Buy and Sell Stock III)
// @Author: robert.sunq
// @Date: 2021-07-12 00:27:41
// @Runtime: 4 ms
// @Memory: 50.9 MB

class Solution {
    public int maxProfit(int[] prices) {
        
        // 第一次买卖
        int dp0_0 = 0,dp0_1 = 0 - prices[0];
        // 第二次买卖
        int dp1_0 = 0,dp1_1 = 0- prices[0];
        for(int i = 0;i<prices.length;i++){
            // 第二次卖 之前已完成两次交易 与 手中持有加上当前股价的最大值
            dp1_0 = Math.max(dp1_0,dp1_1 + prices[i]);
            // 第二次买，第一次卖之后的值减去当前股价
            dp1_1 = Math.max(dp1_1,dp0_0 - prices[i]);
            // 第一次同理
            dp0_0 = Math.max(dp0_0,dp0_1 + prices[i]);
            dp0_1 = Math.max(dp0_1,-prices[i]);
        }
        return Math.max(dp0_0,dp1_0);
    }
}
```



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Dynamic Programming](https://leetcode.cn//tag/dynamic-programming)

## Similar Questions

- [Best Time to Buy and Sell Stock](../best-time-to-buy-and-sell-stock/README_EN.md)
- [Best Time to Buy and Sell Stock II](../best-time-to-buy-and-sell-stock-ii/README_EN.md)
- [Best Time to Buy and Sell Stock IV](../best-time-to-buy-and-sell-stock-iv/README_EN.md)
- [Maximum Sum of 3 Non-Overlapping Subarrays](../maximum-sum-of-3-non-overlapping-subarrays/README_EN.md)
