
```
// @Title: 定长子串中元音的最大数目 (Maximum Number of Vowels in a Substring of Given Length)
// @Author: robert.sunq
// @Date: 2023-08-17 22:25:33
// @Runtime: 22 ms
// @Memory: 42.6 MB

class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> o = new HashSet<>();
        o.add('a');
        o.add('e');
        o.add('i');
        o.add('o');
        o.add('u');

        int max = 0;
        int count = 0;
        int left = 0;
        int right = 0;
        int n = s.length();
        while (right < n) {
            if (o.contains(s.charAt(right))) {
                count++;
            }
            if (right >= k) {
                if (o.contains(s.charAt(left))) {
                    count--;
                }
                left++;
            }
            right++;
            if (right >= k) {
                max = Math.max(max, count);
            }
        }
        return max;
    }
}
