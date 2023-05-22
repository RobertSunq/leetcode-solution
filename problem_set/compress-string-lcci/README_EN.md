
| English | [简体中文](README.md) |

# [面试题 01.06. Compress String LCCI](https://leetcode.cn//problems/compress-string-lcci/)

## Description

<p>Implement a method to perform basic string compression using the counts of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the &quot;compressed&quot; string would not become smaller than the original string, your method should return the original string. You can assume the string has only uppercase and lowercase letters (a - z).</p>

<p><strong>Example 1:</strong></p>

<pre>
<strong>Input: </strong>&quot;aabcccccaaa&quot;
<strong>Output: </strong>&quot;a2b1c5a3&quot;
</pre>

<p><strong>Example 2:</strong></p>

<pre>
<strong>Input: </strong>&quot;abbccd&quot;
<strong>Output: </strong>&quot;abbccd&quot;
<strong>Explanation: </strong>
The compressed string is &quot;a1b2c2d1&quot;, which is longer than the original string.
</pre>

<p>&nbsp;</p>

<p><strong>Note:</strong></p>

<ol>
	<li><code>0 &lt;= S.length &lt;= 50000</code></li>
</ol>


## Solutions


### C++

```C++
// @Title: 字符串压缩 (Compress String LCCI)
// @Author: robert.sunq
// @Date: 2020-03-24 00:15:41
// @Runtime: 16 ms
// @Memory: 8.5 MB

class Solution {
public:
    string compressString(string S) {
        string s = "";
        int counts = 0;
        int len = S.length();
        int i=0;
        int same_counts = 0;
         int j;
        while(i<len){
            j=i+1;
            same_counts = 1;
            while(S[i] == S[j]){
                same_counts++;
                j++;

            }
            s += S[i]+to_string(same_counts);
            i = j;
        }
        if(s.size() >= len) return S;
        else return s;
    }
};
```



## Related Topics

- [Two Pointers](https://leetcode.cn//tag/two-pointers)
- [String](https://leetcode.cn//tag/string)

## Similar Questions


