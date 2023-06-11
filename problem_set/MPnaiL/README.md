
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer II 014. 字符串中的变位词](https://leetcode.cn//problems/MPnaiL/)

## 题目描述

<p>给定两个字符串&nbsp;<code>s1</code>&nbsp;和&nbsp;<code>s2</code>，写一个函数来判断 <code>s2</code> 是否包含 <code>s1</code><strong>&nbsp;</strong>的某个变位词。</p>

<p>换句话说，第一个字符串的排列之一是第二个字符串的 <strong>子串</strong> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入: </strong>s1 = &quot;ab&quot; s2 = &quot;eidbaooo&quot;
<strong>输出: </strong>True
<strong>解释:</strong> s2 包含 s1 的排列之一 (&quot;ba&quot;).
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入: </strong>s1= &quot;ab&quot; s2 = &quot;eidboaoo&quot;
<strong>输出:</strong> False
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= s1.length, s2.length &lt;= 10<sup>4</sup></code></li>
	<li><code>s1</code> 和 <code>s2</code> 仅包含小写字母</li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 567&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/permutation-in-string/">https://leetcode-cn.com/problems/permutation-in-string/</a></p>


## 题解


### Java

```Java
// @Title: 字符串中的变位词 (字符串中的变位词)
// @Author: robert.sunq
// @Date: 2023-06-11 19:07:18
// @Runtime: 27 ms
// @Memory: 42.5 MB

class Solution {
    /**
    通过计算 s2 中的一个子串是否包含 s1 的全部元素且个数相同，来判断是否复合包含变位词
     */
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> charToCount = new HashMap<>();
        // 统计聘书
        for ( int i = 0; i<s1.length(); i++) {
            charToCount.put(s1.charAt(i), charToCount.getOrDefault(s1.charAt(i), 0) + 1);
        }

        // 计算当前 s2 中子串的频数
        Map<Character, Integer> tmp = new HashMap<>();
        // 计算子串开始位置， 当出现子串中某个字符频数超过 s1 时， 用来后跳
        int startIndex = 0;
        for (int i = 0; i<s2.length(); i++) {
            Character c = s2.charAt(i);
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
                    return true;
                }
                continue;
            }
            
            // 当某个字符出现频数大于 s1 了， 就需要移动 s2 的子串到该字符在子串中第一次出现的位置，同时降低对应字符的频数。
            if (tmp.get(c) > charToCount.get(c)) {
                while(s2.charAt(startIndex) != c) {
                    tmp.put(s2.charAt(startIndex), tmp.get(s2.charAt(startIndex)) - 1);
                    startIndex++;
                }
                startIndex++;
                tmp.put(c, tmp.get(c) - 1);
            }
        }
        return false;
    }
}
```



## 相关话题

- [哈希表](https://leetcode.cn//tag/hash-table)
- [双指针](https://leetcode.cn//tag/two-pointers)
- [字符串](https://leetcode.cn//tag/string)
- [滑动窗口](https://leetcode.cn//tag/sliding-window)

## 相似题目



