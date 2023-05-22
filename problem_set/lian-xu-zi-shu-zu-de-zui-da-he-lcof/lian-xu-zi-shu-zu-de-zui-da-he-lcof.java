
```
// @Title: 连续子数组的最大和 (连续子数组的最大和  LCOF)
// @Author: robert.sunq
// @Date: 2021-05-29 00:20:06
// @Runtime: 2 ms
// @Memory: 44.9 MB

class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        // dp[i]  = Math.max(nums[i],dp[i-1]+nums[i] 
        // 及长度为I时,如果加上前面的最大值产生负增益效果，则新的连续串从当前位置开始
        // dp[i] 是以nums[i] 结尾的连续子数组最大值，以nums[i] 结尾是为了保证下一个状态组是连续的
        if (len <= 0) return -1;
        for(int i=1;i<len;i++){
            dp[i] = Math.max(nums[i],dp[i-1]+nums[i]);
        } 
        int res = dp[0];
        for(int i=1;i<len;i++){
            res = Math.max(dp[i],res);
        } 
        return res;
    }
}
