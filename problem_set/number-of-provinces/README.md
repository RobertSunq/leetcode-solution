
| [English](README_EN.md) | 简体中文 |

# [547. 省份数量](https://leetcode.cn//problems/number-of-provinces/)

## 题目描述

<div class="original__bRMd">
<div>
<p>有 <code>n</code> 个城市，其中一些彼此相连，另一些没有相连。如果城市 <code>a</code> 与城市 <code>b</code> 直接相连，且城市 <code>b</code> 与城市 <code>c</code> 直接相连，那么城市 <code>a</code> 与城市 <code>c</code> 间接相连。</p>

<p><strong>省份</strong> 是一组直接或间接相连的城市，组内不含其他没有相连的城市。</p>

<p>给你一个 <code>n x n</code> 的矩阵 <code>isConnected</code> ，其中 <code>isConnected[i][j] = 1</code> 表示第 <code>i</code> 个城市和第 <code>j</code> 个城市直接相连，而 <code>isConnected[i][j] = 0</code> 表示二者不直接相连。</p>

<p>返回矩阵中 <strong>省份</strong> 的数量。</p>

<p> </p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/12/24/graph1.jpg" style="width: 222px; height: 142px;" />
<pre>
<strong>输入：</strong>isConnected = [[1,1,0],[1,1,0],[0,0,1]]
<strong>输出：</strong>2
</pre>

<p><strong>示例 2：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/12/24/graph2.jpg" style="width: 222px; height: 142px;" />
<pre>
<strong>输入：</strong>isConnected = [[1,0,0],[0,1,0],[0,0,1]]
<strong>输出：</strong>3
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= n <= 200</code></li>
	<li><code>n == isConnected.length</code></li>
	<li><code>n == isConnected[i].length</code></li>
	<li><code>isConnected[i][j]</code> 为 <code>1</code> 或 <code>0</code></li>
	<li><code>isConnected[i][i] == 1</code></li>
	<li><code>isConnected[i][j] == isConnected[j][i]</code></li>
</ul>
</div>
</div>


## 题解


### Java

```Java
// @Title: 省份数量 (Number of Provinces)
// @Author: robert.sunq
// @Date: 2023-09-09 22:52:10
// @Runtime: 5 ms
// @Memory: 44.7 MB

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int ans = 0;
        int n = isConnected.length;
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visit = new boolean[n];
        for (int i = 0; i<n; i++) {
            if(!visit[i]) {
                q.add(i);
                while (!q.isEmpty()) {
                    int t = q.poll();
                    visit[t] = true;
                    for (int j = 0; j <n ; j++) {
                        if (!visit[j] && isConnected[t][j] == 1) {
                            q.add(j);
                        }
                    }
                }
                ans++;
            }
        }

        return ans;
    }

    public int findCircleNumDFS(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visit = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                dfs(visit, isConnected, i, n);
                ans++;
            }
        }
        return ans;
    }

    public void dfs(boolean[] visit, int[][] isConnected, int i, int n) {
        for (int j = 0; j < n; j++) {
            if (isConnected[i][j] == 1 && !visit[j]) {
                visit[j] = true;
                dfs(visit, isConnected, j, n);
            }
        }
    }
}
```



## 相关话题

- [深度优先搜索](https://leetcode.cn//tag/depth-first-search)
- [广度优先搜索](https://leetcode.cn//tag/breadth-first-search)
- [并查集](https://leetcode.cn//tag/union-find)
- [图](https://leetcode.cn//tag/graph)

## 相似题目


- [无向图中连通分量的数目](../number-of-connected-components-in-an-undirected-graph/README.md)
- [机器人能否返回原点](../robot-return-to-origin/README.md)
- [句子相似性](../sentence-similarity/README.md)
- [句子相似性 II](../sentence-similarity-ii/README.md)
- [彼此熟识的最早时间](../the-earliest-moment-when-everyone-become-friends/README.md)
