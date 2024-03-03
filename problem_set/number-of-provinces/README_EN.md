
| English | [简体中文](README.md) |

# [547. Number of Provinces](https://leetcode.cn//problems/number-of-provinces/)

## Description

<p>There are <code>n</code> cities. Some of them are connected, while some are not. If city <code>a</code> is connected directly with city <code>b</code>, and city <code>b</code> is connected directly with city <code>c</code>, then city <code>a</code> is connected indirectly with city <code>c</code>.</p>

<p>A <strong>province</strong> is a group of directly or indirectly connected cities and no other cities outside of the group.</p>

<p>You are given an <code>n x n</code> matrix <code>isConnected</code> where <code>isConnected[i][j] = 1</code> if the <code>i<sup>th</sup></code> city and the <code>j<sup>th</sup></code> city are directly connected, and <code>isConnected[i][j] = 0</code> otherwise.</p>

<p>Return <em>the total number of <strong>provinces</strong></em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/12/24/graph1.jpg" style="width: 222px; height: 142px;" />
<pre>
<strong>Input:</strong> isConnected = [[1,1,0],[1,1,0],[0,0,1]]
<strong>Output:</strong> 2
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/12/24/graph2.jpg" style="width: 222px; height: 142px;" />
<pre>
<strong>Input:</strong> isConnected = [[1,0,0],[0,1,0],[0,0,1]]
<strong>Output:</strong> 3
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 200</code></li>
	<li><code>n == isConnected.length</code></li>
	<li><code>n == isConnected[i].length</code></li>
	<li><code>isConnected[i][j]</code> is <code>1</code> or <code>0</code>.</li>
	<li><code>isConnected[i][i] == 1</code></li>
	<li><code>isConnected[i][j] == isConnected[j][i]</code></li>
</ul>


## Solutions


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



## Related Topics

- [Depth-First Search](https://leetcode.cn//tag/depth-first-search)
- [Breadth-First Search](https://leetcode.cn//tag/breadth-first-search)
- [Union Find](https://leetcode.cn//tag/union-find)
- [Graph](https://leetcode.cn//tag/graph)

## Similar Questions

- [Number of Connected Components in an Undirected Graph](../number-of-connected-components-in-an-undirected-graph/README_EN.md)
- [Robot Return to Origin](../robot-return-to-origin/README_EN.md)
- [Sentence Similarity](../sentence-similarity/README_EN.md)
- [Sentence Similarity II](../sentence-similarity-ii/README_EN.md)
- [The Earliest Moment When Everyone Become Friends](../the-earliest-moment-when-everyone-become-friends/README_EN.md)
