
```
// @Title: 参加会议的最多员工数 (Maximum Employees to Be Invited to a Meeting)
// @Author: robert.sunq
// @Date: 2023-11-01 22:38:47
// @Runtime: 17 ms
// @Memory: 54.3 MB

class Solution {
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;

        // 统计入度， 方便进行拓扑排序
        int[] indeg = new int[n];

        for (int i = 0; i < n; i++) {
            indeg[favorite[i]] = indeg[favorite[i]] + 1;
        }

        boolean[] visit = new boolean[n];

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        Queue<Integer> queue = new ArrayDeque<>();

        // 入度为 0 的点
        for (int i = 0; i < n; i++) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }

        // 计算不再环内的节点的最大步长
        while (!queue.isEmpty()) {
            int u = queue.poll();
            visit[u] = true;

            int v = favorite[u];
            // 状态转移方程
            dp[v] = Math.max(dp[v], dp[u] + 1);

            // 被喜欢的节点 入度 - 1
            indeg[v] = indeg[v] - 1;
            if (indeg[v] == 0) {
                queue.offer(v);
            }
        }

        // ring 表示最大环的大小
        // total 表示 所有环大小为 2的 【基环 内向树】上的最长的 【双端游走】 路径之和

        int ring = 0, total = 0;

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                int j = favorite[i];
                // favorite[favorite[i]] = i, 说明相互喜欢， 即 环的大小为2
                if (favorite[j] == i) {
                    total = total + dp[i] + dp[j];
                    visit[i] = true;
                    visit[j] = true;
                } else {
                    // 否则环的大小至少为 3， 此时找出环并计算大小
                    int u = i, cnt =  0;
                    while (true) {
                        cnt++;
                        u = favorite[u];
                        visit[u] = true;
                        // 绕完了整个环
                        if (u == i) {
                            break;
                        }
                    }

                    ring = Math.max(ring, cnt);
                }
            }
        }

        return Math.max(ring, total);
    }
}
