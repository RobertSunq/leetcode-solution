
| English | [简体中文](README.md) |

# [剑指 Offer II 014. 字符串中的变位词](https://leetcode.cn//problems/MPnaiL/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 字符串中的变位词 (字符串中的变位词)
// @Author: robert.sunq
// @Date: 2023-06-11 19:07:18
// @Runtime: 27 ms
// @Memory: 42.5 MB

class Solution {
    /**
    通过计算 s2 中的一个子串是否包含 s1 的全部元素且个数相同，来判断是否复合包含变位词
     */
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> charToCount = new HashMap<>();
        // 统计聘书
        for ( int i = 0; i<s1.length(); i++) {
            charToCount.put(s1.charAt(i), charToCount.getOrDefault(s1.charAt(i), 0) + 1);
        }

        // 计算当前 s2 中子串的频数
        Map<Character, Integer> tmp = new HashMap<>();
        // 计算子串开始位置， 当出现子串中某个字符频数超过 s1 时， 用来后跳
        int startIndex = 0;
        for (int i = 0; i<s2.length(); i++) {
            Character c = s2.charAt(i);
            // 不包含该字符，重新查找子串
            if (!charToCount.containsKey(c)) {
                tmp = new HashMap<>();
                startIndex = i + 1;
                continue;
            }

            tmp.put(c, tmp.getOrDefault(c, 0) + 1);

            // 包含且当前字符频数相等，可以比较是否复合要求了
            // 注意 用 equals 而不是用 == , 因为  Integer > 127 不用 == 比较
            if(tmp.get(c).equals(charToCount.get(c))) {
                if (tmp.equals(charToCount)) {
                    return true;
                }
                continue;
            }
            
            // 当某个字符出现频数大于 s1 了， 就需要移动 s2 的子串到该字符在子串中第一次出现的位置，同时降低对应字符的频数。
            if (tmp.get(c) > charToCount.get(c)) {
                while(s2.charAt(startIndex) != c) {
                    tmp.put(s2.charAt(startIndex), tmp.get(s2.charAt(startIndex)) - 1);
                    startIndex++;
                }
                startIndex++;
                tmp.put(c, tmp.get(c) - 1);
            }
        }
        return false;
    }
}
```



## Related Topics

- [Hash Table](https://leetcode.cn//tag/hash-table)
- [Two Pointers](https://leetcode.cn//tag/two-pointers)
- [String](https://leetcode.cn//tag/string)
- [Sliding Window](https://leetcode.cn//tag/sliding-window)

## Similar Questions


