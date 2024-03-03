
```
// @Title: 统计能整除数字的位数 (Count the Digits That Divide a Number)
// @Author: robert.sunq
// @Date: 2023-10-26 20:51:27
// @Runtime: 0 ms
// @Memory: 38.1 MB

class Solution {
    public int countDigits(int num) {
        int ans = 0;

        for (char c : Integer.toString(num).toCharArray()) {
            if (num % (c - '0') == 0) {
                ans++;
            }
        }

        return ans;
    }
}
