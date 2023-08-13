
```
// @Title: 移动零 (Move Zeroes)
// @Author: robert.sunq
// @Date: 2023-08-13 21:36:42
// @Runtime: 1 ms
// @Memory: 44.2 MB

class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[left] = nums[i];
                left++;
            }
        }

        while (left < n) {
            nums[left++] = 0;
        }

    }
}
