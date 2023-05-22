
| English | [简体中文](README.md) |

# [剑指 Offer 53 - II. 缺失的数字  LCOF](https://leetcode.cn//problems/que-shi-de-shu-zi-lcof/)

## Description

English description is not available for the problem. Please switch to Chinese.

## Solutions


### Java

```Java
// @Title: 0～n-1中缺失的数字 (缺失的数字  LCOF)
// @Author: robert.sunq
// @Date: 2021-05-30 03:16:00
// @Runtime: 0 ms
// @Memory: 39 MB

class Solution {
    public int missingNumber(int[] nums) {
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] == m) i = m + 1;
            else j = m - 1;
        }
        return i;
    }
}
```



## Related Topics

- [Bit Manipulation](https://leetcode.cn//tag/bit-manipulation)
- [Array](https://leetcode.cn//tag/array)
- [Hash Table](https://leetcode.cn//tag/hash-table)
- [Math](https://leetcode.cn//tag/math)
- [Binary Search](https://leetcode.cn//tag/binary-search)

## Similar Questions


