
| [English](README_EN.md) | 简体中文 |

# [206. 反转链表](https://leetcode.cn//problems/reverse-linked-list/)

## 题目描述

给你单链表的头节点 <code>head</code> ，请你反转链表，并返回反转后的链表。
<div class="original__bRMd">
<div>
<p> </p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/rev1ex1.jpg" style="width: 542px; height: 222px;" />
<pre>
<strong>输入：</strong>head = [1,2,3,4,5]
<strong>输出：</strong>[5,4,3,2,1]
</pre>

<p><strong>示例 2：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/rev1ex2.jpg" style="width: 182px; height: 222px;" />
<pre>
<strong>输入：</strong>head = [1,2]
<strong>输出：</strong>[2,1]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>head = []
<strong>输出：</strong>[]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li>链表中节点的数目范围是 <code>[0, 5000]</code></li>
	<li><code>-5000 <= Node.val <= 5000</code></li>
</ul>

<p> </p>

<p><strong>进阶：</strong>链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？</p>
</div>
</div>


## 题解


### Java

```Java
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
```



## 相关话题

- [递归](https://leetcode.cn//tag/recursion)
- [链表](https://leetcode.cn//tag/linked-list)

## 相似题目


- [反转链表 II](../reverse-linked-list-ii/README.md)
- [上下翻转二叉树](../binary-tree-upside-down/README.md)
- [回文链表](../palindrome-linked-list/README.md)
