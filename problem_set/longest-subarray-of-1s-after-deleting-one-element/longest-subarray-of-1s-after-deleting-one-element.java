
```
// @Title: 删掉一个元素以后全为 1 的最长子数组 (Longest Subarray of 1's After Deleting One Element)
// @Author: robert.sunq
// @Date: 2023-08-19 17:54:08
// @Runtime: 2 ms
// @Memory: 54.3 MB

class Solution {
    // https://leetcode.cn/problems/max-consecutive-ones-iii/?envType=study-plan-v2&envId=leetcode-75
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int left = 0;
        int lsum = 0;
        int rsum = 0;
        int ans = 0;
        for (int rigth = 0; rigth < n; rigth++) {
            rsum = rsum + (1 - nums[rigth]);
            while (lsum < rsum - 1) {
                lsum = lsum + (1 - nums[left]);
                left++;
            }
            ans = Math.max(ans, rigth - left);
        }

        return ans;
    }
}
