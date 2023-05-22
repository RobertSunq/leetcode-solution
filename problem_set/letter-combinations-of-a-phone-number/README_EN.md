
| English | [简体中文](README.md) |

# [17. Letter Combinations of a Phone Number](https://leetcode.cn//problems/letter-combinations-of-a-phone-number/)

## Description

<p>Given a string containing digits from <code>2-9</code> inclusive, return all possible letter combinations that the number could represent. Return the answer in <strong>any order</strong>.</p>

<p>A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.</p>
<img alt="" src="https://assets.leetcode.com/uploads/2022/03/15/1200px-telephone-keypad2svg.png" style="width: 300px; height: 243px;" />
<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> digits = &quot;23&quot;
<strong>Output:</strong> [&quot;ad&quot;,&quot;ae&quot;,&quot;af&quot;,&quot;bd&quot;,&quot;be&quot;,&quot;bf&quot;,&quot;cd&quot;,&quot;ce&quot;,&quot;cf&quot;]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> digits = &quot;&quot;
<strong>Output:</strong> []
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> digits = &quot;2&quot;
<strong>Output:</strong> [&quot;a&quot;,&quot;b&quot;,&quot;c&quot;]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= digits.length &lt;= 4</code></li>
	<li><code>digits[i]</code> is a digit in the range <code>[&#39;2&#39;, &#39;9&#39;]</code>.</li>
</ul>


## Solutions


### Java

```Java
// @Title: 电话号码的字母组合 (Letter Combinations of a Phone Number)
// @Author: robert.sunq
// @Date: 2021-06-02 21:53:10
// @Runtime: 0 ms
// @Memory: 36.8 MB

class Solution {
    List<String> res = new ArrayList<>();
    char[] temp;
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return res;
        temp = new char[digits.length()];
        recur(digits,0);
        return res;
    }
    void recur(String digits , int index){
        if(index == digits.length()){
            res.add(String.valueOf(temp));
            return;
        }
        int n = 3;
        char c = digits.charAt(index);
        if(c == '9' || c=='7'){
            n = 4;
        }
        for(int i = 0;i<n;i++){
            int ci = (c-'2') * 3 + 'a' + i;
            if(c>'7'){
                ci++;
            }
            temp[index] = (char) (ci);
            recur(digits,index+1);
        }
    }
}
```



## Related Topics

- [Hash Table](https://leetcode.cn//tag/hash-table)
- [String](https://leetcode.cn//tag/string)
- [Backtracking](https://leetcode.cn//tag/backtracking)

## Similar Questions

- [Generate Parentheses](../generate-parentheses/README_EN.md)
- [Combination Sum](../combination-sum/README_EN.md)
- [Binary Watch](../binary-watch/README_EN.md)
