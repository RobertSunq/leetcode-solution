
```
// @Title: 第一个只出现一次的字符 (第一个只出现一次的字符  LCOF)
// @Author: robert.sunq
// @Date: 2021-05-30 01:51:40
// @Runtime: 31 ms
// @Memory: 38.4 MB

class Solution {
    public char firstUniqChar(String s) {
        Map<Character,Integer> dict = new HashMap<>();
        char[] schar = s.toCharArray();
        for (char c : schar){
            dict.put(c,dict.containsKey(c)?2:1);
        }
        for(char c : schar){
            if(dict.get(c) == 1){
                return c;
            }
        }
        return ' ';
    }
}
