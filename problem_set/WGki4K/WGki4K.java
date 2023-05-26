
```
// @Title: 只出现一次的数字  (只出现一次的数字 )
// @Author: robert.sunq
// @Date: 2023-05-25 23:44:04
// @Runtime: 3 ms
// @Memory: 42.9 MB

class Solution {
    public int singleNumber(int[] nums) {
        // DFA 的解法有点不太懂，不太好理解， DFA 的解法 放到Cpp中
        // 这里来计数字二进制后，每个位上数字的和对三取余， 预留下来的就是只出现一次的数字在该位置上的数值
        // 主要是注意下对符号位的理解， 
        int[] cnt = new int[32];
        for (int x : nums) {
            for (int i = 0; i < 32; i++) {
                // 采用直接位移 并且 & 1 判断该位是不是 1
                // 因为 -3 > 1 = -2,  即  -3 % 2 = -1
                if (((x >> i) & 1) == 1) {
                    cnt[i]++;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            // 直接左移到符号位即可
            if ((cnt[i] % 3 & 1) == 1) {
                ans += (1 << i);
            }
        }
        return ans;
    }
}
