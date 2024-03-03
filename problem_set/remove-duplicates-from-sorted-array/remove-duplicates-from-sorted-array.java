
```
// @Title: 删除有序数组中的重复项 (Remove Duplicates from Sorted Array)
// @Author: robert.sunq
// @Date: 2023-10-03 23:03:39
// @Runtime: 0 ms
// @Memory: 42.6 MB

class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int fast = 1, slow = 1;
        while (fast < n) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }
}
