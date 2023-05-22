
```
// @Title: 股票的最大利润 (股票的最大利润  LCOF)
// @Author: robert.sunq
// @Date: 2021-05-30 23:35:31
// @Runtime: 2 ms
// @Memory: 38.3 MB

class Solution {
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        if(prices.length < 1) return 0;
        // 前几日最低股价
        int min = prices[0];
        dp[0] = 0;
        for(int i = 1;i<prices.length;i++){
            dp[i] = Math.max(dp[i-1],prices[i]-min);
            // 前几日的最低股价
            min = Math.min(min,prices[i]);
        }
        return dp[prices.length -1];
    }
}
