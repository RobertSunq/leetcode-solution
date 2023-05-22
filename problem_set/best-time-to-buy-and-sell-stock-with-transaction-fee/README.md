
| [English](README_EN.md) | 简体中文 |

# [714. 买卖股票的最佳时机含手续费](https://leetcode.cn//problems/best-time-to-buy-and-sell-stock-with-transaction-fee/)

## 题目描述

<p>给定一个整数数组&nbsp;<code>prices</code>，其中 <code>prices[i]</code>表示第&nbsp;<code>i</code>&nbsp;天的股票价格 ；整数&nbsp;<code>fee</code> 代表了交易股票的手续费用。</p>

<p>你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。</p>

<p>返回获得利润的最大值。</p>

<p><strong>注意：</strong>这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>prices = [1, 3, 2, 8, 4, 9], fee = 2
<strong>输出：</strong>8
<strong>解释：</strong>能够达到的最大利润:  
在此处买入&nbsp;prices[0] = 1
在此处卖出 prices[3] = 8
在此处买入 prices[4] = 4
在此处卖出 prices[5] = 9
总利润:&nbsp;((8 - 1) - 2) + ((9 - 4) - 2) = 8</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>prices = [1,3,7,5,10,3], fee = 3
<strong>输出：</strong>6
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= prices.length &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>1 &lt;= prices[i] &lt; 5 * 10<sup>4</sup></code></li>
	<li><code>0 &lt;= fee &lt; 5 * 10<sup>4</sup></code></li>
</ul>


## 题解


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



## 相关话题

- [贪心](https://leetcode.cn//tag/greedy)
- [数组](https://leetcode.cn//tag/array)
- [动态规划](https://leetcode.cn//tag/dynamic-programming)

## 相似题目


- [买卖股票的最佳时机 II](../best-time-to-buy-and-sell-stock-ii/README.md)
