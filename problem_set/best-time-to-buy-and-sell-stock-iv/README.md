
| [English](README_EN.md) | 简体中文 |

# [188. 买卖股票的最佳时机 IV](https://leetcode.cn//problems/best-time-to-buy-and-sell-stock-iv/)

## 题目描述

<p>给定一个整数数组&nbsp;<code>prices</code> ，它的第<em> </em><code>i</code> 个元素&nbsp;<code>prices[i]</code> 是一支给定的股票在第 <code>i</code><em> </em>天的价格，和一个整型 <code>k</code> 。</p>

<p>设计一个算法来计算你所能获取的最大利润。你最多可以完成 <code>k</code> 笔交易。也就是说，你最多可以买 <code>k</code> 次，卖 <code>k</code> 次。</p>

<p><strong>注意：</strong>你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<pre>
<strong>输入：</strong>k = 2, prices = [2,4,1]
<strong>输出：</strong>2
<strong>解释：</strong>在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。</pre>

<p><strong class="example">示例 2：</strong></p>

<pre>
<strong>输入：</strong>k = 2, prices = [3,2,6,5,0,3]
<strong>输出：</strong>7
<strong>解释：</strong>在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
     随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>0 &lt;= k &lt;= 100</code></li>
	<li><code>0 &lt;= prices.length &lt;= 1000</code></li>
	<li><code>0 &lt;= prices[i] &lt;= 1000</code></li>
</ul>


## 题解


### C++

```C++
// @Title: 买卖股票的最佳时机 IV (Best Time to Buy and Sell Stock IV)
// @Author: robert.sunq
// @Date: 2020-05-12 23:38:42
// @Runtime: 104 ms
// @Memory: 21.4 MB

class Solution {
public:
    int maxProfit(int k, vector<int>& prices) {
        
        int n = prices.size();
        if(k>=n/2) {
            int dp_i0 = 0,dp_i1 = INT_MIN;
            for (int i=0;i<n;i++){
                int temp = dp_i0;
                dp_i0 = max(dp_i0,dp_i1+prices[i]);
                dp_i1 = max(dp_i1,temp - prices[i]);
            }
            return dp_i0;
        }
        else{
            int dp[n][k+1][2];
            for(int i=0;i<n;i++){
                for(int j = k;j>=1;j--){
                    if(i==0){
                        dp[i][j][0] = 0;
                        dp[i][j][1] = -prices[i];
                    }
                    else{
                    
                    dp[i][j][0] = max(dp[i-1][j][0] , dp[i-1][j][1]+prices[i]);
                    dp[i][j][1] = max(dp[i][j][1],dp[i-1][j-1][0]-prices[i]);
                }}
            }
            return dp[n-1][k][0];
        }

    }
};
```



### Java

```Java
// @Title: 买卖股票的最佳时机 IV (Best Time to Buy and Sell Stock IV)
// @Author: robert.sunq
// @Date: 2021-07-12 01:01:14
// @Runtime: 1 ms
// @Memory: 36 MB

class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices.length <= 0 || k<=0)return 0;
        // dp[i][0] 第i次 不持有，dp[i][1] 第i次 持有
        int[][] dp = new int[k][2];
        // 第一天，持有状态下的最大值，为买入第一天股票
        for(int i = 0;i<k;i++){
            dp[i][0] = 0;
            dp[i][1] = 0 - prices[0];
        }
        for(int i = 0;i<prices.length;i++){
            for(int j = k-1;j>=0;j--){
                if(j == 0){
                    dp[j][0] =  Math.max(dp[j][0],dp[j][1] + prices[i]);
                    // 第一次持有，则利润应该为当前股价的负值,或者前一天的持有
                    dp[j][1] = Math.max(dp[j][1],0 - prices[i]);
                }else{
                    dp[j][0] = Math.max(dp[j][0],dp[j][1] + prices[i]);
                    // 第j次买入，前一天第j次买入 和 前一天 j - 1 次 卖出减去当前票价的最大值
                    dp[j][1] = Math.max(dp[j][1],dp[j-1][0] - prices[i]);
                }

            }
        }
        int res = 0;
        // 所有卖出的最大值
        for(int i = 0;i<k;i++){
            res = Math.max(res,dp[i][0]);
        }
        return res;
    }
}
```



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [动态规划](https://leetcode.cn//tag/dynamic-programming)

## 相似题目


- [买卖股票的最佳时机](../best-time-to-buy-and-sell-stock/README.md)
- [买卖股票的最佳时机 II](../best-time-to-buy-and-sell-stock-ii/README.md)
- [买卖股票的最佳时机 III](../best-time-to-buy-and-sell-stock-iii/README.md)
