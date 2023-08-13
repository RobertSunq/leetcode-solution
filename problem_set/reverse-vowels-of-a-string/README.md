
| [English](README_EN.md) | 简体中文 |

# [345. 反转字符串中的元音字母](https://leetcode.cn//problems/reverse-vowels-of-a-string/)

## 题目描述

<p>给你一个字符串 <code>s</code> ，仅反转字符串中的所有元音字母，并返回结果字符串。</p>

<p>元音字母包括 <code>'a'</code>、<code>'e'</code>、<code>'i'</code>、<code>'o'</code>、<code>'u'</code>，且可能以大小写两种形式出现不止一次。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = "hello"
<strong>输出：</strong>"holle"
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = "leetcode"
<strong>输出：</strong>"leotcede"</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 3 * 10<sup>5</sup></code></li>
	<li><code>s</code> 由 <strong>可打印的 ASCII</strong> 字符组成</li>
</ul>


## 题解


### Java

```Java
// @Title: 反转字符串中的元音字母 (Reverse Vowels of a String)
// @Author: robert.sunq
// @Date: 2023-08-10 21:59:10
// @Runtime: 4 ms
// @Memory: 42.3 MB

class Solution {
    public String reverseVowels(String s) {
        if (s.length() < 2) {
            return s;
        }
        Set<Character> o = new HashSet<>();
        o.add('a');
        o.add('e');
        o.add('i');
        o.add('o');
        o.add('u');
        o.add('A');
        o.add('E');
        o.add('I');
        o.add('O');
        o.add('U');
        char[] a = s.toCharArray();
        int i = 0;
        int j = a.length - 1;
        while ( i < j) {
            if (o.contains(a[i]) && o.contains(a[j])) {
                char t = a[i];
                a[i] = a[j];
                a[j] = t;
                i++;
                j--;
                continue;
            } 
            if (!o.contains(a[i]) ) {
                i++;
            }
            if (!o.contains(a[j])) {
                j--;
            }
        }

        return new String(a);
    }
}
```



## 相关话题

- [双指针](https://leetcode.cn//tag/two-pointers)
- [字符串](https://leetcode.cn//tag/string)

## 相似题目


- [反转字符串](../reverse-string/README.md)
- [删去字符串中的元音](../remove-vowels-from-a-string/README.md)
