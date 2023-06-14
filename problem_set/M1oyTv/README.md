
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer II 017. 含有所有字符的最短字符串](https://leetcode.cn//problems/M1oyTv/)

## 题目描述

<p>给定两个字符串 <code>s</code> 和&nbsp;<code>t</code> 。返回 <code>s</code> 中包含&nbsp;<code>t</code>&nbsp;的所有字符的最短子字符串。如果 <code>s</code> 中不存在符合条件的子字符串，则返回空字符串 <code>&quot;&quot;</code> 。</p>

<p>如果 <code>s</code> 中存在多个符合条件的子字符串，返回任意一个。</p>

<p>&nbsp;</p>

<p><strong>注意： </strong>对于 <code>t</code> 中重复字符，我们寻找的子字符串中该字符数量必须不少于 <code>t</code> 中该字符数量。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = &quot;ADOBECODEBANC&quot;, t = &quot;ABC&quot;
<strong>输出：</strong>&quot;BANC&quot; 
<strong>解释：</strong>最短子字符串 &quot;BANC&quot; 包含了字符串 t 的所有字符 &#39;A&#39;、&#39;B&#39;、&#39;C&#39;</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = &quot;a&quot;, t = &quot;a&quot;
<strong>输出：</strong>&quot;a&quot;
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>s = &quot;a&quot;, t = &quot;aa&quot;
<strong>输出：</strong>&quot;&quot;
<strong>解释：</strong>t 中两个字符 &#39;a&#39; 均应包含在 s 的子串中，因此没有符合条件的子字符串，返回空字符串。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= s.length, t.length &lt;= 10<sup>5</sup></code></li>
	<li><code>s</code> 和 <code>t</code> 由英文字母组成</li>
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong>你能设计一个在 <code>o(n)</code> 时间内解决此问题的算法吗？</p>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 76&nbsp;题相似（本题答案不唯一）：<a href="https://leetcode-cn.com/problems/minimum-window-substring/">https://leetcode-cn.com/problems/minimum-window-substring/</a></p>


## 题解


### Java

```Java
// @Title: 含有所有字符的最短字符串 (含有所有字符的最短字符串)
// @Author: robert.sunq
// @Date: 2023-06-14 23:19:08
// @Runtime: 100 ms
// @Memory: 43.1 MB

class Solution {
    public String minWindow(String s, String t) {
        int ansStart = 0;
        int ansEnd = Integer.MAX_VALUE;
        
        int start = 0;
        int end = 0;
        
        Map<Character, Integer> charCount = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            Character c = t.charAt(i);
            charCount.put(c, charCount.getOrDefault(c , 0) + 1);
        }

        Map<Character, Integer> tmpCount = new HashMap<>();
        int n = s.length();
        while (end < n) {
            Character c = s.charAt(end);
            tmpCount.put(c, tmpCount.getOrDefault(c, 0) + 1);
            while (isAns(charCount, tmpCount)) {
                if ((end - start) < (ansEnd - ansStart) ) {
                    ansStart = start;
                    ansEnd = end;
                }
                Character cStart = s.charAt(start);
                tmpCount.put(cStart, tmpCount.get(cStart) - 1);
                start++;
            }
            end++;
        }

        return ansEnd == Integer.MAX_VALUE ? "" : s.substring(ansStart, ansEnd + 1);
        
    }

    private boolean isAns(Map<Character, Integer> charCount, Map<Character, Integer> tmpCount) {
        for (Character c : charCount.keySet()) {
            if (charCount.get(c) > tmpCount.getOrDefault(c, 0)) {
                return false;
            }
        }

        return true;
    }
}
```



## 相关话题

- [哈希表](https://leetcode.cn//tag/hash-table)
- [字符串](https://leetcode.cn//tag/string)
- [滑动窗口](https://leetcode.cn//tag/sliding-window)

## 相似题目



