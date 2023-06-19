
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer II 020. 回文子字符串的个数](https://leetcode.cn//problems/a7VOhD/)

## 题目描述

<p>给定一个字符串 <code>s</code> ，请计算这个字符串中有多少个回文子字符串。</p>

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
<strong>输入：</strong>s =<strong> </strong>"aaa"
<strong>输出：</strong>6
<strong>解释：</strong>6个回文子串: "a", "a", "a", "aa", "aa", "aaa"</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 1000</code></li>
	<li><code>s</code> 由小写英文字母组成</li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 647 题相同：<a href="https://leetcode-cn.com/problems/palindromic-substrings/">https://leetcode-cn.com/problems/palindromic-substrings/</a>&nbsp;</p>


## 题解


### Java

```Java
// @Title: 回文子字符串的个数 (回文子字符串的个数)
// @Author: robert.sunq
// @Date: 2023-06-20 00:09:37
// @Runtime: 11 ms
// @Memory: 43.7 MB

class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int[][] revertCount = new int[n][n];
        int ans = 0;

        // 注意 i 从大到小，j 从小到大，原因在于 [i, j] 的状态 依赖于 [i+1, j-1]。 所以需要先计算出i较大的值，j较小的值
        for (int i=n-1; i>=0; i--) {
            for (int j=i; j<n; j++) {
                if (i==j) {
                    revertCount[i][j] = 1;
                    ans++;
                    continue;
                }
                int tmp = 0;
                if (i + 1 < n && j - 1 >=i ) {
                    // 在 i上的字符等于j上的字符时，看其子串是否为回文字符串
                    if (s.charAt(i) == s.charAt(j)) {
                        // 当然如何j 结束变开始了，那么就是两个字符，时回文串
                        // 否则看子串
                        if (j-1<=i+1 || revertCount[i+1][j-1] == 1) {
                            revertCount[i][j] = 1;
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
```



## 相关话题

- [字符串](https://leetcode.cn//tag/string)
- [动态规划](https://leetcode.cn//tag/dynamic-programming)

## 相似题目



