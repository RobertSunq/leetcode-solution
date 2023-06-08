
```
// @Title: 左右两边子数组的和相等 (左右两边子数组的和相等)
// @Author: robert.sunq
// @Date: 2023-06-08 23:36:25
// @Runtime: 1 ms
// @Memory: 42.9 MB

class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n+1];
        for(int i = 1;i<n+1;i++) {
            preSum[i] = preSum[i-1] + nums[i-1];
        }

        for(int i = 0; i<n;i++) {
            if (preSum[i] == preSum[n] - preSum[i + 1]) {
                return i ;
            }
        }
        return -1;
    }
}
