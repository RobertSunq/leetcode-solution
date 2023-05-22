
| [English](README_EN.md) | 简体中文 |

# [208. 实现 Trie (前缀树)](https://leetcode.cn//problems/implement-trie-prefix-tree/)

## 题目描述

<p><strong><a href="https://baike.baidu.com/item/字典树/9825209?fr=aladdin" target="_blank">Trie</a></strong>（发音类似 "try"）或者说 <strong>前缀树</strong> 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。</p>

<p>请你实现 Trie 类：</p>

<ul>
	<li><code>Trie()</code> 初始化前缀树对象。</li>
	<li><code>void insert(String word)</code> 向前缀树中插入字符串 <code>word</code> 。</li>
	<li><code>boolean search(String word)</code> 如果字符串 <code>word</code> 在前缀树中，返回 <code>true</code>（即，在检索之前已经插入）；否则，返回 <code>false</code> 。</li>
	<li><code>boolean startsWith(String prefix)</code> 如果之前已经插入的字符串 <code>word</code> 的前缀之一为 <code>prefix</code> ，返回 <code>true</code> ；否则，返回 <code>false</code> 。</li>
</ul>

<p> </p>

<p><strong>示例：</strong></p>

<pre>
<strong>输入</strong>
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
<strong>输出</strong>
[null, null, true, false, true, null, true]

<strong>解释</strong>
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // 返回 True
trie.search("app");     // 返回 False
trie.startsWith("app"); // 返回 True
trie.insert("app");
trie.search("app");     // 返回 True
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= word.length, prefix.length <= 2000</code></li>
	<li><code>word</code> 和 <code>prefix</code> 仅由小写英文字母组成</li>
	<li><code>insert</code>、<code>search</code> 和 <code>startsWith</code> 调用次数 <strong>总计</strong> 不超过 <code>3 * 10<sup>4</sup></code> 次</li>
</ul>


## 题解


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



## 相关话题

- [设计](https://leetcode.cn//tag/design)
- [字典树](https://leetcode.cn//tag/trie)
- [哈希表](https://leetcode.cn//tag/hash-table)
- [字符串](https://leetcode.cn//tag/string)

## 相似题目


- [添加与搜索单词 - 数据结构设计](../design-add-and-search-words-data-structure/README.md)
- [设计搜索自动补全系统](../design-search-autocomplete-system/README.md)
- [单词替换](../replace-words/README.md)
- [实现一个魔法字典](../implement-magic-dictionary/README.md)
