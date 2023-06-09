
| [English](README_EN.md) | 简体中文 |

# [122. 买卖股票的最佳时机 II](https://leetcode.cn//problems/best-time-to-buy-and-sell-stock-ii/)

## 题目描述

<p>给你一个整数数组 <code>prices</code> ，其中&nbsp;<code>prices[i]</code> 表示某支股票第 <code>i</code> 天的价格。</p>

<p>在每一天，你可以决定是否购买和/或出售股票。你在任何时候&nbsp;<strong>最多</strong>&nbsp;只能持有 <strong>一股</strong> 股票。你也可以先购买，然后在 <strong>同一天</strong> 出售。</p>

<p>返回 <em>你能获得的 <strong>最大</strong> 利润</em>&nbsp;。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>prices = [7,1,5,3,6,4]
<strong>输出：</strong>7
<strong>解释：</strong>在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
&nbsp;    随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3 。
     总利润为 4 + 3 = 7 。</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>prices = [1,2,3,4,5]
<strong>输出：</strong>4
<strong>解释：</strong>在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
&nbsp;    总利润为 4 。</pre>

<p><strong>示例&nbsp;3：</strong></p>

<pre>
<strong>输入：</strong>prices = [7,6,4,3,1]
<strong>输出：</strong>0
<strong>解释：</strong>在这种情况下, 交易无法获得正利润，所以不参与交易可以获得最大利润，最大利润为 0 。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= prices.length &lt;= 3 * 10<sup>4</sup></code></li>
	<li><code>0 &lt;= prices[i] &lt;= 10<sup>4</sup></code></li>
</ul>


## 题解


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



## 相关话题

- [贪心](https://leetcode.cn//tag/greedy)
- [数组](https://leetcode.cn//tag/array)
- [动态规划](https://leetcode.cn//tag/dynamic-programming)

## 相似题目


- [买卖股票的最佳时机](../best-time-to-buy-and-sell-stock/README.md)
- [买卖股票的最佳时机 III](../best-time-to-buy-and-sell-stock-iii/README.md)
- [买卖股票的最佳时机 IV](../best-time-to-buy-and-sell-stock-iv/README.md)
- [最佳买卖股票时机含冷冻期](../best-time-to-buy-and-sell-stock-with-cooldown/README.md)
- [买卖股票的最佳时机含手续费](../best-time-to-buy-and-sell-stock-with-transaction-fee/README.md)
