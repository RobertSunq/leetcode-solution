
| [English](README_EN.md) | 简体中文 |

# [415. 字符串相加](https://leetcode.cn//problems/add-strings/)

## 题目描述

<p>给定两个字符串形式的非负整数&nbsp;<code>num1</code> 和<code>num2</code>&nbsp;，计算它们的和并同样以字符串形式返回。</p>

<p>你不能使用任何內建的用于处理大整数的库（比如 <code>BigInteger</code>），&nbsp;也不能直接将输入的字符串转换为整数形式。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>num1 = "11", num2 = "123"
<strong>输出：</strong>"134"
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>num1 = "456", num2 = "77"
<strong>输出：</strong>"533"
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>num1 = "0", num2 = "0"
<strong>输出：</strong>"0"
</pre>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= num1.length, num2.length &lt;= 10<sup>4</sup></code></li>
	<li><code>num1</code> 和<code>num2</code> 都只包含数字&nbsp;<code>0-9</code></li>
	<li><code>num1</code> 和<code>num2</code> 都不包含任何前导零</li>
</ul>


## 题解


### Java

```Java
// @Title: 字符串相加 (Add Strings)
// @Author: robert.sunq
// @Date: 2021-07-01 22:39:19
// @Runtime: 2 ms
// @Memory: 38.6 MB

class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        char[] num1c = num1.toCharArray();
        char[] num2c = num2.toCharArray();
        int len1 = num1.length()-1;
        int len2 = num2.length()-1;
        int temp = 0;
        while(len1 >= 0 && len2 >= 0){
            res.append( ((num1c[len1] + num2c[len2]- '0'-'0' + temp)%10) );
            temp = ((num1c[len1] + num2c[len2]- '0'-'0'+temp)/10);
            len1--;
            len2--;
        }
        while(len1>= 0){
            res.append( ((num1c[len1] - '0' + temp)%10) );
            temp = ((num1c[len1] - '0'+temp)/10);
            len1--;
        }
        while(len2 >= 0){
            res.append( ((num2c[len2] - '0' + temp)%10) );
            temp = ((num2c[len2] - '0'+temp)/10);
            len2--;
        }
        if(temp != 0){
            res.append(temp);
        }
        return res.reverse().toString();
    }
}
```



## 相关话题

- [数学](https://leetcode.cn//tag/math)
- [字符串](https://leetcode.cn//tag/string)
- [模拟](https://leetcode.cn//tag/simulation)

## 相似题目


- [两数相加](../add-two-numbers/README.md)
- [字符串相乘](../multiply-strings/README.md)
- [数组形式的整数加法](../add-to-array-form-of-integer/README.md)
