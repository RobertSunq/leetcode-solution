
```
// @Title: 排序链表 (Sort List)
// @Author: robert.sunq
// @Date: 2021-06-10 23:22:22
// @Runtime: 2680 ms
// @Memory: 42.8 MB

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
    public ListNode sortList(ListNode head) {
        if(head == null) return null;
        ListNode newhead = new ListNode(-1);
        ListNode pre ,p;
        newhead.next = head;
        head = head.next;
        // 注意 需要将现在尾节点 next 设为空，避免产生环
        newhead.next.next = null;
        while(head != null){
            pre = newhead;
            p = pre.next;
            while(p != null && p.val < head.val ) {
                pre = pre.next;
                p = p.next;
            }
            pre.next = head;
            head = head.next;
            pre.next.next = p;
        }
        return newhead.next;
    }
}
