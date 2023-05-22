
```
// @Title: 两个链表的第一个公共节点 (两个链表的第一个公共节点  LCOF)
// @Author: robert.sunq
// @Date: 2021-05-30 02:34:55
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
        int A = 0,B =0;
        ListNode pA = headA,pB = headB;
        while(pA != null){
            A++;
            pA = pA.next;
        }
        while(pB != null){
            B++;
            pB = pB.next;
        }
        int temp =0;
        if (A >= B){
            pA = headA;
            pB = headB;
            temp = A-B;
        }else{
            pA = headB;
            pB = headA;
            temp = B -A ; 
        }
        while(temp>0){
            pA = pA.next;
            temp--;
        }
        ListNode res = null;
        while(pA != null && pB != null){
            if(pA == pB){
                res = pA;
                break;
            }
            pA = pA.next;
            pB = pB.next;
        }
        return res;
        
    }
}
