
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer II 062. 实现前缀树](https://leetcode.cn//problems/QC3q1f/)

## 题目描述

<p><strong><a href="https://baike.baidu.com/item/字典树/9825209?fr=aladdin" target="_blank">Trie</a></strong>（发音类似 &quot;try&quot;）或者说 <strong>前缀树</strong> 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。</p>

<p>请你实现 Trie 类：</p>

<ul>
	<li><code>Trie()</code> 初始化前缀树对象。</li>
	<li><code>void insert(String word)</code> 向前缀树中插入字符串 <code>word</code> 。</li>
	<li><code>boolean search(String word)</code> 如果字符串 <code>word</code> 在前缀树中，返回 <code>true</code>（即，在检索之前已经插入）；否则，返回 <code>false</code> 。</li>
	<li><code>boolean startsWith(String prefix)</code> 如果之前已经插入的字符串&nbsp;<code>word</code> 的前缀之一为 <code>prefix</code> ，返回 <code>true</code> ；否则，返回 <code>false</code> 。</li>
</ul>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<pre>
<strong>输入</strong>
inputs = [&quot;Trie&quot;, &quot;insert&quot;, &quot;search&quot;, &quot;search&quot;, &quot;startsWith&quot;, &quot;insert&quot;, &quot;search&quot;]
inputs = [[], [&quot;apple&quot;], [&quot;apple&quot;], [&quot;app&quot;], [&quot;app&quot;], [&quot;app&quot;], [&quot;app&quot;]]
<strong>输出</strong>
[null, null, true, false, true, null, true]

<strong>解释</strong>
Trie trie = new Trie();
trie.insert(&quot;apple&quot;);
trie.search(&quot;apple&quot;);   // 返回 True
trie.search(&quot;app&quot;);     // 返回 False
trie.startsWith(&quot;app&quot;); // 返回 True
trie.insert(&quot;app&quot;);
trie.search(&quot;app&quot;);     // 返回 True
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= word.length, prefix.length &lt;= 2000</code></li>
	<li><code>word</code> 和 <code>prefix</code> 仅由小写英文字母组成</li>
	<li><code>insert</code>、<code>search</code> 和 <code>startsWith</code> 调用次数 <strong>总计</strong> 不超过 <code>3 * 10<sup>4</sup></code> 次</li>
</ul>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 208 题相同：<a href="https://leetcode-cn.com/problems/implement-trie-prefix-tree/">https://leetcode-cn.com/problems/implement-trie-prefix-tree/</a>&nbsp;</p>


## 题解


### Java

```Java
// @Title: 实现前缀树 (实现前缀树)
// @Author: robert.sunq
// @Date: 2023-07-12 23:41:29
// @Runtime: 31 ms
// @Memory: 53.4 MB

class Trie {

    // next[i] 不为空，表示对应位置的字母存在
    Trie[] next;

    // 最后一个字母对应的 叶子节点， == ture， 表示该单词结束。
    boolean isEnd;

    /** Initialize your data structure here. */
    public Trie() {
        next = new Trie[26];
        isEnd = false;
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie root = this;
        for (int i = 0; i< word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (root.next[index] == null) {
                root.next[index] = new Trie();
            }
            root = root.next[index];
        }
        root.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie root = this;
        int i = 0;
        int n = word.length();
        while (root != null && i < n) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (root.next[index] == null) {
                return false;
            }
            i++;
            root = root.next[index];
        }
        return root.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie root = this;
        int i = 0;
        int n = prefix.length();
        while (root != null && i < n) {
            char c = prefix.charAt(i);
            int index = c - 'a';
            if (root.next[index] == null) {
                return false;
            }
            i++;
            root = root.next[index];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
```



## 相关话题

- [设计](https://leetcode.cn//tag/design)
- [字典树](https://leetcode.cn//tag/trie)
- [哈希表](https://leetcode.cn//tag/hash-table)
- [字符串](https://leetcode.cn//tag/string)

## 相似题目



