
| English | [简体中文](README.md) |

# [面试题 01.09. String Rotation LCCI](https://leetcode.cn//problems/string-rotation-lcci/)

## Description

<p>Given two strings, <code>s1</code>&nbsp;and <code>s2</code>, write code to check if <code>s2</code> is a rotation of <code>s1</code> (e.g.,&quot;waterbottle&quot; is a rotation of&quot;erbottlewat&quot;).&nbsp;Can you use&nbsp;only one call to the method that&nbsp;checks if one word is a substring of another?</p>

<p><strong>Example 1:</strong></p>

<pre>
<strong>Input: </strong>s1 = <span id="example-input-1-1">&quot;waterbottle&quot;</span>, s2 = <span id="example-input-1-2">&quot;</span>erbottlewat<span>&quot;</span>
<strong>Output: </strong><span id="example-output-1">True</span>
</pre>

<p><strong>Example 2:</strong></p>

<pre>
<strong>Input: </strong>s1 = &quot;aa&quot;, s2 = &quot;aba&quot;
<strong>Output: </strong>False
</pre>

<p>&nbsp;</p>

<p><strong>Note:</strong></p>

<ol>
	<li><code><font face="monospace">0 &lt;= s1.length, s2.length &lt;=&nbsp;</font>100000</code></li>
</ol>


## Solutions


### C++

```C++
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
```



## Related Topics

- [String](https://leetcode.cn//tag/string)
- [String Matching](https://leetcode.cn//tag/string-matching)

## Similar Questions


