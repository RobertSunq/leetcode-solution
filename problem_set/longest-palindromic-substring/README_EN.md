
| English | [简体中文](README.md) |

# [5. Longest Palindromic Substring](https://leetcode.cn//problems/longest-palindromic-substring/)

## Description

<p>Given a string <code>s</code>, return <em>the longest</em> <span data-keyword="palindromic-string"><em>palindromic</em></span> <span data-keyword="substring-nonempty"><em>substring</em></span> in <code>s</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;babad&quot;
<strong>Output:</strong> &quot;bab&quot;
<strong>Explanation:</strong> &quot;aba&quot; is also a valid answer.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;cbbd&quot;
<strong>Output:</strong> &quot;bb&quot;
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 1000</code></li>
	<li><code>s</code> consist of only digits and English letters.</li>
</ul>


## Solutions


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



## Related Topics

- [String](https://leetcode.cn//tag/string)
- [Dynamic Programming](https://leetcode.cn//tag/dynamic-programming)

## Similar Questions

- [Shortest Palindrome](../shortest-palindrome/README_EN.md)
- [Palindrome Permutation](../palindrome-permutation/README_EN.md)
- [Palindrome Pairs](../palindrome-pairs/README_EN.md)
- [Longest Palindromic Subsequence](../longest-palindromic-subsequence/README_EN.md)
- [Palindromic Substrings](../palindromic-substrings/README_EN.md)
