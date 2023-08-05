
| [English](README_EN.md) | 简体中文 |

# [LCR 106. 判断二分图](https://leetcode.cn//problems/vEAB3K/)

## 题目描述

<p>存在一个 <strong>无向图</strong> ，图中有 <code>n</code> 个节点。其中每个节点都有一个介于 <code>0</code> 到 <code>n - 1</code> 之间的唯一编号。</p>

<p>给定一个二维数组 <code>graph</code>&nbsp;，表示图，其中 <code>graph[u]</code> 是一个节点数组，由节点 <code>u</code> 的邻接节点组成。形式上，对于&nbsp;<code>graph[u]</code> 中的每个 <code>v</code> ，都存在一条位于节点 <code>u</code> 和节点 <code>v</code> 之间的无向边。该无向图同时具有以下属性：</p>

<ul>
	<li>不存在自环（<code>graph[u]</code> 不包含 <code>u</code>）。</li>
	<li>不存在平行边（<code>graph[u]</code> 不包含重复值）。</li>
	<li>如果 <code>v</code> 在 <code>graph[u]</code> 内，那么 <code>u</code> 也应该在 <code>graph[v]</code> 内（该图是无向图）</li>
	<li>这个图可能不是连通图，也就是说两个节点 <code>u</code> 和 <code>v</code> 之间可能不存在一条连通彼此的路径。</li>
</ul>

<p><strong>二分图</strong> 定义：如果能将一个图的节点集合分割成两个独立的子集 <code>A</code> 和 <code>B</code> ，并使图中的每一条边的两个节点一个来自 <code>A</code> 集合，一个来自 <code>B</code> 集合，就将这个图称为 <strong>二分图</strong> 。</p>

<p>如果图是二分图，返回 <code>true</code><em> </em>；否则，返回 <code>false</code> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2020/10/21/bi2.jpg" style="width: 222px; height: 222px;" /></p>

<pre>
<strong>输入：</strong>graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
<strong>输出：</strong>false
<strong>解释：</strong><code>不能将节点分割成两个独立的子集，</code>以使每条边都连通一个子集中的一个节点与另一个子集中的一个节点。</pre>

<p><strong>示例 2：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2020/10/21/bi1.jpg" style="width: 222px; height: 222px;" /></p>

<pre>
<strong>输入：</strong>graph = [[1,3],[0,2],[1,3],[0,2]]
<strong>输出：</strong>true
<strong>解释：</strong><code>可以将节点分成两组: {0, 2} 和 {1, 3} 。</code></pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>graph.length == n</code></li>
	<li><code>1 &lt;= n &lt;= 100</code></li>
	<li><code>0 &lt;= graph[u].length &lt; n</code></li>
	<li><code>0 &lt;= graph[u][i] &lt;= n - 1</code></li>
	<li><code>graph[u]</code> 不会包含 <code>u</code></li>
	<li><code>graph[u]</code> 的所有值 <strong>互不相同</strong></li>
	<li>如果 <code>graph[u]</code> 包含 <code>v</code>，那么 <code>graph[v]</code> 也会包含 <code>u</code></li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 785&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/is-graph-bipartite/">https://leetcode-cn.com/problems/is-graph-bipartite/</a></p>


## 题解


### Java

```Java
// @Title: 判断二分图 (判断二分图)
// @Author: robert.sunq
// @Date: 2023-08-03 23:48:20
// @Runtime: 1 ms
// @Memory: 42.8 MB

class Solution {

    int b = 0;
    int r = 1;
    int g = 2;
    private int[] color;

    // 不连通的点集合。为啥可以直接给与红色，而不是要判断给绿色还是红色呢。不会造成一个颜色的点过多么?
    // 注意，并没有要求组中的点个数也要相同，只要求边不属于一个组
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        // 记录点的颜色
        color = new int[n];
        // 初始状态都没有颜色
        // bfs
        // 因为不是连通图，所有要遍历所有的点。
        for (int i = 0; i < n; ++i) {
            // 外层遍历只计算为染色的点
            if (color[i] == b) {
                Queue<Integer> q = new LinkedList<Integer>();
                q.offer(i);
                color[i] = r;
                while (!q.isEmpty()) {
                    int node = q.poll();
                    // 将直接连接的点，设置颜色为当前点的相反颜色
                    int cNei = color[node] == r ? g : r;
                    for (int neighbor : graph[node]) {
                        // 未染色，分配颜色，并放入队列
                        if (color[neighbor] == b) {
                            q.offer(neighbor);
                            color[neighbor] = cNei;
                        } else if (color[neighbor] != cNei) {
                            // 已经染色的话，如果颜色不与要给与的颜色相同， 及与当前点 node 颜色相同。 则说明不能分成两个组
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
```



## 相关话题

- [深度优先搜索](https://leetcode.cn//tag/depth-first-search)
- [广度优先搜索](https://leetcode.cn//tag/breadth-first-search)
- [并查集](https://leetcode.cn//tag/union-find)
- [图](https://leetcode.cn//tag/graph)

## 相似题目



