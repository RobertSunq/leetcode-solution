
| English | [简体中文](README.md) |

# [剑指 Offer II 026. 重排链表](https://leetcode.cn//problems/LGjMqU/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 重排链表 (重排链表)
// @Author: robert.sunq
// @Date: 2023-06-25 23:57:25
// @Runtime: 1 ms
// @Memory: 44.7 MB

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        } 

        int n = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            n++;
        }
        n = (n/2) + (n % 2) - 1;

        p = head;
        while ( n > 0) {
            p = p.next;
            n--;
        }
        
        ListNode head1 = p.next;
        p.next = null;
        head1 = reverseList(head1);
        p = head;
        while (head1 != null) {
            ListNode tmp = head1.next;
            head1.next = p.next;
            p.next = head1;
            p = head1.next;
            head1 = tmp;
        }
    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = head.next;
        ListNode pre = head;
        ListNode tmp = p;
        head.next = null;
        while (p != null) {
            tmp = p.next;
            p.next = pre;
            pre = p;
            p = tmp;
        }

        return pre;
    }
}
```



## Related Topics

- [Stack](https://leetcode.cn//tag/stack)
- [Recursion](https://leetcode.cn//tag/recursion)
- [Linked List](https://leetcode.cn//tag/linked-list)
- [Two Pointers](https://leetcode.cn//tag/two-pointers)

## Similar Questions


