
| English | [简体中文](README.md) |

# [剑指 Offer 65. 不用加减乘除做加法 LCOF](https://leetcode.cn//problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/)

## Description

English description is not available for the problem. Please switch to Chinese.

## Solutions


### Java

```Java
// @Title: 不用加减乘除做加法 (不用加减乘除做加法 LCOF)
// @Author: robert.sunq
// @Date: 2021-05-31 21:23:26
// @Runtime: 0 ms
// @Memory: 35.3 MB

class Solution {
    public int add(int a, int b) {
        // 位加
        // 每位上的进位为当前位的 与   &
        // 每位上的当前值为 异或 ^
        while(b != 0){
            // 进位值，需要将每位左移一位
            int c = (a & b) << 1;
            // 不加进位的求和
            a = a ^ b;
            // 将进位值赋予 b， 用于一下次的计算
            b = c;
        }
        // 最终结果保存在a
        return a;
    }
}
```



## Related Topics

- [Bit Manipulation](https://leetcode.cn//tag/bit-manipulation)
- [Math](https://leetcode.cn//tag/math)

## Similar Questions


