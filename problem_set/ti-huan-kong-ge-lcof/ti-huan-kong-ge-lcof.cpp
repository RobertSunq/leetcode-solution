
```
// @Title: 替换空格 (替换空格 LCOF)
// @Author: robert.sunq
// @Date: 2020-03-21 15:17:24
// @Runtime: 0 ms
// @Memory: 7.6 MB

class Solution {
public:
    string replaceSpace(string s) {
        string :: iterator it = s.begin();
        string str = "%20";
        string str_1 = "";
        while(it != s.end()){
            if(*it == ' '){
                str_1 += str;
                it++;
            }
            else{
                str_1+=(*it);
               it++;  
            }
             
        }

        return str_1;
    }
};
