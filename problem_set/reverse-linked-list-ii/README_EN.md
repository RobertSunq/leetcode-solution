
| English | [简体中文](README.md) |

# [92. Reverse Linked List II](https://leetcode.cn//problems/reverse-linked-list-ii/)

## Description

<p>Given the <code>head</code> of a singly linked list and two integers <code>left</code> and <code>right</code> where <code>left &lt;= right</code>, reverse the nodes of the list from position <code>left</code> to position <code>right</code>, and return <em>the reversed list</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/rev2ex2.jpg" style="width: 542px; height: 222px;" />
<pre>
<strong>Input:</strong> head = [1,2,3,4,5], left = 2, right = 4
<strong>Output:</strong> [1,4,3,2,5]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> head = [5], left = 1, right = 1
<strong>Output:</strong> [5]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the list is <code>n</code>.</li>
	<li><code>1 &lt;= n &lt;= 500</code></li>
	<li><code>-500 &lt;= Node.val &lt;= 500</code></li>
	<li><code>1 &lt;= left &lt;= right &lt;= n</code></li>
</ul>

<p>&nbsp;</p>
<strong>Follow up:</strong> Could you do it in one pass?

## Solutions


### Java

```Java
// @Title: 反转链表 II (Reverse Linked List II)
// @Author: robert.sunq
// @Date: 2021-07-11 22:26:55
// @Runtime: 0 ms
// @Memory: 35.6 MB

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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int i = 1;
        ListNode p = head;
        // 记录开始的位置
        ListNode pl = new ListNode();
        // 记录开始位置的前一节点
        ListNode pre = new ListNode(),res;
        // 添加一个头节点
        pre.next = head;
        // 记录链表的开始，因为可能从第一个节点就开始反转，所以需要二维记忆
        res = pre;
        while(p != null){
            // 开始节点
            if(i == left){
                pl = p;
            }else if ( i > left && i <= right){
                // 中间交换的位置 ， 采用头插法
                pl.next = p.next;
                p.next = pre.next;
                pre.next = p;
                // 将p恢复到最后访问的位置
                p = pl;
            }else {
                // pre 记录开始的前一个节点
                pre = p;
            }
            i++;
            p = p.next;
        }
        return res.next;
    }
}
```



## Related Topics

- [Linked List](https://leetcode.cn//tag/linked-list)

## Similar Questions

- [Reverse Linked List](../reverse-linked-list/README_EN.md)
