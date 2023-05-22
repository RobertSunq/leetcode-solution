
| English | [简体中文](README.md) |

# [剑指 Offer 15. 二进制中1的个数 LCOF](https://leetcode.cn//problems/er-jin-zhi-zhong-1de-ge-shu-lcof/)

## Description

English description is not available for the problem. Please switch to Chinese.

## Solutions


### Java

```Java
// @Title: 二进制中1的个数 (二进制中1的个数 LCOF)
// @Author: robert.sunq
// @Date: 2021-05-25 22:43:24
// @Runtime: 1 ms
// @Memory: 35.1 MB

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int weight = 0;
        // 因为输入的值二进制，所有最高位为1，int表达的时候会变为负数，故使用不等于零
        while( n !=0) {
            weight+=(n & 1);
            // 使用无符号的左移
            n = n>>>1;
        }
        return weight;
    }
}
```



## Related Topics

- [Bit Manipulation](https://leetcode.cn//tag/bit-manipulation)

## Similar Questions


