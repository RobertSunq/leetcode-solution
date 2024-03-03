
| [English](README_EN.md) | 简体中文 |

# [1466. 重新规划路线](https://leetcode.cn//problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/)

## 题目描述

<p><code>n</code> 座城市，从 <code>0</code> 到 <code>n-1</code> 编号，其间共有 <code>n-1</code> 条路线。因此，要想在两座不同城市之间旅行只有唯一一条路线可供选择（路线网形成一颗树）。去年，交通运输部决定重新规划路线，以改变交通拥堵的状况。</p>

<p>路线用 <code>connections</code> 表示，其中 <code>connections[i] = [a, b]</code> 表示从城市 <code>a</code> 到 <code>b</code> 的一条有向路线。</p>

<p>今年，城市 0 将会举办一场大型比赛，很多游客都想前往城市 0 。</p>

<p>请你帮助重新规划路线方向，使每个城市都可以访问城市 0 。返回需要变更方向的最小路线数。</p>

<p>题目数据 <strong>保证</strong> 每个城市在重新规划路线方向后都能到达城市 0 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/05/30/sample_1_1819.png" style="height: 150px; width: 240px;"></strong></p>

<pre><strong>输入：</strong>n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
<strong>输出：</strong>3
<strong>解释：</strong>更改以红色显示的路线的方向，使每个城市都可以到达城市 0 。</pre>

<p><strong>示例 2：</strong></p>

<p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/05/30/sample_2_1819.png" style="height: 60px; width: 380px;"></strong></p>

<pre><strong>输入：</strong>n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
<strong>输出：</strong>2
<strong>解释：</strong>更改以红色显示的路线的方向，使每个城市都可以到达城市 0 。</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>n = 3, connections = [[1,0],[2,0]]
<strong>输出：</strong>0
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>2 &lt;= n &lt;= 5 * 10^4</code></li>
	<li><code>connections.length == n-1</code></li>
	<li><code>connections[i].length == 2</code></li>
	<li><code>0 &lt;= connections[i][0], connections[i][1] &lt;= n-1</code></li>
	<li><code>connections[i][0] != connections[i][1]</code></li>
</ul>


## 题解


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



## 相关话题

- [深度优先搜索](https://leetcode.cn//tag/depth-first-search)
- [广度优先搜索](https://leetcode.cn//tag/breadth-first-search)
- [图](https://leetcode.cn//tag/graph)

## 相似题目



