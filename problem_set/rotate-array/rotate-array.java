
```
// @Title: 轮转数组 (Rotate Array)
// @Author: robert.sunq
// @Date: 2023-10-06 21:09:46
// @Runtime: 0 ms
// @Memory: 54.3 MB

class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }


    public  void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start = start + 1;
            end = end - 1;

        }
    }
}
