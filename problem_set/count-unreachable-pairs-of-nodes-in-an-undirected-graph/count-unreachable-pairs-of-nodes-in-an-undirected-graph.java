
```
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
