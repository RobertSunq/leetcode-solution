
```
// @Title: 掷骰子等于目标和的方法数 (Number of Dice Rolls With Target Sum)
// @Author: robert.sunq
// @Date: 2023-10-24 22:08:21
// @Runtime: 21 ms
// @Memory: 37.9 MB

class Solution {

    private static final long MOD = 1000000007;

    public int numRollsToTarget(int n, int k, int target) {
        long[] dp = new long[target + 1];
        for (int i = 1; i <= k && i <= target; i++) {
            dp[i] = 1;
        }
        for (int count = 2; count <= n; count++) {
            // 因为 骰子最小为 1， 所以 count 个骰子的 最小值和为 count
            // 从最大往小计算 count 个骰子的和，可以避免从小往大算的时候，小的再本轮的新值覆盖上一轮的，导致大的数无法使用上一轮的值
            for (int t = target; t >= count; t--) {
                long tmp = 0L;
                for (int i = 1; i <= k; i++) {
                    // 骰子不存在为 0 的情况， 所以 当前sum - 骰子数目之后必须大于 上一轮 骰子和的最小值 (count - 1)
                    if (t - i < count - 1) {
                        break;
                    }
                    tmp = (tmp + dp[t - i]) % MOD;
                }
                dp[t] = tmp;
            }
        }

        return (int) (dp[target] % MOD);
    }
}
