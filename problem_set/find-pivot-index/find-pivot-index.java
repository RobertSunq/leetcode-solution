
```
// @Title: 寻找数组的中心下标 (Find Pivot Index)
// @Author: robert.sunq
// @Date: 2023-08-21 22:13:35
// @Runtime: 1 ms
// @Memory: 42.6 MB

class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n + 1];

        for (int i = 1; i<=n; i++) {
            pre[i] = pre[i - 1] + nums[i - 1];
        }

        for (int i = 1; i <= n; i++) {
            if (pre[i - 1] == (pre[n] - pre[i])) {
                return i - 1;
            }
        }

        return -1;
    }
}
