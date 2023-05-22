
```
// @Title: 0～n-1中缺失的数字 (缺失的数字  LCOF)
// @Author: robert.sunq
// @Date: 2021-05-30 03:16:00
// @Runtime: 0 ms
// @Memory: 39 MB

class Solution {
    public int missingNumber(int[] nums) {
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] == m) i = m + 1;
            else j = m - 1;
        }
        return i;
    }
}
