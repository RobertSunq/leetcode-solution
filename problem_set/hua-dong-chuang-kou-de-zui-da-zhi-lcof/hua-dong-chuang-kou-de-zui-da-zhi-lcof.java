
```
// @Title: 滑动窗口的最大值 (滑动窗口的最大值 LCOF)
// @Author: robert.sunq
// @Date: 2021-05-30 21:05:52
// @Runtime: 2 ms
// @Memory: 46.3 MB

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int maxNum = Integer.MIN_VALUE;
        if(nums.length < 1) return new int[0];
        int[] res = new int[nums.length - k + 1];
        int j = 0;
        while(j<k){
            maxNum = Math.max(nums[j],maxNum);
            j++;
        }
        int i = 0;
        res[i] = maxNum;
        while(j<nums.length){
            i++;
            if(nums[j] >= maxNum){
                maxNum = nums[j];
            }else{
                if(nums[i-1] >= maxNum){
                    maxNum = Integer.MIN_VALUE;
                    for(int t=i;t<=j;t++){
                        maxNum = Math.max(maxNum,nums[t]);
                    }
                }
            }
            res[i] = maxNum;
            j++;
        }
        return res;
    }
}
