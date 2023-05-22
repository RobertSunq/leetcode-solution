
```
// @Title: 环形链表 II (Linked List Cycle II)
// @Author: robert.sunq
// @Date: 2021-06-10 22:12:27
// @Runtime: 1 ms
// @Memory: 38.4 MB

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode l = head,f = head;
        while(true){
            if(l == null || f == null || f.next == null) return null;
            l = l.next;
            f = f.next.next;
            if(l == f) break;
        }
        f = head;
        while( f != l){
            f = f.next;
            l = l.next;
        }
        return f;
    }
}
