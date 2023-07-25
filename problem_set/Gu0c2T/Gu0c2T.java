
```
// @Title: 房屋偷盗 (房屋偷盗)
// @Author: robert.sunq
// @Date: 2023-07-25 23:34:05
// @Runtime: 0 ms
// @Memory: 38.5 MB

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n < 1) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);
        
        for (int i = 2; i < n ; i++) {
            // 上上家的 + 当前   或者 上一家
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }

        return second;

    }
}
