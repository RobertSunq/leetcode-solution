
| English | [简体中文](README.md) |

# [647. Palindromic Substrings](https://leetcode.cn//problems/palindromic-substrings/)

## Description

<p>Given a string <code>s</code>, return <em>the number of <strong>palindromic substrings</strong> in it</em>.</p>

<p>A string is a <strong>palindrome</strong> when it reads the same backward as forward.</p>

<p>A <strong>substring</strong> is a contiguous sequence of characters within the string.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;abc&quot;
<strong>Output:</strong> 3
<strong>Explanation:</strong> Three palindromic strings: &quot;a&quot;, &quot;b&quot;, &quot;c&quot;.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;aaa&quot;
<strong>Output:</strong> 6
<strong>Explanation:</strong> Six palindromic strings: &quot;a&quot;, &quot;a&quot;, &quot;a&quot;, &quot;aa&quot;, &quot;aa&quot;, &quot;aaa&quot;.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 1000</code></li>
	<li><code>s</code> consists of lowercase English letters.</li>
</ul>


## Solutions


### Java

```Java
// @Title: 回文子串 (Palindromic Substrings)
// @Author: robert.sunq
// @Date: 2021-06-23 00:17:25
// @Runtime: 1 ms
// @Memory: 36.6 MB

class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        char[] sc = s.toCharArray();
        //  从第二个字符开始查找
        for(int i =0;i<s.length();i++){
            // 判断当前位置有多少个回文串
            res+=recur(sc,i);
        }

        return res;
    }
    // 判断当前位置是否可以是回文串
    int recur(char[] sc ,int start){
        int res = 0;
        // 以当前节点为中点，像左右查询
        int i=start,j = start;
        while(i >= 0 && j<sc.length){
            // 不能匹配，则直接退回
            if(sc[i] != sc[j]){
                break;
            }
            // 能匹配上，则表示为一种回文串
            res++;
            i--;
            j++;
        }
        // 当前字符为，对称回文串的左侧
        i = start -1;
        j = start;
        while(i >= 0 && j<sc.length){
            // 不能匹配，则直接退回
            if(sc[i] != sc[j]){
                break;
            }
            // 能匹配上，则表示为一种回文串
            res++;
            i--;
            j++;
        }
        return res;
    }
}
```



## Related Topics

- [String](https://leetcode.cn//tag/string)
- [Dynamic Programming](https://leetcode.cn//tag/dynamic-programming)

## Similar Questions

- [Longest Palindromic Substring](../longest-palindromic-substring/README_EN.md)
- [Longest Palindromic Subsequence](../longest-palindromic-subsequence/README_EN.md)
- [Palindromic Substrings](../palindromic-substrings/README_EN.md)
