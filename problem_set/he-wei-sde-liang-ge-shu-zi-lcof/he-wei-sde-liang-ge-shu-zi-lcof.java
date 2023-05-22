
```
// @Title: 和为s的两个数字 (和为s的两个数字 LCOF)
// @Author: robert.sunq
// @Date: 2021-05-30 19:18:06
// @Runtime: 2 ms
// @Memory: 55.2 MB

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i = 0,j = nums.length-1;
        while(i < j && (nums[i]+nums[j] != target) ){
            int sum = nums[i]+nums[j];
            if(sum > target) j--;
            else if(sum < target) i++;
            else{
                break;
            }
        }
        if (i < j) return new int[]{nums[i],nums[j]};
        return new int[0];
    }
}
