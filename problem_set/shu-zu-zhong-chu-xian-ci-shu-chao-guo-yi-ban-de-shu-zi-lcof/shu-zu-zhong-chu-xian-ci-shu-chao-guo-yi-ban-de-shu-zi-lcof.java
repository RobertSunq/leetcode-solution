
```
// @Title: 数组中出现次数超过一半的数字 (数组中出现次数超过一半的数字  LCOF)
// @Author: robert.sunq
// @Date: 2021-05-28 00:15:06
// @Runtime: 1 ms
// @Memory: 41.7 MB

class Solution {
    public int majorityElement(int[] nums) {
        int num = nums[0];
        int n=0;
        for(int i =0;i<nums.length;i++){
            if  (n == 0){
                num = nums[i];
                n++;
            }else{
                if(nums[i] == num) n++;
                else n-- ;
            }
            
        }
        return num;
    }
}
