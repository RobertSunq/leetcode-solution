
| English | [简体中文](README.md) |

# [剑指 Offer II 065. 最短的单词编码](https://leetcode.cn//problems/iSwD2y/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 最短的单词编码 (最短的单词编码)
// @Author: robert.sunq
// @Date: 2023-07-14 22:14:32
// @Runtime: 14 ms
// @Memory: 42.8 MB

class Solution {
    // 注意 如果单词 X 是 Y 的后缀，那么单词 X 就不需要考虑了，因为编码 Y 的时候就同时将 X 编码了。
    // 例如，如果 words 中同时有 "me" 和 "time"，我们就可以在不改变答案的情况下不考虑 "me"。
    // 注意，不能单纯的理解 indices 中 下标的索引一定是 升序的， 头部的单词也可以包含在后面的单词中
    public int minimumLengthEncoding(String[] words) {
        int n = words.length;
        if (n < 1) {
            return 1;
        }
        Set<String> set = new HashSet<>();
        for (String str : words) {
            set.add(str);
        }

        for (String str : words) {
            // 从结果set中， 删除当前字符串的所有后缀
            for (int i = 1; i < str.length() ; i++) {
                set.remove(str.substring(i));
            }
        }
        // 最后的结果，是剩余单词的长度和 + “#” 的个数

        int ans = 0;
        for (String str : set) {
            ans+=str.length();
        }
        return ans + set.size();
    }
}
```



## Related Topics

- [Trie](https://leetcode.cn//tag/trie)
- [Array](https://leetcode.cn//tag/array)
- [Hash Table](https://leetcode.cn//tag/hash-table)
- [String](https://leetcode.cn//tag/string)

## Similar Questions


