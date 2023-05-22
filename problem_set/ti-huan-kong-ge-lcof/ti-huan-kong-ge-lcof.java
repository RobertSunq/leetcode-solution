
```
// @Title: 替换空格 (替换空格 LCOF)
// @Author: robert.sunq
// @Date: 2023-02-05 22:59:59
// @Runtime: 0 ms
// @Memory: 39.5 MB

class Solution {
    public String replaceSpace(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        char ch;
        for(int i = 0;i < s.length();i++) {
            ch = s.charAt(i);
            if (ch == ' '){
                stringBuilder.append("%20");
            }else {
                stringBuilder.append(ch);
            }
        }
        return stringBuilder.toString();
    }
}
