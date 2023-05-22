
```
// @Title: 判定是否互为字符重排 (Check Permutation LCCI)
// @Author: robert.sunq
// @Date: 2021-08-02 15:50:35
// @Runtime: 0 ms
// @Memory: 36.2 MB

class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        // 长度不相等直接退回
        if(len1 != len2 ) return false;
        // 保存字符出现次数
        int[] dict = new int[256];
        for(int i=0;i<len1;i++){
            dict[s1.charAt(i)]++;
            dict[s2.charAt(i)]--;
        }
        for(int i=0;i<256;i++){
            if(dict[i] != 0) {
                return false;
            }
        }
        return true;

    }
}
