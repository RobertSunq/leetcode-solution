
```
// @Title: 判断子序列 (Is Subsequence)
// @Author: robert.sunq
// @Date: 2023-08-14 21:21:30
// @Runtime: 1 ms
// @Memory: 39.4 MB

class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }

        if (t.length() == 0) {
            return false;
        }

        int i = 0;
        int j = 0;
        int ns = s.length() , nt = t.length();
        while (i < ns && j < nt) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

        return i >= ns;
    }
}
