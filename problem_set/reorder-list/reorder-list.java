
```
// @Title: 重排链表 (Reorder List)
// @Author: robert.sunq
// @Date: 2021-07-08 22:03:17
// @Runtime: 2 ms
// @Memory: 42.1 MB

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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode fast,slow,pre = new ListNode();
        fast = head;
        slow = head;
        // 快慢指针找到中点
        while(true){
            if(fast == null || fast.next == null){
                break;
            }
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // 反转后半段，并拆成两个链表
        pre.next = null;
        ListNode p = head,rp;
        rp = recur(slow);
        // 合并两个链表，且后半段链表长度必 大于等于前半段，故如果最后后半段有结余 放到整个链表最后面
        // 这里也可以将前半段  前插的方式放到后半段中
        while(rp != null && p!=null){
            // 拼接
            ListNode temp = rp.next;
            rp.next = p.next;
            p.next = rp;
            p = rp.next;
            // 保留最后边节点的前一个节点
            pre = rp;
            rp = temp;
        }
        if(rp != null){
            pre.next = rp;
        }
        
    }
    // 反转链表
    ListNode recur(ListNode p){
        if(p == null || p.next == null){
            return p;
        }
        ListNode temp = recur(p.next);
        p.next.next = p;
        p.next = null;
        return temp;
    }
}
