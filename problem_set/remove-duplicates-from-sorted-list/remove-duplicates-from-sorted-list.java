
```
// @Title: 删除排序链表中的重复元素 (Remove Duplicates from Sorted List)
// @Author: robert.sunq
// @Date: 2021-07-18 17:44:24
// @Runtime: 0 ms
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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode newHand = new ListNode(head.val,head);
        ListNode pre = newHand,p = head;
        while(p!=null){
            // 和前节点值相同，删除当前元素
            if(pre.val == p.val){
                pre.next=p.next;
                p = p.next;
            }else{
                pre = pre.next;
                p = p.next;
            }
        }
        return newHand;
    }
}
