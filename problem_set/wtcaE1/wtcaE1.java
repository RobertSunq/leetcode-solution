
```
// @Title: 不含重复字符的最长子字符串 (不含重复字符的最长子字符串)
// @Author: robert.sunq
// @Date: 2023-06-11 19:26:27
// @Runtime: 6 ms
// @Memory: 42.5 MB

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int start = 0;
        int end = 0;
        int ans = 0;
        while (end < n) {
            Character c = s.charAt(end);
            if (!set.contains(c)) {
                ans = Math.max(ans, end - start + 1);
                set.add(c);
                end++;
                continue;
            }
            
            while(set.contains(c)) {
                set.remove(s.charAt(start));
                start++;
            }
            set.add(c);
            end++;
        }

        return ans;
    }
}
