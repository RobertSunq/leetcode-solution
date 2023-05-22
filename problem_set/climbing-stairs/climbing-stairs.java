
```
// @Title: 爬楼梯 (Climbing Stairs)
// @Author: robert.sunq
// @Date: 2021-06-05 00:01:59
// @Runtime: 0 ms
// @Memory: 35 MB

class Solution {
    public int climbStairs(int n) {
        if ( n <= 0 ) return 0;
        int f0 = 1,f1= 1;
        for(int i = 0;i<n;i++){
            int temp = f0+f1;
            f0 = f1;
            f1 = temp;
        }
        return f0;
    }
}
