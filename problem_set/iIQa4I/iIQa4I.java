
```
// @Title: 每日温度 (每日温度)
// @Author: robert.sunq
// @Date: 2023-07-02 22:10:08
// @Runtime: 1141 ms
// @Memory: 55.4 MB

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        ans[n - 1] = 0;
        if (n <2) {
            return ans;
        }
        for (int i = n - 2; i>= 0; i--) {
            if (temperatures[i] < temperatures[i+1]) {
                ans[i] = ans[i] + 1;
            } else {
                int j = i+1;
                while (j < n ) {
                    if (temperatures[i] < temperatures[j]) {
                        ans[i] = j - i;
                        break; 
                    }
                    j++;
                }
                if (j == n) {
                    ans[i] = 0;
                }
            }
        }

        return ans;
    }
}
