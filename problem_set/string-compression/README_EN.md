
| English | [简体中文](README.md) |

# [443. String Compression](https://leetcode.cn//problems/string-compression/)

## Description

<p>Given an array of characters <code>chars</code>, compress it using the following algorithm:</p>

<p>Begin with an empty string <code>s</code>. For each group of <strong>consecutive repeating characters</strong> in <code>chars</code>:</p>

<ul>
	<li>If the group&#39;s length is <code>1</code>, append the character to <code>s</code>.</li>
	<li>Otherwise, append the character followed by the group&#39;s length.</li>
</ul>

<p>The compressed string <code>s</code> <strong>should not be returned separately</strong>, but instead, be stored <strong>in the input character array <code>chars</code></strong>. Note that group lengths that are <code>10</code> or longer will be split into multiple characters in <code>chars</code>.</p>

<p>After you are done <strong>modifying the input array,</strong> return <em>the new length of the array</em>.</p>

<p>You must write an algorithm that uses only constant extra space.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> chars = [&quot;a&quot;,&quot;a&quot;,&quot;b&quot;,&quot;b&quot;,&quot;c&quot;,&quot;c&quot;,&quot;c&quot;]
<strong>Output:</strong> Return 6, and the first 6 characters of the input array should be: [&quot;a&quot;,&quot;2&quot;,&quot;b&quot;,&quot;2&quot;,&quot;c&quot;,&quot;3&quot;]
<strong>Explanation:</strong> The groups are &quot;aa&quot;, &quot;bb&quot;, and &quot;ccc&quot;. This compresses to &quot;a2b2c3&quot;.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> chars = [&quot;a&quot;]
<strong>Output:</strong> Return 1, and the first character of the input array should be: [&quot;a&quot;]
<strong>Explanation:</strong> The only group is &quot;a&quot;, which remains uncompressed since it&#39;s a single character.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> chars = [&quot;a&quot;,&quot;b&quot;,&quot;b&quot;,&quot;b&quot;,&quot;b&quot;,&quot;b&quot;,&quot;b&quot;,&quot;b&quot;,&quot;b&quot;,&quot;b&quot;,&quot;b&quot;,&quot;b&quot;,&quot;b&quot;]
<strong>Output:</strong> Return 4, and the first 4 characters of the input array should be: [&quot;a&quot;,&quot;b&quot;,&quot;1&quot;,&quot;2&quot;].
<strong>Explanation:</strong> The groups are &quot;a&quot; and &quot;bbbbbbbbbbbb&quot;. This compresses to &quot;ab12&quot;.</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= chars.length &lt;= 2000</code></li>
	<li><code>chars[i]</code> is a lowercase English letter, uppercase English letter, digit, or symbol.</li>
</ul>


## Solutions


### Java

```Java
// @Title: 压缩字符串 (String Compression)
// @Author: robert.sunq
// @Date: 2023-08-12 21:53:44
// @Runtime: 0 ms
// @Memory: 41.9 MB

class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        // 记录当前要写入新字符的位置
        int wirte = 0;
        // 记录当前重复字段的开启
        int left = 0;
        for (int i = 0; i < n ; i++) {
            if (i == n - 1 || chars[i] != chars[i + 1]) {
                chars[wirte++] = chars[i];
                int num = i - left + 1;
                // 长度比1大，才有需要保存数字
                if (num > 1) {
                    int tmp = wirte;
                    while (num > 0) {
                        chars[wirte++] = (char) (num % 10 + '0');
                        num = num / 10;
                    }
                    // 翻转数字部分
                    revers(chars, tmp, wirte - 1);
                }
                left = i  + 1;
            }
        }
        // 结尾
        return wirte;
    }

    // 翻转数字部分
    private void revers(char[] chars , int left, int right) {
        while (left < right) {
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            left++;
            right--;
        }
    }
}
```



## Related Topics

- [Two Pointers](https://leetcode.cn//tag/two-pointers)
- [String](https://leetcode.cn//tag/string)

## Similar Questions

- [Count and Say](../count-and-say/README_EN.md)
- [Encode and Decode Strings](../encode-and-decode-strings/README_EN.md)
- [Design Compressed String Iterator](../design-compressed-string-iterator/README_EN.md)
