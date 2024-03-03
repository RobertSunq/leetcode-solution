
```
// @Title: 链表最大孪生和 (Maximum Twin Sum of a Linked List)
// @Author: robert.sunq
// @Date: 2023-09-02 16:57:42
// @Runtime: 9 ms
// @Memory: 66.3 MB

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
    public int pairSum(ListNode head) {
        int n = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            n++;
        }

        int i = 0;
        ListNode head1;
        int size = n / 2;
        p = head;
        while(i < size) {
            p = p.next;
            i++;
        }
        head1 = reserveDFS(p);

        int ans = 0;
        p = head;
        while (head1 != null) {
            int tmp = p.val + head1.val;
            ans = Math.max(tmp, ans);
            p = p.next;
            head1 = head1.next;
        }

        return ans;
    }

    private ListNode reserveDFS(ListNode head){
        if (head.next == null) {
            return head;
        }
        ListNode newHead = reserveDFS(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
