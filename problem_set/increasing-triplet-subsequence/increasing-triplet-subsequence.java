
```
// @Title: 递增的三元子序列 (Increasing Triplet Subsequence)
// @Author: robert.sunq
// @Date: 2023-08-11 21:47:49
// @Runtime: 2 ms
// @Memory: 126.7 MB

class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        boolean[] bs = new boolean[n];

        int min = nums[0];
        for (int i = 1; i<n; i++) {
            if (min < nums[i]) {
                bs[i] = true;
            } else {
                min = nums[i];
            }
        }

        min = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (min > nums[i]) {
                if (bs[i]) {
                    return true;
                }
            } else {
                min = nums[i];
            }
        }

        return false;
    }
}
