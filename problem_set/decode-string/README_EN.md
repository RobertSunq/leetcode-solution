
| English | [简体中文](README.md) |

# [394. Decode String](https://leetcode.cn//problems/decode-string/)

## Description

<p>Given an encoded string, return its decoded string.</p>

<p>The encoding rule is: <code>k[encoded_string]</code>, where the <code>encoded_string</code> inside the square brackets is being repeated exactly <code>k</code> times. Note that <code>k</code> is guaranteed to be a positive integer.</p>

<p>You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, <code>k</code>. For example, there will not be input like <code>3a</code> or <code>2[4]</code>.</p>

<p>The test cases are generated so that the length of the output will never exceed <code>10<sup>5</sup></code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;3[a]2[bc]&quot;
<strong>Output:</strong> &quot;aaabcbc&quot;
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;3[a2[c]]&quot;
<strong>Output:</strong> &quot;accaccacc&quot;
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;2[abc]3[cd]ef&quot;
<strong>Output:</strong> &quot;abcabccdcdcdef&quot;
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 30</code></li>
	<li><code>s</code> consists of lowercase English letters, digits, and square brackets <code>&#39;[]&#39;</code>.</li>
	<li><code>s</code> is guaranteed to be <strong>a valid</strong> input.</li>
	<li>All the integers in <code>s</code> are in the range <code>[1, 300]</code>.</li>
</ul>


## Solutions


### Java

```Java
// @Title: 字符串解码 (Decode String)
// @Author: robert.sunq
// @Date: 2021-06-20 22:16:42
// @Runtime: 2 ms
// @Memory: 36.4 MB

class Solution {
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        // 保存数字
        Stack<Integer> stNum = new Stack<>();
        // 保存当前密码串
        Stack<String> stSt = new Stack<>();
        // 记录数组
        int num = 0;
        for(Character c:s.toCharArray()){
            // 字符等于【 将重复次数放入栈，将序列放入栈，开始统计需要重复的字符串
            if(c == '['){
                stNum.push(num);
                stSt.push(res.toString());
                res = new StringBuilder();
                num = 0;
            }else if(c == ']'){
                // 字符串等于】 数字出栈，将当前字符重复 出栈的次数
                int tempNum = stNum.pop();
                StringBuilder temp = new StringBuilder();
                for(int i=0;i<tempNum;i++){
                    temp.append(res);
                }
                res = new StringBuilder(stSt.pop()+temp.toString());
            }else if( c <= '9' && c>='0'){
                // 计算重复数字
                num = num * 10 + Integer.parseInt(c.toString());
            }else{
                res.append(c);
            }
        }
        return res.toString();
    }
}
```



## Related Topics

- [Stack](https://leetcode.cn//tag/stack)
- [Recursion](https://leetcode.cn//tag/recursion)
- [String](https://leetcode.cn//tag/string)

## Similar Questions

- [Encode String with Shortest Length](../encode-string-with-shortest-length/README_EN.md)
- [Number of Atoms](../number-of-atoms/README_EN.md)
- [Brace Expansion](../brace-expansion/README_EN.md)
