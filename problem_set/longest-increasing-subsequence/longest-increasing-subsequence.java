
```
// @Title: 最长递增子序列 (Longest Increasing Subsequence)
// @Author: robert.sunq
// @Date: 2021-06-19 17:26:33
// @Runtime: 71 ms
// @Memory: 37.8 MB

class Solution {
    public int lengthOfLIS(int[] nums) {
        int res = 0;
        // 保存当前位置的最大序列长度
        int[] dp = new int[nums.length];
        for(int i = 0 ;i<nums.length;i++){
            dp[i] = 1;
            // 状态方程是  当前位置的长度，为此之前小于该位置的最大序列长度 + 1
            for(int j=i-1;j>=0;j--){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
