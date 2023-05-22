
```
// @Title: 找到字符串中所有字母异位词 (Find All Anagrams in a String)
// @Author: robert.sunq
// @Date: 2021-06-21 22:15:22
// @Runtime: 39 ms
// @Memory: 39.7 MB

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character,Integer> dict = new HashMap<>();
        // 创建 子串字典
        for(Character c : p.toCharArray()){
            dict.put(c,dict.getOrDefault(c,0)+1);
        }
        Map<Character,Integer> mp = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        char[] temp = s.toCharArray();
        int i = 0,j=0,len=s.length();
        while(j<len){
            // 如果当前j所指元素不在 字典中，则I，J均当前的下一位开始
            if(!dict.containsKey(temp[j])){
                i = j+1;
                j = j+1;
                // 暂存数值，恢复
                mp = new HashMap<Character,Integer>();
                continue;
            }
            // 匹配当前元素
            mp.put(temp[j],mp.getOrDefault(temp[j],0)+1);
            // 如果 j - i + 1 = p的长度，检验现在的子字符串是否是异位词
            if((j - i + 1) == p.length()){
                if(recur(mp,dict)) res.add(i);
                mp.put(temp[i],mp.get(temp[i])-1);
                i++;
            }
            j++;
        }
        return res;
    }

    // 检验mp种是否所有元素均为 零，即所有的都匹配到
    boolean recur(Map<Character,Integer> mp,Map<Character,Integer> dict){
        for(Character c : mp.keySet()){
            if((int)mp.get(c) != (int)dict.get(c)) return false;
        }
        return true;
    }
}
