
```
// @Title: 用最少数量的箭引爆气球 (Minimum Number of Arrows to Burst Balloons)
// @Author: robert.sunq
// @Date: 2023-09-29 21:40:10
// @Runtime: 52 ms
// @Memory: 74.6 MB

class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }

        Arrays.sort(points, new Comparator<int[]>() {

            // 不能直接使用减法，存在超限问题
            @Override
            public int compare(int[] point1, int[] point2) {
                if (point1[1] > point2[1]) {
                    return 1;
                } else if (point1[1] < point2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        int n = points.length;

        // 首个最左侧区间的右节点
        int right = points[0][1];

        int ans = 1;
        for (int i = 1; i < n; i++) {
            // 如果剩余的区间中，左节点小于第一支箭射中的最右侧，则可以被爆炸，不用重新找区间射箭
            // 注意 等于的时候，也可以打爆
            if (points[i][0] > right) {
                ans++;
                right = points[i][1];
            }
        }

        // 总个数减去需要去掉的个数，就是结果
        return ans;
    }
}
