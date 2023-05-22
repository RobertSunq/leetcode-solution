
| English | [简体中文](README.md) |

# [188. Best Time to Buy and Sell Stock IV](https://leetcode.cn//problems/best-time-to-buy-and-sell-stock-iv/)

## Description

<p>You are given an integer array <code>prices</code> where <code>prices[i]</code> is the price of a given stock on the <code>i<sup>th</sup></code> day, and an integer <code>k</code>.</p>

<p>Find the maximum profit you can achieve. You may complete at most <code>k</code> transactions: i.e. you may buy at most <code>k</code> times and sell at most <code>k</code> times.</p>

<p><strong>Note:</strong> You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> k = 2, prices = [2,4,1]
<strong>Output:</strong> 2
<strong>Explanation:</strong> Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> k = 2, prices = [3,2,6,5,0,3]
<strong>Output:</strong> 7
<strong>Explanation:</strong> Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= k &lt;= 100</code></li>
	<li><code>1 &lt;= prices.length &lt;= 1000</code></li>
	<li><code>0 &lt;= prices[i] &lt;= 1000</code></li>
</ul>


## Solutions


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



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Dynamic Programming](https://leetcode.cn//tag/dynamic-programming)

## Similar Questions

- [Best Time to Buy and Sell Stock](../best-time-to-buy-and-sell-stock/README_EN.md)
- [Best Time to Buy and Sell Stock II](../best-time-to-buy-and-sell-stock-ii/README_EN.md)
- [Best Time to Buy and Sell Stock III](../best-time-to-buy-and-sell-stock-iii/README_EN.md)
