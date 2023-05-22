
| English | [简体中文](README.md) |

# [剑指 Offer 64. 求1+2+…+n LCOF](https://leetcode.cn//problems/qiu-12n-lcof/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 求1+2+…+n (求1+2+…+n LCOF)
// @Author: robert.sunq
// @Date: 2021-05-30 23:09:33
// @Runtime: 1 ms
// @Memory: 35.8 MB

class Solution {
    public int sumNums(int n) {
        return n == 1? 1: n + sumNums(n-1);
    }
}
```



## Related Topics

- [Bit Manipulation](https://leetcode.cn//tag/bit-manipulation)
- [Recursion](https://leetcode.cn//tag/recursion)
- [Brainteaser](https://leetcode.cn//tag/brainteaser)

## Similar Questions


