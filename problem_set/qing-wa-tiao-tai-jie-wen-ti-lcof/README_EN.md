
| English | [简体中文](README.md) |

# [剑指 Offer 10- II. 青蛙跳台阶问题  LCOF](https://leetcode.cn//problems/qing-wa-tiao-tai-jie-wen-ti-lcof/)

## Description

English description is not available for the problem. Please switch to Chinese.

## Solutions


### Java

```Java
// @Title: 青蛙跳台阶问题 (青蛙跳台阶问题  LCOF)
// @Author: robert.sunq
// @Date: 2021-05-24 23:17:10
// @Runtime: 0 ms
// @Memory: 35.3 MB

class Solution {
    public int numWays(int n) {
        int f0 = 1, f1 = 1,fn;
        for (int i = 0 ; i< n ; i++){
            fn = (f1+f0) % 1000000007;
            f0 = f1;
            f1 = fn;
        } 
        return f0;
    }
}
```



## Related Topics

- [Memoization](https://leetcode.cn//tag/memoization)
- [Math](https://leetcode.cn//tag/math)
- [Dynamic Programming](https://leetcode.cn//tag/dynamic-programming)

## Similar Questions


