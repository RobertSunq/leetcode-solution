
| English | [简体中文](README.md) |

# [345. Reverse Vowels of a String](https://leetcode.cn//problems/reverse-vowels-of-a-string/)

## Description

<p>Given a string <code>s</code>, reverse only all the vowels in the string and return it.</p>

<p>The vowels are <code>&#39;a&#39;</code>, <code>&#39;e&#39;</code>, <code>&#39;i&#39;</code>, <code>&#39;o&#39;</code>, and <code>&#39;u&#39;</code>, and they can appear in both lower and upper cases, more than once.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> s = "hello"
<strong>Output:</strong> "holle"
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> s = "leetcode"
<strong>Output:</strong> "leotcede"
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 3 * 10<sup>5</sup></code></li>
	<li><code>s</code> consist of <strong>printable ASCII</strong> characters.</li>
</ul>


## Solutions


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



## Related Topics

- [Two Pointers](https://leetcode.cn//tag/two-pointers)
- [String](https://leetcode.cn//tag/string)

## Similar Questions

- [Reverse String](../reverse-string/README_EN.md)
- [Remove Vowels from a String](../remove-vowels-from-a-string/README_EN.md)
