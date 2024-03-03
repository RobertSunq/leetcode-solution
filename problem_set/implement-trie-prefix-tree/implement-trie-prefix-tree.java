
```
// @Title: 实现 Trie (前缀树) (Implement Trie (Prefix Tree))
// @Author: robert.sunq
// @Date: 2023-09-27 21:25:55
// @Runtime: 32 ms
// @Memory: 53.2 MB

class Trie {

    class Node {
        public Node[] child;
        public boolean end;

        public Node () {
            this.child = new Node[26];
            this.end = false;
        }
    }
    private Node head;
    public Trie() {
        this.head = new Node();
    }
    
    public void insert(String word) {

        Node p = head;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (p.child[index] == null) {
                p.child[index] = new Node();
            }
            p = p.child[index];
        }
        p.end = true;
    }
    
    public boolean search(String word) {
        Node p = head;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (p.child[index] == null) {
                return false;
            }
            p = p.child[index];
        }
        return p.end;
    }
    
    public boolean startsWith(String prefix) {
        Node p = head;
                for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (p.child[index] == null) {
                return false;
            }
            p = p.child[index];
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
