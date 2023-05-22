
| English | [简体中文](README.md) |

# [剑指 Offer 24. 反转链表 LCOF](https://leetcode.cn//problems/fan-zhuan-lian-biao-lcof/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 反转链表 (反转链表 LCOF)
// @Author: robert.sunq
// @Date: 2021-08-03 22:07:32
// @Runtime: 0 ms
// @Memory: 38.4 MB

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        /**
        if(head == null) return null;
        // 头节点
        ListNode pre = new ListNode(head.val);
        ListNode p = head;
        while(p != null) {
            // 前插法
            ListNode temp = p.next;
            p.next = pre.next;
            pre.next = p;
            p = temp;
        }
        return pre.next;
         */
         if(head == null || head.next == null) return head;
         ListNode res = reverseList(head.next);
         head.next.next = head;
         head.next = null;
         return res;
    }
}
```



## Related Topics

- [Recursion](https://leetcode.cn//tag/recursion)
- [Linked List](https://leetcode.cn//tag/linked-list)

## Similar Questions


