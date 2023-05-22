
```
// @Title: 长度最小的子数组 (Minimum Size Subarray Sum)
// @Author: robert.sunq
// @Date: 2021-07-18 16:43:56
// @Runtime: 1 ms
// @Memory: 38.4 MB

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l=0,r=0;
        int len = nums.length;
        int res = len+5;
        int sum = 0;
        while(r<len){
            sum = sum+nums[r];
            // 如果和大于目标值，则移动左侧指针
            if(sum >= target){
                while(sum >= target){
                    sum = sum - nums[l];
                    res = Math.min(res,r-l+1);
                    l++;
                }
            }
            r++;
        }
        return res == len+5?0:res;
    }
}
