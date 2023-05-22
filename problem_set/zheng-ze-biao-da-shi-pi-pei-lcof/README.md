
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer 19. 正则表达式匹配](https://leetcode.cn//problems/zheng-ze-biao-da-shi-pi-pei-lcof/)

## 题目描述

<p>请实现一个函数用来匹配包含<code>&#39;. &#39;</code>和<code>&#39;*&#39;</code>的正则表达式。模式中的字符<code>&#39;.&#39;</code>表示任意一个字符，而<code>&#39;*&#39;</code>表示它前面的字符可以出现任意次（含0次）。在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串<code>&quot;aaa&quot;</code>与模式<code>&quot;a.a&quot;</code>和<code>&quot;ab*ac*a&quot;</code>匹配，但与<code>&quot;aa.a&quot;</code>和<code>&quot;ab*a&quot;</code>均不匹配。</p>

<p><strong>示例 1:</strong></p>

<pre><strong>输入:</strong>
s = &quot;aa&quot;
p = &quot;a&quot;
<strong>输出:</strong> false
<strong>解释:</strong> &quot;a&quot; 无法匹配 &quot;aa&quot; 整个字符串。
</pre>

<p><strong>示例 2:</strong></p>

<pre><strong>输入:</strong>
s = &quot;aa&quot;
p = &quot;a*&quot;
<strong>输出:</strong> true
<strong>解释:</strong>&nbsp;因为 &#39;*&#39; 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 &#39;a&#39;。因此，字符串 &quot;aa&quot; 可被视为 &#39;a&#39; 重复了一次。
</pre>

<p><strong>示例&nbsp;3:</strong></p>

<pre><strong>输入:</strong>
s = &quot;ab&quot;
p = &quot;.*&quot;
<strong>输出:</strong> true
<strong>解释:</strong>&nbsp;&quot;.*&quot; 表示可匹配零个或多个（&#39;*&#39;）任意字符（&#39;.&#39;）。
</pre>

<p><strong>示例 4:</strong></p>

<pre><strong>输入:</strong>
s = &quot;aab&quot;
p = &quot;c*a*b&quot;
<strong>输出:</strong> true
<strong>解释:</strong>&nbsp;因为 &#39;*&#39; 表示零个或多个，这里 &#39;c&#39; 为 0 个, &#39;a&#39; 被重复一次。因此可以匹配字符串 &quot;aab&quot;。
</pre>

<p><strong>示例 5:</strong></p>

<pre><strong>输入:</strong>
s = &quot;mississippi&quot;
p = &quot;mis*is*p*.&quot;
<strong>输出:</strong> false</pre>

<ul>
	<li><code>s</code>&nbsp;可能为空，且只包含从&nbsp;<code>a-z</code>&nbsp;的小写字母。</li>
	<li><code>p</code>&nbsp;可能为空，且只包含从&nbsp;<code>a-z</code>&nbsp;的小写字母以及字符&nbsp;<code>.</code>&nbsp;和&nbsp;<code>*</code>，无连续的 <code>&#39;*&#39;</code>。</li>
</ul>

<p>注意：本题与主站 10&nbsp;题相同：<a href="https://leetcode-cn.com/problems/regular-expression-matching/">https://leetcode-cn.com/problems/regular-expression-matching/</a></p>


## 题解


### Java

```Java
// @Title: 正则表达式匹配 (正则表达式匹配 LCOF)
// @Author: robert.sunq
// @Date: 2021-05-26 22:08:16
// @Runtime: 2 ms
// @Memory: 38.3 MB

class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        // f[i][j] 表示 s的0-i，与怕p的0-j是否匹配
        boolean[][] f = new boolean[n+1][m+1];
        // 注意 0 代表字符串为空
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                //分成空正则和非空正则两种
                if (j == 0) {
                    f[i][j] = i == 0;
                }else{
                    // 非空正则分 * 和 非* 
                    // 采用 -1 是因为， 长为j再字符串中位置为 j-1 ，及当前位置字符是否为 * 
                    if(p.charAt(j-1) != '*') {
                        if(i>0 && (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.')){
                            f[i][j] = f[i-1][j-1];
                        }
                    }else{
                        // 不看，及不匹配
                        if(j >= 2){
                            // 注意为 或的关系 意思就是算两次，第一次不看，第二次看为下面的地方  ****** 
                            f[i][j] |= f[i][j-2];
                        }
                        // 看， 及匹配 (相等，和 匹配 . 效果是一样的，转换子问题状态也一致)
                        if(i>=1 && j>=2 && (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.')){
                            f[i][j] |= f[i-1][j];
                        }
                    }
                }
            }
        }
        return f[n][m];
    }
}
```



## 相关话题

- [递归](https://leetcode.cn//tag/recursion)
- [字符串](https://leetcode.cn//tag/string)
- [动态规划](https://leetcode.cn//tag/dynamic-programming)

## 相似题目



