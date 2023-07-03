
```
// @Title: 直方图最大矩形面积 (直方图最大矩形面积)
// @Author: robert.sunq
// @Date: 2023-07-03 23:11:49
// @Runtime: 11 ms
// @Memory: 53.4 MB

class Solution {
    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        int n = heights.length;
        // 记录 左侧第一个小于当前 heights[i] 的索引 - 1
        int[] leftMinIndex = new int[n];
        // 记录 右侧第一个大于当前 heights[i] 的索引 + 1
        int[] rightMinIndex = new int[n];

        for (int i = 0; i < n; i++) {
            int index = i - 1;
            int a = heights[i];
            int b = -1;;
            while (index >= 0) {
                b = heights[index];
                if (b < a) {
                    leftMinIndex[i] = index;
                    break;
                }
                // 当 h[j] > h[i] 可以根据 j 所在的 leftMinIndex 快速跳跃
                index = leftMinIndex[index];
                b = -1;
            }
            if (b == -1) {
                leftMinIndex[i] = index;
            }
        }


        for (int i = n - 1; i >= 0; i--) {
            int index = i + 1;
            int a = heights[i];
            int b = -1;;
            while (index < n) {
                b = heights[index];
                if (b < a) {
                    rightMinIndex[i] = index;
                    break;
                }
                // 当 h[j] > h[i] 可以根据 j 所在的 rightMinIndex 快速跳跃
                index = rightMinIndex[index];
                b = -1;
            }
            if (b == -1) {
                rightMinIndex[i] = index;
            }
        }

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, (rightMinIndex[i] - leftMinIndex[i] - 1) * heights[i]);
        }
        return ans;
    }
}
