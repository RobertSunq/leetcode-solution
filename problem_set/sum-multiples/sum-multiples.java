
```
// @Title: 倍数求和 (Sum Multiples)
// @Author: robert.sunq
// @Date: 2023-10-17 23:09:56
// @Runtime: 2 ms
// @Memory: 38.4 MB

class Solution {
    public int sumOfMultiples(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
                ans = ans + i;
            }
        }

        return ans;
    }
}
