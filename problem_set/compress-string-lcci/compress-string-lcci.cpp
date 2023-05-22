
```
// @Title: 字符串压缩 (Compress String LCCI)
// @Author: robert.sunq
// @Date: 2020-03-24 00:15:41
// @Runtime: 16 ms
// @Memory: 8.5 MB

class Solution {
public:
    string compressString(string S) {
        string s = "";
        int counts = 0;
        int len = S.length();
        int i=0;
        int same_counts = 0;
         int j;
        while(i<len){
            j=i+1;
            same_counts = 1;
            while(S[i] == S[j]){
                same_counts++;
                j++;

            }
            s += S[i]+to_string(same_counts);
            i = j;
        }
        if(s.size() >= len) return S;
        else return s;
    }
};
