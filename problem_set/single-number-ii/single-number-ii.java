
```
// @Title: 只出现一次的数字 II (Single Number II)
// @Author: robert.sunq
// @Date: 2023-10-15 22:05:08
// @Runtime: 2 ms
// @Memory: 42.3 MB

class Solution {
    public int singleNumber(int[] nums) {
        // 计算每一位1的数量， 然后对每一位进行对3趋于

        int[] count = new int[32];

        for (int n : nums) {
            int i = 0;
            while(n != 0) {
                count[i] = (count[i] + (n & 1)) % 3;
                n = n >>> 1;
                i++;
            }
        }

        int ans = 0;
        for (int i = 31; i > -1; i--) {
            ans = ans  + (count[i] << i);
        }

        return ans;
    }
}
