
```
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
