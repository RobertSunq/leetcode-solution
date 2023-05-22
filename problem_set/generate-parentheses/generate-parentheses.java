
```
// @Title: 括号生成 (Generate Parentheses)
// @Author: robert.sunq
// @Date: 2021-06-02 22:50:38
// @Runtime: 0 ms
// @Memory: 38.5 MB

class Solution {
    List<String> res = new ArrayList<>();
    char[] resTemp;
    int N;
    public List<String> generateParenthesis(int n) {
        resTemp = new char[n*2];
        N = n;
        recur(0,0,0);
        return res;
        
    }
    void recur(int index,int l , int r){
        // System.out.println("index = "+ index+", l = "+l+", r = "+r);
        if(index == 2*N){
            res.add(String.valueOf(resTemp));
            return;
        }
        // 如果 已用的左括号和已用的右括号相等 ， 则只能填入左
        if (l <= r){
            resTemp[index] = '(';
            recur(index+1,l+1,r);
        }else{
            // 此时可以选择填入 左 或者填入右
            if(l < N){
                resTemp[index] = '(';
                recur(index+1,l+1,r);
            }
            if(r < N){
                resTemp[index] = ')';
                recur(index+1,l,r+1);
            }
        }
    }
}
