
| English | [简体中文](README.md) |

# [剑指 Offer II 019. 最多删除一个字符得到回文](https://leetcode.cn//problems/RQku0D/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 最多删除一个字符得到回文 (最多删除一个字符得到回文)
// @Author: robert.sunq
// @Date: 2023-06-15 23:12:53
// @Runtime: 4 ms
// @Memory: 43.4 MB

class Solution {
    public boolean validPalindrome(String s) {
        int start = 0;
        int n = s.length();
        int end = n - 1;
        int tmpStart, tmpEnd;
        while(start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                break;
            }
            start++;
            end--;
        }

        if (start >= end) {
            return true;
        }

        tmpStart = start;
        tmpEnd = end;
        // 移动其中一个点，表示删除了字符
        start++;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                break;
            }
            start++;
            end--;
        }

        if (start >= end) {
            return true;
        }

        // 移动另一边，表示删除了字符
        start = tmpStart;
        end = tmpEnd;
        end--;
        while(start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
```



## Related Topics

- [Greedy](https://leetcode.cn//tag/greedy)
- [Two Pointers](https://leetcode.cn//tag/two-pointers)
- [String](https://leetcode.cn//tag/string)

## Similar Questions


