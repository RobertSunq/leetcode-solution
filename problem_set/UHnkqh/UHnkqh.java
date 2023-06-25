
```
// @Title: 反转链表 (反转链表)
// @Author: robert.sunq
// @Date: 2023-06-25 22:28:31
// @Runtime: 0 ms
// @Memory: 39.9 MB

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
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = head;
        ListNode p = head.next;
        ListNode tmp = null;
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
