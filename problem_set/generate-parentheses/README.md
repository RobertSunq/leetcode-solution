
| [English](README_EN.md) | 简体中文 |

# [22. 括号生成](https://leetcode.cn//problems/generate-parentheses/)

## 题目描述

<p>数字 <code>n</code>&nbsp;代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 <strong>有效的 </strong>括号组合。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>n = 3
<strong>输出：</strong>["((()))","(()())","(())()","()(())","()()()"]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>n = 1
<strong>输出：</strong>["()"]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 8</code></li>
</ul>


## 题解


### Java

```Java
// @Title: 括号生成 (Generate Parentheses)
// @Author: robert.sunq
// @Date: 2021-06-02 22:50:38
// @Runtime: 0 ms
// @Memory: 38.5 MB

class Solution {
    List<String> res = new ArrayList<>();
    char[] resTemp;
    int N;
    public List<String> generateParenthesis(int n) {
        resTemp = new char[n*2];
        N = n;
        recur(0,0,0);
        return res;
        
    }
    void recur(int index,int l , int r){
        // System.out.println("index = "+ index+", l = "+l+", r = "+r);
        if(index == 2*N){
            res.add(String.valueOf(resTemp));
            return;
        }
        // 如果 已用的左括号和已用的右括号相等 ， 则只能填入左
        if (l <= r){
            resTemp[index] = '(';
            recur(index+1,l+1,r);
        }else{
            // 此时可以选择填入 左 或者填入右
            if(l < N){
                resTemp[index] = '(';
                recur(index+1,l+1,r);
            }
            if(r < N){
                resTemp[index] = ')';
                recur(index+1,l,r+1);
            }
        }
    }
}
```



## 相关话题

- [字符串](https://leetcode.cn//tag/string)
- [动态规划](https://leetcode.cn//tag/dynamic-programming)
- [回溯](https://leetcode.cn//tag/backtracking)

## 相似题目


- [电话号码的字母组合](../letter-combinations-of-a-phone-number/README.md)
- [有效的括号](../valid-parentheses/README.md)
