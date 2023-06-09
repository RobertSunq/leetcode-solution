
| [English](README_EN.md) | 简体中文 |

# [121. 买卖股票的最佳时机](https://leetcode.cn//problems/best-time-to-buy-and-sell-stock/)

## 题目描述

<p>给定一个数组 <code>prices</code> ，它的第 <code>i</code> 个元素 <code>prices[i]</code> 表示一支给定股票第 <code>i</code> 天的价格。</p>

<p>你只能选择 <strong>某一天</strong> 买入这只股票，并选择在 <strong>未来的某一个不同的日子</strong> 卖出该股票。设计一个算法来计算你所能获取的最大利润。</p>

<p>返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 <code>0</code> 。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>[7,1,5,3,6,4]
<strong>输出：</strong>5
<strong>解释：</strong>在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>prices = [7,6,4,3,1]
<strong>输出：</strong>0
<strong>解释：</strong>在这种情况下, 没有交易完成, 所以最大利润为 0。
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= prices.length <= 10<sup>5</sup></code></li>
	<li><code>0 <= prices[i] <= 10<sup>4</sup></code></li>
</ul>


## 题解


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



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [动态规划](https://leetcode.cn//tag/dynamic-programming)

## 相似题目


- [最大子数组和](../maximum-subarray/README.md)
- [买卖股票的最佳时机 II](../best-time-to-buy-and-sell-stock-ii/README.md)
- [买卖股票的最佳时机 III](../best-time-to-buy-and-sell-stock-iii/README.md)
- [买卖股票的最佳时机 IV](../best-time-to-buy-and-sell-stock-iv/README.md)
- [最佳买卖股票时机含冷冻期](../best-time-to-buy-and-sell-stock-with-cooldown/README.md)
