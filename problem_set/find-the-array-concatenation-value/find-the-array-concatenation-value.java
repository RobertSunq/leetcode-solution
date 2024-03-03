
```
// @Title: 找出数组的串联值 (Find the Array Concatenation Value)
// @Author: robert.sunq
// @Date: 2023-10-12 22:23:50
// @Runtime: 1 ms
// @Memory: 41.8 MB

class Solution {
    public long findTheArrayConcVal(int[] nums) {
        long ans = 0;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (left == right) {
                ans += nums[left];
            } else {
                int n = String.valueOf(nums[right]).length();
                long power = 1;
                while (n > 0) {
                    power = power * 10;
                    n--;
                }
                long tmp = (1L * nums[left] * power) + nums[right];
                ans = ans + tmp;
            }
            left++;
            right--;
        }

        return ans;
    }
}
