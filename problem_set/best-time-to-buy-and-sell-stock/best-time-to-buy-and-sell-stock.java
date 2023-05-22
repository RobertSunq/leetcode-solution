
```
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
