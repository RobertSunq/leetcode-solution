
| English | [简体中文](README.md) |

# [剑指 Offer II 063. 替换单词](https://leetcode.cn//problems/UhWRSj/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 替换单词 (替换单词)
// @Author: robert.sunq
// @Date: 2023-07-13 21:53:03
// @Runtime: 26 ms
// @Memory: 44.8 MB

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        dictionary.sort(Comparator.comparingInt(String::length));
        // dictionary.sort((s1, s2) -> s1.length() - s2.length());

        StringBuilder builder = new StringBuilder();
        int i = 0, j = 0;
        sentence = sentence.trim();
        int n = sentence.length();
        while (j < n) {
            char c = sentence.charAt(j);
            if (c == ' ' || j == n - 1) {
                builder.append(" " + isSuccessor(dictionary, sentence.substring(i, j == n - 1 ? n : j)));
                i = j + 1;
            }
            j++;
        }
        return builder.deleteCharAt(0).toString();

    }

    private String isSuccessor(List<String> dictionary, String sentence) {
        for (String str : dictionary) {
            if (sentence.startsWith(str)) {
                return str;
            }
        }

        return sentence;
    }
}
```



## Related Topics

- [Trie](https://leetcode.cn//tag/trie)
- [Array](https://leetcode.cn//tag/array)
- [Hash Table](https://leetcode.cn//tag/hash-table)
- [String](https://leetcode.cn//tag/string)

## Similar Questions


