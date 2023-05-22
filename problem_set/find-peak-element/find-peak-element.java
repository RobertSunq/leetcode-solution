
```
// @Title: 寻找峰值 (Find Peak Element)
// @Author: robert.sunq
// @Date: 2021-07-18 16:15:36
// @Runtime: 0 ms
// @Memory: 38.1 MB

class Solution {
    public int findPeakElement(int[] nums) {
        // 因为左右边界可以认定为-无穷，则整个数组种必定存在一个峰值
        // 因为中间可假想为连续函数，且不全相等，则必然存在倒数为0点，即峰值，因为左右为负无穷，所以存在大峰值

        int l = 0,r = nums.length-1;
        // 故可以使用双指针，区间查找，中点大于右边，则峰值，必然存在于左边区间
        while(l<r){
            int mid = (l+r)/2;
            if( mid== nums.length-1){
                break;
            }
            if(nums[mid] >= nums[mid+1]){
                r = mid;
            }else{
                l = mid+1;
            }
        }

        return l;
    }
}
