
```
// @Title: 跳跃游戏 II (Jump Game II)
// @Author: robert.sunq
// @Date: 2021-08-02 23:59:18
// @Runtime: 53 ms
// @Memory: 38.9 MB

class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        // 初始化需要跳跃的次数状态数组，第I格最多需要I次
        for(int i = 0;i<nums.length;i++){
            dp[i] = i;
        }
        for(int i=0;i<nums.length;i++){
            // 当前位置可跳跃范围中 最少次数为 （当前位置次数+1，或者原本的次数）
            for(int j = i+1;j<=i+nums[i] && j<nums.length;j++){
                dp[j] = Math.min(dp[i]+1,dp[j]);
            }
        }
        return dp[nums.length-1];
    }
}
