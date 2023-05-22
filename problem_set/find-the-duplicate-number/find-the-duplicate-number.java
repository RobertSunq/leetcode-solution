
```
// @Title: 寻找重复数 (Find the Duplicate Number)
// @Author: robert.sunq
// @Date: 2021-07-11 16:50:25
// @Runtime: 4 ms
// @Memory: 54.3 MB

class Solution {
    public int findDuplicate(int[] nums) {
        int i = 0;
        while(i<nums.length){
            if(nums[i] == i){
                i++;
                continue;
            }
            if(nums[i] == nums[nums[i]]) return nums[i];
            int temp = nums[i];
            nums[i] = nums[temp];
            nums[temp] = temp;
        }
        return -1;
    }
}
