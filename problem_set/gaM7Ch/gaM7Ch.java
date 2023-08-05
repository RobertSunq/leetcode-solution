
```
// @Title: 零钱兑换 (零钱兑换)
// @Author: robert.sunq
// @Date: 2023-08-02 00:17:12
// @Runtime: 17 ms
// @Memory: 41.7 MB

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) {
            return 0;
        }

        Arrays.sort(coins);
        int n = coins.length; 

        int[] dp = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            // 从大到小开始兑换，因为金额每轮+1， 所以每次对于硬币相对于上轮最多也是+1
            for (int j = n - 1; j>=0; j--) {
                if (i == coins[j]) {
                    dp[i] = 1;
                    break;
                } 

                // 注意排除非法值，就是兑换一个当前硬币后，剩余的钱，在之前的轮次中依旧无法兑换
                if (i - coins[j] > 0 && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
