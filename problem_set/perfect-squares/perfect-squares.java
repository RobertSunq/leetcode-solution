
```
// @Title: 完全平方数 (Perfect Squares)
// @Author: robert.sunq
// @Date: 2021-06-18 23:02:16
// @Runtime: 1262 ms
// @Memory: 37.4 MB

class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for (int i =0;i<=n;i++){
            // 假设全部都是 1 组成
            dp[i] = i;
            // // j 代表组成当前数的一个 平方根  即 i = J*J + k  
            // for(int j=1;j*j<=i;j++){
            //     dp[i] = Math.min(dp[i],dp[i - j*j] +1);
            // }
            
            // 此时 j 表示 当前数的一个组成 i = j + k
            for(int j = 1; j * 2<= i;j++){
                if(i == j*j ){
                    dp[i] = 1;
                    break;
                } 
                else dp[i] = Math.min(dp[i] , dp[i-j]+dp[j]);
            }
        }
        return dp[n];
    }
}
