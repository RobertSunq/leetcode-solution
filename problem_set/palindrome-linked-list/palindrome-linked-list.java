
```
// @Title: 回文链表 (Palindrome Linked List)
// @Author: robert.sunq
// @Date: 2021-06-17 22:52:19
// @Runtime: 17 ms
// @Memory: 51 MB

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
    // 快慢指针 找到中点
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode low = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            low = low.next;
        }
        fast = recur(low.next);
        ListNode p = head;
        ListNode p1 = fast;
        boolean res = true;
        while(res && p1 != null){
            if(p.val != p1.val){
                res =  false;
            }
            p1 = p1.next;
            p = p.next;
        }
        // 还原列表
        low = recur(fast);
        return res;

    }

    // 反转后半段列表
    ListNode recur(ListNode head){
        // 找到最后一个 就是反转后的新头部
        if(head == null || head.next == null) return head;
        ListNode temp = recur(head.next);
        // 下一个节点的 next 指向当前节点
        head.next.next = head; 
        // 避免环，删掉当前节点与下一个节点的连接，即当前节点为目前的尾节点
        head.next = null;
        return temp;
    }
}
