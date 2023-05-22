
| English | [简体中文](README.md) |

# [206. Reverse Linked List](https://leetcode.cn//problems/reverse-linked-list/)

## Description

<p>Given the <code>head</code> of a singly linked list, reverse the list, and return <em>the reversed list</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/rev1ex1.jpg" style="width: 542px; height: 222px;" />
<pre>
<strong>Input:</strong> head = [1,2,3,4,5]
<strong>Output:</strong> [5,4,3,2,1]
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/rev1ex2.jpg" style="width: 182px; height: 222px;" />
<pre>
<strong>Input:</strong> head = [1,2]
<strong>Output:</strong> [2,1]
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> head = []
<strong>Output:</strong> []
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the list is the range <code>[0, 5000]</code>.</li>
	<li><code>-5000 &lt;= Node.val &lt;= 5000</code></li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong> A linked list can be reversed either iteratively or recursively. Could you implement both?</p>


## Solutions


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



## Related Topics

- [Recursion](https://leetcode.cn//tag/recursion)
- [Linked List](https://leetcode.cn//tag/linked-list)

## Similar Questions

- [Reverse Linked List II](../reverse-linked-list-ii/README_EN.md)
- [Binary Tree Upside Down](../binary-tree-upside-down/README_EN.md)
- [Palindrome Linked List](../palindrome-linked-list/README_EN.md)
