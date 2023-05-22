
```
// @Title: 字母异位词分组 (Group Anagrams)
// @Author: robert.sunq
// @Date: 2021-06-03 23:49:44
// @Runtime: 7 ms
// @Memory: 41.2 MB

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String key = String.valueOf(c);
            List<String> value = map.getOrDefault(key,new ArrayList<String>());
            value.add(str);
            map.put(key,value);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
