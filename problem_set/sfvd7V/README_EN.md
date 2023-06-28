
| English | [简体中文](README.md) |

# [剑指 Offer II 033. 变位词组](https://leetcode.cn//problems/sfvd7V/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 变位词组 (变位词组)
// @Author: robert.sunq
// @Date: 2023-06-28 23:10:03
// @Runtime: 683 ms
// @Memory: 45.7 MB

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();

        if (strs == null || strs.length == 0) {
            return ans;
        }
        
        boolean add = false;
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            for (int j = 0; j < ans.size(); j++) {
                if (isAnagram(ans.get(j).get(0), str)) {
                    ans.get(j).add(str);
                    add = true;
                    break;
                }
            }
            if (add) {
                add = false;
            } else {
                List<String> tmp = new ArrayList<>();
                tmp.add(str);
                ans.add(tmp);
            }
        }

        return ans;
    }



    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        if (s.equals(t)) {
            return true;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
```



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Hash Table](https://leetcode.cn//tag/hash-table)
- [String](https://leetcode.cn//tag/string)
- [Sorting](https://leetcode.cn//tag/sorting)

## Similar Questions


