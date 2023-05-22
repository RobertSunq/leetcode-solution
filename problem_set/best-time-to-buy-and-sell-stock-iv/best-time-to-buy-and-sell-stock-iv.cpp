
```
// @Title: 买卖股票的最佳时机 IV (Best Time to Buy and Sell Stock IV)
// @Author: robert.sunq
// @Date: 2020-05-12 23:38:42
// @Runtime: 104 ms
// @Memory: 21.4 MB

class Solution {
public:
    int maxProfit(int k, vector<int>& prices) {
        
        int n = prices.size();
        if(k>=n/2) {
            int dp_i0 = 0,dp_i1 = INT_MIN;
            for (int i=0;i<n;i++){
                int temp = dp_i0;
                dp_i0 = max(dp_i0,dp_i1+prices[i]);
                dp_i1 = max(dp_i1,temp - prices[i]);
            }
            return dp_i0;
        }
        else{
            int dp[n][k+1][2];
            for(int i=0;i<n;i++){
                for(int j = k;j>=1;j--){
                    if(i==0){
                        dp[i][j][0] = 0;
                        dp[i][j][1] = -prices[i];
                    }
                    else{
                    
                    dp[i][j][0] = max(dp[i-1][j][0] , dp[i-1][j][1]+prices[i]);
                    dp[i][j][1] = max(dp[i][j][1],dp[i-1][j-1][0]-prices[i]);
                }}
            }
            return dp[n-1][k][0];
        }

    }
};
