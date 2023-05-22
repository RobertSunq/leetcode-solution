
```
// @Title: 可被三整除的最大和 (Greatest Sum Divisible by Three)
// @Author: robert.sunq
// @Date: 2020-05-13 00:17:08
// @Runtime: 80 ms
// @Memory: 23 MB

class Solution {
public:
    int maxSumDivThree(vector<int>& nums) {
        int dp[3] = {0,0,0};
        for (int i=0;i<nums.size();i++){
            int mod = nums[i]%3;
            int a = dp[(3+0-mod) %3];
            int b = dp[(3+1-mod) %3];
            int c = dp[(3+2-mod) %3];

            if(a|| mod == 0) dp[0] = max(dp[0],a+nums[i]);
            if(b|| mod == 1) dp[1] = max(dp[1],b+nums[i]);
            if(c|| mod == 2) dp[2] = max(dp[2],c+nums[i]);
        }
        return dp[0];
    }
};
