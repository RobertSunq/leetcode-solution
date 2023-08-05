
```
// @Title: 分割等和子集 (分割等和子集)
// @Author: robert.sunq
// @Date: 2023-08-01 00:05:23
// @Runtime: 43 ms
// @Memory: 44.3 MB

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        PriorityQueue<Integer> p = new PriorityQueue<>();
   
        for (int n : nums) {
            sum = sum + n;
            p.offer(n);
        }

        
        if ( (sum & 1) == 1) {
            return false;
        }
        int n = nums.length;
        // 0  ---- i 的和是否可以为j
        int halfSum = sum / 2;
        boolean[][] dp = new boolean[n + 1][halfSum + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= halfSum; j++) {
                // 和为 0 ，及任何一个数字都不选
                if (j == 0) {
                    dp[i][j] = true;
                    continue;
                }
                // 只有数字只有一种情况和为 num[0]
                if (i == 0) {
                    if (nums[i] <= halfSum) {
                        dp[i][nums[i]] = true;
                    }
                    break;
                }
                int tmp = j - nums[i];
                if (tmp < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][tmp];
                }
            }
        }

        return dp[n-1][halfSum];
    }
}
