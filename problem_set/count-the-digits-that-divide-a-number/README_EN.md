
| English | [简体中文](README.md) |

# [2520. Count the Digits That Divide a Number](https://leetcode.cn//problems/count-the-digits-that-divide-a-number/)

## Description

<p>Given an integer <code>num</code>, return <em>the number of digits in <code>num</code> that divide </em><code>num</code>.</p>

<p>An integer <code>val</code> divides <code>nums</code> if <code>nums % val == 0</code>.</p>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>

<pre>
<strong>Input:</strong> num = 7
<strong>Output:</strong> 1
<strong>Explanation:</strong> 7 divides itself, hence the answer is 1.
</pre>

<p><strong>Example 2:</strong></p>

<pre>
<strong>Input:</strong> num = 121
<strong>Output:</strong> 2
<strong>Explanation:</strong> 121 is divisible by 1, but not 2. Since 1 occurs twice as a digit, we return 2.
</pre>

<p><strong>Example 3:</strong></p>

<pre>
<strong>Input:</strong> num = 1248
<strong>Output:</strong> 4
<strong>Explanation:</strong> 1248 is divisible by all of its digits, hence the answer is 4.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= num &lt;= 10<sup>9</sup></code></li>
	<li><code>num</code> does not contain <code>0</code> as one of its digits.</li>
</ul>


## Solutions


### Java

```Java
// @Title: 统计能整除数字的位数 (Count the Digits That Divide a Number)
// @Author: robert.sunq
// @Date: 2023-10-26 20:51:27
// @Runtime: 0 ms
// @Memory: 38.1 MB

class Solution {
    public int countDigits(int num) {
        int ans = 0;

        for (char c : Integer.toString(num).toCharArray()) {
            if (num % (c - '0') == 0) {
                ans++;
            }
        }

        return ans;
    }
}
```



## Related Topics

- [Math](https://leetcode.cn//tag/math)

## Similar Questions


