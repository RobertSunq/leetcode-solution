
```
// @Title: 链表相交 (Intersection of Two Linked Lists LCCI)
// @Author: robert.sunq
// @Date: 2021-08-02 22:54:49
// @Runtime: 1 ms
// @Memory: 41.3 MB

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
        ListNode pA = headA;
        ListNode pB = headB;
        while(pA != pB){
            pA = (pA == null)? headB:pA.next;
            pB = (pB == null)? headA:pB.next;
        }
        return pA;
    }
}
