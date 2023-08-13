
```
// @Title: 交替合并字符串 (Merge Strings Alternately)
// @Author: robert.sunq
// @Date: 2023-08-08 21:39:43
// @Runtime: 1 ms
// @Memory: 39.1 MB

class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        StringBuffer str = new StringBuffer();
        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            str.append(word1.charAt(i++));
            str.append(word2.charAt(j++));
        }

        while (i < n1) {
            str.append(word1.charAt(i++));
        }

        while (j < n2) {
            str.append(word2.charAt(j++));
        }

        return str.toString();
    }
}
