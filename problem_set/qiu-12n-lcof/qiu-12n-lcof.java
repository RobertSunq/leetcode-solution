
```
// @Title: 求1+2+…+n (求1+2+…+n LCOF)
// @Author: robert.sunq
// @Date: 2021-05-30 23:09:33
// @Runtime: 1 ms
// @Memory: 35.8 MB

class Solution {
    public int sumNums(int n) {
        return n == 1? 1: n + sumNums(n-1);
    }
}
