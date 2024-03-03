
| [English](README_EN.md) | 简体中文 |

# [828. 统计子串中的唯一字符](https://leetcode.cn//problems/count-unique-characters-of-all-substrings-of-a-given-string/)

## 题目描述

<p>我们定义了一个函数 <code>countUniqueChars(s)</code> 来统计字符串 <code>s</code> 中的唯一字符，并返回唯一字符的个数。</p>

<p>例如：<code>s = "LEETCODE"</code> ，则其中 <code>"L"</code>, <code>"T"</code>,<code>"C"</code>,<code>"O"</code>,<code>"D"</code> 都是唯一字符，因为它们只出现一次，所以 <code>countUniqueChars(s) = 5</code> 。</p>

<p>本题将会给你一个字符串 <code>s</code> ，我们需要返回 <code>countUniqueChars(t)</code> 的总和，其中 <code>t</code> 是 <code>s</code> 的子字符串。输入用例保证返回值为&nbsp;32 位整数。</p>

<p>注意，某些子字符串可能是重复的，但你统计时也必须算上这些重复的子字符串（也就是说，你必须统计 <code>s</code> 的所有子字符串中的唯一字符）。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<pre>
<strong>输入: </strong>s = "ABC"
<strong>输出: </strong>10
<strong>解释:</strong> 所有可能的子串为："A","B","C","AB","BC" 和 "ABC"。
     其中，每一个子串都由独特字符构成。
     所以其长度总和为：1 + 1 + 1 + 2 + 2 + 3 = 10
</pre>

<p><strong class="example">示例 2：</strong></p>

<pre>
<strong>输入: </strong>s = "ABA"
<strong>输出: </strong>8
<strong>解释: </strong>除了 countUniqueChars("ABA") = 1 之外，其余与示例 1 相同。
</pre>

<p><strong class="example">示例 3：</strong></p>

<pre>
<strong>输入：</strong>s = "LEETCODE"
<strong>输出：</strong>92
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
	<li><code>s</code> 只包含大写英文字符</li>
</ul>


## 题解


### Java

```Java
// @Title: 统计子串中的唯一字符 (Count Unique Characters of All Substrings of a Given String)
// @Author: robert.sunq
// @Date: 2023-11-26 15:39:13
// @Runtime: 45 ms
// @Memory: 45.7 MB

class Solution {
    public int uniqueLetterString(String s) {
        // 注意， 这里统计的时子字符串， 不是元素的排列组合
        // 当字符 c 出现在i位置时，如果在某个子字符串中出现一次，就对结果有贡献
        // 所以 记 c 上一次出现的位置位  j, 则从j (不包含) 到 i 位置开始的所有字符串都只有一个 c
        // 同理，记 c 下一次出现的位置位 k， 则从 i 到 k (不包含) 位置结束的所有字符串都只有一个 c
        // 所以，这个j 到 k 区间内的所有可能为  (i - j) * (k - i)

        Map<Character, List<Integer>> index = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!index.containsKey(c)) {
                index.put(c, new ArrayList<>());
                index.get(c).add(-1);
            }
            index.get(c).add(i);
        }


        int ans = 0;
        for (Map.Entry<Character, List<Integer>> entry : index.entrySet()) {
            List<Integer> arr = entry.getValue();
            // 注意这里， 字符的最后结束位置为字符串的长度，方便计算
            arr.add(s.length());
            for (int i = 1; i < arr.size() - 1; i++) {
                ans = ans + ((arr.get(i) - arr.get(i - 1)) * (arr.get(i + 1) - arr.get(i)));
            }
        }


        return ans;
    }
}
```



## 相关话题

- [哈希表](https://leetcode.cn//tag/hash-table)
- [字符串](https://leetcode.cn//tag/string)
- [动态规划](https://leetcode.cn//tag/dynamic-programming)

## 相似题目



