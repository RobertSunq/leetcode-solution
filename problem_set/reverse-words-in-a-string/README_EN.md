
| English | [简体中文](README.md) |

# [151. Reverse Words in a String](https://leetcode.cn//problems/reverse-words-in-a-string/)

## Description

<p>Given an input string <code>s</code>, reverse the order of the <strong>words</strong>.</p>

<p>A <strong>word</strong> is defined as a sequence of non-space characters. The <strong>words</strong> in <code>s</code> will be separated by at least one space.</p>

<p>Return <em>a string of the words in reverse order concatenated by a single space.</em></p>

<p><b>Note</b> that <code>s</code> may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;the sky is blue&quot;
<strong>Output:</strong> &quot;blue is sky the&quot;
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;  hello world  &quot;
<strong>Output:</strong> &quot;world hello&quot;
<strong>Explanation:</strong> Your reversed string should not contain leading or trailing spaces.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;a good   example&quot;
<strong>Output:</strong> &quot;example good a&quot;
<strong>Explanation:</strong> You need to reduce multiple spaces between two words to a single space in the reversed string.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>4</sup></code></li>
	<li><code>s</code> contains English letters (upper-case and lower-case), digits, and spaces <code>&#39; &#39;</code>.</li>
	<li>There is <strong>at least one</strong> word in <code>s</code>.</li>
</ul>

<p>&nbsp;</p>
<p><b data-stringify-type="bold">Follow-up:&nbsp;</b>If the string data type is mutable in your language, can&nbsp;you solve it&nbsp;<b data-stringify-type="bold">in-place</b>&nbsp;with&nbsp;<code data-stringify-type="code">O(1)</code>&nbsp;extra space?</p>


## Solutions


### Java

```Java
// @Title: 反转字符串中的单词 (Reverse Words in a String)
// @Author: robert.sunq
// @Date: 2021-08-01 20:33:04
// @Runtime: 7 ms
// @Memory: 38.7 MB

class Solution {
    public String reverseWords(String s) {
        // 去除先后空格
        s = " "+s.trim();
        char[] schar = s.toCharArray();
        String res = "";
        int j = schar.length-1;
        for(int i = schar.length-1;i>= 0; i--){
            if(schar[i] == ' '){
                String temp = recur(schar,i,j) + " ";
                res = res + temp;
                while(i>0 && schar[i] == ' ') i--;
                j = i;
            }
        }
        return res.trim();
    }

    String recur(char[] schar , int start,int end){
        String res = "";
        for(int i =0 ;i<end - start ; i++){
            res = res + String.valueOf(schar[start + 1 + i]);
        }
        return res;
    }
}
```



## Related Topics

- [Two Pointers](https://leetcode.cn//tag/two-pointers)
- [String](https://leetcode.cn//tag/string)

## Similar Questions

- [Reverse Words in a String II](../reverse-words-in-a-string-ii/README_EN.md)
