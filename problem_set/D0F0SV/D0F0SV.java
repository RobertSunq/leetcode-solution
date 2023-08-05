
```
// @Title: 组合总和 Ⅳ (组合总和 Ⅳ)
// @Author: robert.sunq
// @Date: 2023-08-02 23:44:14
// @Runtime: 1 ms
// @Memory: 38.5 MB

class Solution {
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target + 1];
        // 不选元素的时候，和才是 0， 所以只有一种情况
        dp[0] = 1;

        // 当和为 i 时， 如果存在一种排列，其中的元素之后等于 i， 则该排列的最后一个元素一定是数组中第一个
        // 所以，dp[i] ，就是所有的 dp[i - num] 的和
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) {
                    // 当最后一位时 num 时， 则dp[i] 的个数应该加上 和为 i - num 的个数
                    dp[i] = dp[i] +  dp[i - num];
                }
            }
        }

        return dp[target];

    }
}
