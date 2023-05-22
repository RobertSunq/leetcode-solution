
```
// @Title: 字符串轮转 (String Rotation LCCI)
// @Author: robert.sunq
// @Date: 2020-03-24 23:55:21
// @Runtime: 0 ms
// @Memory: 7.4 MB

class Solution {
public:
    bool isFlipedString(string s1, string s2) {
        int len_1 = s1.length();
        int len_2 = s2.length();

        if(len_1-len_2) return false;
        if(len_2 == 0) return true;
        //int indexs_2 = 0;
        for(int i=0;i<len_1;i++){
            if(s1[i] == s2[0]){
                int indexs_1 = i;
                bool falg = true;
                for(int j =0;j<len_2;j++){
                    if(s1[indexs_1] != s2[j]){
                        falg = false;
                        break;
                    }
                      
                    indexs_1 = (indexs_1+1)%len_1;
                }
                if(falg) return true;
            }
        }

        return false;

    }
};
