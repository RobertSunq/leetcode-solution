
| English | [简体中文](README.md) |

# [剑指 Offer 05. 替换空格 LCOF](https://leetcode.cn//problems/ti-huan-kong-ge-lcof/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### C++

```C++
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
```



### Java

```Java
// @Title: 替换空格 (替换空格 LCOF)
// @Author: robert.sunq
// @Date: 2023-02-05 22:59:59
// @Runtime: 0 ms
// @Memory: 39.5 MB

class Solution {
    public String replaceSpace(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        char ch;
        for(int i = 0;i < s.length();i++) {
            ch = s.charAt(i);
            if (ch == ' '){
                stringBuilder.append("%20");
            }else {
                stringBuilder.append(ch);
            }
        }
        return stringBuilder.toString();
    }
}
```



## Related Topics

- [String](https://leetcode.cn//tag/string)

## Similar Questions


