
```
// @Title: 判定是否互为字符重排 (Check Permutation LCCI)
// @Author: robert.sunq
// @Date: 2020-03-22 00:25:13
// @Runtime: 4 ms
// @Memory: 7.5 MB

class Solution {
public:
    bool CheckPermutation(string s1, string s2) {
            int len_s1 =  s1.size();
            int len_s2 = s2.size();
            if(len_s1 != len_s2 ) return false;
            int mp1[260]={0};
            for(int i=0;i<len_s2;i++){
                    mp1[s1[i]]++;
                    mp1[s2[i]]--;
            }
            for(int i=0;i<256;i++){
                if(mp1[i] != 0)
                   return false;

            }
            return true;

    }
};
