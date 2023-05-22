
```
// @Title: 只出现一次的数字 (Single Number)
// @Author: robert.sunq
// @Date: 2021-06-09 23:47:54
// @Runtime: 1 ms
// @Memory: 38.6 MB

class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i=0;i<nums.length;i++){
            // 相等的元素异或 为 0   0 与任何元素异或 元素值不变
            res = res ^ nums[i];
        }
        return res;
    }
}
