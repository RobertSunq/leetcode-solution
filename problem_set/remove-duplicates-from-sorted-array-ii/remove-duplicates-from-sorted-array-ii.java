
```
// @Title: 删除有序数组中的重复项 II (Remove Duplicates from Sorted Array II)
// @Author: robert.sunq
// @Date: 2023-10-04 20:51:44
// @Runtime: 0 ms
// @Memory: 42.6 MB

class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int slow = 2, fast = 2;
        while (fast < n) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }
}
