
```
// @Title: 只出现一次的数字 III (Single Number III)
// @Author: robert.sunq
// @Date: 2023-10-16 23:21:55
// @Runtime: 0 ms
// @Memory: 42.6 MB

class Solution {
    public int[] singleNumber(int[] nums) {
        // 所有的元素异或起来， 得到最终两个独立数字的 异或结果
        // 从最终的结果可以得知， 某一位为 1 时， 表示这两个独立的数字，在这一位上分别为 0 和 1
        // 所以可以通过这个规律来判断将 nums 分为两个数组，这两个独立的数字就会分别属于两个数组，
        // 之后在将两组数进行异或就得到结果


        int result = 0;
        for (int n : nums) {
            result = result ^ n;
        }

        // 防止溢出, 因为 result != 0，所以 可以 result & -result 来获取最低位的1的位置
        result = (result == Integer.MIN_VALUE) ? result : (result & (-result));

        int group1 = 0;
        int group2 = 0;
        for (int n : nums) {
            if ((n & result) != 0) {
                group1 = group1 ^ n;
            } else {
                group2 = group2 ^ n;
            }
        }

        return new int[]{group1, group2};
    }
}
