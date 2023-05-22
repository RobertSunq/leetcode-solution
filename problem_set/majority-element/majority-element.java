
```
// @Title: 多数元素 (Majority Element)
// @Author: robert.sunq
// @Date: 2021-06-14 22:30:48
// @Runtime: 1 ms
// @Memory: 44.3 MB

class Solution {
    public int majorityElement(int[] nums) {
        if (nums.length <= 0) return -1;
        int temp = nums[0] , n = 0;
        for(int i = 0;i<nums.length;i++){
            if(n == 0) {
               temp=nums[i]; 
               n++;
            }
            else{
                if(nums[i] == temp){
                    n++;
                }else{
                    n--;
                }
            }
        } 
        return temp;
    }
}
