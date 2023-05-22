
```
// @Title: 删除链表的节点 (删除链表的节点 LCOF)
// @Author: robert.sunq
// @Date: 2021-05-25 23:37:52
// @Runtime: 0 ms
// @Memory: 37.7 MB

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
       if(head.val == val) return head.next;
        ListNode pre = head, cur = head.next;
        // 找到第一个相等的点，保存其位置
        while(cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        // 如果该点存在，则删除该点。
        if(cur != null) pre.next = cur.next;
        return head;

    }
}
