
```
// @Title: 打家劫舍 II (House Robber II)
// @Author: robert.sunq
// @Date: 2021-07-11 23:23:46
// @Runtime: 0 ms
// @Memory: 35.9 MB

class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        // 0 第一间房子偷 1 第一间房子不偷
        int[][] dp = new int[nums.length][2];
        dp[0][0] = nums[0];
        dp[1][0] = Math.max(nums[0],nums[1]);
        dp[0][1] = 0;
        dp[1][1] = nums[1];
        // 
        for(int i = 2;i<nums.length;i++){
            // 最后一间房子
            if(i == nums.length-1){
                dp[i][0] = dp[i-1][0];
                dp[i][1] = Math.max(dp[i-2][1] + nums[i],dp[i-1][1]);
            }else{
                dp[i][0] = Math.max(dp[i-2][0]+nums[i],dp[i-1][0]);
                dp[i][1] = Math.max(dp[i-2][1]+nums[i],dp[i-1][1]);
            }
        }
        return Math.max(dp[nums.length-1][0],dp[nums.length-1][1]);
    }
}
