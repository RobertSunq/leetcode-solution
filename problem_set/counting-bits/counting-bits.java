
```
// @Title: 比特位计数 (Counting Bits)
// @Author: robert.sunq
// @Date: 2023-09-22 20:55:54
// @Runtime: 1 ms
// @Memory: 45 MB

class Solution {
    // 奇数后，是偶数，偶数后是奇数
    // 偶数最后一位是 0， 所以下一位奇数时尾变为 1， 即1个个数是前个数+1；
    // 偶数最后一位是 0， 所以 偶数中1的个数，应该是右移一位后的数的中1的个数相同（去掉二进制最后一位0）
    public int[] countBits(int n) {

        int[] dp = new int[n+1];

        for (int i = 0; i <= n; i++) {
            if (i % 2 == 1) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = dp[i >> 1];
            }
        }

        return dp;
    }
}
