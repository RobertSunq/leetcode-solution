
```
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
