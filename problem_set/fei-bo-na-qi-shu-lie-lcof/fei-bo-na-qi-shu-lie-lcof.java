
```
// @Title: 斐波那契数列 (斐波那契数列  LCOF)
// @Author: robert.sunq
// @Date: 2021-05-24 23:08:06
// @Runtime: 0 ms
// @Memory: 35.3 MB

class Solution {
    // 迭代模式会超时，选择使用循环（又称动态规划）
    public int fib(int n) {
        
        int min = 0,max = 1,sum ;
        for (int i = 0; i<n; i++){
            sum = (min + max) % 1000000007;
            min = max;
            max = sum ;
        }
        return min ;
    }
}
