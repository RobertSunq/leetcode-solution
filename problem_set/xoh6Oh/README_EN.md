
| English | [简体中文](README.md) |

# [剑指 Offer II 001. 整数除法](https://leetcode.cn//problems/xoh6Oh/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>

## Solutions


### Java

```Java
// @Title: 整数除法 (整数除法)
// @Author: robert.sunq
// @Date: 2023-05-25 00:59:19
// @Runtime: 1 ms
// @Memory: 38.6 MB

class Solution {
    public int divide(int a, int b) {
        if ( a == 0) {
            return 0;
        }
        // 判断是不是相同符号， 同符号相加，不同号相减
        int sameSymbol = sameSymbol(a, b);

        int result = 0;
        
        // 记录 b 的放大倍数
        int i = 1;
        int bi = b;
        int is_bi_max = -1;
        int max_bi = Integer.MAX_VALUE >> 1;
        // 同号相减去，求和之后变符号了，则说明被除数大
        while ( 
            canSub(sameSymbol, a, b) > 0
        ) {
            if ((bi < 0 && -bi >= max_bi) || (bi > 0 && bi >= max_bi)) {
                is_bi_max = 1;
            }
            // a 的剩余量仍大于 bi， 则b做减法，bi可以直接放大  加速计算
            if (canSub(sameSymbol, a, bi) > 0) {
                if (sameSymbol > 0) {
                    // 判断结果是不是在取值范围， 即做操作后超限
                    if (result + i < 0) {
                        return Integer.MAX_VALUE;
                    }
                    a = a - bi;
                    result = result + i;
                } else {
                    if (result - i > 0) {
                        return Integer.MAX_VALUE;
                    }
                    a = a + bi;
                    // 不同符 做减法来计数， 负数可以达到 - 2^31
                    result = result - i;
                }
                // 达到最大值之后就没必要增加了
                if (is_bi_max < 0) {
                    bi = bi + bi;
                    i = i + i;
                }
            } else {
                // a 的剩余量不足 bi  则 bi 右移做缩小，i 也右移动
                bi = bi >> 1;
                i = i >> 1;
                is_bi_max = 1;
            }
        }
        return result;
    }

    // 判断是否同符号
    private int sameSymbol(int a, int b) {
        int status = 1;
        if (a < 0) {
            status = 0 - status;
        }
        if (b < 0) {
            status = 0 - status;
        }
        return status;
    }

    // 判断 a 的绝对值是否大于b， 即 a 除以 b 大于1
    private int canSub(int sameSymbol, int a , int b) {
        // 同符号下，如果相减，被减数与结果同符号（或者是 0 相等），则可以除法
        // 不同符号下，相加，....
        if (
            (a != 0 && sameSymbol > 0 && (sameSymbol(a, a - b) > 0 || (a - b) ==0))
            || (a != 0 && sameSymbol < 0 && (sameSymbol(a, a + b) > 0 || (a + b) ==0))
        ) {
            return 1;
        } else {
            return -1;
        }
    }
}
```



## Related Topics

- [Bit Manipulation](https://leetcode.cn//tag/bit-manipulation)
- [Math](https://leetcode.cn//tag/math)

## Similar Questions


