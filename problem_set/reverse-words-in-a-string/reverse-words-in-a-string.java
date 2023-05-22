
```
// @Title: 反转字符串中的单词 (Reverse Words in a String)
// @Author: robert.sunq
// @Date: 2021-08-01 20:33:04
// @Runtime: 7 ms
// @Memory: 38.7 MB

class Solution {
    public String reverseWords(String s) {
        // 去除先后空格
        s = " "+s.trim();
        char[] schar = s.toCharArray();
        String res = "";
        int j = schar.length-1;
        for(int i = schar.length-1;i>= 0; i--){
            if(schar[i] == ' '){
                String temp = recur(schar,i,j) + " ";
                res = res + temp;
                while(i>0 && schar[i] == ' ') i--;
                j = i;
            }
        }
        return res.trim();
    }

    String recur(char[] schar , int start,int end){
        String res = "";
        for(int i =0 ;i<end - start ; i++){
            res = res + String.valueOf(schar[start + 1 + i]);
        }
        return res;
    }
}
