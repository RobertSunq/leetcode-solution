
```
// @Title: 回文子串 (Palindromic Substrings)
// @Author: robert.sunq
// @Date: 2021-06-23 00:17:25
// @Runtime: 1 ms
// @Memory: 36.6 MB

class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        char[] sc = s.toCharArray();
        //  从第二个字符开始查找
        for(int i =0;i<s.length();i++){
            // 判断当前位置有多少个回文串
            res+=recur(sc,i);
        }

        return res;
    }
    // 判断当前位置是否可以是回文串
    int recur(char[] sc ,int start){
        int res = 0;
        // 以当前节点为中点，像左右查询
        int i=start,j = start;
        while(i >= 0 && j<sc.length){
            // 不能匹配，则直接退回
            if(sc[i] != sc[j]){
                break;
            }
            // 能匹配上，则表示为一种回文串
            res++;
            i--;
            j++;
        }
        // 当前字符为，对称回文串的左侧
        i = start -1;
        j = start;
        while(i >= 0 && j<sc.length){
            // 不能匹配，则直接退回
            if(sc[i] != sc[j]){
                break;
            }
            // 能匹配上，则表示为一种回文串
            res++;
            i--;
            j++;
        }
        return res;
    }
}
