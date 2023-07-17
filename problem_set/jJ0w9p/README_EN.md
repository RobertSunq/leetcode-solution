
| English | [简体中文](README.md) |

# [剑指 Offer II 072. 求平方根](https://leetcode.cn//problems/jJ0w9p/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 求平方根 (求平方根)
// @Author: robert.sunq
// @Date: 2023-07-17 22:50:52
// @Runtime: 1 ms
// @Memory: 38.6 MB

class Solution {
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int  ans = -1; 
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if ((long) mid * mid <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
```



## Related Topics

- [Math](https://leetcode.cn//tag/math)
- [Binary Search](https://leetcode.cn//tag/binary-search)

## Similar Questions


