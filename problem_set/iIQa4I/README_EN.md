
| English | [简体中文](README.md) |

# [剑指 Offer II 038. 每日温度](https://leetcode.cn//problems/iIQa4I/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
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
```



## Related Topics

- [Stack](https://leetcode.cn//tag/stack)
- [Array](https://leetcode.cn//tag/array)
- [Monotonic Stack](https://leetcode.cn//tag/monotonic-stack)

## Similar Questions


