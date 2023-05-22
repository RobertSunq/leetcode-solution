
```
// @Title: 单词拆分 (Word Break)
// @Author: robert.sunq
// @Date: 2021-06-10 00:21:41
// @Runtime: 14 ms
// @Memory: 38.7 MB

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length() == 0) return true;
        int len = s.length();
        // 保存可以可以拆分成单词的 字符串下标
        List<Integer> li = new ArrayList<>();
        li.add(-1);
        for(int i =0 ;i<len;i++){
            for(int j = 0;j<li.size();j++){
                // 当前长度的字符串可以 由之前可以拆分的子字符串和某单词组成
                if(wordDict.contains(s.substring(li.get(j)+1,i+1))){
                    li.add(i);
                    break;
                }
            }
        }
        // System.out.println(li);
        return li.get(li.size()-1) == len -1;
    }
}
