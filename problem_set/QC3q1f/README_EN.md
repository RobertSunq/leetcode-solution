
| English | [简体中文](README.md) |

# [剑指 Offer II 062. 实现前缀树](https://leetcode.cn//problems/QC3q1f/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


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



## Related Topics

- [Design](https://leetcode.cn//tag/design)
- [Trie](https://leetcode.cn//tag/trie)
- [Hash Table](https://leetcode.cn//tag/hash-table)
- [String](https://leetcode.cn//tag/string)

## Similar Questions


