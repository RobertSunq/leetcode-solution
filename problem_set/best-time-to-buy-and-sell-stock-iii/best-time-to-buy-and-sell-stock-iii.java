
```
// @Title: 买卖股票的最佳时机 III (Best Time to Buy and Sell Stock III)
// @Author: robert.sunq
// @Date: 2021-07-12 00:27:41
// @Runtime: 4 ms
// @Memory: 50.9 MB

class Solution {
    public int maxProfit(int[] prices) {
        
        // 第一次买卖
        int dp0_0 = 0,dp0_1 = 0 - prices[0];
        // 第二次买卖
        int dp1_0 = 0,dp1_1 = 0- prices[0];
        for(int i = 0;i<prices.length;i++){
            // 第二次卖 之前已完成两次交易 与 手中持有加上当前股价的最大值
            dp1_0 = Math.max(dp1_0,dp1_1 + prices[i]);
            // 第二次买，第一次卖之后的值减去当前股价
            dp1_1 = Math.max(dp1_1,dp0_0 - prices[i]);
            // 第一次同理
            dp0_0 = Math.max(dp0_0,dp0_1 + prices[i]);
            dp0_1 = Math.max(dp0_1,-prices[i]);
        }
        return Math.max(dp0_0,dp1_0);
    }
}
