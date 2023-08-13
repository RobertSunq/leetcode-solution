
```
// @Title: 反转字符串中的单词 (Reverse Words in a String)
// @Author: robert.sunq
// @Date: 2023-08-10 22:17:27
// @Runtime: 7 ms
// @Memory: 42.9 MB

class Solution {
    public String reverseWords(String s) {
        String sTrim = s.trim();

        int n = sTrim.length();
        int i = 0;
        int j = 0;
        String ans = "";
        while (i < n && j < n) {
            if (sTrim.charAt(j) == ' ') {
                String tmp = sTrim.substring(i, j);
                if (ans.length() != 0) {
                    ans = " " + ans;
                }
                ans = tmp + ans;
                while (j < n && sTrim.charAt(j) == ' ') {
                    j++;
                }
                i = j;
            } else {
                j++;
            }
        }

        if (ans.length() != 0 && i < n) {
            ans = " " + ans;
        }
        ans = sTrim.substring(i, j) + ans;
        return ans;
    }
}
