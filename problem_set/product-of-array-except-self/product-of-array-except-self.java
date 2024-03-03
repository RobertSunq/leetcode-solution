
```
// @Title: 除自身以外数组的乘积 (Product of Array Except Self)
// @Author: robert.sunq
// @Date: 2023-10-29 21:51:12
// @Runtime: 1 ms
// @Memory: 50.5 MB

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int tmp = 1;
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = tmp;
            tmp = tmp * nums[i];
        }

        tmp = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = tmp * ans[i];
            tmp = tmp * nums[i];
        }

        return ans;

    }
}
