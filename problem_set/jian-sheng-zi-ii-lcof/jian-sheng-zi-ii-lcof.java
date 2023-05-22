
```
// @Title: 剪绳子 II (剪绳子 II LCOF)
// @Author: robert.sunq
// @Date: 2021-05-25 22:32:01
// @Runtime: 0 ms
// @Memory: 35 MB

class Solution {
    public int cuttingRope(int n) {
        if(n < 3) return 1;
        if (n == 3 ) return 2;
        long m = 1;
        int p = (int) 1e9+7;
        // 由数学规律知道，每次剪掉三 积最大
        // 余数 2 -- 乘2 
        // 余数 3 -- 乘3
        // 余数 4 -- 乘4  相当于剪成 2 * 2
        while(n > 4) {
            n = n-3;
            m = m*3 % p;
        }
        return (int)(m*n % p);
    }
}
