
```
// @Title: 链表中的两数相加 (链表中的两数相加)
// @Author: robert.sunq
// @Date: 2023-06-25 23:13:46
// @Runtime: 1 ms
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }
        
        ListNode p1 = l1, p2 = l2;
        int n = 0, m  = 0;
        while (p1 != null) {
            p1 = p1.next;
            n++;
        }
        while (p2 != null) {
            p2 = p2.next;
            m++;
        }

        p1 = l1;
        p2 = l2;
        if (n < m) {
            p1 = l2;
            p2 = l1;
            int tmp = n;
            n = m;
            m = tmp;
        }

        ListNode ans = add(p1, p2, n - m);
        return ans.val > 0 ? ans : ans.next; 
    }

    private ListNode add(ListNode l1, ListNode l2, int n) {
        if (n > 0) {
            ListNode p = add(l1.next, l2, --n);
            int tmp = p.val + l1.val;
            ListNode ans  = new ListNode(tmp / 10);
            p.val = tmp % 10;
            ans.next = p;
            return ans;
        }
        if (l1.next == null) {
            int tmp = l1.val + l2.val;
            ListNode ans  = new ListNode(tmp / 10);
            ans.next = new ListNode(tmp % 10);
            return ans;
        }
        ListNode p = add(l1.next, l2.next, n);
        int tmp = p.val + l1.val + l2.val;
        ListNode ans  = new ListNode(tmp / 10);
        p.val = tmp % 10;
        ans.next = p;
        return ans;
    }
}
