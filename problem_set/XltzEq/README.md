
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer II 018. 有效的回文](https://leetcode.cn//problems/XltzEq/)

## 题目描述

<p>给定一个字符串 <code>s</code> ，验证 <code>s</code>&nbsp;是否是&nbsp;<strong>回文串&nbsp;</strong>，只考虑字母和数字字符，可以忽略字母的大小写。</p>

<p>本题中，将空字符串定义为有效的&nbsp;<strong>回文串&nbsp;</strong>。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入: </strong>s =<strong> </strong>&quot;A man, a plan, a canal: Panama&quot;
<strong>输出:</strong> true
<strong>解释：</strong>&quot;amanaplanacanalpanama&quot; 是回文串</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> s = &quot;race a car&quot;
<strong>输出:</strong> false
解释：&quot;raceacar&quot; 不是回文串</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 2 * 10<sup>5</sup></code></li>
	<li>字符串 <code>s</code> 由 ASCII 字符组成</li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 125&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/valid-palindrome/">https://leetcode-cn.com/problems/valid-palindrome/</a></p>


## 题解


### Java

```Java
// @Title: 有效的回文 (有效的回文)
// @Author: robert.sunq
// @Date: 2023-06-15 00:14:37
// @Runtime: 3 ms
// @Memory: 40.9 MB

class Solution {
    public boolean isPalindrome(String s) {
        int start = 0;
        int n = s.length();
        int end = n - 1;
        s = s.toLowerCase();
        char cStart;
        char cEnd;
        while (start < end) {
            cStart = s.charAt(start);
            cEnd = s.charAt(end);
            
            while ( !isNumOrEnglish(cStart)) {
                start++;
                if (start >= n) {
                    return true;
                }
                cStart = s.charAt(start);
            }

            while ( !isNumOrEnglish(cEnd)) {
                end--;
                if (end < 0) {
                    return true;
                }
                cEnd = s.charAt(end);
            }
            if (cEnd != cStart) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private boolean isNumOrEnglish(char c) {
        if (c >= 'a' && c <= 'z') {
            return true;
        }

        return c >= '0' && c <= '9';
    }
}
```



## 相关话题

- [双指针](https://leetcode.cn//tag/two-pointers)
- [字符串](https://leetcode.cn//tag/string)

## 相似题目



