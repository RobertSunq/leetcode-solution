
| English | [简体中文](README.md) |

# [剑指 Offer 67. 把字符串转换成整数 LCOF](https://leetcode.cn//problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/)

## Description

English description is not available for the problem. Please switch to Chinese.

## Solutions


### Java

```Java
// @Title: 把字符串转换成整数 (把字符串转换成整数 LCOF)
// @Author: robert.sunq
// @Date: 2021-05-31 22:16:50
// @Runtime: 2 ms
// @Memory: 38 MB

class Solution {
    public int strToInt(String str) {
        String s = str.trim();
        if(s.length() < 1)  return 0;
        char[] schar = s.toCharArray();
        int i = 0;
        int flag = 1;
        if(schar[i] != '-' && (schar[i] < '0' || schar[i] > '9') && schar[i] != '+') return 0;
        if(schar[i] == '-'){
            flag = -1;
            i++;
        } else if(schar[i]=='+') i++;
        int res = 0,b = Integer.MAX_VALUE / 10;
        for( ; i<schar.length;i++){
            // 是数字
            if(schar[i] < '0' || schar[i] > '9') break;
                // 判断加上这一位是否会超限
                // Integer.MAX_VALUE = 2147483647, 负数时最后一位可以为 8 但是此时结果也就是最小值，故不需要特殊考虑
                if( res > b || res == b && schar[i] > '7'){
                    if(flag == 1) return Integer.MAX_VALUE;
                    else return Integer.MIN_VALUE;
                }
                res = res* 10 + schar[i] - '0';
        }
        return res*flag;
    }
}
```



## Related Topics

- [String](https://leetcode.cn//tag/string)

## Similar Questions


