
```
// @Title: 反转链表 II (Reverse Linked List II)
// @Author: robert.sunq
// @Date: 2021-07-11 22:26:55
// @Runtime: 0 ms
// @Memory: 35.6 MB

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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int i = 1;
        ListNode p = head;
        // 记录开始的位置
        ListNode pl = new ListNode();
        // 记录开始位置的前一节点
        ListNode pre = new ListNode(),res;
        // 添加一个头节点
        pre.next = head;
        // 记录链表的开始，因为可能从第一个节点就开始反转，所以需要二维记忆
        res = pre;
        while(p != null){
            // 开始节点
            if(i == left){
                pl = p;
            }else if ( i > left && i <= right){
                // 中间交换的位置 ， 采用头插法
                pl.next = p.next;
                p.next = pre.next;
                pre.next = p;
                // 将p恢复到最后访问的位置
                p = pl;
            }else {
                // pre 记录开始的前一个节点
                pre = p;
            }
            i++;
            p = p.next;
        }
        return res.next;
    }
}
