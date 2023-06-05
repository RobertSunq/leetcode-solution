
```
// @Title: 和大于等于 target 的最短子数组 (和大于等于 target 的最短子数组)
// @Author: robert.sunq
// @Date: 2023-05-30 23:49:27
// @Runtime: 2 ms
// @Memory: 42.9 MB

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int sum = nums[0];
        while (start < nums.length) {
            if (sum >= target) {
                ans = min(ans, end - start + 1);
                sum = sum - nums[start];
                start++;
                continue;
            } else if (end == nums.length - 1) {
                break;
            }
            if (end < nums.length - 1) {
                end++;
                sum = sum + nums[end];
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }


    private int min(int a, int b) {
        return a < b? a: b;
    }
}
