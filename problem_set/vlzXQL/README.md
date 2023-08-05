
| [English](README_EN.md) | 简体中文 |

# [LCR 111. 除法求值](https://leetcode.cn//problems/vlzXQL/)

## 题目描述

<p>给定一个变量对数组 <code>equations</code> 和一个实数值数组 <code>values</code> 作为已知条件，其中 <code>equations[i] = [A<sub>i</sub>, B<sub>i</sub>]</code> 和 <code>values[i]</code> 共同表示等式 <code>A<sub>i</sub> / B<sub>i</sub> = values[i]</code> 。每个 <code>A<sub>i</sub></code> 或 <code>B<sub>i</sub></code> 是一个表示单个变量的字符串。</p>

<p>另有一些以数组 <code>queries</code> 表示的问题，其中 <code>queries[j] = [C<sub>j</sub>, D<sub>j</sub>]</code> 表示第 <code>j</code> 个问题，请你根据已知条件找出 <code>C<sub>j</sub> / D<sub>j</sub> = ?</code> 的结果作为答案。</p>

<p>返回 <strong>所有问题的答案</strong> 。如果存在某个无法确定的答案，则用 <code>-1.0</code> 替代这个答案。如果问题中出现了给定的已知条件中没有出现的字符串，也需要用 <code>-1.0</code> 替代这个答案。</p>

<p><strong>注意：</strong>输入总是有效的。可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>equations = [[&quot;a&quot;,&quot;b&quot;],[&quot;b&quot;,&quot;c&quot;]], values = [2.0,3.0], queries = [[&quot;a&quot;,&quot;c&quot;],[&quot;b&quot;,&quot;a&quot;],[&quot;a&quot;,&quot;e&quot;],[&quot;a&quot;,&quot;a&quot;],[&quot;x&quot;,&quot;x&quot;]]
<strong>输出：</strong>[6.00000,0.50000,-1.00000,1.00000,-1.00000]
<strong>解释：</strong>
条件：<em>a / b = 2.0</em>, <em>b / c = 3.0</em>
问题：<em>a / c = ?</em>, <em>b / a = ?</em>, <em>a / e = ?</em>, <em>a / a = ?</em>, <em>x / x = ?</em>
结果：[6.0, 0.5, -1.0, 1.0, -1.0 ]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>equations = [[&quot;a&quot;,&quot;b&quot;],[&quot;b&quot;,&quot;c&quot;],[&quot;bc&quot;,&quot;cd&quot;]], values = [1.5,2.5,5.0], queries = [[&quot;a&quot;,&quot;c&quot;],[&quot;c&quot;,&quot;b&quot;],[&quot;bc&quot;,&quot;cd&quot;],[&quot;cd&quot;,&quot;bc&quot;]]
<strong>输出：</strong>[3.75000,0.40000,5.00000,0.20000]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>equations = [[&quot;a&quot;,&quot;b&quot;]], values = [0.5], queries = [[&quot;a&quot;,&quot;b&quot;],[&quot;b&quot;,&quot;a&quot;],[&quot;a&quot;,&quot;c&quot;],[&quot;x&quot;,&quot;y&quot;]]
<strong>输出：</strong>[0.50000,2.00000,-1.00000,-1.00000]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= equations.length &lt;= 20</code></li>
	<li><code>equations[i].length == 2</code></li>
	<li><code>1 &lt;= A<sub>i</sub>.length, B<sub>i</sub>.length &lt;= 5</code></li>
	<li><code>values.length == equations.length</code></li>
	<li><code>0.0 &lt; values[i] &lt;= 20.0</code></li>
	<li><code>1 &lt;= queries.length &lt;= 20</code></li>
	<li><code>queries[i].length == 2</code></li>
	<li><code>1 &lt;= C<sub>j</sub>.length, D<sub>j</sub>.length &lt;= 5</code></li>
	<li><code>A<sub>i</sub>, B<sub>i</sub>, C<sub>j</sub>, D<sub>j</sub></code> 由小写英文字母与数字组成</li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 399&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/evaluate-division/">https://leetcode-cn.com/problems/evaluate-division/</a></p>


## 题解


### Java

```Java
// @Title: 除法求值 (除法求值)
// @Author: robert.sunq
// @Date: 2023-08-06 00:10:13
// @Runtime: 7 ms
// @Memory: 40.5 MB

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Map<String, Integer> map = new HashMap<>();
        int index = 0;
        for (List<String> equation : equations) {
            for (String str : equation) {
                if (!map.containsKey(str)) {
                    map.put(str, index++);
                }
            }
        }

        // 创建图
        int n = map.size();
        double[][] graph = new double[n][n];


        // + 1， 表示右路径到达， ==0 表示无路径
        for (int i = 0; i< equations.size(); i++) {
            graph[map.get(equations.get(i).get(0))][map.get(equations.get(i).get(1))] = values[i] + 1;
            graph[map.get(equations.get(i).get(1))][map.get(equations.get(i).get(0))] = (1 / values[i]) + 1;
        }

        Map<String, Double> ans = new HashMap<>();
        for (int i = 0 ; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] > 0.5) {
                    boolean[] visit = new boolean[n];
                    visit[i] = true;
                    visit[j] = true;
                    ans.put(String.valueOf(i) + "_" + String.valueOf(j), graph[i][j] - 1);
                    if ( i != j) {
                        dfs(graph, i, j, graph[i][j] - 1, ans, visit); 
                    }
                }
            }
        }

        int m = queries.size();
        double[] result = new double[m];
        index = 0;
        for (List<String> q : queries) {
            if (q.get(0).equals(q.get(1))) {
                result[index++] = map.containsKey(q.get(0)) ? 1.0 : -1.0;
                continue;
            }
            int i = map.getOrDefault(q.get(0), -1);
            int j = map.getOrDefault(q.get(1), -1);
            String key = String.valueOf(i) + "_" + String.valueOf(j);
            result[index++] = ans.getOrDefault(key, -1.0);

        }

        return result;
    }

    private void dfs(double[][] graph, int start, int end, double result, Map<String, Double> ans, boolean[] visit) {
        
        for (int i = 0; i < graph.length; i++) {
            // 说明有路径 end --> i
            if (graph[end][i] > 0.5 && !visit[i]) {
                double t = result * (graph[end][i] - 1);
                visit[i] = true;
                ans.put(String.valueOf(start) + "_" + String.valueOf(i), t);
                dfs(graph, start, i, t, ans, visit); 
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
- [数组](https://leetcode.cn//tag/array)
- [最短路](https://leetcode.cn//tag/shortest-path)

## 相似题目



