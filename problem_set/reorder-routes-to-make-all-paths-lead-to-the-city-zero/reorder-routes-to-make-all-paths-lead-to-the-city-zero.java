
```
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
