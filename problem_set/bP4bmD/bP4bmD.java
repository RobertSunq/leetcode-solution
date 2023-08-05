
```
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
