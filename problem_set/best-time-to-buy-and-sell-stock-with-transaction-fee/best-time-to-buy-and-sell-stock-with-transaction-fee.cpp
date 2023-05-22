
```
// @Title: 买卖股票的最佳时机含手续费 (Best Time to Buy and Sell Stock with Transaction Fee)
// @Author: robert.sunq
// @Date: 2020-05-12 23:54:10
// @Runtime: 224 ms
// @Memory: 50.5 MB

class Solution {
public:
    int maxProfit(vector<int>& prices, int fee) {
        int n= prices.size();
        int dp_i0 = 0,dp_i1 = INT_MIN;
        for (int i=0;i<n;i++){
            int temp = dp_i0;
            dp_i0 = max(dp_i0,dp_i1+prices[i]);
            dp_i1 = max(dp_i1,temp-prices[i]-fee);
        }
        return dp_i0;

    }
};
