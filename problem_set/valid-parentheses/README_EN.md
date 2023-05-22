
| English | [简体中文](README.md) |

# [20. Valid Parentheses](https://leetcode.cn//problems/valid-parentheses/)

## Description

<p>Given a string <code>s</code> containing just the characters <code>&#39;(&#39;</code>, <code>&#39;)&#39;</code>, <code>&#39;{&#39;</code>, <code>&#39;}&#39;</code>, <code>&#39;[&#39;</code> and <code>&#39;]&#39;</code>, determine if the input string is valid.</p>

<p>An input string is valid if:</p>

<ol>
	<li>Open brackets must be closed by the same type of brackets.</li>
	<li>Open brackets must be closed in the correct order.</li>
	<li>Every close bracket has a corresponding open bracket of the same type.</li>
</ol>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;()&quot;
<strong>Output:</strong> true
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;()[]{}&quot;
<strong>Output:</strong> true
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;(]&quot;
<strong>Output:</strong> false
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>4</sup></code></li>
	<li><code>s</code> consists of parentheses only <code>&#39;()[]{}&#39;</code>.</li>
</ul>


## Solutions


### Java

```Java
// @Title: 有效的括号 (Valid Parentheses)
// @Author: robert.sunq
// @Date: 2021-06-02 22:18:39
// @Runtime: 1 ms
// @Memory: 36.6 MB

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        char[] sc = s.toCharArray();
        for(int i=0;i<sc.length;i++){
            if(sc[i] == '(' || sc[i] == '{' || sc[i] == '['){
                st.push(sc[i]);
            }else{
                if(st.isEmpty()) return false;
                if(sc[i] == ')'){
                    if(st.pop() != '(') return false;
                    continue;
                }else if(sc[i] == '}'){
                    if(st.pop() != '{') return false;
                    continue;
                }else{
                    if(st.pop() != '[') return false;
                    continue;
                }
            }
        }
        if(st.isEmpty()) return true;
        return false;
    }
}
```



## Related Topics

- [Stack](https://leetcode.cn//tag/stack)
- [String](https://leetcode.cn//tag/string)

## Similar Questions

- [Generate Parentheses](../generate-parentheses/README_EN.md)
- [Longest Valid Parentheses](../longest-valid-parentheses/README_EN.md)
- [Remove Invalid Parentheses](../remove-invalid-parentheses/README_EN.md)
- [Check If Word Is Valid After Substitutions](../check-if-word-is-valid-after-substitutions/README_EN.md)
