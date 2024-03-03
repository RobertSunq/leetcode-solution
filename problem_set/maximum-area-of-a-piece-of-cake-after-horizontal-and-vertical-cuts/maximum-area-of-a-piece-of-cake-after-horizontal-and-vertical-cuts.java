
```
// @Title: 切割后面积最大的蛋糕 (Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts)
// @Author: robert.sunq
// @Date: 2023-10-27 22:00:51
// @Runtime: 14 ms
// @Memory: 52.6 MB

class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        return (int) ((long) selectMax(horizontalCuts, h) * selectMax(verticalCuts, w) % 1000000007);
    }

    // n 表示该方向上的边界值， 用来计算最后一刀切出来的宽度
    private int selectMax(int[] nums, int n) {
        int ans = 0;
        int pre = 0;
        for (int i : nums) {
            ans = Math.max(i - pre, ans);
            pre = i;
        }

        return Math.max(ans , n - pre);
    }
}
