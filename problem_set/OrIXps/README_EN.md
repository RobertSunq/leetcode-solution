
| English | [简体中文](README.md) |

# [剑指 Offer II 031. 最近最少使用缓存](https://leetcode.cn//problems/OrIXps/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 最近最少使用缓存 (最近最少使用缓存)
// @Author: robert.sunq
// @Date: 2023-06-28 00:05:42
// @Runtime: 1866 ms
// @Memory: 102.7 MB

class LRUCache {
    private Node head;
    private int capacity;
    private int nodeSize;


    public LRUCache(int capacity) {
        this.head = new Node();
        this.capacity = capacity;
        this.nodeSize = 0;
    }
    
    public int get(int key) {
        Node p = head.next;
        Node pre = head;
        while (p != null) {
            if (p.key == key) {
                pre.next = p.next;
                p.next = head.next;
                head.next = p;
                return p.val;
            }
            p = p.next;
            pre = pre.next;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (this.get(key) != -1) {
            head.next.val = value;
            return;
        }
        
        Node p = new Node(key, value);
        p.next = head.next;
        head.next = p;
        if (nodeSize < capacity) {
            nodeSize++;
            return;
        }

        p = head.next;
        Node pre = head;
        while (p.next != null) {
            p = p.next;
            pre = pre.next;
        }
        pre.next = null;
    }

    class Node {
        public int key;
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int key, int val) {
            Node.this.key = key;
            Node.this.val = val;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
```



## Related Topics

- [Design](https://leetcode.cn//tag/design)
- [Hash Table](https://leetcode.cn//tag/hash-table)
- [Linked List](https://leetcode.cn//tag/linked-list)
- [Doubly-Linked List](https://leetcode.cn//tag/doubly-linked-list)

## Similar Questions


