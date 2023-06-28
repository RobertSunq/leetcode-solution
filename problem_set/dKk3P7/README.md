
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer II 032. 有效的变位词](https://leetcode.cn//problems/dKk3P7/)

## 题目描述

<p>给定两个字符串 <code>s</code> 和 <code>t</code> ，编写一个函数来判断它们是不是一组变位词（字母异位词）。</p>

<p><strong>注意：</strong>若&nbsp;<code><em>s</em></code> 和 <code><em>t</em></code><em>&nbsp;</em>中每个字符出现的次数都相同且<strong>字符顺序不完全相同</strong>，则称&nbsp;<code><em>s</em></code> 和 <code><em>t</em></code><em>&nbsp;</em>互为变位词（字母异位词）。</p>

<p>&nbsp;</p>

<p><strong>示例&nbsp;1:</strong></p>

<pre>
<strong>输入:</strong> s = &quot;anagram&quot;, t = &quot;nagaram&quot;
<strong>输出:</strong> true
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> s = &quot;rat&quot;, t = &quot;car&quot;
<strong>输出: </strong>false</pre>

<p><strong>示例 3:</strong></p>

<pre>
<strong>输入:</strong> s = &quot;a&quot;, t = &quot;a&quot;
<strong>输出: </strong>false</pre>

<p>&nbsp;</p>

<p><strong>提示:</strong></p>

<ul>
	<li><code>1 &lt;= s.length, t.length &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>s</code>&nbsp;and&nbsp;<code>t</code>&nbsp;仅包含小写字母</li>
</ul>

<p>&nbsp;</p>

<p><strong>进阶:&nbsp;</strong>如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？</p>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 242&nbsp;题相似（字母异位词定义不同）：<a href="https://leetcode-cn.com/problems/valid-anagram/">https://leetcode-cn.com/problems/valid-anagram/</a></p>


## 题解


### Java

```Java
// @Title: 有效的变位词 (有效的变位词)
// @Author: robert.sunq
// @Date: 2023-06-28 22:48:34
// @Runtime: 14 ms
// @Memory: 42.6 MB

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        boolean ans =  true;
        for (int i = 0; i < s.length(); i++) {

            Character c = s.charAt(i);
            ans = ans && c == t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        if (ans) {
            return false;
        }

        for (int i = 0; i < t.length(); i++) {
            Character c = t.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) < 0) {
                    return false;
                }
                continue;
            }
            return false;
        }

        return true;

    }
}
```



## 相关话题

- [哈希表](https://leetcode.cn//tag/hash-table)
- [字符串](https://leetcode.cn//tag/string)
- [排序](https://leetcode.cn//tag/sorting)

## 相似题目



