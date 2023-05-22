
```
// @Title: 剪绳子 (剪绳子  LCOF)
// @Author: robert.sunq
// @Date: 2021-05-25 22:22:22
// @Runtime: 1 ms
// @Memory: 35.1 MB

class Solution {
    public int cuttingRope(int n) {
        if(n<3) return 1;
        int[] dp = new int[n+1];
        dp[1]=1;dp[2]=1;
        for (int i = 3;i<=n;i++){
            for (int j = 2 ;j<i;j++){
                // 及长度为i是，最大长度应该是 (i-j) 还是 （j*dp[i-j]）绳子长为i-j的最大值 还是当前剪j不是最优解
                dp[i] = Math.max(dp[i],Math.max((j*(i-j)) ,(j*dp[i-j])));
            }
        }
        return dp[n];
    }
}
