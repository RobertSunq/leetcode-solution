
```
// @Title: 合并区间 (合并区间)
// @Author: robert.sunq
// @Date: 2023-07-18 22:47:39
// @Runtime: 7 ms
// @Memory: 42.8 MB

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (row1 , row2) -> {
            if (row1[0] == row2[0]) {
                return  row1[1] - row2[1];
            }
            return  row1[0] - row2[0];
        });
        int resIndex = 0;
        for (int i = 1; i< intervals.length;i++) {
            int[] tmp = intervals[i];
            int[] res = intervals[resIndex];
            if (tmp[0] <= res[1]) {
                intervals[resIndex][1] = Math.max(res[1] , tmp[1]);
            } else {
                resIndex = resIndex + 1;
                intervals[resIndex][0] = tmp[0];
                intervals[resIndex][1] = tmp[1];
            }
        }

        int[][] ans = new int[resIndex + 1][2];
        for (int i = 0; i<= resIndex; i++) {
            ans[i][0] = intervals[i][0];
            ans[i][1] = intervals[i][1];
        }

        return ans;
    }
}
