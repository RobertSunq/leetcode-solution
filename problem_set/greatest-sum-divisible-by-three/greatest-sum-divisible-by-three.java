
```
// @Title: 可被三整除的最大和 (Greatest Sum Divisible by Three)
// @Author: robert.sunq
// @Date: 2021-08-02 23:50:11
// @Runtime: 8 ms
// @Memory: 44.6 MB

class Solution {
    public int maxSumDivThree(int[] nums) {
        // 保存当前状态下，和对三取余  余 0 ，1 ，2 的最大和
        int[] dp = new int[3];

        for(int i=0;i<nums.length;i++){
            // 将动态规划变为事前处理

            // 当前位对三取余
            int mod = nums[i]%3;
            // 表示当前位如果要凑成对3取余为0，需要再哪个余数 和的基础上增加
            int a = dp[(3 + 0 - mod) % 3];
            // 表示当前位如果要凑成对3取余为1，。。。。
            int b = dp[(3 + 1 - mod) % 3];
            // 表示当前位如果要凑成对3取余为2，。。。。
            int c = dp[(3 + 2 - mod) % 3];
            
            // 求和
            if(a>0 || mod == 0){
                dp[0] = Math.max(dp[0],a+nums[i]);
            }
            if(b>0 || mod == 1){
                dp[1] = Math.max(dp[1],b+nums[i]);
            }
            if(c>0 || mod == 2){
                dp[2] = Math.max(dp[2],c+nums[i]);
            }
        }

        return dp[0];
    }
}
