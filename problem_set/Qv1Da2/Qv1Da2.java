
```
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
