
```
// @Title: 乘积小于 K 的子数组 (乘积小于 K 的子数组)
// @Author: robert.sunq
// @Date: 2023-06-06 00:06:30
// @Runtime: 4 ms
// @Memory: 44.8 MB

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int prod = 1;
        int ans = 0;
        int i = 0;
        for (int j = 0; j < n; j++){
            prod = prod * nums[j];
            while(i <= j && prod >= k) {
                prod = prod / nums[i];
                i++;
            }
            ans = ans + (j - i) + 1;
        }
        return ans;
    }
}
