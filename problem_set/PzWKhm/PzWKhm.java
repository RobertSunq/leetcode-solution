
```
// @Title: 环形房屋偷盗 (环形房屋偷盗)
// @Author: robert.sunq
// @Date: 2023-07-26 23:28:43
// @Runtime: 0 ms
// @Memory: 38.5 MB

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }


        if (n == 1) {
            return nums[0];
        }

        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        // 这里是重点
        // 偷第一家，所以不能偷最后一家， [0, n - 1]
        int prevRobFirst = nums[0];
        int curRobFirst = Math.max(nums[0], nums[1]);

        // 不偷最后一家， 所以可以选择偷最后一家 [1, n]
        int prevNotRobFirst = nums[1];
        int curNotRobFirst = Math.max(nums[1], nums[2]);

        for (int i = 2; i < n; i++) {
            // 偷第一家， 不偷最后一家
            if ( i < n - 1) {
                int tmpRob = Math.max(prevRobFirst + nums[i], curRobFirst);
                prevRobFirst = curRobFirst;
                curRobFirst = tmpRob;
            } 
            // 不偷最后一家，偷到最后
            if (i > 2) {
                int tmpNotRob = Math.max(prevNotRobFirst + nums[i] , curNotRobFirst);
                prevNotRobFirst = curNotRobFirst;
                curNotRobFirst = tmpNotRob;
            }
        }

        return Math.max(curRobFirst, curNotRobFirst);
    }
}
