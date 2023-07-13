
| English | [简体中文](README.md) |

# [剑指 Offer II 064. 神奇的字典](https://leetcode.cn//problems/US1pGT/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 神奇的字典 (神奇的字典)
// @Author: robert.sunq
// @Date: 2023-07-13 23:07:52
// @Runtime: 28 ms
// @Memory: 42.9 MB

class MagicDictionary {

    Map<Integer, List<String>> dict;

    /** Initialize your data structure here. */
    public MagicDictionary() {
        dict = new HashMap<>();
    }
    
    public void buildDict(String[] dictionary) {
        for (String str : dictionary) {
            if (dict.containsKey(str.length())) {
                dict.get(str.length()).add(str);
            } else {
                List<String> tmp = new ArrayList<>();
                tmp.add(str);
                dict.put(str.length(), tmp);
            }
        }
    }
    
    public boolean search(String searchWord) {
        int n = searchWord.length();
        if (dict.containsKey(n)) {
            for (String dic : dict.get(n)) {
                int tmp = 0;
                for (int i = 0; i < n; i++) {
                    if (searchWord.charAt(i) != dic.charAt(i)) {
                        tmp++;
                    }
                }
                if (tmp == 1) {
                    return true;
                }
            }
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */
```



## Related Topics

- [Design](https://leetcode.cn//tag/design)
- [Trie](https://leetcode.cn//tag/trie)
- [Hash Table](https://leetcode.cn//tag/hash-table)
- [String](https://leetcode.cn//tag/string)

## Similar Questions


