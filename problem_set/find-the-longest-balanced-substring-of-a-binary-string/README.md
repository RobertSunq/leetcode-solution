
| [English](README_EN.md) | 简体中文 |

# [2609. 最长平衡子字符串](https://leetcode.cn//problems/find-the-longest-balanced-substring-of-a-binary-string/)

## 题目描述

<p>给你一个仅由 <code>0</code> 和 <code>1</code> 组成的二进制字符串 <code>s</code> 。<span style="">&nbsp;</span><span style="">&nbsp;</span></p>

<p>如果子字符串中 <strong>所有的<span style=""> </span></strong><code><span style="">0</span></code><strong><span style=""> </span>都在 </strong><code>1</code><strong> 之前</strong> 且其中 <code>0</code> 的数量等于 <code>1</code> 的数量，则认为 <code>s</code> 的这个子字符串是平衡子字符串。请注意，空子字符串也视作平衡子字符串。<span style="">&nbsp;</span></p>

<p>返回&nbsp;<span style=""> </span><code>s</code> 中最长的平衡子字符串长度。</p>

<p>子字符串是字符串中的一个连续字符序列。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = "01000111"
<strong>输出：</strong>6
<strong>解释：</strong>最长的平衡子字符串是 "000111" ，长度为 6 。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = "00111"
<strong>输出：</strong>4
<strong>解释：</strong>最长的平衡子字符串是 "0011" ，长度为 <span style="">&nbsp;</span>4 。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>s = "111"
<strong>输出：</strong>0
<strong>解释：</strong>除了空子字符串之外不存在其他平衡子字符串，所以答案为 0 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 50</code></li>
	<li><code>'0' &lt;= s[i] &lt;= '1'</code></li>
</ul>


## 题解


### Java

```Java
// @Title: 最长平衡子字符串 (Find the Longest Balanced Substring of a Binary String)
// @Author: robert.sunq
// @Date: 2023-11-08 22:13:35
// @Runtime: 1 ms
// @Memory: 40.9 MB

class Solution {
    public int findTheLongestBalancedSubstring(String s) {
        int n = s.length();
        if (n < 2) {
            return 0;
        }

        int ans = 0;
        // 记录遇到的连续 0 和 1 的个数
        int[] count = new int[2];

        if (s.charAt(0) == '0') {
            count[0] = 1;
        } else {
            count[1] = 1;
        }

        for (int i = 1; i < n; i++) {
            char c = s.charAt(i);
            if (c == '0') {
                if (s.charAt(i - 1) == '0') {
                    // 当前 0 和前一位是连续的 0, 则连续个数+1
                    // 1 不做修改，因为连续的0再开头的时候已经处理过 赋值1的连续个数为 0
                    count[0] = count[0] + 1;
                } else {
                    // 是开头第一位 0， 所有恢复初始计算
                    count[0] = 1;
                    count[1] = 0;
                }
            } else {
                // 如果是1， 则再前面连续的1 的个数上 + 1。
                // 不区分的原因在于不论是不是开头还是连续的1， 都是再原来的基础上 + 1
                count[1] = count[1] + 1;

                // 因为都是统计的连续的个数， 所有 这时候两个连续个数 的最小的值 * 2 ，就是符合条件的结果
                // 不连续，从1变为0的时候，会在另一个判断中，把 1 的连续个数清零。所以可以直接用最小的连续数，来表示结果的一半
                ans = Math.max(ans, Math.min(count[0], count[1]) * 2);
            }
        }

        return ans;
    }
}
```



## 相关话题

- [字符串](https://leetcode.cn//tag/string)

## 相似题目



