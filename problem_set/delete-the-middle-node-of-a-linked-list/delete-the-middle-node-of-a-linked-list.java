
```
// @Title: 删除链表的中间节点 (Delete the Middle Node of a Linked List)
// @Author: robert.sunq
// @Date: 2023-08-29 23:39:58
// @Runtime: 3 ms
// @Memory: 62.1 MB

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
    public ListNode deleteMiddle(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        if (pre== null) {
            return null;
        }
        pre.next = pre.next.next;
        return head;
    }
}
