
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer II 015. 字符串中的所有变位词](https://leetcode.cn//problems/VabMRr/)

## 题目描述

<p>给定两个字符串&nbsp;<code>s</code>&nbsp;和<b>&nbsp;</b><code>p</code>，找到&nbsp;<code>s</code><strong>&nbsp;</strong>中所有 <code>p</code> 的&nbsp;<strong>变位词&nbsp;</strong>的子串，返回这些子串的起始索引。不考虑答案输出的顺序。</p>

<p><strong>变位词 </strong>指字母相同，但排列不同的字符串。</p>

<p>&nbsp;</p>

<p><strong>示例&nbsp;1：</strong></p>

<pre>
<strong>输入: </strong>s = &quot;cbaebabacd&quot;, p = &quot;abc&quot;
<strong>输出: </strong>[0,6]
<strong>解释:</strong>
起始索引等于 0 的子串是 &quot;cba&quot;, 它是 &quot;abc&quot; 的变位词。
起始索引等于 6 的子串是 &quot;bac&quot;, 它是 &quot;abc&quot; 的变位词。
</pre>

<p><strong>&nbsp;示例 2：</strong></p>

<pre>
<strong>输入: </strong>s = &quot;abab&quot;, p = &quot;ab&quot;
<strong>输出: </strong>[0,1,2]
<strong>解释:</strong>
起始索引等于 0 的子串是 &quot;ab&quot;, 它是 &quot;ab&quot; 的变位词。
起始索引等于 1 的子串是 &quot;ba&quot;, 它是 &quot;ab&quot; 的变位词。
起始索引等于 2 的子串是 &quot;ab&quot;, 它是 &quot;ab&quot; 的变位词。
</pre>

<p>&nbsp;</p>

<p><strong>提示:</strong></p>

<ul>
	<li><code>1 &lt;= s.length, p.length &lt;= 3 * 10<sup>4</sup></code></li>
	<li><code>s</code>&nbsp;和 <code>p</code> 仅包含小写字母</li>
</ul>

<p>&nbsp;</p>

<p>注意：本题与主站 438&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/" style="background-color: rgb(255, 255, 255);">https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/</a></p>


## 题解


### Java

```Java
// @Title: 字符串中的所有变位词 (字符串中的所有变位词)
// @Author: robert.sunq
// @Date: 2023-06-11 19:51:43
// @Runtime: 48 ms
// @Memory: 43.5 MB

class Solution {
     /**
    延续 [剑指 Offer II 014. 字符串中的变位词](https://leetcode.cn/problems/MPnaiL/) 的逻辑
     */
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        int m = p.length();
        if (m > n) {
            return new ArrayList<>();
        }
        
        List<Integer> ans = new ArrayList<>();

        Map<Character, Integer> charToCount = new HashMap<>();
        for ( int i = 0; i < m; i++) {
            charToCount.put(p.charAt(i), charToCount.getOrDefault(p.charAt(i), 0) + 1);
        }

        Map<Character, Integer> tmp = new HashMap<>();
        // 计算子串开始位置
        int startIndex = 0;
        for (int i = 0; i<n; i++) {
            Character c = s.charAt(i);
            // 不包含该字符，重新查找子串
            if (!charToCount.containsKey(c)) {
                tmp = new HashMap<>();
                startIndex = i + 1;
                continue;
            }

            tmp.put(c, tmp.getOrDefault(c, 0) + 1);

            // 包含且当前字符频数相等，可以比较是否复合要求了
            // 注意 用 equals 而不是用 == , 因为  Integer > 127 不用 == 比较
            if(tmp.get(c).equals(charToCount.get(c))) {
                if (tmp.equals(charToCount)) {
                    ans.add(startIndex);
                }
                continue;
            }
            
            // 当某个字符出现频数大于 s 了， 就需要移动 s 的子串到该字符在子串中第一次出现的位置，同时降低对应字符的频数。
            if (tmp.get(c) > charToCount.get(c)) {
                while(s.charAt(startIndex) != c) {
                    tmp.put(s.charAt(startIndex), tmp.get(s.charAt(startIndex)) - 1);
                    startIndex++;
                }
                startIndex++;
                tmp.put(c, tmp.get(c) - 1);
                // 注意，前端移动到要求位置后，需要在判断下子字符串是否复合要求
                if (tmp.equals(charToCount)) {
                    ans.add(startIndex);
                }
            }
        }
        return ans;
    }
}
```



## 相关话题

- [哈希表](https://leetcode.cn//tag/hash-table)
- [字符串](https://leetcode.cn//tag/string)
- [滑动窗口](https://leetcode.cn//tag/sliding-window)

## 相似题目



