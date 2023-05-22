
```
// @Title: 最佳买卖股票时机含冷冻期 (Best Time to Buy and Sell Stock with Cooldown)
// @Author: robert.sunq
// @Date: 2021-06-19 21:22:41
// @Runtime: 1 ms
// @Memory: 37.9 MB

class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length <= 0 ) return 0;
        int[][] dp = new int[prices.length][3];
        // dp[i][0] 表示不持有股票且属于冷冻期
        dp[0][0] = 0;
        // dp[i][1] 表示当前持有股票
        dp[0][1] = -prices[0];
        // dp[i][2] 表示不持有股票且不属于冷冻期
        dp[0][2] = 0;
        for(int i=1;i<prices.length;i++){
            // 当前冷冻期不持有股票，前一天的不持有，或 将当前股票卖出
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            // 当前冷冻期持有股票 , 冷冻期外买入 或者 保存和前一天状态相同
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][2] - prices[i]);
            // 不属于冷冻期
            dp[i][2] = dp[i-1][0];
        }

        return Math.max(dp[prices.length-1][0],dp[prices.length-1][2]);
    }
}
