
```
// @Title: 无重叠区间 (Non-overlapping Intervals)
// @Author: robert.sunq
// @Date: 2023-09-28 22:25:23
// @Runtime: 47 ms
// @Memory: 94.1 MB

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        // 按照 右节点升序
        Arrays.sort(intervals, new Comparator<int[]>() {

            @Override
            public int compare(int[] interval1, int[] interval2) {
                return interval1[1] - interval2[1];
            }
        });

        int n = intervals.length;

        // 首个最左侧区间的右节点
        int right = intervals[0][1];

        int ans = 1;
        for (int i = 1; i < n; i++) {
            // 区间不重复，就是剩余所有区间中的 最左侧区间
            if (intervals[i][0] >= right) {
                ans++;
                right = intervals[i][1];
            }
        }

        // 总个数减去需要去掉的个数，就是结果
        return n - ans;
    }
}
