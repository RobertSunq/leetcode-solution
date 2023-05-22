
| [English](README_EN.md) | 简体中文 |

# [17. 电话号码的字母组合](https://leetcode.cn//problems/letter-combinations-of-a-phone-number/)

## 题目描述

<p>给定一个仅包含数字&nbsp;<code>2-9</code>&nbsp;的字符串，返回所有它能表示的字母组合。答案可以按 <strong>任意顺序</strong> 返回。</p>

<p>给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。</p>

<p><img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2021/11/09/200px-telephone-keypad2svg.png" style="width: 200px;" /></p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>digits = "23"
<strong>输出：</strong>["ad","ae","af","bd","be","bf","cd","ce","cf"]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>digits = ""
<strong>输出：</strong>[]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>digits = "2"
<strong>输出：</strong>["a","b","c"]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>0 &lt;= digits.length &lt;= 4</code></li>
	<li><code>digits[i]</code> 是范围 <code>['2', '9']</code> 的一个数字。</li>
</ul>


## 题解


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



## 相关话题

- [哈希表](https://leetcode.cn//tag/hash-table)
- [字符串](https://leetcode.cn//tag/string)
- [回溯](https://leetcode.cn//tag/backtracking)

## 相似题目


- [括号生成](../generate-parentheses/README.md)
- [组合总和](../combination-sum/README.md)
- [二进制手表](../binary-watch/README.md)
