
```
// @Title: 在排序数组中查找元素的第一个和最后一个位置 (Find First and Last Position of Element in Sorted Array)
// @Author: robert.sunq
// @Date: 2021-08-08 15:38:57
// @Runtime: 0 ms
// @Memory: 41.5 MB

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0,right = nums.length-1;
        int temp = 0;;
        while(left <= right){
            temp = (left+right)/2;
            // System.out.println(temp);
            if(nums[temp] == target) break;
            else if(nums[temp] > target) {
                right = temp-1;
            }else{
                left =temp+1;
            }
        }
        if(temp < 0 || temp >= nums.length ||nums[temp] != target ) return new int[]{-1,-1};
        left = temp;
        right = temp;
        while(left>=0 && nums[left] == target) left--;
        while(right<nums.length && nums[right] == target) right++;
        return new int[]{left+1,right-1};
    }
}
