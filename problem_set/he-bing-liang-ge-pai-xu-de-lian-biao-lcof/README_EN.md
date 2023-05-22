
| English | [简体中文](README.md) |

# [剑指 Offer 25. 合并两个排序的链表  LCOF](https://leetcode.cn//problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/)

## Description

English description is not available for the problem. Please switch to Chinese.

## Solutions


### Java

```Java
// @Title: 合并两个排序的链表 (合并两个排序的链表  LCOF)
// @Author: robert.sunq
// @Date: 2021-05-26 22:43:32
// @Runtime: 1 ms
// @Memory: 38.6 MB

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        head.next = null;
        ListNode p = head;
        while(l1 != null && l2!= null){
            if(l1.val <= l2.val) {
                p.next = l1;
                l1= l1.next;
            }else{
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if(l1 != null) p.next = l1;
        if(l2 != null) p.next = l2;
        return head.next;
    }
}
```



## Related Topics

- [Recursion](https://leetcode.cn//tag/recursion)
- [Linked List](https://leetcode.cn//tag/linked-list)

## Similar Questions


