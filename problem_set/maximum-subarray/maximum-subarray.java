
```
// @Title: 最大子数组和 (Maximum Subarray)
// @Author: robert.sunq
// @Date: 2021-08-08 15:59:00
// @Runtime: 1 ms
// @Memory: 38.5 MB

class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        // 表示连续数组的长度
        int len = nums.length;
        // temp 前一个串中的连续串最大值
        int temp = nums[0];
        // int[] dp = new int[len];
        // dp[0] = nums[0];
        // dp[i] 以i为结尾的最大连续子数组和， 且必须包含当前位。
        for(int i=1;i<len;i++){
            // 前一串的最大值加上当前位， 对当前位产生负增益，则当前为位置的最大值位当前值
            temp = Math.max(nums[i],temp+nums[i]);
            res = Math.max(res,temp);
        }
        return res;

    }
}
