
```
// @Title: 买卖股票的最佳时机 III (Best Time to Buy and Sell Stock III)
// @Author: robert.sunq
// @Date: 2020-05-12 23:07:49
// @Runtime: 16 ms
// @Memory: 12.7 MB

class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int dp_i10 = 0,dp_i11 =  INT_MIN;
        int dp_i20 = 0,dp_i21 =  INT_MIN;
        for(int i = 0;i<prices.size();i++){
            dp_i20 = max(dp_i20,dp_i21+prices[i]);
            dp_i21 = max(dp_i21,dp_i10 - prices[i]);
            dp_i10 = max(dp_i10,dp_i11 + prices[i]);
            dp_i11 = max(dp_i11,-prices[i]);
        }
        return dp_i20;

    }
};

