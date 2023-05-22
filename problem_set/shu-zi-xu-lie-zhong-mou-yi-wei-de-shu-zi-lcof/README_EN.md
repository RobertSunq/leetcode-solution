
| English | [简体中文](README.md) |

# [剑指 Offer 44. 数字序列中某一位的数字  LCOF](https://leetcode.cn//problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/)

## Description

English description is not available for the problem. Please switch to Chinese.

## Solutions


### Java

```Java
// @Title: 数字序列中某一位的数字 (数字序列中某一位的数字  LCOF)
// @Author: robert.sunq
// @Date: 2021-05-29 20:40:53
// @Runtime: 0 ms
// @Memory: 35.5 MB

class Solution {
    public int findNthDigit(int n) {
        int di = 1;
        // 使用long 是位了当N 接近与最大值，一下为的数量会超限
        long count = 9;
        long start = 1;
        // 检验是否是 在下一位中
        while(n > count){
            // 减去当前位数里 的 数字数量
            n = n - (int)count;
            // 下一位数的开始 数字
            start = start * 10;
            // 下一位
            di = di + 1;
            // 下一位的数量
            count = di * start * 9;  
        }
        // 当前位 的 第n -1个数， 剪1时去除整个数列的第一位 “0”
        long num = start + (n-1) / di;
        // 在当前数字种的第 (n-1) % di 位
        // return Long.toString(num).charAt((n-1) % di) - '0';
        return String.valueOf(num).charAt((n-1) % di) - '0';
    }
}
```



## Related Topics

- [Math](https://leetcode.cn//tag/math)
- [Binary Search](https://leetcode.cn//tag/binary-search)

## Similar Questions


