
| [English](README_EN.md) | 简体中文 |

# [1071. 字符串的最大公因子](https://leetcode.cn//problems/greatest-common-divisor-of-strings/)

## 题目描述

<p>对于字符串&nbsp;<code>s</code> 和&nbsp;<code>t</code>，只有在&nbsp;<code>s = t + ... + t</code>（<code>t</code> 自身连接 1 次或多次）时，我们才认定&nbsp;“<code>t</code> 能除尽 <code>s</code>”。</p>

<p>给定两个字符串&nbsp;<code>str1</code>&nbsp;和&nbsp;<code>str2</code>&nbsp;。返回 <em>最长字符串&nbsp;<code>x</code>，要求满足&nbsp;<code>x</code> 能除尽 <code>str1</code> 且 <code>x</code> 能除尽 <code>str2</code></em> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>str1 = "ABCABC", str2 = "ABC"
<strong>输出：</strong>"ABC"
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>str1 = "ABABAB", str2 = "ABAB"
<strong>输出：</strong>"AB"
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>str1 = "LEET", str2 = "CODE"
<strong>输出：</strong>""
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= str1.length, str2.length &lt;= 1000</code></li>
	<li><code>str1</code>&nbsp;和&nbsp;<code>str2</code>&nbsp;由大写英文字母组成</li>
</ul>


## 题解


### Java

```Java
// @Title: 字符串的最大公因子 (Greatest Common Divisor of Strings)
// @Author: robert.sunq
// @Date: 2023-08-08 22:03:22
// @Runtime: 1 ms
// @Memory: 39.8 MB

class Solution {
    public String gcdOfStrings(String str1, String str2) {

        //从最大可用长度开始枚举
        int n1 = str1.length();
        int n2 = str2.length();
        int subSize = Math.min(n1, n2);
        while (subSize > 0) {
            if (n1 % subSize == 0 && n2 % subSize == 0) {
                String x = str1.substring(0, subSize);
                if (isGcd(str1, x) && isGcd(str2, x)) {
                    return str1.substring(0, subSize);
                }
            }
            subSize--;
        }

        return "";

    }

    private boolean isGcd(String str, String x) {
        int lenx = str.length() / x.length();
        StringBuffer ans = new StringBuffer();
        for (int i = 0; i < lenx; i++) {
            ans.append(x);
        }
        return str.equals(ans.toString());
    }
}
```



## 相关话题

- [数学](https://leetcode.cn//tag/math)
- [字符串](https://leetcode.cn//tag/string)

## 相似题目



