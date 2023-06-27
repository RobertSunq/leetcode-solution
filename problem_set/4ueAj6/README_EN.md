
| English | [简体中文](README.md) |

# [剑指 Offer II 029. 排序的循环链表](https://leetcode.cn//problems/4ueAj6/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 排序的循环链表 (排序的循环链表)
// @Author: robert.sunq
// @Date: 2023-06-27 23:16:46
// @Runtime: 0 ms
// @Memory: 40.7 MB

/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        Node newNode = new Node(insertVal);
        if (head == null) {
            newNode.next = newNode;;
            return newNode;
        }

        if (head.next == head) {
            newNode.next = head.next;
            head.next.next = newNode;
            return head;
        }
        
        Node p = head.next;
        Node pre = head;

        // 找到交变点
        while(p != head) {
            if (p.val < pre.val) {
                break;
            }
            p = p.next;
            pre = pre.next;
        }
        // 拆循环连
        pre.next = null;
        Node last = pre;
        Node first = new Node();
        first.next = p;
        pre = first;

        while (p != null) {
            if (p.val >= insertVal) {
                pre.next = newNode;
                newNode.next = p;
                break;
            }
            p = p.next;
            pre = pre.next;
        }

        // 将循环链恢复， 如果p是null则插入值是最大值
        if (p == null) {
            pre.next = newNode;
            last = newNode;
        }

        last.next = first.next;

        return head;

    }
}
```



## Related Topics

- [Linked List](https://leetcode.cn//tag/linked-list)

## Similar Questions


