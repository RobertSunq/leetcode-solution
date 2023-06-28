
```
// @Title: 外星语言是否排序 (外星语言是否排序)
// @Author: robert.sunq
// @Date: 2023-06-28 23:37:06
// @Runtime: 0 ms
// @Memory: 39.8 MB

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        if (words == null || words.length < 2) {
            return true;
        }

        int[] dictIndex = new int[26];
        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            dictIndex[c - 'a'] = i;
        }

        for (int i = 1; i < words.length ; i++) {
            if (!isSorted(words[i - 1], words[i], dictIndex)) {
                return false;
            }
        }

        return true;
    }


        private boolean isSorted(String s, String t, int[] dictIndex) {
            for (int i = 0; i < s.length() && i < t.length(); i++) {
                char sChar = s.charAt(i);
                char tChar = t.charAt(i);
                int sIndex = dictIndex[sChar - 'a'];
                int tIndex = dictIndex[tChar - 'a'];
                if (sIndex != tIndex) {
                    return sIndex < tIndex;
                }
            }
            return s.length() <= t.length();
        }
}
