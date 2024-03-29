
```
// @Title: 阈值距离内邻居最少的城市 (Find the City With the Smallest Number of Neighbors at a Threshold Distance)
// @Author: robert.sunq
// @Date: 2023-11-14 22:49:54
// @Runtime: 7 ms
// @Memory: 42 MB

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[] ans = {Integer.MAX_VALUE / 2, -1};
        int[][] mp = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(mp[i], Integer.MAX_VALUE / 2);
        }

        for (int[] eg : edges) {
            int from = eg[0], to = eg[1], weight = eg[2];
            mp[from][to] = mp[to][from] = weight;
        }

        for (int k = 0; k < n; k++) {
            mp[k][k] = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mp[i][j] = Math.min(mp[i][j], mp[i][k] + mp[k][j]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (mp[i][j] <= distanceThreshold) {
                    cnt++;
                }
            }
            // 统计到达城市最少的，且序号最大的
            if (cnt <= ans[0]) {
                ans[0] = cnt;
                ans[1] = i;
            }
        }

        return ans[1];
    }
}
