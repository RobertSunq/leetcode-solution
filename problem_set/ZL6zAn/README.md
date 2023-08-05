
| [English](README_EN.md) | 简体中文 |

# [LCR 105. 岛屿的最大面积](https://leetcode.cn//problems/ZL6zAn/)

## 题目描述

<p>给定一个由&nbsp;<code>0</code> 和 <code>1</code> 组成的非空二维数组&nbsp;<code>grid</code>&nbsp;，用来表示海洋岛屿地图。</p>

<p>一个&nbsp;<strong>岛屿</strong>&nbsp;是由一些相邻的&nbsp;<code>1</code>&nbsp;(代表土地) 构成的组合，这里的「相邻」要求两个 <code>1</code> 必须在水平或者竖直方向上相邻。你可以假设&nbsp;<code>grid</code> 的四个边缘都被 <code>0</code>（代表水）包围着。</p>

<p>找到给定的二维数组中最大的岛屿面积。如果没有岛屿，则返回面积为 <code>0</code> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<p><img alt="" src="https://pic.leetcode-cn.com/1626667010-nSGPXz-image.png" style="width: 452px; " /></p>

<pre>
<strong>输入: </strong>grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
<strong>输出: </strong>6
<strong>解释: </strong>对于上面这个给定矩阵应返回&nbsp;<code>6</code>。注意答案不应该是 <code>11</code> ，因为岛屿只能包含水平或垂直的四个方向的 <code>1</code> 。</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入: </strong>grid = [[0,0,0,0,0,0,0,0]]
<strong>输出: </strong>0</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>m == grid.length</code></li>
	<li><code>n == grid[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 50</code></li>
	<li><code>grid[i][j] is either 0 or 1</code></li>
</ul>

<p>&nbsp;</p>

<p>注意：本题与主站 695&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/max-area-of-island/">https://leetcode-cn.com/problems/max-area-of-island/</a></p>


## 题解


### Java

```Java
// @Title: 岛屿的最大面积 (岛屿的最大面积)
// @Author: robert.sunq
// @Date: 2023-08-03 00:58:36
// @Runtime: 5 ms
// @Memory: 42.6 MB

class Solution {


    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        Stack<int[]> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (visited[i][j] || grid[i][j] == 0) {
                    visited[i][j] = true;
                    continue;
                }
                int tmp = 0;
                st.add(new int[]{i,j});
                visited[i][j] = true;
                while (!st.isEmpty()) {
                    int[] index = st.pop();
                    tmp++;
                    // 上
                    if(index[0] > 0 && grid[index[0]-1][index[1]] == 1 && !visited[index[0]-1][index[1]]) {
                        st.add(new int[]{index[0]-1, index[1]});
                        // 注意这里需要提前标记下，避免重复计算
                        visited[index[0] - 1][index[1]] = true;
                    }
                    // 左
                    if (index[1] > 0 && grid[index[0]][index[1] - 1] == 1 && !visited[index[0]][index[1] - 1]) {
                        st.add(new int[]{index[0], index[1] - 1});
                        // 注意这里需要提前标记下，避免重复计算
                        visited[index[0]][index[1] - 1] = true;
                    }
                    // 下
                    if(index[0] < n-1 && grid[index[0]+1][index[1]] == 1 && !visited[index[0]+1][index[1]]) {
                        st.add(new int[]{index[0]+1, index[1]});
                        // 注意这里需要提前标记下，避免重复计算
                        visited[index[0] + 1][index[1]] = true;
                    }
                    // 右
                    if (index[1] < m - 1 && grid[index[0]][index[1] + 1] == 1 && !visited[index[0]][index[1] + 1]) {
                        st.add(new int[]{index[0], index[1]+1});
                        // 注意这里需要提前标记下，避免重复计算
                        visited[index[0]][index[1] + 1] = true;
                    }
                }

                ans = Math.max(ans, tmp);
            }
        }

        return ans;
    }
}
```



## 相关话题

- [深度优先搜索](https://leetcode.cn//tag/depth-first-search)
- [广度优先搜索](https://leetcode.cn//tag/breadth-first-search)
- [并查集](https://leetcode.cn//tag/union-find)
- [数组](https://leetcode.cn//tag/array)
- [矩阵](https://leetcode.cn//tag/matrix)

## 相似题目



