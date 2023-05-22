
```
// @Title: 反转链表 (Reverse Linked List)
// @Author: robert.sunq
// @Date: 2021-06-16 00:22:46
// @Runtime: 0 ms
// @Memory: 38.5 MB

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
    // 双指针，或者头节点前插法
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode temp = null;
        ListNode cur = head;
        while(cur != null){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}


// // 迭代法
//     public ListNode reverseList(ListNode head) {
//         // 尾节点返回 ， 极为返回节点的头节点
//         if (head == null || head.next == null) return head;
//         // 表示要返回的节点，即已完成反转
//         ListNode temp = reverseList(head.next);
//         // 将下一个节点的next指针指向当前,当前节点的下一个节点的next指针 指向当前
//         head.next.next = head;
//         // 断掉当前指针指向下一指针，防止环
//         head.next = null;
//         // 返回反转好的节点，即最后的根节点
//         return temp;
//     }
