
| English | [简体中文](README.md) |

# [19. Remove Nth Node From End of List](https://leetcode.cn//problems/remove-nth-node-from-end-of-list/)

## Description

<p>Given the <code>head</code> of a linked list, remove the <code>n<sup>th</sup></code> node from the end of the list and return its head.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/03/remove_ex1.jpg" style="width: 542px; height: 222px;" />
<pre>
<strong>Input:</strong> head = [1,2,3,4,5], n = 2
<strong>Output:</strong> [1,2,3,5]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> head = [1], n = 1
<strong>Output:</strong> []
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> head = [1,2], n = 1
<strong>Output:</strong> [1]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the list is <code>sz</code>.</li>
	<li><code>1 &lt;= sz &lt;= 30</code></li>
	<li><code>0 &lt;= Node.val &lt;= 100</code></li>
	<li><code>1 &lt;= n &lt;= sz</code></li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong> Could you do this in one pass?</p>


## Solutions


### Java

```Java
// @Title: 删除链表的倒数第 N 个结点 (Remove Nth Node From End of List)
// @Author: robert.sunq
// @Date: 2021-06-02 22:03:42
// @Runtime: 0 ms
// @Memory: 36.2 MB

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(n <= 0 ) return head;
        ListNode p = head,pre = new ListNode(-1,head);
        ListNode res = pre;
        while(n > 0 && p != null){
            p = p.next;
            n--;
        }
        while(p != null){
            p = p.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return res.next;
    }

}
```



## Related Topics

- [Linked List](https://leetcode.cn//tag/linked-list)
- [Two Pointers](https://leetcode.cn//tag/two-pointers)

## Similar Questions


