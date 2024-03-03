
| English | [简体中文](README.md) |

# [2316. Count Unreachable Pairs of Nodes in an Undirected Graph](https://leetcode.cn//problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/)

## Description

<p>You are given an integer <code>n</code>. There is an <strong>undirected</strong> graph with <code>n</code> nodes, numbered from <code>0</code> to <code>n - 1</code>. You are given a 2D integer array <code>edges</code> where <code>edges[i] = [a<sub>i</sub>, b<sub>i</sub>]</code> denotes that there exists an <strong>undirected</strong> edge connecting nodes <code>a<sub>i</sub></code> and <code>b<sub>i</sub></code>.</p>

<p>Return <em>the <strong>number of pairs</strong> of different nodes that are <strong>unreachable</strong> from each other</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2022/05/05/tc-3.png" style="width: 267px; height: 169px;" />
<pre>
<strong>Input:</strong> n = 3, edges = [[0,1],[0,2],[1,2]]
<strong>Output:</strong> 0
<strong>Explanation:</strong> There are no pairs of nodes that are unreachable from each other. Therefore, we return 0.
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2022/05/05/tc-2.png" style="width: 295px; height: 269px;" />
<pre>
<strong>Input:</strong> n = 7, edges = [[0,2],[0,5],[2,4],[1,6],[5,4]]
<strong>Output:</strong> 14
<strong>Explanation:</strong> There are 14 pairs of nodes that are unreachable from each other:
[[0,1],[0,3],[0,6],[1,2],[1,3],[1,4],[1,5],[2,3],[2,6],[3,4],[3,5],[3,6],[4,6],[5,6]].
Therefore, we return 14.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= edges.length &lt;= 2 * 10<sup>5</sup></code></li>
	<li><code>edges[i].length == 2</code></li>
	<li><code>0 &lt;= a<sub>i</sub>, b<sub>i</sub> &lt; n</code></li>
	<li><code>a<sub>i</sub> != b<sub>i</sub></code></li>
	<li>There are no repeated edges.</li>
</ul>


## Solutions


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



## Related Topics

- [Depth-First Search](https://leetcode.cn//tag/depth-first-search)
- [Breadth-First Search](https://leetcode.cn//tag/breadth-first-search)
- [Union Find](https://leetcode.cn//tag/union-find)
- [Graph](https://leetcode.cn//tag/graph)

## Similar Questions


