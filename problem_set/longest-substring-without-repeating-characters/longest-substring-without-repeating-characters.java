
```
// @Title: 无重复字符的最长子串 (Longest Substring Without Repeating Characters)
// @Author: robert.sunq
// @Date: 2021-06-30 22:07:58
// @Runtime: 7 ms
// @Memory: 38.5 MB

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0,temp =0;
        char[] cs = s.toCharArray();
        Map<Character,Integer> mp = new HashMap<>();
        for(int i = 0;i<cs.length;i++){
            // 如果前面有字符cs[i] 存在
            if(mp.containsKey(cs[i])){
                int j = mp.get(cs[i]);
                // 说明 前一次出现的位置 在temp距离之外
                if(i-j > temp){
                    temp = temp+1;
                }else{
                    // 否则到这个元素最长不重复的长度就是两个字符的距离差
                    temp =i - j;
                }
            }else{
                temp++;
            }
            mp.put(cs[i],i);
            res = Math.max(temp,res);
        }
        return res;
    }
}
