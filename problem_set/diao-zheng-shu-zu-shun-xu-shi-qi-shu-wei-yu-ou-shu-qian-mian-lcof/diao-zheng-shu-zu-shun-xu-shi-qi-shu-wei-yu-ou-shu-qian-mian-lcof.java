
```
// @Title: 调整数组顺序使奇数位于偶数前面 (调整数组顺序使奇数位于偶数前面 LCOF)
// @Author: robert.sunq
// @Date: 2021-05-26 22:18:33
// @Runtime: 3 ms
// @Memory: 46.4 MB

class Solution {
    public int[] exchange(int[] nums) {
        int pre = 0,i = 0;
        // 不论pre所指位置为奇偶 最后再两个的分界线上，所以不需要过多考虑，直接交换即可
        while(i<nums.length && pre < nums.length) {
            if( (nums[i] % 2) == 1 ){
                int temp = nums[pre];
                nums[pre] = nums[i];
                nums[i] = temp;
                pre ++;
            }
            i++;
        }
        return nums;
    }
}
