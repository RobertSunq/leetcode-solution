
```
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
