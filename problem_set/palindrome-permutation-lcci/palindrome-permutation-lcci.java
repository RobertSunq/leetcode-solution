
```
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
