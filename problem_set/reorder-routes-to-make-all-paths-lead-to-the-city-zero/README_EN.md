
| English | [简体中文](README.md) |

# [1466. Reorder Routes to Make All Paths Lead to the City Zero](https://leetcode.cn//problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/)

## Description

<p>There are <code>n</code> cities numbered from <code>0</code> to <code>n - 1</code> and <code>n - 1</code> roads such that there is only one way to travel between two different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.</p>

<p>Roads are represented by <code>connections</code> where <code>connections[i] = [a<sub>i</sub>, b<sub>i</sub>]</code> represents a road from city <code>a<sub>i</sub></code> to city <code>b<sub>i</sub></code>.</p>

<p>This year, there will be a big event in the capital (city <code>0</code>), and many people want to travel to this city.</p>

<p>Your task consists of reorienting some roads such that each city can visit the city <code>0</code>. Return the <strong>minimum</strong> number of edges changed.</p>

<p>It&#39;s <strong>guaranteed</strong> that each city can reach city <code>0</code> after reorder.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/05/13/sample_1_1819.png" style="width: 311px; height: 189px;" />
<pre>
<strong>Input:</strong> n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
<strong>Output:</strong> 3
<strong>Explanation: </strong>Change the direction of edges show in red such that each node can reach the node 0 (capital).
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/05/13/sample_2_1819.png" style="width: 509px; height: 79px;" />
<pre>
<strong>Input:</strong> n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
<strong>Output:</strong> 2
<strong>Explanation: </strong>Change the direction of edges show in red such that each node can reach the node 0 (capital).
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> n = 3, connections = [[1,0],[2,0]]
<strong>Output:</strong> 0
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= n &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>connections.length == n - 1</code></li>
	<li><code>connections[i].length == 2</code></li>
	<li><code>0 &lt;= a<sub>i</sub>, b<sub>i</sub> &lt;= n - 1</code></li>
	<li><code>a<sub>i</sub> != b<sub>i</sub></code></li>
</ul>


## Solutions


### Java

```Java
// @Title: 重新规划路线 (Reorder Routes to Make All Paths Lead to the City Zero)
// @Author: robert.sunq
// @Date: 2023-09-10 19:09:17
// @Runtime: 36 ms
// @Memory: 66.6 MB

class Solution {

    private int count; // 变更方向的路线数

    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> graph = buildGraph(n, connections);

        boolean[] visited = new boolean[n];
        
        dfs(graph, visited, 0);

        return count;
    }

    private void dfs(List<List<Integer>> graph, boolean[] visited, int city) {
        visited[city] = true;
        for (int neighbor : graph.get(city)) {
            // 如果邻居节点未被访问
            if (!visited[Math.abs(neighbor)]) {
                // 从城市 0 的方向往外走，因为结构是树，不存在环，因此从任意一个城市倒带另一个城市
                // 经过的城市是唯一的，如果 neighbor > 0，就说没有版本发绕过其他城市地带目标城市，
                // 就需要改路， count++
                if (neighbor > 0) {
                    count++;
                }
                // 继续深度遍历搜索
                dfs(graph, visited, Math.abs(neighbor));
            }
        }
    }


    private List<List<Integer>> buildGraph(int n, int[][] connections) {
        // 邻接表来表示有向图
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] connection : connections) {
            int from = connection[0];
            int to = connection[1];
            // 添加真实正向路线
            graph.get(from).add(to);

            // 取反添加反向路线，并用负数区分
            graph.get(to).add(-from);
        }

        return graph;
    }
}
```



## Related Topics

- [Depth-First Search](https://leetcode.cn//tag/depth-first-search)
- [Breadth-First Search](https://leetcode.cn//tag/breadth-first-search)
- [Graph](https://leetcode.cn//tag/graph)

## Similar Questions


