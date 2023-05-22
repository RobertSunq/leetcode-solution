
```
// @Title: 丑数 (丑数 LCOF)
// @Author: robert.sunq
// @Date: 2021-05-30 01:19:59
// @Runtime: 2 ms
// @Memory: 37.7 MB

class Solution {
    public int nthUglyNumber(int n) {
        // t2,t3,t5 表示乘数对应的前一个数
        int i = 1,t2 = 0,t3=0,t5 = 0;
        int a , b , c;
        int[] dp = new int[n+1];
        dp[0] = 1;
        while(i<n){
            a = dp[t2]*2;
            b = dp[t3]*3;
            c = dp[t5]*5;
            // 如果乘2 最小，则指针后移
            dp[i] = Math.min(Math.min(a, b), c);
            // 采用连续的If而不是  if else 的原因在于 相等的时候，都往各自的标志位均往后移动，避免重复计算
            if(dp[i] == a) t2++;
            if(dp[i] == b) t3++;
            if(dp[i] == c) t5++;
            i++;
        }
        return dp[n-1];
    }
}
