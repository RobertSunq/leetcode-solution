
```
// @Title: 买卖股票的最佳时机 II (Best Time to Buy and Sell Stock II)
// @Author: robert.sunq
// @Date: 2020-05-12 22:37:41
// @Runtime: 8 ms
// @Memory: 7 MB

class Solution {
public:
    int maxProfit(vector<int>& prices) {
        
        int temp[2] = {0};
        int out = 0;
        for(int i=1;i<prices.size();i++){
            if((prices[i]-prices[i-1])>0) out=out+prices[i]-prices[i-1];
        }
        return out;
    }
};
