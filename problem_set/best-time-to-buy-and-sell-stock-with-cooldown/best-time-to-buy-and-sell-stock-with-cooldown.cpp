
```
// @Title: 最佳买卖股票时机含冷冻期 (Best Time to Buy and Sell Stock with Cooldown)
// @Author: robert.sunq
// @Date: 2020-05-12 23:50:37
// @Runtime: 4 ms
// @Memory: 11 MB

class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int n= prices.size();
        int dp_i0 = 0,dp_i1 = INT_MIN;
        int dp_pre_0 = 0;
        for (int i=0;i<n;i++){
            int temp = dp_i0;
            dp_i0 = max(dp_i0,dp_i1+prices[i]);
            dp_i1 = max(dp_i1,dp_pre_0 - prices[i]);
            dp_pre_0 = temp;
        }
        return dp_i0;

    }
};
