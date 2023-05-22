
```
// @Title: 在排序数组中查找数字 I (在排序数组中查找数字  LCOF)
// @Author: robert.sunq
// @Date: 2021-05-30 02:39:26
// @Runtime: 1 ms
// @Memory: 41.6 MB

class Solution {
    public int search(int[] nums, int target) {
        int res = 0;
        for(int i=0;i<nums.length;i++){
            if (nums[i] == target) res++;
        }
        return res;
    }
}
