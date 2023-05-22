
```
// @Title: 电话号码的字母组合 (Letter Combinations of a Phone Number)
// @Author: robert.sunq
// @Date: 2021-06-02 21:53:10
// @Runtime: 0 ms
// @Memory: 36.8 MB

class Solution {
    List<String> res = new ArrayList<>();
    char[] temp;
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return res;
        temp = new char[digits.length()];
        recur(digits,0);
        return res;
    }
    void recur(String digits , int index){
        if(index == digits.length()){
            res.add(String.valueOf(temp));
            return;
        }
        int n = 3;
        char c = digits.charAt(index);
        if(c == '9' || c=='7'){
            n = 4;
        }
        for(int i = 0;i<n;i++){
            int ci = (c-'2') * 3 + 'a' + i;
            if(c>'7'){
                ci++;
            }
            temp[index] = (char) (ci);
            recur(digits,index+1);
        }
    }
}
