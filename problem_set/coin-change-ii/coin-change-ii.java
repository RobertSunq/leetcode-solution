
```
// @Title: 零钱兑换 II (Coin Change II)
// @Author: robert.sunq
// @Date: 2021-07-18 18:56:59
// @Runtime: 2 ms
// @Memory: 35.9 MB

class Solution {
    public int change(int amount, int[] coins) {
        // 表示金额amount有多少种组成方式
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int i=0;i<coins.length;i++){
            // 每添加一个硬币，各个总金额组成情况的变化
            for(int j=coins[i];j<=amount;j++){
                // 当前添加可选硬币下，需要组成的金额需要大于硬币值
                dp[j] = dp[j] + dp[j-coins[i]];
            }
        }
        return dp[amount];
    }
}
