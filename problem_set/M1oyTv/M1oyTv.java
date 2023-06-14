
```
// @Title: 含有所有字符的最短字符串 (含有所有字符的最短字符串)
// @Author: robert.sunq
// @Date: 2023-06-14 23:19:08
// @Runtime: 100 ms
// @Memory: 43.1 MB

class Solution {
    public String minWindow(String s, String t) {
        int ansStart = 0;
        int ansEnd = Integer.MAX_VALUE;
        
        int start = 0;
        int end = 0;
        
        Map<Character, Integer> charCount = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            Character c = t.charAt(i);
            charCount.put(c, charCount.getOrDefault(c , 0) + 1);
        }

        Map<Character, Integer> tmpCount = new HashMap<>();
        int n = s.length();
        while (end < n) {
            Character c = s.charAt(end);
            tmpCount.put(c, tmpCount.getOrDefault(c, 0) + 1);
            while (isAns(charCount, tmpCount)) {
                if ((end - start) < (ansEnd - ansStart) ) {
                    ansStart = start;
                    ansEnd = end;
                }
                Character cStart = s.charAt(start);
                tmpCount.put(cStart, tmpCount.get(cStart) - 1);
                start++;
            }
            end++;
        }

        return ansEnd == Integer.MAX_VALUE ? "" : s.substring(ansStart, ansEnd + 1);
        
    }

    private boolean isAns(Map<Character, Integer> charCount, Map<Character, Integer> tmpCount) {
        for (Character c : charCount.keySet()) {
            if (charCount.get(c) > tmpCount.getOrDefault(c, 0)) {
                return false;
            }
        }

        return true;
    }
}
