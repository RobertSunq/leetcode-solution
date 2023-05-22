
```
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
