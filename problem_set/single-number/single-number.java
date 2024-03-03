
```
// @Title: 只出现一次的数字 (Single Number)
// @Author: robert.sunq
// @Date: 2023-10-14 19:59:10
// @Runtime: 1 ms
// @Memory: 43.6 MB

class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int n : nums) {
            ans = ans ^ n;
        }

        return ans;
    }
}
