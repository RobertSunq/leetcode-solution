
```
// @Title: x 的平方根  (Sqrt(x))
// @Author: robert.sunq
// @Date: 2021-07-07 00:02:57
// @Runtime: 1 ms
// @Memory: 35.4 MB

class Solution {
    public int mySqrt(int x) {
        if(x == 1) return 1;
        int min = 0;
        int max = x;
        // 通过左右逼近，
        while(max - min > 1){
            // 判断上下线中位数，是否是符合要求
            int m = (max+min)/2;
            // 采用除法，避免乘法的溢出
            if(x/m < m){
                // 此时M比 x 实际平方根大  ， 上线下移
                max = m;
            }else{
                min = m;
            }
        }
        return min;
    }
}
