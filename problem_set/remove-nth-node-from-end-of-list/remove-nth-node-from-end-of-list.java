
```
// @Title: 删除链表的倒数第 N 个结点 (Remove Nth Node From End of List)
// @Author: robert.sunq
// @Date: 2021-06-02 22:03:42
// @Runtime: 0 ms
// @Memory: 36.2 MB

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
        if(n <= 0 ) return head;
        ListNode p = head,pre = new ListNode(-1,head);
        ListNode res = pre;
        while(n > 0 && p != null){
            p = p.next;
            n--;
        }
        while(p != null){
            p = p.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return res.next;
    }

}
