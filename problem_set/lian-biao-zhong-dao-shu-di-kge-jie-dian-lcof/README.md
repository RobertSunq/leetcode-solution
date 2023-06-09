
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer 22. 链表中倒数第k个节点](https://leetcode.cn//problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/)

## 题目描述

<p>输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。</p>

<p>例如，一个链表有 <code>6</code> 个节点，从头节点开始，它们的值依次是 <code>1、2、3、4、5、6</code>。这个链表的倒数第 <code>3</code> 个节点是值为 <code>4</code> 的节点。</p>

<p> </p>

<p><strong>示例：</strong></p>

<pre>
给定一个链表: <strong>1->2->3->4->5</strong>, 和 <em>k </em><strong>= 2</strong>.

返回链表 4<strong>->5</strong>.</pre>


## 题解


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



## 相关话题

- [链表](https://leetcode.cn//tag/linked-list)
- [双指针](https://leetcode.cn//tag/two-pointers)

## 相似题目



