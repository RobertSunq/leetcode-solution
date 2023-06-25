
```
// @Title: 两个链表的第一个重合节点 (两个链表的第一个重合节点)
// @Author: robert.sunq
// @Date: 2023-06-25 22:15:56
// @Runtime: 1 ms
// @Memory: 45 MB

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next; 
        }

        return pA;
        
    }
}
