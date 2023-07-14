
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer II 065. 最短的单词编码](https://leetcode.cn//problems/iSwD2y/)

## 题目描述

<p>单词数组&nbsp;<code>words</code> 的 <strong>有效编码</strong> 由任意助记字符串 <code>s</code> 和下标数组 <code>indices</code> 组成，且满足：</p>

<ul>
	<li><code>words.length == indices.length</code></li>
	<li>助记字符串 <code>s</code> 以 <code>&#39;#&#39;</code> 字符结尾</li>
	<li>对于每个下标 <code>indices[i]</code> ，<code>s</code> 的一个从 <code>indices[i]</code> 开始、到下一个 <code>&#39;#&#39;</code> 字符结束（但不包括 <code>&#39;#&#39;</code>）的 <strong>子字符串</strong> 恰好与 <code>words[i]</code> 相等</li>
</ul>

<p>给定一个单词数组&nbsp;<code>words</code> ，返回成功对 <code>words</code> 进行编码的最小助记字符串 <code>s</code> 的长度 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>words = [&quot;time&quot;, &quot;me&quot;, &quot;bell&quot;]
<strong>输出：</strong>10
<strong>解释：</strong>一组有效编码为 s = <code>&quot;time#bell#&quot; 和 indices = [0, 2, 5</code>] 。
words[0] = &quot;time&quot; ，s 开始于 indices[0] = 0 到下一个 &#39;#&#39; 结束的子字符串，如加粗部分所示 &quot;<strong>time</strong>#bell#&quot;
words[1] = &quot;me&quot; ，s 开始于 indices[1] = 2 到下一个 &#39;#&#39; 结束的子字符串，如加粗部分所示 &quot;ti<strong>me</strong>#bell#&quot;
words[2] = &quot;bell&quot; ，s 开始于 indices[2] = 5 到下一个 &#39;#&#39; 结束的子字符串，如加粗部分所示 &quot;time#<strong>bell</strong>#&quot;
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>words = [&quot;t&quot;]
<strong>输出：</strong>2
<strong>解释：</strong>一组有效编码为 s = &quot;t#&quot; 和 indices = [0] 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= words.length &lt;= 2000</code></li>
	<li><code>1 &lt;= words[i].length &lt;= 7</code></li>
	<li><code>words[i]</code> 仅由小写字母组成</li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 820&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/short-encoding-of-words/">https://leetcode-cn.com/problems/short-encoding-of-words/</a></p>


## 题解


### Java

```Java
// @Title: 最短的单词编码 (最短的单词编码)
// @Author: robert.sunq
// @Date: 2023-07-14 22:14:32
// @Runtime: 14 ms
// @Memory: 42.8 MB

class Solution {
    // 注意 如果单词 X 是 Y 的后缀，那么单词 X 就不需要考虑了，因为编码 Y 的时候就同时将 X 编码了。
    // 例如，如果 words 中同时有 "me" 和 "time"，我们就可以在不改变答案的情况下不考虑 "me"。
    // 注意，不能单纯的理解 indices 中 下标的索引一定是 升序的， 头部的单词也可以包含在后面的单词中
    public int minimumLengthEncoding(String[] words) {
        int n = words.length;
        if (n < 1) {
            return 1;
        }
        Set<String> set = new HashSet<>();
        for (String str : words) {
            set.add(str);
        }

        for (String str : words) {
            // 从结果set中， 删除当前字符串的所有后缀
            for (int i = 1; i < str.length() ; i++) {
                set.remove(str.substring(i));
            }
        }
        // 最后的结果，是剩余单词的长度和 + “#” 的个数

        int ans = 0;
        for (String str : set) {
            ans+=str.length();
        }
        return ans + set.size();
    }
}
```



## 相关话题

- [字典树](https://leetcode.cn//tag/trie)
- [数组](https://leetcode.cn//tag/array)
- [哈希表](https://leetcode.cn//tag/hash-table)
- [字符串](https://leetcode.cn//tag/string)

## 相似题目



