
```
// @Title: 确定两个字符串是否接近 (Determine if Two Strings Are Close)
// @Author: robert.sunq
// @Date: 2023-08-23 23:14:37
// @Runtime: 12 ms
// @Memory: 43.1 MB

class Solution {
    // 具体的，由于 s1 和 s2 都仅包含小写字母，因此可以创建两个大小为 26 的数组 c1 和 c2 分别对两字符串进行词频统计
    public boolean closeStrings(String word1, String word2) {
        int[] c1 = new int[26];
        int[] c2 = new int[26];
        for (char c : word1.toCharArray()) {
            c1[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            c2[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (c1[i] + c2[i] == 0) {
                continue;
            }
            // 某个字符在 word1 或 word2 中存在，但另一个字符串中不存在
            if (c1[i] == 0 || c2[i] == 0) {
                return false;
            }
        }

        // 检查字符频次是相等的
        Arrays.sort(c1);
        Arrays.sort(c2);
        for (int i = 0; i < 26; i++) {
            if (c1[i] != c2[i]) {
                return false;
            }
        }

        return true;
    }
}
