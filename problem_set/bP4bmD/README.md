
| [English](README_EN.md) | 简体中文 |

# [LCR 110. 所有可能的路径](https://leetcode.cn//problems/bP4bmD/)

## 题目描述

<p>给定一个有&nbsp;<code>n</code>&nbsp;个节点的有向无环图，用二维数组&nbsp;<code>graph</code>&nbsp;表示，请找到所有从&nbsp;<code>0</code>&nbsp;到&nbsp;<code>n-1</code>&nbsp;的路径并输出（不要求按顺序）。</p>

<p><code>graph</code>&nbsp;的第 <code>i</code> 个数组中的单元都表示有向图中 <code>i</code>&nbsp;号节点所能到达的下一些结点（译者注：有向图是有方向的，即规定了 a&rarr;b 你就不能从 b&rarr;a ），若为空，就是没有下一个节点了。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2020/09/28/all_1.jpg" style="height: 242px; width: 242px;" /></p>

<pre>
<strong>输入：</strong>graph = [[1,2],[3],[3],[]]
<strong>输出：</strong>[[0,1,3],[0,2,3]]
<strong>解释：</strong>有两条路径 0 -&gt; 1 -&gt; 3 和 0 -&gt; 2 -&gt; 3
</pre>

<p><strong>示例 2：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2020/09/28/all_2.jpg" style="height: 301px; width: 423px;" /></p>

<pre>
<strong>输入：</strong>graph = [[4,3,1],[3,2,4],[3],[4],[]]
<strong>输出：</strong>[[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>graph = [[1],[]]
<strong>输出：</strong>[[0,1]]
</pre>

<p><strong>示例 4：</strong></p>

<pre>
<strong>输入：</strong>graph = [[1,2,3],[2],[3],[]]
<strong>输出：</strong>[[0,1,2,3],[0,2,3],[0,3]]
</pre>

<p><strong>示例 5：</strong></p>

<pre>
<strong>输入：</strong>graph = [[1,3],[2],[3],[]]
<strong>输出：</strong>[[0,1,2,3],[0,3]]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>n == graph.length</code></li>
	<li><code>2 &lt;= n &lt;= 15</code></li>
	<li><code>0 &lt;= graph[i][j] &lt; n</code></li>
	<li><code>graph[i][j] != i</code>&nbsp;</li>
	<li>保证输入为有向无环图 <code>(GAD)</code></li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 797&nbsp;题相同：<a href="https://leetcode-cn.com/problems/all-paths-from-source-to-target/">https://leetcode-cn.com/problems/all-paths-from-source-to-target/</a></p>


## 题解


### Java

```Java
// @Title: 所有可能的路径 (所有可能的路径)
// @Author: robert.sunq
// @Date: 2023-08-05 22:29:46
// @Runtime: 1 ms
// @Memory: 44.4 MB

class Solution {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();

        // 找所有的路径
        // int n = graph.length;
        // boolean[] visit = new boolean[n];

        // for (int i = 0; i < n ; i++) {
        //     for (int j = 0; j < graph[i].length; j++) {
        //         visit[graph[i][j]] = true;
        //     }
        // }

        // for (int i = 0; i < n; i++) {
        //     if (!visit[i]) {
        //         dfs(ans, new ArrayList<>(), i, graph);
        //     }
        // }

        dfs(ans, new ArrayList<>(), 0, graph);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, List<Integer> tmp, int n, int[][] graph) {
        if (n == graph.length - 1) {
            tmp.add(n);
            ans.add(new ArrayList<>(tmp));
            tmp.remove(tmp.size() - 1);
            return ;
        } 

        tmp.add(n);
        for (int sub : graph[n]) {
            dfs(ans, tmp, sub, graph);   
        }
        tmp.remove(tmp.size() - 1);
    }
}
```



## 相关话题

- [深度优先搜索](https://leetcode.cn//tag/depth-first-search)
- [广度优先搜索](https://leetcode.cn//tag/breadth-first-search)
- [图](https://leetcode.cn//tag/graph)
- [回溯](https://leetcode.cn//tag/backtracking)

## 相似题目



