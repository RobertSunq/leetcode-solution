
```
// @Title: 最短无序连续子数组 (Shortest Unsorted Continuous Subarray)
// @Author: robert.sunq
// @Date: 2021-06-23 22:39:00
// @Runtime: 2 ms
// @Memory: 39.9 MB

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int res = 0;
        // 从左往右走找到第一个逆序的位置
        int left = 1;
        while(left<len && nums[left-1] <= nums[left]){
            left++;
        }
        //  如果走到最后都没有找到，那就不需要调整
        if(left == len) return res;
        // 存在逆序，则找逆序后最小的元素位置
        int temp = left;
        while(temp<len){
            if(nums[temp] < nums[left]){
                left = temp;
            }
            temp++;
        }
        // 找到 left 应该存在的位置
        temp = 0;
        while(temp<=left && nums[temp] <= nums[left]){
            temp++;
        }
        // 表示要插入的位置
        left = temp;
        // 否则 从右往左走 找
        int right = len -2;
        while(right>0 && nums[right] <= nums[right+1]){
            right--;
        }
        // 找到逆序后的最大元素
        temp = right;
        while(temp>=0){
            if(nums[temp]>nums[right]){
                right = temp;
            }
            temp--;
        }
        // 找到 right 应该存在的位置
        temp = len-1;
        while(temp>=right && nums[right] <= nums[temp]){
            temp--;
        }
        right = temp;
        return right - left +1;
    }
}
