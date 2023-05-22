
```
// @Title: 一次编辑 (One Away LCCI)
// @Author: robert.sunq
// @Date: 2021-08-02 21:28:20
// @Runtime: 2 ms
// @Memory: 38.3 MB

class Solution {
    public boolean oneEditAway(String first, String second) {
        if(Math.abs(first.length()-second.length()) > 1) return false;

        int i = 0,j = 0,count = 0;
        while(i<first.length() && j<second.length()){
            if(first.charAt(i) == second.charAt(j)){
                i++;
                j++;
                continue;
            }
            count++;
            if(count > 1) return false;
            // 第一次不匹配时，两字符串不等时表示长的需要删除一个字符，及长的指针后移一位。
            if(first.length() < second.length()){
                j++;
            } else if(first.length() > second.length()){
                i++;
            } else {
                i++;
                j++;
            }
        }
        return true;
    }
}
