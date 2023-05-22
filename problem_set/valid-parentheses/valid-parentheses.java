
```
// @Title: 有效的括号 (Valid Parentheses)
// @Author: robert.sunq
// @Date: 2021-06-02 22:18:39
// @Runtime: 1 ms
// @Memory: 36.6 MB

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        char[] sc = s.toCharArray();
        for(int i=0;i<sc.length;i++){
            if(sc[i] == '(' || sc[i] == '{' || sc[i] == '['){
                st.push(sc[i]);
            }else{
                if(st.isEmpty()) return false;
                if(sc[i] == ')'){
                    if(st.pop() != '(') return false;
                    continue;
                }else if(sc[i] == '}'){
                    if(st.pop() != '{') return false;
                    continue;
                }else{
                    if(st.pop() != '[') return false;
                    continue;
                }
            }
        }
        if(st.isEmpty()) return true;
        return false;
    }
}
