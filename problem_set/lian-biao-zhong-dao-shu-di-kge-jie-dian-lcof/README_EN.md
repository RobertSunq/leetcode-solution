
| English | [简体中文](README.md) |

# [剑指 Offer 22. 链表中倒数第k个节点 LCOF](https://leetcode.cn//problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>

## Solutions


### Java

```Java
// @Title: 链表中倒数第k个节点 (链表中倒数第k个节点 LCOF)
// @Author: robert.sunq
// @Date: 2021-05-26 22:25:20
// @Runtime: 0 ms
// @Memory: 36.3 MB

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode pre = head, p = head;
        while(p.next!= null){
            if(k <= 1){
                pre = pre.next;
            }
            p = p.next;
            k--;
        } 
        return pre;
    }
}
```



## Related Topics

- [Linked List](https://leetcode.cn//tag/linked-list)
- [Two Pointers](https://leetcode.cn//tag/two-pointers)

## Similar Questions


