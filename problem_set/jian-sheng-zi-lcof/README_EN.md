
| English | [简体中文](README.md) |

# [剑指 Offer 14- I. 剪绳子  LCOF](https://leetcode.cn//problems/jian-sheng-zi-lcof/)

## Description

English description is not available for the problem. Please switch to Chinese.

## Solutions


### Java

```Java
// @Title: 剪绳子 (剪绳子  LCOF)
// @Author: robert.sunq
// @Date: 2021-05-25 22:22:22
// @Runtime: 1 ms
// @Memory: 35.1 MB

class Solution {
    public int cuttingRope(int n) {
        if(n<3) return 1;
        int[] dp = new int[n+1];
        dp[1]=1;dp[2]=1;
        for (int i = 3;i<=n;i++){
            for (int j = 2 ;j<i;j++){
                // 及长度为i是，最大长度应该是 (i-j) 还是 （j*dp[i-j]）绳子长为i-j的最大值 还是当前剪j不是最优解
                dp[i] = Math.max(dp[i],Math.max((j*(i-j)) ,(j*dp[i-j])));
            }
        }
        return dp[n];
    }
}
```



### C++

```C++
// @Title: 剪绳子 (剪绳子  LCOF)
// @Author: robert.sunq
// @Date: 2020-05-14 13:25:51
// @Runtime: 0 ms
// @Memory: 5.9 MB

class Solution {
public:
    int cuttingRope(int n) {
        vector <int> dp(n+1,0);
        if(n<3) return 1;
        dp[0] = 1;
        for(int i=1;i<=(n+1)/2;i++){
            for(int j=i;j<=n;j++)
                {   
                    dp[j] = max(dp[j],dp[j-i]*i);
                }
        }
        return dp[n];
    }
};
```



## Related Topics

- [Math](https://leetcode.cn//tag/math)
- [Dynamic Programming](https://leetcode.cn//tag/dynamic-programming)

## Similar Questions


