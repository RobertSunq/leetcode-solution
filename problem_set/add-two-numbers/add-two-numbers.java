
```
// @Title: 两数相加 (Add Two Numbers)
// @Author: robert.sunq
// @Date: 2021-06-01 21:36:40
// @Runtime: 2 ms
// @Memory: 38.9 MB

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
        ListNode res = new ListNode(0);
        ListNode p ;
        p = res;
        int ad = 0;
        while(l1 != null && l2 != null){
            int t = l1.val+l2.val + ad;
            ListNode temp = new ListNode(t % 10);
            ad = t/10;
            p.next = temp;
            p = p.next;
            l1 = l1.next;
            l2 = l2.next; 
        }
        while(l1 != null){
            int t = l1.val+ad;
            ListNode temp = new ListNode(t % 10);
            ad = t/10;
            p.next = temp;
            l1 = l1.next;
            p = p.next;
        }
        while(l2 != null){
            int t = l2.val+ad;
            ListNode temp = new ListNode(t % 10);
            ad = t/10;
            p.next = temp;
            l2 = l2.next;
            p = p.next;
        }
        if(ad != 0){
            ListNode temp = new ListNode(ad % 10);
            ad = ad/10;
            p.next = temp;
        }
        return res.next;
    }
}
