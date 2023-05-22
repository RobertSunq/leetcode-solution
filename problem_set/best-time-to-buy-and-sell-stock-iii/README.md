
| [English](README_EN.md) | 简体中文 |

# [123. 买卖股票的最佳时机 III](https://leetcode.cn//problems/best-time-to-buy-and-sell-stock-iii/)

## 题目描述

<p>给定一个数组，它的第<em> </em><code>i</code> 个元素是一支给定的股票在第 <code>i</code><em> </em>天的价格。</p>

<p>设计一个算法来计算你所能获取的最大利润。你最多可以完成 <strong>两笔 </strong>交易。</p>

<p><strong>注意：</strong>你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。</p>

<p> </p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入：</strong>prices = [3,3,5,0,0,3,1,4]
<strong>输出：</strong>6
<strong>解释：</strong>在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
     随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>prices = [1,2,3,4,5]
<strong>输出：</strong>4
<strong>解释：</strong>在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。   
     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。   
     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>prices = [7,6,4,3,1] 
<strong>输出：</strong>0 
<strong>解释：</strong>在这个情况下, 没有交易完成, 所以最大利润为 0。</pre>

<p><strong>示例 4：</strong></p>

<pre>
<strong>输入：</strong>prices = [1]
<strong>输出：</strong>0
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= prices.length <= 10<sup>5</sup></code></li>
	<li><code>0 <= prices[i] <= 10<sup>5</sup></code></li>
</ul>


## 题解


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



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [动态规划](https://leetcode.cn//tag/dynamic-programming)

## 相似题目


- [买卖股票的最佳时机](../best-time-to-buy-and-sell-stock/README.md)
- [买卖股票的最佳时机 II](../best-time-to-buy-and-sell-stock-ii/README.md)
- [买卖股票的最佳时机 IV](../best-time-to-buy-and-sell-stock-iv/README.md)
- [三个无重叠子数组的最大和](../maximum-sum-of-3-non-overlapping-subarrays/README.md)
