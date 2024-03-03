
```
// @Title: 省份数量 (Number of Provinces)
// @Author: robert.sunq
// @Date: 2023-09-09 22:52:10
// @Runtime: 5 ms
// @Memory: 44.7 MB

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int ans = 0;
        int n = isConnected.length;
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visit = new boolean[n];
        for (int i = 0; i<n; i++) {
            if(!visit[i]) {
                q.add(i);
                while (!q.isEmpty()) {
                    int t = q.poll();
                    visit[t] = true;
                    for (int j = 0; j <n ; j++) {
                        if (!visit[j] && isConnected[t][j] == 1) {
                            q.add(j);
                        }
                    }
                }
                ans++;
            }
        }

        return ans;
    }

    public int findCircleNumDFS(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visit = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                dfs(visit, isConnected, i, n);
                ans++;
            }
        }
        return ans;
    }

    public void dfs(boolean[] visit, int[][] isConnected, int i, int n) {
        for (int j = 0; j < n; j++) {
            if (isConnected[i][j] == 1 && !visit[j]) {
                visit[j] = true;
                dfs(visit, isConnected, j, n);
            }
        }
    }
}
