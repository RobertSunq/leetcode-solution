
| English | [简体中文](README.md) |

# [面试题 01.05. One Away LCCI](https://leetcode.cn//problems/one-away-lcci/)

## Description

<p>There are three types of edits that can be performed on strings: insert a character, remove a character, or replace a character. Given two strings, write a function to check if they are one edit (or zero edits) away.</p>

<p>&nbsp;</p>

<p><strong>Example&nbsp;1:</strong></p>

<pre>
<strong>Input:</strong> 
first = &quot;pale&quot;
second = &quot;ple&quot;
<strong>Output:</strong> True
</pre>

<p><strong>Example&nbsp;2:</strong></p>

<pre>
<strong>Input:</strong> 
first = &quot;pales&quot;
second = &quot;pal&quot;
<strong>Output:</strong> False
</pre>


## Solutions


### C++

```C++
// @Title: 一次编辑 (One Away LCCI)
// @Author: robert.sunq
// @Date: 2020-03-23 23:39:43
// @Runtime: 0 ms
// @Memory: 7.4 MB

class Solution {
public:
    bool oneEditAway(string first, string second) { 
        int len_f = first.length();
        int len_s = second.length();
        if(abs(len_f-len_s) >1) return false;
        int counts = 0;
        if(len_s == len_f){
            for(int i=0;i<len_f;i++){
                if(first[i] != second[i]) counts++;
                if(counts >1) return false;

            }
            return true;
        }
        
        if(len_f >len_s){
            int i=0,j=0;
            counts = 0;
             while(i<len_f && j<len_s){
               if(first[i] != second[j]){
                  counts++;
                  if(counts >1) return false;
                  if(first[i+1] == second[j])
                     i++;
                  else return false; 
            }
            i++;
            j++;
          }  
          return true; 
        }
        else {
             int i=0,j=0;
            counts = 0;
             while(j<len_f && i<len_s){
               if(first[j] != second[i]){
                  counts++;
                  if(counts >1) return false;
                  if(first[j] == second[i+1])
                     i++;
                  else return false; 
            }
             i++;
             j++;
          }
          return true;   
        }
       

    }
};
```



### Java

```Java
// @Title: 一次编辑 (One Away LCCI)
// @Author: robert.sunq
// @Date: 2021-08-02 21:28:20
// @Runtime: 2 ms
// @Memory: 38.3 MB

class Solution {
    public boolean oneEditAway(String first, String second) {
        if(Math.abs(first.length()-second.length()) > 1) return false;

        int i = 0,j = 0,count = 0;
        while(i<first.length() && j<second.length()){
            if(first.charAt(i) == second.charAt(j)){
                i++;
                j++;
                continue;
            }
            count++;
            if(count > 1) return false;
            // 第一次不匹配时，两字符串不等时表示长的需要删除一个字符，及长的指针后移一位。
            if(first.length() < second.length()){
                j++;
            } else if(first.length() > second.length()){
                i++;
            } else {
                i++;
                j++;
            }
        }
        return true;
    }
}
```



## Related Topics

- [Two Pointers](https://leetcode.cn//tag/two-pointers)
- [String](https://leetcode.cn//tag/string)

## Similar Questions


