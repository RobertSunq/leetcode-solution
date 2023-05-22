
```
// @Title: 骑士在棋盘上的概率 (Knight Probability in Chessboard)
// @Author: robert.sunq
// @Date: 2020-05-13 00:11:57
// @Runtime: 16 ms
// @Memory: 8.5 MB

class Solution {
public:
    double knightProbability(int N, int K, int r, int c) {
        if(N == 0) return 0;
        vector<vector<vector<double> > > dp(N+4,vector<vector<double> > (N+4 , vector<double>(K+1))) ;
        for(int i=0;i<N+4;i++){
            for (int j=0;j<N+4;j++){
                if(i>=2 && i<=N+1){
                    if(j>=2 && j<= N+1){
                        dp[i][j][0] = 1;
                    }

                }
                else{
                    dp[i][j][0] = 0;
                }
            }
        }
        for(int k=1;k<=K;k++){
            for (int i=2;i<=N+1;i++){
                for(int j=2;j<=N+1;j++){
                    dp[i][j][k] = (dp[i - 2][j - 1][k - 1] + dp[i - 2][j + 1][k - 1] + \
							   dp[i - 1][j - 2][k - 1] + dp[i - 1][j + 2][k - 1] + \
					           dp[i + 1][j - 2][k - 1] + dp[i + 1][j + 2][k - 1] + \
					           dp[i + 2][j - 1][k - 1] + dp[i + 2][j + 1][k - 1]) / 8.0;

                }
            }
        }
        return dp[r+2][c+2][K];
    }
};
