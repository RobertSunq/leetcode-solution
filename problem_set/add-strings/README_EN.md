
| English | [简体中文](README.md) |

# [415. Add Strings](https://leetcode.cn//problems/add-strings/)

## Description

<p>Given two non-negative integers, <code>num1</code> and <code>num2</code> represented as string, return <em>the sum of</em> <code>num1</code> <em>and</em> <code>num2</code> <em>as a string</em>.</p>

<p>You must solve the problem without using any built-in library for handling large integers (such as <code>BigInteger</code>). You must also not convert the inputs to integers directly.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> num1 = &quot;11&quot;, num2 = &quot;123&quot;
<strong>Output:</strong> &quot;134&quot;
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> num1 = &quot;456&quot;, num2 = &quot;77&quot;
<strong>Output:</strong> &quot;533&quot;
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> num1 = &quot;0&quot;, num2 = &quot;0&quot;
<strong>Output:</strong> &quot;0&quot;
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= num1.length, num2.length &lt;= 10<sup>4</sup></code></li>
	<li><code>num1</code> and <code>num2</code> consist of only digits.</li>
	<li><code>num1</code> and <code>num2</code> don&#39;t have any leading zeros except for the zero itself.</li>
</ul>


## Solutions


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



## Related Topics

- [Math](https://leetcode.cn//tag/math)
- [String](https://leetcode.cn//tag/string)
- [Simulation](https://leetcode.cn//tag/simulation)

## Similar Questions

- [Add Two Numbers](../add-two-numbers/README_EN.md)
- [Multiply Strings](../multiply-strings/README_EN.md)
- [Add to Array-Form of Integer](../add-to-array-form-of-integer/README_EN.md)
