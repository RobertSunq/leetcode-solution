
| [English](README_EN.md) | 简体中文 |

# [2316. 统计无向图中无法互相到达点对数](https://leetcode.cn//problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/)

## 题目描述

<p>给你一个整数&nbsp;<code>n</code>&nbsp;，表示一张<strong>&nbsp;无向图</strong>&nbsp;中有 <code>n</code>&nbsp;个节点，编号为&nbsp;<code>0</code>&nbsp;到&nbsp;<code>n - 1</code>&nbsp;。同时给你一个二维整数数组&nbsp;<code>edges</code>&nbsp;，其中&nbsp;<code>edges[i] = [a<sub>i</sub>, b<sub>i</sub>]</code>&nbsp;表示节点&nbsp;<code>a<sub>i</sub></code> 和&nbsp;<code>b<sub>i</sub></code>&nbsp;之间有一条&nbsp;<strong>无向</strong>&nbsp;边。</p>

<p>请你返回 <strong>无法互相到达</strong>&nbsp;的不同 <strong>点对数目</strong>&nbsp;。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2022/05/05/tc-3.png" style="width: 267px; height: 169px;"></p>

<pre><b>输入：</b>n = 3, edges = [[0,1],[0,2],[1,2]]
<b>输出：</b>0
<b>解释：</b>所有点都能互相到达，意味着没有点对无法互相到达，所以我们返回 0 。
</pre>

<p><strong>示例 2：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2022/05/05/tc-2.png" style="width: 295px; height: 269px;"></p>

<pre><b>输入：</b>n = 7, edges = [[0,2],[0,5],[2,4],[1,6],[5,4]]
<b>输出：</b>14
<b>解释：</b>总共有 14 个点对互相无法到达：
[[0,1],[0,3],[0,6],[1,2],[1,3],[1,4],[1,5],[2,3],[2,6],[3,4],[3,5],[3,6],[4,6],[5,6]]
所以我们返回 14 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= edges.length &lt;= 2 * 10<sup>5</sup></code></li>
	<li><code>edges[i].length == 2</code></li>
	<li><code>0 &lt;= a<sub>i</sub>, b<sub>i</sub> &lt; n</code></li>
	<li><code>a<sub>i</sub> != b<sub>i</sub></code></li>
	<li>不会有重复边。</li>
</ul>


## 题解


### Java

```Java
// @Title: 统计无向图中无法互相到达点对数 (Count Unreachable Pairs of Nodes in an Undirected Graph)
// @Author: robert.sunq
// @Date: 2023-10-21 22:28:11
// @Runtime: 44 ms
// @Memory: 101.6 MB

class Solution {
    public long countPairs(int n, int[][] edges) {
        boolean[] visit = new boolean[n];

        List<Integer> counts = new ArrayList<>();

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        for (int i = 0; i < n; i++) {
            if (visit[i]) {
                continue;
            }

            int count = 0;
            q.offer(i);
            visit[i] = true;
            while (!q.isEmpty()) {
                count++;
                int tmp = q.poll();
                for (Integer j : graph.get(tmp)) {
                    if (! visit[j]) {
                        visit[j] = true;
                        q.offer(j);
                    }
                }
            }
            counts.add(count);
        }

        long ans = 0;

        for (int i = 0; i < counts.size(); i++) {
            // 属于一个组的可以相互到达， 那么剩下的 不管属于其他的哪个组，都是不能直接到达的
            // 所以 这个组和其他不可达的点对为 count * (n - count)。 遍历完所有的组，因为每个点这样被计算量两次，所以要除以 2 
            ans = ans + (1L * counts.get(i) * (n - counts.get(i)));
        }

        return ans / 2;
    }
}
```



## 相关话题

- [深度优先搜索](https://leetcode.cn//tag/depth-first-search)
- [广度优先搜索](https://leetcode.cn//tag/breadth-first-search)
- [并查集](https://leetcode.cn//tag/union-find)
- [图](https://leetcode.cn//tag/graph)

## 相似题目



