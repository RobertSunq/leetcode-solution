
```
// @Title: 环形链表 (Linked List Cycle)
// @Author: robert.sunq
// @Date: 2021-06-10 00:30:45
// @Runtime: 0 ms
// @Memory: 39.7 MB

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
    public boolean hasCycle(ListNode head) {
        // 使用双指针，一个步进为1，一个步进为2，如果有环，两个中将会相遇
        if(head == null) return false;
        ListNode p1 = head,p2 = head.next;
        // 整个遍历过程中，出现空节点 则表示无环
        while(p1 != null && p2 != null){
            // p2 与p1 相遇则表示有环存在
            if(p1 == p2) return true;
            // 步进为一
            p1 = p1.next;
            // 步进为二
            if(p2.next == null) return false;
            p2 = p2.next.next;
        }
        return false;
    }
}
