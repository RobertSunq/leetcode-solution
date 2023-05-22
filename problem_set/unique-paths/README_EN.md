
| English | [简体中文](README.md) |

# [62. Unique Paths](https://leetcode.cn//problems/unique-paths/)

## Description

<p>There is a robot on an <code>m x n</code> grid. The robot is initially located at the <strong>top-left corner</strong> (i.e., <code>grid[0][0]</code>). The robot tries to move to the <strong>bottom-right corner</strong> (i.e., <code>grid[m - 1][n - 1]</code>). The robot can only move either down or right at any point in time.</p>

<p>Given the two integers <code>m</code> and <code>n</code>, return <em>the number of possible unique paths that the robot can take to reach the bottom-right corner</em>.</p>

<p>The test cases are generated so that the answer will be less than or equal to <code>2 * 10<sup>9</sup></code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img src="https://assets.leetcode.com/uploads/2018/10/22/robot_maze.png" style="width: 400px; height: 183px;" />
<pre>
<strong>Input:</strong> m = 3, n = 7
<strong>Output:</strong> 28
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> m = 3, n = 2
<strong>Output:</strong> 3
<strong>Explanation:</strong> From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -&gt; Down -&gt; Down
2. Down -&gt; Down -&gt; Right
3. Down -&gt; Right -&gt; Down
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= m, n &lt;= 100</code></li>
</ul>


## Solutions


### C++

```C++
// @Title: 不同路径 (Unique Paths)
// @Author: robert.sunq
// @Date: 2020-05-14 11:48:50
// @Runtime: 0 ms
// @Memory: 6.1 MB

class Solution {
public:
    int uniquePaths(int m, int n) {
        vector<int>dp(n,1);
        if(m<2) return 1;
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                
                    dp[j] = dp[j]+dp[j-1];
                
            }
        
        }
        return dp[n-1];
        
    }
};
```



### Java

```Java
// @Title: 不同路径 (Unique Paths)
// @Author: robert.sunq
// @Date: 2021-06-04 23:51:00
// @Runtime: 0 ms
// @Memory: 35.2 MB

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // 到上边界个点的 左边界个点的 路径均只有有一种
        for(int i = 0 ; i<m;i++){
            dp[i][0] = 1;
        }
        for(int j = 0 ; j<n;j++){
            dp[0][j] = 1;
        }

        // 动态规划  到达位置do[i][j] 的路径为 dp[i-1][j] + dp[i][j-1]的和
        for(int i = 1 ; i<m;i++){
            for(int j = 1;j<n;j++){
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }

        return dp[m-1][n-1];
    }
}
```



## Related Topics

- [Math](https://leetcode.cn//tag/math)
- [Dynamic Programming](https://leetcode.cn//tag/dynamic-programming)
- [Combinatorics](https://leetcode.cn//tag/combinatorics)

## Similar Questions

- [Unique Paths II](../unique-paths-ii/README_EN.md)
- [Minimum Path Sum](../minimum-path-sum/README_EN.md)
- [Dungeon Game](../dungeon-game/README_EN.md)
