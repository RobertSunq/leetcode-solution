
```
// @Title: 相交链表 (Intersection of Two Linked Lists)
// @Author: robert.sunq
// @Date: 2021-06-14 22:19:33
// @Runtime: 1 ms
// @Memory: 41.1 MB

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
        if(headA == null && headB == null) return null;
        ListNode pA = headA,pB = headB;
        // 当两个都为空时，说明不相遇 返回空
        // 当两个节点相等时 返回相交节点
        while(pA != pB){
            // 如果其中一个节点走到尾端，则换向另一个链表，来消除两个链表的长度差
            // 及短的到尾部，换到长的。 长的到位部，换到短的
            if(pA == null) pA = headB;else pA = pA.next;
            if(pB == null) pB = headA;else pB = pB.next;

            // pA = pA == null ? headB : pA.next;
            // pB = pB == null ? headA : pB.next; 
        }

        return pA;
    }
}
