
| English | [简体中文](README.md) |

# [LCR 106. 判断二分图](https://leetcode.cn//problems/vEAB3K/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


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



## Related Topics

- [Depth-First Search](https://leetcode.cn//tag/depth-first-search)
- [Breadth-First Search](https://leetcode.cn//tag/breadth-first-search)
- [Union Find](https://leetcode.cn//tag/union-find)
- [Graph](https://leetcode.cn//tag/graph)

## Similar Questions


