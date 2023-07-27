
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer II 092. 翻转字符](https://leetcode.cn//problems/cyJERH/)

## 题目描述

<p>如果一个由&nbsp;<code>&#39;0&#39;</code> 和 <code>&#39;1&#39;</code>&nbsp;组成的字符串，是以一些 <code>&#39;0&#39;</code>（可能没有 <code>&#39;0&#39;</code>）后面跟着一些 <code>&#39;1&#39;</code>（也可能没有 <code>&#39;1&#39;</code>）的形式组成的，那么该字符串是&nbsp;<strong>单调递增&nbsp;</strong>的。</p>

<p>我们给出一个由字符 <code>&#39;0&#39;</code> 和 <code>&#39;1&#39;</code>&nbsp;组成的字符串 <font color="#c7254e" face="Menlo, Monaco, Consolas, Courier New, monospace"><span style="caret-color: rgb(199, 37, 78); font-size: 12.600000381469727px; background-color: rgb(249, 242, 244);">s</span></font>，我们可以将任何&nbsp;<code>&#39;0&#39;</code> 翻转为&nbsp;<code>&#39;1&#39;</code>&nbsp;或者将&nbsp;<code>&#39;1&#39;</code>&nbsp;翻转为&nbsp;<code>&#39;0&#39;</code>。</p>

<p>返回使 <font color="#c7254e" face="Menlo, Monaco, Consolas, Courier New, monospace"><span style="caret-color: rgb(199, 37, 78); font-size: 12.600000381469727px; background-color: rgb(249, 242, 244);">s</span></font>&nbsp;<strong>单调递增&nbsp;</strong>的最小翻转次数。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s =<strong> </strong>&quot;00110&quot;
<strong>输出：</strong>1
<strong>解释：</strong>我们翻转最后一位得到 00111.
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s =<strong> </strong>&quot;010110&quot;
<strong>输出：</strong>2
<strong>解释：</strong>我们翻转得到 011111，或者是 000111。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>s =<strong> </strong>&quot;00011000&quot;
<strong>输出：</strong>2
<strong>解释：</strong>我们翻转得到 00000000。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 20000</code></li>
	<li><font color="#c7254e" face="Menlo, Monaco, Consolas, Courier New, monospace"><span style="caret-color: rgb(199, 37, 78); font-size: 12.600000381469727px; background-color: rgb(249, 242, 244);">s</span></font> 中只包含字符&nbsp;<code>&#39;0&#39;</code>&nbsp;和&nbsp;<code>&#39;1&#39;</code></li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 926&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/flip-string-to-monotone-increasing/">https://leetcode-cn.com/problems/flip-string-to-monotone-increasing/</a></p>


## 题解


### Java

```Java
// @Title: 翻转字符 (翻转字符)
// @Author: robert.sunq
// @Date: 2023-07-27 23:22:15
// @Runtime: 4 ms
// @Memory: 40.2 MB

class Solution {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int dp0 = 0;
        int dp1 = 0;

        // 如果要当前位为 0
        // dp[i][0]=dp[i−1][0]+I(s[i]=‘1’)

        // 如果要当前为为1
        // dp[i][1]=min(dp[i−1][0],dp[i−1][1])+I(s[i]=‘0’)
        for (int i = 0; i<n; i++) {
            char c = s.charAt(i);
            int dp0New = dp0;
            int dp1New = Math.min(dp0, dp1);
            if (c == '1') {
                // 想使得当前位为0， 所以真是为1需要反转下
                dp0New++;
                // 想要使得为1，不用处理
            } else {
                // 想使得当前位为1， 所以真是为0需要反转下
                dp1New++;

                // 想要使得为0，不用处理
            }
            dp0 = dp0New;
            dp1 = dp1New;
        }

        return Math.min(dp0, dp1);
    }
}
```



## 相关话题

- [字符串](https://leetcode.cn//tag/string)
- [动态规划](https://leetcode.cn//tag/dynamic-programming)

## 相似题目



