
```
// @Title: 奇偶链表 (Odd Even Linked List)
// @Author: robert.sunq
// @Date: 2023-08-31 23:43:31
// @Runtime: 0 ms
// @Memory: 41.9 MB

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
    public ListNode oddEvenList(ListNode head) {
        ListNode left = new ListNode();
        ListNode right = new ListNode();
        ListNode p1 = left;
        ListNode p2 = right;
        ListNode p = head;
        boolean t = true;
        while (p != null) {
            if (t) {
                p1.next = p;
                p1 = p;
                p = p.next;
                p1.next = null;
                t = false;
            } else {
                p2.next = p;
                p2 = p;
                p = p.next;
                p2.next = null;
                t = true;
            }
        }

        p1.next = right.next;
        return left.next;
    }
}
