
| English | [简体中文](README.md) |

# [剑指 Offer 58 - II. 左旋转字符串 LCOF](https://leetcode.cn//problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 左旋转字符串 (左旋转字符串 LCOF)
// @Author: robert.sunq
// @Date: 2021-08-04 22:36:31
// @Runtime: 6 ms
// @Memory: 38.3 MB

class Solution {
    public String reverseLeftWords(String s, int n) {
        // return s.substring(n,s.length()) + s.substring(0,n);
        StringBuilder res = new StringBuilder();
        for(int i=0;i<s.length();i++){
            res.append(s.charAt((n + i) % s.length()));
        }
        return res.toString();
    }
}
```



## Related Topics

- [Math](https://leetcode.cn//tag/math)
- [Two Pointers](https://leetcode.cn//tag/two-pointers)
- [String](https://leetcode.cn//tag/string)

## Similar Questions


