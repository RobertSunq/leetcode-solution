
```
// @Title: 不同路径 (Unique Paths)
// @Author: robert.sunq
// @Date: 2020-05-14 11:48:50
// @Runtime: 0 ms
// @Memory: 6.1 MB

class Solution {
public:
    int uniquePaths(int m, int n) {
        vector<int>dp(n,1);
        if(m<2) return 1;
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                
                    dp[j] = dp[j]+dp[j-1];
                
            }
        
        }
        return dp[n-1];
        
    }
};
