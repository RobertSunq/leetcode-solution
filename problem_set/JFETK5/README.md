
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer II 002. 二进制加法](https://leetcode.cn//problems/JFETK5/)

## 题目描述

<p>给定两个 01 字符串&nbsp;<code>a</code>&nbsp;和&nbsp;<code>b</code>&nbsp;，请计算它们的和，并以二进制字符串的形式输出。</p>

<p>输入为 <strong>非空 </strong>字符串且只包含数字&nbsp;<code>1</code>&nbsp;和&nbsp;<code>0</code>。</p>

<p>&nbsp;</p>

<p><strong>示例&nbsp;1:</strong></p>

<pre>
<strong>输入:</strong> a = &quot;11&quot;, b = &quot;10&quot;
<strong>输出:</strong> &quot;101&quot;</pre>

<p><strong>示例&nbsp;2:</strong></p>

<pre>
<strong>输入:</strong> a = &quot;1010&quot;, b = &quot;1011&quot;
<strong>输出:</strong> &quot;10101&quot;</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li>每个字符串仅由字符 <code>&#39;0&#39;</code> 或 <code>&#39;1&#39;</code> 组成。</li>
	<li><code>1 &lt;= a.length, b.length &lt;= 10^4</code></li>
	<li>字符串如果不是 <code>&quot;0&quot;</code> ，就都不含前导零。</li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 67&nbsp;题相同：<a href="https://leetcode-cn.com/problems/add-binary/">https://leetcode-cn.com/problems/add-binary/</a></p>


## 题解


### Java

```Java
// @Title: 二进制加法 (二进制加法)
// @Author: robert.sunq
// @Date: 2023-05-25 16:41:32
// @Runtime: 2 ms
// @Memory: 41.3 MB

class Solution {
    public String addBinary(String a, String b) {
        int aLength = a.length();
        int bLength = b.length();

        // 进位值
        int add = 0;
        // 记录索引
        int aIndex = aLength - 1;
        int bIndex = bLength - 1;
        // 
        String result = "";
        while (aIndex >=0 || bIndex >= 0) {
            int aChar = 0;
            int bChar = 0;
            if (aIndex >= 0) {
                aChar = a.charAt(aIndex) - '0';
                aIndex--;
            }
            if (bIndex >= 0) {
                bChar = b.charAt(bIndex) - '0';
                bIndex--;
            }
            int sum = aChar + bChar + add;
            // 进位除法， 当前位取余数
            add = sum / 2;
            result = String.valueOf(sum % 2) + result;
        }
        if (add > 0) {
            result = "1" + result;
        }

        return result;
    }
}
```



## 相关话题

- [位运算](https://leetcode.cn//tag/bit-manipulation)
- [数学](https://leetcode.cn//tag/math)
- [字符串](https://leetcode.cn//tag/string)
- [模拟](https://leetcode.cn//tag/simulation)

## 相似题目



