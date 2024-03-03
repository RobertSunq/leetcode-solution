
```
// @Title: 三个无重叠子数组的最大和 (Maximum Sum of 3 Non-Overlapping Subarrays)
// @Author: robert.sunq
// @Date: 2023-11-19 20:48:39
// @Runtime: 3 ms
// @Memory: 44.7 MB

class Solution {


    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] ans = new int[3];
        int sum1 = 0, maxSum1 = 0, maxSum1Idx = 0;
        int sum2 = 0, maxSum12 = 0, maxSum12Idx1 = 0, maxSum12Idx2 = 0;
        int sum3 = 0, maxTotal = 0;

        for (int i = k * 2; i < nums.length; i++) {
            sum1 = sum1 + nums[i -  k * 2];
            sum2 = sum2 + nums[i - k];
            sum3 = sum3 + nums[i];

            // 三个数组都补全了 k 个元素
            if (i >= k * 3 - 1) {
                // 第一个组和最大时， 索引位置
                if (sum1 > maxSum1) {
                    maxSum1 = sum1;
                    maxSum1Idx = i - k * 3 + 1;
                }
                // 当前两个数组和最大时， 两个数组的索引
                if (maxSum1 + sum2 > maxSum12) {
                    maxSum12 = maxSum1 + sum2;
                    maxSum12Idx1 = maxSum1Idx;
                    maxSum12Idx2 = i - k * 2 + 1;
                }

                if (maxSum12 + sum3 > maxTotal) {
                    maxTotal = maxSum12 + sum3;
                    ans[0] = maxSum12Idx1;
                    ans[1] = maxSum12Idx2;
                    ans[2] = i - k + 1;
                }
                sum1 = sum1 - nums[i - k * 3 + 1];
                sum2 = sum2 - nums[i - k * 2 + 1];
                sum3 = sum3 - nums[i - k + 1];
            }
        }

        return ans;
    }
}
