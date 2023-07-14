
| English | [简体中文](README.md) |

# [剑指 Offer II 066. 单词之和](https://leetcode.cn//problems/z1R5dt/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 单词之和 (单词之和)
// @Author: robert.sunq
// @Date: 2023-07-14 22:52:18
// @Runtime: 11 ms
// @Memory: 40.3 MB

class MapSum {

    TreeNode head;
    /** Initialize your data structure here. */
    public MapSum() {
        head = new TreeNode();
    }
    
    public void insert(String key, int val) {
        head.insert(key, val);
    }
    
    public int sum(String prefix) {
        TreeNode p = head.startsWith(prefix);
        if (p == null) {
            return 0;
        }
        int ans = 0;
        Stack<TreeNode> st = new Stack<>();
        st.push(p);
        while (!st.isEmpty()) {
            p = st.pop();
            for (int i = 0; i < 26; i++) {
                if (p.next[i] != null) {
                    st.push(p.next[i]);
                }
            }
            if (p.isEnd) {
                ans+=p.val;
            }
        }

        return ans;
    }

    class TreeNode {
        public TreeNode[] next;
        public boolean isEnd;
        public int val;

        public TreeNode() {
            next = new TreeNode[26];
            isEnd = false;
            val = 0;
        }

        public void insert(String key, int val) {
            TreeNode root = this;
            for (int i = 0; i < key.length(); i++) {
                int index = key.charAt(i) - 'a';
                if (root.next[index] == null) {
                    root.next[index] = new TreeNode();
                }
                root = root.next[index];
            }

            root.isEnd = true;
            root.val = val;
        }

        public TreeNode startsWith(String prefix) {
            TreeNode root = this;
            int i = 0;
            int n = prefix.length();
            while (root != null && i < n) {
                int index = prefix.charAt(i) - 'a';
                if (root.next[index] == null) {
                    return null;
                }
                i++;
                root = root.next[index];
            }
            return root;
        }

    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
```



## Related Topics

- [Design](https://leetcode.cn//tag/design)
- [Trie](https://leetcode.cn//tag/trie)
- [Hash Table](https://leetcode.cn//tag/hash-table)
- [String](https://leetcode.cn//tag/string)

## Similar Questions


