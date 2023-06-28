
| English | [简体中文](README.md) |

# [剑指 Offer II 032. 有效的变位词](https://leetcode.cn//problems/dKk3P7/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 有效的变位词 (有效的变位词)
// @Author: robert.sunq
// @Date: 2023-06-28 22:48:34
// @Runtime: 14 ms
// @Memory: 42.6 MB

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        boolean ans =  true;
        for (int i = 0; i < s.length(); i++) {

            Character c = s.charAt(i);
            ans = ans && c == t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        if (ans) {
            return false;
        }

        for (int i = 0; i < t.length(); i++) {
            Character c = t.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) < 0) {
                    return false;
                }
                continue;
            }
            return false;
        }

        return true;

    }
}
```



## Related Topics

- [Hash Table](https://leetcode.cn//tag/hash-table)
- [String](https://leetcode.cn//tag/string)
- [Sorting](https://leetcode.cn//tag/sorting)

## Similar Questions


