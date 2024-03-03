
```
// @Title: 使用最小花费爬楼梯 (Min Cost Climbing Stairs)
// @Author: robert.sunq
// @Date: 2023-09-20 21:41:33
// @Runtime: 0 ms
// @Memory: 41.5 MB

class Solution {
    // 注意，最后一个台阶之后才是楼顶（越过最后一个台阶），而不是到达最后一个台阶。
    // 无力吐槽
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int dp1 = 0;
        int dp2 = 0;
        int i = 2;
        // 要越过最后一个台阶
        while (i <= n) {
            int dp = Math.min(dp1 + cost[i - 2], dp2 + cost[i - 1]);
            dp1 = dp2;
            dp2 = dp;
            i++;
        }

        return dp2;
    }
}
