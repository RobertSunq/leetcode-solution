
| English | [简体中文](README.md) |

# [121. Best Time to Buy and Sell Stock](https://leetcode.cn//problems/best-time-to-buy-and-sell-stock/)

## Description

<p>You are given an array <code>prices</code> where <code>prices[i]</code> is the price of a given stock on the <code>i<sup>th</sup></code> day.</p>

<p>You want to maximize your profit by choosing a <strong>single day</strong> to buy one stock and choosing a <strong>different day in the future</strong> to sell that stock.</p>

<p>Return <em>the maximum profit you can achieve from this transaction</em>. If you cannot achieve any profit, return <code>0</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> prices = [7,1,5,3,6,4]
<strong>Output:</strong> 5
<strong>Explanation:</strong> Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> prices = [7,6,4,3,1]
<strong>Output:</strong> 0
<strong>Explanation:</strong> In this case, no transactions are done and the max profit = 0.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= prices.length &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= prices[i] &lt;= 10<sup>4</sup></code></li>
</ul>


## Solutions


### C++

```C++
// @Title: 买卖股票的最佳时机 (Best Time to Buy and Sell Stock)
// @Author: robert.sunq
// @Date: 2020-05-12 22:32:24
// @Runtime: 12 ms
// @Memory: 12.7 MB

class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int temp[2];
        temp[0] = 0;
        temp[1] =0 ;
        int max = 0 ;
        for(int i=1;i<prices.size();i++){
            if((prices[i]-prices[temp[0]]) > max) {
                max = prices[i]-prices[temp[0]];
                temp[1] = i;
            }
            if(prices[i] < prices[temp[0]]) temp[0] = i;
        }
        return max;
    }
};
```



### Java

```Java
// @Title: 买卖股票的最佳时机 (Best Time to Buy and Sell Stock)
// @Author: robert.sunq
// @Date: 2021-06-30 23:38:26
// @Runtime: 3 ms
// @Memory: 51.5 MB

class Solution {
    public int maxProfit(int[] prices) {
        int min  = prices[0];
        int res = 0;
        // pre 到当前天 最大利润
        int pre = 0;
        for(int i = 1;i<prices.length;i++){
            // 当前天的最大利润，是前一天的最大利润，和当前天减去前面最小值的利润中的大者
            pre = Math.max(pre,prices[i] - min);
            min = Math.min(min , prices[i]);
        }
        return pre;
    }
}
```



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Dynamic Programming](https://leetcode.cn//tag/dynamic-programming)

## Similar Questions

- [Maximum Subarray](../maximum-subarray/README_EN.md)
- [Best Time to Buy and Sell Stock II](../best-time-to-buy-and-sell-stock-ii/README_EN.md)
- [Best Time to Buy and Sell Stock III](../best-time-to-buy-and-sell-stock-iii/README_EN.md)
- [Best Time to Buy and Sell Stock IV](../best-time-to-buy-and-sell-stock-iv/README_EN.md)
- [Best Time to Buy and Sell Stock with Cooldown](../best-time-to-buy-and-sell-stock-with-cooldown/README_EN.md)
