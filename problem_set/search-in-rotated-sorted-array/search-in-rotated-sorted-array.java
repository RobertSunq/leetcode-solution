
```
// @Title: 搜索旋转排序数组 (Search in Rotated Sorted Array)
// @Author: robert.sunq
// @Date: 2021-06-03 01:07:23
// @Runtime: 0 ms
// @Memory: 37.8 MB

class Solution {
    public int search(int[] nums, int target) {
        int i = 0 , j = nums.length-1,temp;
        while(i<=j){
            temp = (i+j)/2;
            if(nums[temp] == target) return temp;
            //  则此时中间点在 左半边排序数组中
            // 左半边有序
            if(nums[temp] >= nums[j]){
                // 在左侧中
                if (target >= nums[i] && target< nums[temp]) {
                    j=temp;
                }else{
                    i = temp+1;
                }
            }else{
                // 此时中间点 在右半边
                // 右半边有序
                if (target <= nums[j] && target> nums[temp]) {
                    i=temp+1;
                }else{
                    j = temp;
                }
            }
        }
        return -1;
    }
}
