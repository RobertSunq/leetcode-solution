
| [English](README_EN.md) | 简体中文 |

# [62. 不同路径](https://leetcode.cn//problems/unique-paths/)

## 题目描述

<p>一个机器人位于一个 <code>m x n</code><em> </em>网格的左上角 （起始点在下图中标记为 “Start” ）。</p>

<p>机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。</p>

<p>问总共有多少条不同的路径？</p>

<p> </p>

<p><strong>示例 1：</strong></p>
<img src="https://assets.leetcode.com/uploads/2018/10/22/robot_maze.png" />
<pre>
<strong>输入：</strong>m = 3, n = 7
<strong>输出：</strong>28</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>m = 3, n = 2
<strong>输出：</strong>3
<strong>解释：</strong>
从左上角开始，总共有 3 条路径可以到达右下角。
1. 向右 -> 向下 -> 向下
2. 向下 -> 向下 -> 向右
3. 向下 -> 向右 -> 向下
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>m = 7, n = 3
<strong>输出：</strong>28
</pre>

<p><strong>示例 4：</strong></p>

<pre>
<strong>输入：</strong>m = 3, n = 3
<strong>输出：</strong>6</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= m, n <= 100</code></li>
	<li>题目数据保证答案小于等于 <code>2 * 10<sup>9</sup></code></li>
</ul>


## 题解


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



## 相关话题

- [数学](https://leetcode.cn//tag/math)
- [动态规划](https://leetcode.cn//tag/dynamic-programming)
- [组合数学](https://leetcode.cn//tag/combinatorics)

## 相似题目


- [不同路径 II](../unique-paths-ii/README.md)
- [最小路径和](../minimum-path-sum/README.md)
- [地下城游戏](../dungeon-game/README.md)
