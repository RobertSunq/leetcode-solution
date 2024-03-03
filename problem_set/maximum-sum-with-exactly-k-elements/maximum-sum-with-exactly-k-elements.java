
```
// @Title: K 个元素的最大和 (Maximum Sum With Exactly K Elements )
// @Author: robert.sunq
// @Date: 2023-11-15 22:28:27
// @Runtime: 1 ms
// @Memory: 42.1 MB

class Solution {
    public int maximizeSum(int[] nums, int k) {
        int max = 0;
        for (int i : nums) {
            max = Math.max(i, max);
        }

        return (max + (max + k - 1)) * k / 2;
    }
}
