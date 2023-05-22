
```
// @Title: 青蛙跳台阶问题 (青蛙跳台阶问题  LCOF)
// @Author: robert.sunq
// @Date: 2021-05-24 23:17:10
// @Runtime: 0 ms
// @Memory: 35.3 MB

class Solution {
    public int numWays(int n) {
        int f0 = 1, f1 = 1,fn;
        for (int i = 0 ; i< n ; i++){
            fn = (f1+f0) % 1000000007;
            f0 = f1;
            f1 = fn;
        } 
        return f0;
    }
}
