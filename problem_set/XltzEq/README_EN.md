
| English | [简体中文](README.md) |

# [剑指 Offer II 018. 有效的回文](https://leetcode.cn//problems/XltzEq/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 有效的回文 (有效的回文)
// @Author: robert.sunq
// @Date: 2023-06-15 00:14:37
// @Runtime: 3 ms
// @Memory: 40.9 MB

class Solution {
    public boolean isPalindrome(String s) {
        int start = 0;
        int n = s.length();
        int end = n - 1;
        s = s.toLowerCase();
        char cStart;
        char cEnd;
        while (start < end) {
            cStart = s.charAt(start);
            cEnd = s.charAt(end);
            
            while ( !isNumOrEnglish(cStart)) {
                start++;
                if (start >= n) {
                    return true;
                }
                cStart = s.charAt(start);
            }

            while ( !isNumOrEnglish(cEnd)) {
                end--;
                if (end < 0) {
                    return true;
                }
                cEnd = s.charAt(end);
            }
            if (cEnd != cStart) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private boolean isNumOrEnglish(char c) {
        if (c >= 'a' && c <= 'z') {
            return true;
        }

        return c >= '0' && c <= '9';
    }
}
```



## Related Topics

- [Two Pointers](https://leetcode.cn//tag/two-pointers)
- [String](https://leetcode.cn//tag/string)

## Similar Questions


