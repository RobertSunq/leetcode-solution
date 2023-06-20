
```
// @Title: 删除链表的倒数第 n 个结点 (删除链表的倒数第 n 个结点)
// @Author: robert.sunq
// @Date: 2023-06-20 23:15:52
// @Runtime: 0 ms
// @Memory: 39.2 MB

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            n--;
            if (n < 0) {
                pre = pre.next;
            }
        } 
        if (pre.next == head) {
            return head.next;
        }
        pre.next = pre.next.next;

        return head;
    }
}
