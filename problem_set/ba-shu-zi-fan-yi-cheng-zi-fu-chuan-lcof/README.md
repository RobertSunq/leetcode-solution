
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer 46. 把数字翻译成字符串](https://leetcode.cn//problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/)

## 题目描述

<p>给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 &ldquo;a&rdquo; ，1 翻译成 &ldquo;b&rdquo;，&hellip;&hellip;，11 翻译成 &ldquo;l&rdquo;，&hellip;&hellip;，25 翻译成 &ldquo;z&rdquo;。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<pre><strong>输入:</strong> 12258
<strong>输出:</strong> <code>5
</code><strong>解释:</strong> 12258有5种不同的翻译，分别是&quot;bccfi&quot;, &quot;bwfi&quot;, &quot;bczi&quot;, &quot;mcfi&quot;和&quot;mzi&quot;</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>0 &lt;= num &lt; 2<sup>31</sup></code></li>
</ul>


## 题解


### Java

```Java
// @Title: 把数字翻译成字符串 (把数字翻译成字符串 LCOF)
// @Author: robert.sunq
// @Date: 2021-05-29 23:03:43
// @Runtime: 0 ms
// @Memory: 35 MB

class Solution {
    public int translateNum(int num) {
        String str = String.valueOf(num);
        int[] dp = new int[str.length() + 1];
        dp[0] = 1;dp[1] = 1;
        // dp[i] 表示长度为 i时翻译数量
        for (int i = 2;i<=str.length();i++){
            // 和前一个可以一起翻译
            String tmp = str.substring(i-2,i);
            if(tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0){
                dp[i] = dp[i-1]+dp[i-2];
            }
            else{
                 dp[i] = dp[i-1];
            }
        }
        return dp[str.length()];
    }
}
```



## 相关话题

- [字符串](https://leetcode.cn//tag/string)
- [动态规划](https://leetcode.cn//tag/dynamic-programming)

## 相似题目



