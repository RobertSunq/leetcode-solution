
| English | [简体中文](README.md) |

# [208. Implement Trie (Prefix Tree)](https://leetcode.cn//problems/implement-trie-prefix-tree/)

## Description

<p>A <a href="https://en.wikipedia.org/wiki/Trie" target="_blank"><strong>trie</strong></a> (pronounced as &quot;try&quot;) or <strong>prefix tree</strong> is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.</p>

<p>Implement the Trie class:</p>

<ul>
	<li><code>Trie()</code> Initializes the trie object.</li>
	<li><code>void insert(String word)</code> Inserts the string <code>word</code> into the trie.</li>
	<li><code>boolean search(String word)</code> Returns <code>true</code> if the string <code>word</code> is in the trie (i.e., was inserted before), and <code>false</code> otherwise.</li>
	<li><code>boolean startsWith(String prefix)</code> Returns <code>true</code> if there is a previously inserted string <code>word</code> that has the prefix <code>prefix</code>, and <code>false</code> otherwise.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input</strong>
[&quot;Trie&quot;, &quot;insert&quot;, &quot;search&quot;, &quot;search&quot;, &quot;startsWith&quot;, &quot;insert&quot;, &quot;search&quot;]
[[], [&quot;apple&quot;], [&quot;apple&quot;], [&quot;app&quot;], [&quot;app&quot;], [&quot;app&quot;], [&quot;app&quot;]]
<strong>Output</strong>
[null, null, true, false, true, null, true]

<strong>Explanation</strong>
Trie trie = new Trie();
trie.insert(&quot;apple&quot;);
trie.search(&quot;apple&quot;);   // return True
trie.search(&quot;app&quot;);     // return False
trie.startsWith(&quot;app&quot;); // return True
trie.insert(&quot;app&quot;);
trie.search(&quot;app&quot;);     // return True
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= word.length, prefix.length &lt;= 2000</code></li>
	<li><code>word</code> and <code>prefix</code> consist only of lowercase English letters.</li>
	<li>At most <code>3 * 10<sup>4</sup></code> calls <strong>in total</strong> will be made to <code>insert</code>, <code>search</code>, and <code>startsWith</code>.</li>
</ul>


## Solutions


### Java

```Java
// @Title: 实现 Trie (前缀树) (Implement Trie (Prefix Tree))
// @Author: robert.sunq
// @Date: 2021-06-16 23:29:53
// @Runtime: 38 ms
// @Memory: 47.8 MB

class Trie {

    class TrieNode{
        // 当前点是否时根节点
        boolean isEnd;
        // 下一个节点的连接，序号代表下一个的字母
        TrieNode[] next;

        public TrieNode(){
            this.isEnd = false;
            this.next = new TrieNode[26];
        }
    }

    // 根节点
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        this.root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode p = this.root;
        for(int i=0;i<word.length();i++){
            // 遍历字符串，组装树
            int index = word.charAt(i)-'a';
            // 下一个字母为null 表示没有改单词，新增
            if(p.next[index] == null){
                p.next[index] = new TrieNode();
            }
            p = p.next[index];
        }
        // 当前节点是根
        p.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode p = this.root;
        for(int i=0;i<word.length();i++){
            // 遍历字符串，组装树
            int index = word.charAt(i)-'a';
            // 下一个字母为null 表示没有该字母，返回flase
            if(p.next[index] == null){
                return false;
            }
            p = p.next[index];
        }
        // 如果当前节点为结尾，则表示存在该单词
        return p.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode p = this.root;
        for(int i=0; i<prefix.length();i++){
            // 遍历字符串，组装树
            int index = prefix.charAt(i)-'a';
            // 下一个字母为null 表示没有该字母，返回flase
            if(p.next[index] == null){
                return false;
            }
            p = p.next[index];
        }
        // 查询前缀的话，若可以遍历所有字符，则表示时前缀
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



## Related Topics

- [Design](https://leetcode.cn//tag/design)
- [Trie](https://leetcode.cn//tag/trie)
- [Hash Table](https://leetcode.cn//tag/hash-table)
- [String](https://leetcode.cn//tag/string)

## Similar Questions

- [Design Add and Search Words Data Structure](../design-add-and-search-words-data-structure/README_EN.md)
- [Design Search Autocomplete System](../design-search-autocomplete-system/README_EN.md)
- [Replace Words](../replace-words/README_EN.md)
- [Implement Magic Dictionary](../implement-magic-dictionary/README_EN.md)
