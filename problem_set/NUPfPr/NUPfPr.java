
```
// @Title: 分割等和子集 (分割等和子集)
// @Author: robert.sunq
// @Date: 2024-03-01 11:36:10
// @Runtime: 50 ms
// @Memory: 44 MB

class Solution {
    public boolean canPartition(int[] nums) {
                int n = nums.length;
        int sum = 0;
        for (int a : nums) {
            sum += a;
        }
        if ((sum & 1) == 1) {
            return false;
        }

        int halfSum = sum / 2;
        // 行表示 前序和，列表示 0 - i 的数组序列
        boolean[][] dp = new boolean[n][halfSum + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= halfSum; j++) {
                // 和为0的时候，表示一个数字都不选为一组
                if (j == 0) {
                    dp[i][j] = true;
                    continue;
                }
                // 第一个数，没有前置数，单独判断可以达到的 前序和
                if (i == 0) {
                    if (nums[i] <= halfSum) {
                        dp[i][nums[i]] = true;
                    }
                    break;
                }

                // 表示 当前数不参与 前序和
                dp[i][j] = dp[i - 1][j];
                // 表示 当前数可以参与 前序和
                if (j - nums[i] >= 0) {
                    // 则能否组成该和，等于 参与 ｜｜ 不参与
                    dp[i][j] = dp[i - 1][j - nums[i]] || dp[i - 1][j];
                }
            }
        }
        return dp[n-1][halfSum];
    }
}
