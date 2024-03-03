
```
// @Title: 最长奇偶子数组 (Longest Even Odd Subarray With Threshold)
// @Author: robert.sunq
// @Date: 2023-11-16 22:04:25
// @Runtime: 4 ms
// @Memory: 42.5 MB

class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int left = 0;
        int right = 0;
        int ans = 0;
        boolean b = true;
        int n = nums.length;
        while (right < n) {
            if (b) {
                // 当前位应该是偶数
                if ((nums[right] & 1) == 0 && nums[right] <= threshold) {
                    ans = Math.max(ans, right - left + 1);
                    b = false;
                } else {
                    left = right+1;
                }
            } else {
                // 当前位应该是奇数
                if ((nums[right] & 1) == 1 && nums[right] <= threshold) {
                    ans = Math.max(ans, right - left + 1);
                    b = true;
                } else {
                    // 当前位小于 threshold 才可以从当前位作为下一个组的起点
                    if (nums[right] <= threshold) {
                        left = right;
                    } else {
                        left = right + 1;
                        b = true;
                    }
                    
                }
            }
            right++;
        }

        return ans;
    }
}
