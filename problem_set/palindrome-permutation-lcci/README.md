
| [English](README_EN.md) | 简体中文 |

# [面试题 01.04. 回文排列](https://leetcode.cn//problems/palindrome-permutation-lcci/)

## 题目描述

<p>给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。</p>

<p>回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。</p>

<p>回文串不一定是字典当中的单词。</p>

<p>&nbsp;</p>

<p><strong>示例1：</strong></p>

<pre><strong>输入：&quot;</strong>tactcoa&quot;
<strong>输出：</strong>true（排列有&quot;tacocat&quot;、&quot;atcocta&quot;，等等）
</pre>

<p>&nbsp;</p>


## 题解


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



## 相关话题

- [位运算](https://leetcode.cn//tag/bit-manipulation)
- [哈希表](https://leetcode.cn//tag/hash-table)
- [字符串](https://leetcode.cn//tag/string)

## 相似题目



