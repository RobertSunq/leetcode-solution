
```
// @Title: 字符串中的所有变位词 (字符串中的所有变位词)
// @Author: robert.sunq
// @Date: 2023-06-11 19:51:43
// @Runtime: 48 ms
// @Memory: 43.5 MB

class Solution {
     /**
    延续 [剑指 Offer II 014. 字符串中的变位词](https://leetcode.cn/problems/MPnaiL/) 的逻辑
     */
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        int m = p.length();
        if (m > n) {
            return new ArrayList<>();
        }
        
        List<Integer> ans = new ArrayList<>();

        Map<Character, Integer> charToCount = new HashMap<>();
        for ( int i = 0; i < m; i++) {
            charToCount.put(p.charAt(i), charToCount.getOrDefault(p.charAt(i), 0) + 1);
        }

        Map<Character, Integer> tmp = new HashMap<>();
        // 计算子串开始位置
        int startIndex = 0;
        for (int i = 0; i<n; i++) {
            Character c = s.charAt(i);
            // 不包含该字符，重新查找子串
            if (!charToCount.containsKey(c)) {
                tmp = new HashMap<>();
                startIndex = i + 1;
                continue;
            }

            tmp.put(c, tmp.getOrDefault(c, 0) + 1);

            // 包含且当前字符频数相等，可以比较是否复合要求了
            // 注意 用 equals 而不是用 == , 因为  Integer > 127 不用 == 比较
            if(tmp.get(c).equals(charToCount.get(c))) {
                if (tmp.equals(charToCount)) {
                    ans.add(startIndex);
                }
                continue;
            }
            
            // 当某个字符出现频数大于 s 了， 就需要移动 s 的子串到该字符在子串中第一次出现的位置，同时降低对应字符的频数。
            if (tmp.get(c) > charToCount.get(c)) {
                while(s.charAt(startIndex) != c) {
                    tmp.put(s.charAt(startIndex), tmp.get(s.charAt(startIndex)) - 1);
                    startIndex++;
                }
                startIndex++;
                tmp.put(c, tmp.get(c) - 1);
                // 注意，前端移动到要求位置后，需要在判断下子字符串是否复合要求
                if (tmp.equals(charToCount)) {
                    ans.add(startIndex);
                }
            }
        }
        return ans;
    }
}
