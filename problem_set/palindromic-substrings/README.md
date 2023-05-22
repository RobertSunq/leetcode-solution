
| [English](README_EN.md) | 简体中文 |

# [647. 回文子串](https://leetcode.cn//problems/palindromic-substrings/)

## 题目描述

<p>给你一个字符串 <code>s</code> ，请你统计并返回这个字符串中 <strong>回文子串</strong> 的数目。</p>

<p><strong>回文字符串</strong> 是正着读和倒过来读一样的字符串。</p>

<p><strong>子字符串</strong> 是字符串中的由连续字符组成的一个序列。</p>

<p>具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = "abc"
<strong>输出：</strong>3
<strong>解释：</strong>三个回文子串: "a", "b", "c"
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = "aaa"
<strong>输出：</strong>6
<strong>解释：</strong>6个回文子串: "a", "a", "a", "aa", "aa", "aaa"</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 1000</code></li>
	<li><code>s</code> 由小写英文字母组成</li>
</ul>


## 题解


### Java

```Java
// @Title: 回文子串 (Palindromic Substrings)
// @Author: robert.sunq
// @Date: 2021-06-23 00:17:25
// @Runtime: 1 ms
// @Memory: 36.6 MB

class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        char[] sc = s.toCharArray();
        //  从第二个字符开始查找
        for(int i =0;i<s.length();i++){
            // 判断当前位置有多少个回文串
            res+=recur(sc,i);
        }

        return res;
    }
    // 判断当前位置是否可以是回文串
    int recur(char[] sc ,int start){
        int res = 0;
        // 以当前节点为中点，像左右查询
        int i=start,j = start;
        while(i >= 0 && j<sc.length){
            // 不能匹配，则直接退回
            if(sc[i] != sc[j]){
                break;
            }
            // 能匹配上，则表示为一种回文串
            res++;
            i--;
            j++;
        }
        // 当前字符为，对称回文串的左侧
        i = start -1;
        j = start;
        while(i >= 0 && j<sc.length){
            // 不能匹配，则直接退回
            if(sc[i] != sc[j]){
                break;
            }
            // 能匹配上，则表示为一种回文串
            res++;
            i--;
            j++;
        }
        return res;
    }
}
```



## 相关话题

- [字符串](https://leetcode.cn//tag/string)
- [动态规划](https://leetcode.cn//tag/dynamic-programming)

## 相似题目


- [最长回文子串](../longest-palindromic-substring/README.md)
- [最长回文子序列](../longest-palindromic-subsequence/README.md)
- [回文子串](../palindromic-substrings/README.md)
