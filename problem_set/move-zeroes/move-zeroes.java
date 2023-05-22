
```
// @Title: 移动零 (Move Zeroes)
// @Author: robert.sunq
// @Date: 2021-06-18 23:26:33
// @Runtime: 0 ms
// @Memory: 38.6 MB

class Solution {
    public void moveZeroes(int[] nums) {
        // 双指针，left 指向当前不包含零的元素位置，i 移动指针，
        int left = 0,i=0;
        while(left < nums.length && i<nums.length){
            // i位置不为0 将其交换到 left位置
            if( nums[i] != 0){
                nums[left] = nums[i];
                i++;
                
                left++;
            }else{
                i++;
            }
        }
        // left 之前的元素 均为不为零，故将left之后的全部置换为0 即可
        for( ;left<nums.length;left++){
            nums[left] = 0;
        }
        
    }
}
