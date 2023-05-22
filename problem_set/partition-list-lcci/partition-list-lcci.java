
```
// @Title: 分割链表 (Partition List LCCI)
// @Author: robert.sunq
// @Date: 2021-08-02 22:43:10
// @Runtime: 0 ms
// @Memory: 38 MB

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null ) return head;
        ListNode resHead = new ListNode(-1);
        resHead.next = head;
        ListNode pre = resHead,p = head,minPre = resHead;
        while(p!=null){
            if(p.val >= x){
                pre = p;
                p = p.next;
            }else{
                if(pre == minPre){
                    pre= pre.next;
                    minPre = minPre.next;
                    p = p.next;
                    continue;
                }
                pre.next = p.next;
                p.next = minPre.next;
                minPre.next = p;
                minPre = p;
                p = pre.next;
            }
        }
        return resHead.next;
    }
}
