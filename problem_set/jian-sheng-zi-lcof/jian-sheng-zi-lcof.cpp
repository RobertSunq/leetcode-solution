
```
// @Title: 剪绳子 (剪绳子  LCOF)
// @Author: robert.sunq
// @Date: 2020-05-14 13:25:51
// @Runtime: 0 ms
// @Memory: 5.9 MB

class Solution {
public:
    int cuttingRope(int n) {
        vector <int> dp(n+1,0);
        if(n<3) return 1;
        dp[0] = 1;
        for(int i=1;i<=(n+1)/2;i++){
            for(int j=i;j<=n;j++)
                {   
                    dp[j] = max(dp[j],dp[j-i]*i);
                }
        }
        return dp[n];
    }
};
