
| [English](README_EN.md) | 简体中文 |

# [5. 最长回文子串](https://leetcode.cn//problems/longest-palindromic-substring/)

## 题目描述

<p>给你一个字符串 <code>s</code>，找到 <code>s</code> 中最长的回文子串。</p>

<p>如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = "babad"
<strong>输出：</strong>"bab"
<strong>解释：</strong>"aba" 同样是符合题意的答案。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = "cbbd"
<strong>输出：</strong>"bb"
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 1000</code></li>
	<li><code>s</code> 仅由数字和英文字母组成</li>
</ul>


## 题解


### Java

```Java
// @Title: 最长回文子串 (Longest Palindromic Substring)
// @Author: robert.sunq
// @Date: 2021-06-01 23:24:41
// @Runtime: 10 ms
// @Memory: 38.7 MB

class Solution {

    public String longestPalindrome(String s) {
        if(s == null || s.length() < 1) return "";
        int resIndexLeft = 0,resIndexRight = 0;
        char[] ss = s.toCharArray();
        int res = 0;
        int i = 0;
        while(i< ss.length){
            int[] temp = recur(ss,i);
            if(temp[0] > res){
                resIndexLeft = temp[1];
                resIndexRight = temp[2] ;
                res = temp[0];
            }
            i++;
            // System.out.println("-----i  " + temp[0]+" j  "+temp[1] + "   "+ temp[2]);
        }
        return s.substring(resIndexLeft,resIndexRight);
    }
    // 向两边查询回文串
    int[] recur(char[] ss,int mid){
        int i = mid,j = mid;
        int res = 0,left=mid,right = mid;
        // 以mid为中心的最长回文串
        while(i>=0 && j <ss.length){
            // System.out.println(i+"  "+ j);
            if(ss[i] == ss[j]){
                i--;
                j++;
            }else{
                break;
            }
        }
        res = j-i-1;
        left = i+1;
        right = j;
        // 以mid与mid+1为中心的最长回文串
        i=  mid;
        j = mid+1;
        while(i>=0 && j < ss.length){
            if(ss[i] == ss[j]){
                i--;
                j++;
            }else{
                break;
            }
        }
        if ((j-i-1) > res){
            res= j-i-1;
            left = i+1;
            right = j;
        }
        res = Math.max(res,j-i-1);
        // System.out.println("res  " + res);
        return new int[]{res,left,right};
    }
}
```



## 相关话题

- [字符串](https://leetcode.cn//tag/string)
- [动态规划](https://leetcode.cn//tag/dynamic-programming)

## 相似题目


- [最短回文串](../shortest-palindrome/README.md)
- [回文排列](../palindrome-permutation/README.md)
- [回文对](../palindrome-pairs/README.md)
- [最长回文子序列](../longest-palindromic-subsequence/README.md)
- [回文子串](../palindromic-substrings/README.md)
