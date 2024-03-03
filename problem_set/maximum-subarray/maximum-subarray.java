
```
// @Title: 最大子数组和 (Maximum Subarray)
// @Author: robert.sunq
// @Date: 2023-11-20 22:35:31
// @Runtime: 1 ms
// @Memory: 56.8 MB

class Solution {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int n = nums.length;

        // 表示前一串的最大值
        int tmp = nums[0];
        // int[] dp = new int[n];
        // dp[0] = nums[0];
        // dp[i] 以 i 为结尾   的最大连续子数组之和
        
        
        for(int i = 1; i < n; i++) {
            // 注意这里是计算当前串的包含 当前位 的最大和
            // 如果前一个串(包含了前一位)的最大值和   "对当前值" 产生了负增益,则包含当前串的最大值应该是当前值
            // 反之, 则是当前值 加上前一个串的最大和
            tmp = Math.max(nums[i], nums[i] + tmp);

            // 上面是计算了包含当前位的最大值,  这里就是为了保存其中遍历到某一个位置时候曾经出现的最大值
            ans = Math.max(ans, tmp);
        }

        return ans;
    }
}
