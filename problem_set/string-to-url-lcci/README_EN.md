
| English | [简体中文](README.md) |

# [面试题 01.03. String to URL LCCI](https://leetcode.cn//problems/string-to-url-lcci/)

## Description

<p>Write a method to replace all spaces in a string with &#39;%20&#39;. You may assume that the string has sufficient space at the end to hold the additional characters,and that you are given the &quot;true&quot; length of the string. (Note: If implementing in Java,please use a character array so that you can perform this operation in place.)</p>

<p><strong>Example 1:</strong></p>

<pre>
<strong>Input: </strong>&quot;Mr John Smith &quot;, 13
<strong>Output: </strong>&quot;Mr%20John%20Smith&quot;
</pre>

<p><strong>Example 2:</strong></p>

<pre>
<strong>Input: </strong>&quot;               &quot;, 5
<strong>Output: </strong>&quot;%20%20%20%20%20&quot;
</pre>

<p>&nbsp;</p>

<p><strong>Note:</strong></p>

<ol>
	<li><code>0 &lt;= S.length &lt;= 500000</code></li>
</ol>


## Solutions


### C++

```C++
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
```



## Related Topics

- [String](https://leetcode.cn//tag/string)

## Similar Questions


