
```
// @Title: 翻转单词顺序 (翻转单词顺序 LCOF)
// @Author: robert.sunq
// @Date: 2021-05-30 20:07:13
// @Runtime: 15 ms
// @Memory: 39.1 MB

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
