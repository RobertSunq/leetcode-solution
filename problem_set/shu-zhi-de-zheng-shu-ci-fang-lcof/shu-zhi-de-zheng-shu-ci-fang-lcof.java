
```
// @Title: 数值的整数次方 (数值的整数次方 LCOF)
// @Author: robert.sunq
// @Date: 2021-05-25 23:08:15
// @Runtime: 1 ms
// @Memory: 37.6 MB

class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        boolean flag = false;
        if (n<0) {
          flag = true; 
          n = -n; 
        }
        double powNum = x;
        n--;
        while(n > 0) {
            // 奇数时，算一次；
            if((n%2) == 1) {
                powNum = powNum*x;
                n--;
            }else{
                // 偶数时将，可将幂低放大（注意这里时幂低，而不是积）
                x = x*x;
                n>>=1;
            }
            
        }
        if(flag) return 1/powNum;
        return powNum;
    }
}
