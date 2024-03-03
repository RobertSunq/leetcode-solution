
```
// @Title: 多数元素 (Majority Element)
// @Author: robert.sunq
// @Date: 2023-10-08 21:44:00
// @Runtime: 1 ms
// @Memory: 47.3 MB

class Solution {
    public int majorityElement(int[] nums) {
        int ans = nums[0];
        int count = 1;
        int i = 1;
        while (i < nums.length) {
            if (nums[i] != ans) {
                count--;
                if (count == 0) {
                    ans = nums[i];
                    count = 1;
                }
            } else {
                count++;
            }
            i++;
        }

        return ans;
    }
}
