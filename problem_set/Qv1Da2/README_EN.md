
| English | [简体中文](README.md) |

# [剑指 Offer II 028. 展平多级双向链表](https://leetcode.cn//problems/Qv1Da2/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 展平多级双向链表 (展平多级双向链表)
// @Author: robert.sunq
// @Date: 2023-06-27 00:04:02
// @Runtime: 0 ms
// @Memory: 39.4 MB

/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }

        Node p = head;
        while (p != null) {
            Node children = null;
            if (p.child != null) {
                children = flatten(p.child);
                // 注意，这里设置将child设置为null，否则会被判断为非双相列表
                p.child = null;
            }
            if (children != null) {
                p = addSubNode(p, children);
            }
            p = p.next;
        }
        p = head;
        return head;
    }

    private Node addSubNode(Node head, Node children) {
        Node tmp = head.next;
        Node p = head;
        if (children != null) {
            p.next = children;
            children.prev = p;
            while (p.next != null) {
                p = p.next;
            }
        }
        p.next = tmp;
        if (tmp != null) {
            tmp.prev = p;
        }
        return p;
    }
}
```



## Related Topics

- [Depth-First Search](https://leetcode.cn//tag/depth-first-search)
- [Linked List](https://leetcode.cn//tag/linked-list)
- [Doubly-Linked List](https://leetcode.cn//tag/doubly-linked-list)

## Similar Questions


