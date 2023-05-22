
```
// @Title: 除自身以外数组的乘积 (Product of Array Except Self)
// @Author: robert.sunq
// @Date: 2021-06-17 23:26:30
// @Runtime: 1 ms
// @Memory: 48.7 MB

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        if(nums.length == 0) return res;
        int temp = 1;
        for(int i=0;i<nums.length;i++){
            res[i] =  temp;
            temp = temp*nums[i];
        }
        temp = 1;
        for (int i = nums.length-1;i>=0;i--){
            res[i] = res[i]*temp;
            temp = temp*nums[i];
        }
        return res;
    }
}
