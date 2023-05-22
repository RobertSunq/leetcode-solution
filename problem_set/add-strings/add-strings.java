
```
// @Title: 字符串相加 (Add Strings)
// @Author: robert.sunq
// @Date: 2021-07-01 22:39:19
// @Runtime: 2 ms
// @Memory: 38.6 MB

class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        char[] num1c = num1.toCharArray();
        char[] num2c = num2.toCharArray();
        int len1 = num1.length()-1;
        int len2 = num2.length()-1;
        int temp = 0;
        while(len1 >= 0 && len2 >= 0){
            res.append( ((num1c[len1] + num2c[len2]- '0'-'0' + temp)%10) );
            temp = ((num1c[len1] + num2c[len2]- '0'-'0'+temp)/10);
            len1--;
            len2--;
        }
        while(len1>= 0){
            res.append( ((num1c[len1] - '0' + temp)%10) );
            temp = ((num1c[len1] - '0'+temp)/10);
            len1--;
        }
        while(len2 >= 0){
            res.append( ((num2c[len2] - '0' + temp)%10) );
            temp = ((num2c[len2] - '0'+temp)/10);
            len2--;
        }
        if(temp != 0){
            res.append(temp);
        }
        return res.reverse().toString();
    }
}
