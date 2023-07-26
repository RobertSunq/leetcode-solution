
```
// @Title: 粉刷房子 (粉刷房子)
// @Author: robert.sunq
// @Date: 2023-07-26 23:51:56
// @Runtime: 0 ms
// @Memory: 40.3 MB

class Solution {
    public int minCost(int[][] costs) {

        // 当前颜色涂为 红， 则从前面的颜色中选取低的一个涂色

        // 分别保存前一节房子涂抹颜色的最低价
        int[] cost = new int[3];
        cost[0] = costs[0][0];
        cost[1] = costs[0][1];
        cost[2] = costs[0][2];

        int n = costs.length;
        for (int i = 1; i < n; i++) {

            // 注意要先给与临时变量，最后赋值，避免下一个颜色计算被上一个的结果干扰
            // 红
            int tmp0 = Math.min(cost[1], cost[2]) + costs[i][0];
            // 蓝
            int tmp1 = Math.min(cost[0], cost[2]) + costs[i][1];
            // 绿
            int tmp2 = Math.min(cost[0], cost[1]) + costs[i][2];

            // 注意，
            cost[0] = tmp0;
            cost[1] = tmp1;
            cost[2] = tmp2;
        }


        return Math.min(Math.min(cost[0], cost[1]), cost[2]);
    }
}
