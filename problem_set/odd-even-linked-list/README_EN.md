
| English | [简体中文](README.md) |

# [328. Odd Even Linked List](https://leetcode.cn//problems/odd-even-linked-list/)

## Description

<p>Given the <code>head</code> of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return <em>the reordered list</em>.</p>

<p>The <strong>first</strong> node is considered <strong>odd</strong>, and the <strong>second</strong> node is <strong>even</strong>, and so on.</p>

<p>Note that the relative order inside both the even and odd groups should remain as it was in the input.</p>

<p>You must solve the problem&nbsp;in <code>O(1)</code>&nbsp;extra space complexity and <code>O(n)</code> time complexity.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/10/oddeven-linked-list.jpg" style="width: 300px; height: 123px;" />
<pre>
<strong>Input:</strong> head = [1,2,3,4,5]
<strong>Output:</strong> [1,3,5,2,4]
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/10/oddeven2-linked-list.jpg" style="width: 500px; height: 142px;" />
<pre>
<strong>Input:</strong> head = [2,1,3,5,6,4,7]
<strong>Output:</strong> [2,3,6,7,1,5,4]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the linked list is in the range <code>[0, 10<sup>4</sup>]</code>.</li>
	<li><code>-10<sup>6</sup> &lt;= Node.val &lt;= 10<sup>6</sup></code></li>
</ul>


## Solutions


### Java

```Java
// @Title: 奇偶链表 (Odd Even Linked List)
// @Author: robert.sunq
// @Date: 2023-08-31 23:43:31
// @Runtime: 0 ms
// @Memory: 41.9 MB

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
    public ListNode oddEvenList(ListNode head) {
        ListNode left = new ListNode();
        ListNode right = new ListNode();
        ListNode p1 = left;
        ListNode p2 = right;
        ListNode p = head;
        boolean t = true;
        while (p != null) {
            if (t) {
                p1.next = p;
                p1 = p;
                p = p.next;
                p1.next = null;
                t = false;
            } else {
                p2.next = p;
                p2 = p;
                p = p.next;
                p2.next = null;
                t = true;
            }
        }

        p1.next = right.next;
        return left.next;
    }
}
```



## Related Topics

- [Linked List](https://leetcode.cn//tag/linked-list)

## Similar Questions

- [Split Linked List in Parts](../split-linked-list-in-parts/README_EN.md)
