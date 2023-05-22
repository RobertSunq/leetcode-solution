
```
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
