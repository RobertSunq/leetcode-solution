
```
// @Title: 合并两个有序链表 (Merge Two Sorted Lists)
// @Author: robert.sunq
// @Date: 2021-06-02 22:24:00
// @Runtime: 1 ms
// @Memory: 38 MB

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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode p = res;
        while(l1 != null && l2!= null){
            if(l1.val <= l2.val) {
                p.next = l1;
                p = p.next;
                l1= l1.next;
            }else{
                p.next = l2;
                p = p.next;
                l2= l2.next;
            }
        }
        if(l1 != null){
            p.next = l1;
        }
        if(l2 != null){
            p.next = l2;
        }
        return res.next;

    }
}
