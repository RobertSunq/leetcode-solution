
```
// @Title: 删除排序链表中的重复元素 II (Remove Duplicates from Sorted List II)
// @Author: robert.sunq
// @Date: 2021-07-18 18:07:33
// @Runtime: 0 ms
// @Memory: 37.8 MB

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
        ListNode res = new ListNode(head.val-1,head);
        ListNode pre = res,p= head;
        while(p!= null){
            // 找到当前位置和下一个节点位置不重复的地方
            while(p.next!=null && p.next.val == p.val){
                p = p.next;
            }
            // 如果p没有移动，则不需要跳过节点
            if(pre.next == p){
                pre = pre.next;
            }else{
                // 否则跳过中间重复的部分
                pre.next = p.next;
            }
            p = p.next;
        }
        return res.next;
    }
}
