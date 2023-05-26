
```
// @Title: 前 n 个数字二进制中 1 的个数 (前 n 个数字二进制中 1 的个数)
// @Author: robert.sunq
// @Date: 2023-05-25 22:25:16
// @Runtime: 1 ms
// @Memory: 45.1 MB

class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n+1];

        for (int i = 1; i <= n ; i++) {
            result[i] = (i % 2) + result[i/2];
        }

        return result;
    }
}
