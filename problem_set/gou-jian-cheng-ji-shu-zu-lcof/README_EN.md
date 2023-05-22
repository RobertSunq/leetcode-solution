
| English | [简体中文](README.md) |

# [剑指 Offer 66. 构建乘积数组 LCOF](https://leetcode.cn//problems/gou-jian-cheng-ji-shu-zu-lcof/)

## Description

English description is not available for the problem. Please switch to Chinese.

## Solutions


### Java

```Java
// @Title: 构建乘积数组 (构建乘积数组 LCOF)
// @Author: robert.sunq
// @Date: 2021-05-31 21:31:56
// @Runtime: 1 ms
// @Memory: 51.1 MB

class Solution {
    public int[] constructArr(int[] a) {
        int temp = 1;
        if(a.length < 1) return new int[0];
        int[] res = new int[a.length];
        for(int i=0;i<a.length;i++){
            res[i] = temp;
            temp = temp*a[i];
        }
        temp = 1;
        for(int i=a.length-1;i>=0;i--){
            res[i] = res[i]*temp;
            temp = temp*a[i];
        }
        return res;
    }
}
```



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Prefix Sum](https://leetcode.cn//tag/prefix-sum)

## Similar Questions


