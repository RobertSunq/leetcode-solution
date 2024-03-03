
```
// @Title: 反转链表 (Reverse Linked List)
// @Author: robert.sunq
// @Date: 2023-09-01 23:34:28
// @Runtime: 0 ms
// @Memory: 40 MB

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
    ListNode ans = new ListNode();
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return ans.next;
        }
        dfs(head);
        return ans.next;
    }

    private ListNode dfs(ListNode head) {
        if (head.next == null) {
            ans.next = head;
            return head;
        }
        ListNode ans = dfs(head.next);
        ans.next = head;
        head.next = null;
        return head;
    }
}
