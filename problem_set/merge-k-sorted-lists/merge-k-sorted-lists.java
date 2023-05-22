
```
// @Title: 合并 K 个升序链表 (Merge k Sorted Lists)
// @Author: robert.sunq
// @Date: 2021-07-08 22:14:24
// @Runtime: 1 ms
// @Memory: 40 MB

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
        if(lists.length <= 0) return null;
        // 两两进行归并排序
        return recur(lists,0,lists.length-1);
    }
    ListNode recur(ListNode[] lists , int start,int end){
        // 指向同一个链表 返回
        if(start == end) return lists[start];
        // 分别合并左右两边链表
        ListNode left = recur(lists,start,(start + end)/2);
        ListNode right = recur(lists,(start+end)/2+1,end);
        return merge(left,right);
    }
    // 合并两个链表
    ListNode merge(ListNode left,ListNode right){
        ListNode head = new ListNode(),l,r;
        l = left;
        r = right;
        ListNode p = head;
        while(l !=null && r != null){
            if(l.val<=r.val){
                p.next = l;
                p = l;
                l = l.next;
            }else{
                p.next = r;
                p = r;
                r = r.next; 
            }
        }
        if(l != null){
            p.next = l;
        }
        if(r != null){
            p.next = r;
        }
        return head.next;
    }
}
