
```
// @Title: 数组中重复的数字 (数组中重复的数字 LCOF)
// @Author: robert.sunq
// @Date: 2023-02-02 22:35:05
// @Runtime: 0 ms
// @Memory: 48.4 MB

class Solution {
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++){
            int index = nums[i];
             if (i == index){
                continue;
            }
            if (nums[index] == index){
                return index;
            }
            int tmp = nums[index];
            nums[index] = index;
            nums[i] = tmp;
            i--;
        }
        return -1;
    }
}
