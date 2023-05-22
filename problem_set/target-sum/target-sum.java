
```
// @Title: 目标和 (Target Sum)
// @Author: robert.sunq
// @Date: 2021-06-21 23:15:45
// @Runtime: 586 ms
// @Memory: 35.9 MB

class Solution {
    int res = 0;
    public int findTargetSumWays(int[] nums, int target) {
        recur(nums,0,target);
        return res;
    }
    void recur(int[] nums , int i,int sum){
        if(i == nums.length && sum == 0) {
            res++;
            return;
        } 
        if(i>= nums.length) return;
        // 做加法
        recur(nums,i+1,sum+nums[i]);
        // 做减法
        recur(nums,i+1,sum - nums[i]);
    }
}
