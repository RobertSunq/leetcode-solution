
```
// @Title: URL化 (String to URL LCCI)
// @Author: robert.sunq
// @Date: 2020-03-22 00:28:57
// @Runtime: 80 ms
// @Memory: 26.7 MB

class Solution {
public:
    string replaceSpaces(string S, int length) {
        string :: iterator it = S.begin();
        string str = "%20";
        string str_1 = "";
        while(it != S.begin()+length){
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
