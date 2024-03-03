
```
// @Title: 打家劫舍 (House Robber)
// @Author: robert.sunq
// @Date: 2023-09-21 21:21:20
// @Runtime: 0 ms
// @Memory: 38.8 MB

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return nums[0];
        }

        int dp0 = nums[0];
        int dp1 = Math.max(dp0, nums[1]);
        int i = 2;
        while (i < n) {
            int tmp = Math.max(dp0 + nums[i], dp1);
            dp0 = dp1;
            dp1 = tmp;
            i++;
        }
        return dp1;
    }
}
