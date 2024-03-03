
```
// @Title: 最大单词长度乘积 (Maximum Product of Word Lengths)
// @Author: robert.sunq
// @Date: 2023-11-06 22:12:39
// @Runtime: 10 ms
// @Memory: 43 MB

class Solution {
    public int maxProduct(String[] words) {
        int ans = 0;
        int n = words.length;

        int[] masks = new int[n];

        for (int i = 0; i < n; i++) {
            String word = words[i];
            int strN = word.length();
            for (int j = 0; j < strN; j++) {
                // 位运算， 使用int 的0 - 25 位 来表示这个字母的存在
                masks[i] = masks[i] | (1 << (word.charAt(j) - 'a'));
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((masks[i] & masks[j]) == 0) {
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }

        return ans;
    }
}
