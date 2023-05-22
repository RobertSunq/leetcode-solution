
```
// @Title: 栈的压入、弹出序列 (栈的压入、弹出序列 LCOF)
// @Author: robert.sunq
// @Date: 2021-05-27 00:07:27
// @Runtime: 3 ms
// @Memory: 38.3 MB

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        LinkedList<Integer> st = new LinkedList<>();
        int n = pushed.length;
        int m = popped.length;
        if(n != m) return false;
        int i=0,j=0;
        // 值判断 J 因为 i 一定时先于j达到最大值。
        while(j< m){
            if(st.isEmpty()) {
                st.addLast(pushed[i]);
                i++;
            }else{
                if(st.getLast() == popped[j]){
                    st.removeLast();
                    j++;
                }else {
                    // 需要 i 超出输入的长度继续输入，则肯定是不匹配的
                    if(i >= n ) return false;
                    st.addLast(pushed[i]);
                    i++; 
                }
            }
        }
        if(i == n &&  j == m && st.isEmpty()) return true;
        return false; 
    }
}
