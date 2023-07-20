
```
// @Title: 合并排序链表 (合并排序链表)
// @Author: robert.sunq
// @Date: 2023-07-20 22:30:39
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
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if (n < 1) {
            return null;
        }

        // 设置归并的步长
        for (int step =  1; step < n; ) {
            // 起始下标
            int indexHeadOne = 0;
            while (indexHeadOne < n) {
                // 获取需要归并的两个
                ListNode head1 = lists[indexHeadOne];
                // 第二个不存在就是null
                ListNode head2 = indexHeadOne + step < n ? lists[indexHeadOne + step] : null;

                // 合并两个
                ListNode merge = merge(head1, head2);

                // 放到随意是1的位置上上
                lists[indexHeadOne] = merge;

                // 下一个区间
                indexHeadOne = indexHeadOne + step + step;
            }
            step = step << 1;
        }

        return lists[0];
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode head = new ListNode();
        ListNode p = head;
        ListNode p1 = head1;
        ListNode p2 = head2;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }
        return head.next;
    }
}
