
| English | [简体中文](README.md) |

# [剑指 Offer 11. 旋转数组的最小数字  LCOF](https://leetcode.cn//problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/)

## Description

English description is not available for the problem. Please switch to Chinese.

## Solutions


### Java

```Java
// @Title: 旋转数组的最小数字 (旋转数组的最小数字  LCOF)
// @Author: robert.sunq
// @Date: 2021-05-24 23:50:28
// @Runtime: 0 ms
// @Memory: 38.4 MB

class Solution {
    public int minArray(int[] numbers) {
        for(int i = 0; i < numbers.length; i++){
        if(numbers[i] < numbers[0]){
            return numbers[i];
        }
    }
    return numbers[0];
    }
}
```



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Binary Search](https://leetcode.cn//tag/binary-search)

## Similar Questions


