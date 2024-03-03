
```
// @Title: 买卖股票的最佳时机含手续费 (Best Time to Buy and Sell Stock with Transaction Fee)
// @Author: robert.sunq
// @Date: 2023-09-25 21:14:04
// @Runtime: 4 ms
// @Memory: 53.1 MB

class Solution {

    // 计算的技巧， 在购买股票的时候将购买的花费，和手续费全部扣除，这样在买入的时候只需要直接加上股价就好
    public int maxProfit(int[] prices, int fee) {
        
        // 当前不持有股票，且处于冷冻期， 该题里面维护期为 0 
        int dp_0 = 0;

        // 当前持有股票。（减去第一天的股价 和 手续费）
        int dp_1 = 0 - prices[0] - fee;

        // 当前不持有股票，且不处于冷冻期
        int dp_2 = 0;

        for (int price : prices) {
            int tmp = dp_0;
            
            // 当天，是前一天不持有股票的最大值，和将之前买入的股票卖出
            dp_0 = Math.max(dp_0, dp_1 + price);

            // 当天，是前一天继续持有股票，或者不属于冷冻期的买入
            dp_1 = Math.max(dp_1, dp_0 - price - fee);

            // 当天，不属于冷冻期 则是 上一个冷冻期（因为是 0 天冷冻期，所以直接相等即可）
            dp_2 = tmp;
        }

        // 最后的最大值，肯定是没有买入的
        return Math.max(dp_0, dp_2);
    }
}
