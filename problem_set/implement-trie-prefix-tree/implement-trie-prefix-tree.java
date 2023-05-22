
```
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
