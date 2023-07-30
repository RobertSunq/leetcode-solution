
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer II 098. 路径的数目](https://leetcode.cn//problems/2AoeFn/)

## 题目描述

<p>一个机器人位于一个 <code>m x n</code><em>&nbsp;</em>网格的左上角 （起始点在下图中标记为 &ldquo;Start&rdquo; ）。</p>

<p>机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 &ldquo;Finish&rdquo; ）。</p>

<p>问总共有多少条不同的路径？</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img src="https://assets.leetcode.com/uploads/2018/10/22/robot_maze.png" /></p>

<pre>
<strong>输入：</strong>m = 3, n = 7
<strong>输出：</strong>28</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>m = 3, n = 2
<strong>输出：</strong>3
<strong>解释：</strong>
从左上角开始，总共有 3 条路径可以到达右下角。
1. 向右 -&gt; 向下 -&gt; 向下
2. 向下 -&gt; 向下 -&gt; 向右
3. 向下 -&gt; 向右 -&gt; 向下
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

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= m, n &lt;= 100</code></li>
	<li>题目数据保证答案小于等于 <code>2 * 10<sup>9</sup></code></li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 62&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/unique-paths/">https://leetcode-cn.com/problems/unique-paths/</a></p>


## 题解


### Java

```Java
// @Title: 路径的数目 (路径的数目)
// @Author: robert.sunq
// @Date: 2023-07-30 23:37:29
// @Runtime: 0 ms
// @Memory: 37.7 MB

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1];
                } else if ( j == 0) {
                    dp[i][j] = dp[i -1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i] [ j -1];
                }
            }
        }

        return dp[m - 1][ n - 1];
    }
}
```



## 相关话题

- [数学](https://leetcode.cn//tag/math)
- [动态规划](https://leetcode.cn//tag/dynamic-programming)
- [组合数学](https://leetcode.cn//tag/combinatorics)

## 相似题目



