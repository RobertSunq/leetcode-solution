
| English | [简体中文](README.md) |

# [剑指 Offer II 027. 回文链表](https://leetcode.cn//problems/aMhZSa/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 回文链表 (回文链表)
// @Author: robert.sunq
// @Date: 2023-06-26 22:56:59
// @Runtime: 3 ms
// @Memory: 57.8 MB

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
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        ListNode slowP = head, fastP = head;
        while (fastP != null && fastP.next != null) {
            slowP = slowP.next;
            fastP = fastP.next.next;
        }

        if (fastP != null) {
            slowP = slowP.next;
        }
        fastP = head;
        slowP = reverseList(slowP);
        while (slowP != null) {
            if (slowP.val != fastP.val) {
                return false;
            }
            slowP = slowP.next;
            fastP = fastP.next;
        }

        return true;
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


