
```
// @Title: 汉明距离 (Hamming Distance)
// @Author: robert.sunq
// @Date: 2021-06-21 22:39:09
// @Runtime: 0 ms
// @Memory: 35.4 MB

class Solution {
    public int hammingDistance(int x, int y) {
        int temp = x ^ y;
        int res = 0;
        while(temp!=0){
            res += (temp & 1);
            temp >>= 1;
        }
        return res;
    }
}
