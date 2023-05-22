
```
// @Title: 判定字符是否唯一 (Is Unique LCCI)
// @Author: robert.sunq
// @Date: 2021-05-23 14:20:13
// @Runtime: 0 ms
// @Memory: 35.9 MB

class Solution {
    public boolean isUnique(String astr) {
        Set<String> se = new HashSet<>();
        for(int i = 0 ; i<astr.length();i++){
            if(se.contains(astr.substring(i,i+1)))
            {return false;}
            se.add(astr.substring(i,i+1));
        }
        return true;
    }
}
