
```
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
