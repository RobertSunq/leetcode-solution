
```
// @Title: 比特位计数 (Counting Bits)
// @Author: robert.sunq
// @Date: 2021-06-20 00:32:51
// @Runtime: 2 ms
// @Memory: 42.3 MB

class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n+1];

        for(int i=1;i<=n;i++){
            // 奇数的一个数，是其前一个1个数 + 1
            if(i % 2 == 1){
                dp[i] = dp[i-1]+1;
            }else{
                // 偶数的一的个数  与 其右移后一的个数相同， 因为出去了最后的0
                dp[i] = dp[i>>1];
            }
        }
        return dp;
    }
}
