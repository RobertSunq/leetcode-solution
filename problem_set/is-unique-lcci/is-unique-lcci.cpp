
```
// @Title: 判定字符是否唯一 (Is Unique LCCI)
// @Author: robert.sunq
// @Date: 2020-03-21 23:51:14
// @Runtime: 0 ms
// @Memory: 7.4 MB

class Solution {
public:
    bool isUnique(string astr) {

        map<char, int> mp;
        for(int i=0;i<astr.size();i++){
            mp[astr[i]]++;
            if(mp[astr[i]]>1){
                return false;
            }
        }
        return true;

    }
};
