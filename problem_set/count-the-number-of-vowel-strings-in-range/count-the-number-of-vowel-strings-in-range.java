
```
// @Title: 统计范围内的元音字符串数 (Count the Number of Vowel Strings in Range)
// @Author: robert.sunq
// @Date: 2023-11-07 21:35:50
// @Runtime: 2 ms
// @Memory: 42 MB

class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int ans = 0;
        for (int i = left; i <= right; i++) {
            if (set.contains(words[i].charAt(0)) && set.contains(words[i].charAt(words[i].length() - 1))) {
                ans++;
            }
        }

        return ans;
    }
}
