
| English | [简体中文](README.md) |

# [688. Knight Probability in Chessboard](https://leetcode.cn//problems/knight-probability-in-chessboard/)

## Description

<p>On an <code>n x n</code> chessboard, a knight starts at the cell <code>(row, column)</code> and attempts to make exactly <code>k</code> moves. The rows and columns are <strong>0-indexed</strong>, so the top-left cell is <code>(0, 0)</code>, and the bottom-right cell is <code>(n - 1, n - 1)</code>.</p>

<p>A chess knight has eight possible moves it can make, as illustrated below. Each move is two cells in a cardinal direction, then one cell in an orthogonal direction.</p>
<img src="https://assets.leetcode.com/uploads/2018/10/12/knight.png" style="width: 300px; height: 300px;" />
<p>Each time the knight is to move, it chooses one of eight possible moves uniformly at random (even if the piece would go off the chessboard) and moves there.</p>

<p>The knight continues moving until it has made exactly <code>k</code> moves or has moved off the chessboard.</p>

<p>Return <em>the probability that the knight remains on the board after it has stopped moving</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = 3, k = 2, row = 0, column = 0
<strong>Output:</strong> 0.06250
<strong>Explanation:</strong> There are two moves (to (1,2), (2,1)) that will keep the knight on the board.
From each of those positions, there are also two moves that will keep the knight on the board.
The total probability the knight stays on the board is 0.0625.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 1, k = 0, row = 0, column = 0
<strong>Output:</strong> 1.00000
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 25</code></li>
	<li><code>0 &lt;= k &lt;= 100</code></li>
	<li><code>0 &lt;= row, column &lt;= n - 1</code></li>
</ul>


## Solutions


### C++

```C++
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
```



## Related Topics

- [Dynamic Programming](https://leetcode.cn//tag/dynamic-programming)

## Similar Questions

- [Out of Boundary Paths](../out-of-boundary-paths/README_EN.md)
