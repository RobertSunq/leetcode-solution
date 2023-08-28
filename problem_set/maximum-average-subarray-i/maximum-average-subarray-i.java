
```
// @Title: 子数组最大平均数 I (Maximum Average Subarray I)
// @Author: robert.sunq
// @Date: 2023-08-16 22:16:15
// @Runtime: 6 ms
// @Memory: 54.1 MB

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double max = Integer.MIN_VALUE;
        int n = nums.length;
        int preSum[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = nums[i - 1] + preSum[i - 1];
        }
        double kk = (double) k;
        for (int i = k; i <= n ; i++) {
            max = Math.max(max, (preSum[i] - preSum[i - k]) / kk);
        }

        return max;
        
    }
}
