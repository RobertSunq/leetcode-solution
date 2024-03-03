
```
// @Title: 或运算的最小翻转次数 (Minimum Flips to Make a OR b Equal to c)
// @Author: robert.sunq
// @Date: 2023-09-26 21:40:22
// @Runtime: 0 ms
// @Memory: 38.1 MB

class Solution {
    public int minFlips(int a, int b, int c) {
        int ans = 0;
        while (c != 0) {
            int ai = a % 2;
            int bi = b % 2;
            int ci = c % 2;

            a = a / 2;
            b = b / 2;
            c = c / 2;

            if ((ai | bi) != ci) {
                if (ci == 0) {
                    ans = ans + bi + ai;
                } else {
                    ans = ans  + 1;
                }
            }
        }

        while (a != 0) {
            int ai = a % 2;
            a = a / 2;
            ans = ans + ai;
        }

        while (b != 0) {
            int bi = b % 2;
            b = b / 2;
            ans = ans + bi;
        }

        return ans;
    }
}
