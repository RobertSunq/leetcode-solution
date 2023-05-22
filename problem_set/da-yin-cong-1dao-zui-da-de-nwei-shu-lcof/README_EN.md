
| English | [简体中文](README.md) |

# [剑指 Offer 17. 打印从1到最大的n位数 LCOF](https://leetcode.cn//problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/)

## Description

English description is not available for the problem. Please switch to Chinese.

## Solutions


### Java

```Java
// @Title: 打印从1到最大的n位数 (打印从1到最大的n位数 LCOF)
// @Author: robert.sunq
// @Date: 2021-05-25 23:15:10
// @Runtime: 1 ms
// @Memory: 46.3 MB

class Solution {
    public int[] printNumbers(int n) {
        if (n == 0) return new int[0];
        int num = (int)Math.pow(10,n);
        int[] dp = new int[num-1];
        for (int i=0;i<num-1;i++){
            dp[i] = i+1;
        }
        return dp;
    }
}
```



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Math](https://leetcode.cn//tag/math)

## Similar Questions


