
| English | [简体中文](README.md) |

# [剑指 Offer II 002. 二进制加法](https://leetcode.cn//problems/JFETK5/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 二进制加法 (二进制加法)
// @Author: robert.sunq
// @Date: 2023-05-25 16:41:32
// @Runtime: 2 ms
// @Memory: 41.3 MB

class Solution {
    public String addBinary(String a, String b) {
        int aLength = a.length();
        int bLength = b.length();

        // 进位值
        int add = 0;
        // 记录索引
        int aIndex = aLength - 1;
        int bIndex = bLength - 1;
        // 
        String result = "";
        while (aIndex >=0 || bIndex >= 0) {
            int aChar = 0;
            int bChar = 0;
            if (aIndex >= 0) {
                aChar = a.charAt(aIndex) - '0';
                aIndex--;
            }
            if (bIndex >= 0) {
                bChar = b.charAt(bIndex) - '0';
                bIndex--;
            }
            int sum = aChar + bChar + add;
            // 进位除法， 当前位取余数
            add = sum / 2;
            result = String.valueOf(sum % 2) + result;
        }
        if (add > 0) {
            result = "1" + result;
        }

        return result;
    }
}
```



## Related Topics

- [Bit Manipulation](https://leetcode.cn//tag/bit-manipulation)
- [Math](https://leetcode.cn//tag/math)
- [String](https://leetcode.cn//tag/string)
- [Simulation](https://leetcode.cn//tag/simulation)

## Similar Questions


