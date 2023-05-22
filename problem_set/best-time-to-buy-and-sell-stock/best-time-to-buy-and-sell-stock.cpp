
```
// @Title: 买卖股票的最佳时机 (Best Time to Buy and Sell Stock)
// @Author: robert.sunq
// @Date: 2020-05-12 22:32:24
// @Runtime: 12 ms
// @Memory: 12.7 MB

class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int temp[2];
        temp[0] = 0;
        temp[1] =0 ;
        int max = 0 ;
        for(int i=1;i<prices.size();i++){
            if((prices[i]-prices[temp[0]]) > max) {
                max = prices[i]-prices[temp[0]];
                temp[1] = i;
            }
            if(prices[i] < prices[temp[0]]) temp[0] = i;
        }
        return max;
    }
};
