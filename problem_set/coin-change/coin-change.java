
```
// @Title: 零钱兑换 (Coin Change)
// @Author: robert.sunq
// @Date: 2021-06-19 22:46:51
// @Runtime: 25 ms
// @Memory: 37.8 MB

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        Arrays.sort(coins);
        int[] dp = new int[amount+1];
        for(int i=0;i<=amount;i++){
            dp[i] = i+5;
            for(int j = coins.length-1;j>=0;j--){
                // 当前数值，与硬币中的一个数目相等 则需要的数量为 1
                if(i == coins[j]) {
                    dp[i] = 1;
                    continue;
                }
                // 当前数值需要硬币的最小数目，等于去除一个硬币后，的数目 + 1
                // 需要排除 不能由硬币组成的数字 
                if(i - coins[j] >=0 && dp[i - coins[j]] -5 != i-coins[j]){
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        return dp[amount] -5 == amount ? -1:dp[amount];
    }
}
