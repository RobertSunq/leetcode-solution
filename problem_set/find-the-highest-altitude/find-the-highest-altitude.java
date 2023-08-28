
```
// @Title: 找到最高海拔 (Find the Highest Altitude)
// @Author: robert.sunq
// @Date: 2023-08-20 22:59:24
// @Runtime: 0 ms
// @Memory: 39 MB

class Solution {
    public int largestAltitude(int[] gain) {
        int ans = 0;
        int hight = 0;
        int n = gain.length;
        for (int i = 0; i < n ; i++) {
            hight = hight + gain[i];
            ans = Math.max(ans, hight);
        }

        return ans;
    }
}
