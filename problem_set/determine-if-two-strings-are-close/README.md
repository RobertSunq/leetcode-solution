
| [English](README_EN.md) | 简体中文 |

# [1657. 确定两个字符串是否接近](https://leetcode.cn//problems/determine-if-two-strings-are-close/)

## 题目描述

<p>如果可以使用以下操作从一个字符串得到另一个字符串，则认为两个字符串 <strong>接近</strong> ：</p>

<ul>
	<li>操作 1：交换任意两个 <strong>现有</strong> 字符。

	<ul>
		<li>例如，<code>a<strong>b</strong>cd<strong>e</strong> -> a<strong>e</strong>cd<strong>b</strong></code></li>
	</ul>
	</li>
	<li>操作 2：将一个 <strong>现有</strong> 字符的每次出现转换为另一个 <strong>现有</strong> 字符，并对另一个字符执行相同的操作。
	<ul>
		<li>例如，<code><strong>aa</strong>c<strong>abb</strong> -> <strong>bb</strong>c<strong>baa</strong></code>（所有 <code>a</code> 转化为 <code>b</code> ，而所有的 <code>b</code> 转换为 <code>a</code> ）</li>
	</ul>
	</li>
</ul>

<p>你可以根据需要对任意一个字符串多次使用这两种操作。</p>

<p>给你两个字符串，<code>word1</code> 和 <code>word2</code> 。如果<em> </em><code>word1</code><em> </em>和<em> </em><code>word2</code><em> </em><strong>接近 </strong>，就返回 <code>true</code> ；否则，返回<em> </em><code>false</code><em> </em>。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>word1 = "abc", word2 = "bca"
<strong>输出：</strong>true
<strong>解释：</strong>2 次操作从 word1 获得 word2 。
执行操作 1："a<strong>bc</strong>" -> "a<strong>cb</strong>"
执行操作 1："<strong>a</strong>c<strong>b</strong>" -> "<strong>b</strong>c<strong>a</strong>"
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>word1 = "a", word2 = "aa"
<strong>输出：</strong>false
<strong>解释：</strong>不管执行多少次操作，都无法从 word1 得到 word2 ，反之亦然。</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>word1 = "cabbba", word2 = "abbccc"
<strong>输出：</strong>true
<strong>解释：</strong>3 次操作从 word1 获得 word2 。
执行操作 1："ca<strong>b</strong>bb<strong>a</strong>" -> "ca<strong>a</strong>bb<strong>b</strong>"
执行操作 2：<code>"</code><strong>c</strong>aa<strong>bbb</strong>" -> "<strong>b</strong>aa<strong>ccc</strong>"
执行操作 2："<strong>baa</strong>ccc" -> "<strong>abb</strong>ccc"
</pre>

<p><strong>示例 4：</strong></p>

<pre>
<strong>输入：</strong>word1 = "cabbba", word2 = "aabbss"
<strong>输出：</strong>false
<strong>解释：</strong>不管执行多少次操作，都无法从 word1 得到 word2 ，反之亦然。</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= word1.length, word2.length <= 10<sup>5</sup></code></li>
	<li><code>word1</code> 和 <code>word2</code> 仅包含小写英文字母</li>
</ul>


## 题解


### Java

```Java
// @Title: 确定两个字符串是否接近 (Determine if Two Strings Are Close)
// @Author: robert.sunq
// @Date: 2023-08-23 23:14:37
// @Runtime: 12 ms
// @Memory: 43.1 MB

class Solution {
    // 具体的，由于 s1 和 s2 都仅包含小写字母，因此可以创建两个大小为 26 的数组 c1 和 c2 分别对两字符串进行词频统计
    public boolean closeStrings(String word1, String word2) {
        int[] c1 = new int[26];
        int[] c2 = new int[26];
        for (char c : word1.toCharArray()) {
            c1[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            c2[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (c1[i] + c2[i] == 0) {
                continue;
            }
            // 某个字符在 word1 或 word2 中存在，但另一个字符串中不存在
            if (c1[i] == 0 || c2[i] == 0) {
                return false;
            }
        }

        // 检查字符频次是相等的
        Arrays.sort(c1);
        Arrays.sort(c2);
        for (int i = 0; i < 26; i++) {
            if (c1[i] != c2[i]) {
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
- [排序](https://leetcode.cn//tag/sorting)

## 相似题目



