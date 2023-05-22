
| [English](README_EN.md) | 简体中文 |

# [面试题 01.05. 一次编辑](https://leetcode.cn//problems/one-away-lcci/)

## 题目描述

<p>字符串有三种编辑操作:插入一个英文字符、删除一个英文字符或者替换一个英文字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。</p>

<p>&nbsp;</p>

<p><strong>示例&nbsp;1:</strong></p>

<pre>
<strong>输入:</strong> 
first = "pale"
second = "ple"
<strong>输出:</strong> True</pre>

<p>&nbsp;</p>

<p><strong>示例&nbsp;2:</strong></p>

<pre>
<strong>输入:</strong> 
first = "pales"
second = "pal"
<strong>输出:</strong> False
</pre>


## 题解


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



## 相关话题

- [双指针](https://leetcode.cn//tag/two-pointers)
- [字符串](https://leetcode.cn//tag/string)

## 相似题目



