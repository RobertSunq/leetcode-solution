
```
// @Title: 最大连续1的个数 III (Max Consecutive Ones III)
// @Author: robert.sunq
// @Date: 2023-08-18 22:19:12
// @Runtime: 3 ms
// @Memory: 45.1 MB

class Solution {

    /**
    转化为 在区间  [left,right]  内。
    对于任意的右端点 right，希望找到最小的左端点 left，使得 [left,right] 包含不超过 k 个 0。
    通过枚举所有可能的右断电，将得到的区间长度取最大值，即可得到答案。

    将 数组中 0 1 翻转，则前缀和就是需要翻转的次数
     */
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;

        int left = 0;
        int lsum = 0;
        int rsum = 0;
        int ans = 0;
        for (int right = 0; right < n; right++) {
            // 1 - nums[right] 表示当前位置需要翻转一次
            rsum = rsum + ( 1 - nums[right]);
            // 如果窗口之内的翻转次数，大于K， 则需要移动左端点，来降低翻转次数
            while (lsum < rsum - k) {
                // 窗口下线的位置，需要翻转 的次数
                lsum = lsum + (1-nums[left]);
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}
