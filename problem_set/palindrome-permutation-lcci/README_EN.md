
| English | [简体中文](README.md) |

# [面试题 01.04. Palindrome Permutation LCCI](https://leetcode.cn//problems/palindrome-permutation-lcci/)

## Description

<p>Given a string, write a function to check if it is a permutation of a palindrome. A palindrome is a word or phrase that is the same forwards and backwards. A permutation is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.</p>

<p>&nbsp;</p>

<p><strong>Example1: </strong></p>

<pre>
<strong>Input: &quot;</strong>tactcoa&quot;
<strong>Output: </strong>true（permutations: &quot;tacocat&quot;、&quot;atcocta&quot;, etc.）
</pre>

<p>&nbsp;</p>


## Solutions


### Java

```Java
// @Title: 回文排列 (Palindrome Permutation LCCI)
// @Author: robert.sunq
// @Date: 2021-08-02 20:59:10
// @Runtime: 0 ms
// @Memory: 36.2 MB

class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] dict = new int[256];
        for(Character c : s.toCharArray()){
            dict[c]++;
        }
        int res = 0;
        for(int i = 0;i<256;i++){
            if(dict[i]%2 == 1) res++;
        }
        return res<2;
    }
}
```



### C++

```C++
// @Title: 回文排列 (Palindrome Permutation LCCI)
// @Author: robert.sunq
// @Date: 2020-03-23 17:02:06
// @Runtime: 0 ms
// @Memory: 7.7 MB

class Solution {
public:
    bool canPermutePalindrome(string s) {
        int flag = 0;
        if(s.size() == 0) return true;
        int an[256] = {0};
        for(int i=0;i<s.size();i++){
            an[s[i]]++;
        }

        for(int i=0;i<256;i++){
            if(an[i]%2) flag++;
            if(flag >1) return false;
        }
        return true;
    }
};
```



## Related Topics

- [Bit Manipulation](https://leetcode.cn//tag/bit-manipulation)
- [Hash Table](https://leetcode.cn//tag/hash-table)
- [String](https://leetcode.cn//tag/string)

## Similar Questions


