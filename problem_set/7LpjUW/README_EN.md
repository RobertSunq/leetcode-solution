
| English | [简体中文](README.md) |

# [LCR 118. 冗余连接](https://leetcode.cn//problems/7LpjUW/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 冗余连接 (冗余连接)
// @Author: robert.sunq
// @Date: 2023-08-07 22:21:13
// @Runtime: 0 ms
// @Memory: 40.8 MB

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];

        for (int i =1; i<= n ; i++) {
            parent[i] = i;
        }

        for (int i =0; i < n; i++) {
            int[] edge = edges[i];
            int node1 = edge[0];
            int node2 = edge[1];
            if (find(parent, node1) != find(parent, node2)) {
                union(parent, node1, node2);
            } else {
                return edge;
            }
        }

        return new int[0];
    }

    private void union(int[] parent, int node1, int node2) {
        parent[find(parent, node1)] = find(parent, node2);
    }

    private int find(int[] parent, int node) {
        if (parent[node] != node) {
            parent[node] = find(parent, parent[node]);
        }

        return parent[node];
    }
}
```



## Related Topics

- [Depth-First Search](https://leetcode.cn//tag/depth-first-search)
- [Breadth-First Search](https://leetcode.cn//tag/breadth-first-search)
- [Union Find](https://leetcode.cn//tag/union-find)
- [Graph](https://leetcode.cn//tag/graph)

## Similar Questions


