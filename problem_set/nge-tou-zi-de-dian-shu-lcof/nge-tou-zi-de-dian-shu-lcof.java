
```
// @Title: n个骰子的点数 (n个骰子的点数  LCOF)
// @Author: robert.sunq
// @Date: 2021-05-31 23:45:56
// @Runtime: 1 ms
// @Memory: 38.5 MB

class Solution {
    int[] sum , num;
    int[] dict = {0,1,2,3,4,5,6};
    int N;
    public double[] dicesProbability(int n) {
        // i 表示第几个骰子，j表示和
        int[][] dp = new int[n+1][n*6+1];
        // 第一个骰子，也是边界初始化
        for(int i=1;i<=6;i++){
            dp[1][i] = 1;
        }
        for(int i =2;i<=n;i++){
            // 第i个骰子之后的和
            for (int j=i;j<=n*6;j++){
                // 第i个骰子投 1 —— 6
                for (int cur = 1;cur<=6;cur++){
                    // 前 i-1 个骰子的和不能小于一
                    if(j-cur < 1) break;
                    // 状态转移
                    dp[i][j] = dp[i][j]+dp[i-1][j-cur];
                }
            }
        }
        double sum = Math.pow(6,n);
        double[] res = new double[5*n+1];
        for(int i = n;i<=6*n;i++){
            res[i-n] = dp[n][i]/sum;
        }

        return res;
    }
}
