
```
// @Title: K 个一组翻转链表 (Reverse Nodes in k-Group)
// @Author: robert.sunq
// @Date: 2021-06-30 22:55:18
// @Runtime: 1 ms
// @Memory: 38.4 MB

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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k <= 1) return head;
        int i = 1;
        ListNode p = head;
        // nHead 头节点
        ListNode temp ,nHead = new ListNode() ;
        ListNode pre = nHead;
        nHead.next = head;
        while(p != null){
            // 开始反转
            if(i == k){
                // 保存下一节点，并断开链表
                // pre 指向需要开始反转链表的 第一个节点的前一个节点
                temp = p.next;
                p.next = null;
                // 反转
                recur(pre.next);
                // 恢复连接
                // 此时 pre.next 指向反转后的最后一个节点
                pre.next.next = temp;
                // temp 记录反转链表的最后一个节点
                temp = pre.next;
                // 此时 p记录的是头节点 ， 该部操作将前面的链表 与反转的链表恢复链接关系
                pre.next = p;
                // 开始新一轮的计数
                // pre 记录 下一个链表头节点的 前一个节点
                pre = temp;
                p = temp.next;
                i = 1;
            }else{
                p = p.next;
                i++;
            }
        } 
        return nHead.next;
    }

    ListNode recur(ListNode head ){
        if(head == null || head.next == null) return head;
        ListNode temp = recur(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }
}
