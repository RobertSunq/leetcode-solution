
| English | [简体中文](README.md) |

# [148. Sort List](https://leetcode.cn//problems/sort-list/)

## Description

<p>Given the <code>head</code> of a linked list, return <em>the list after sorting it in <strong>ascending order</strong></em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/09/14/sort_list_1.jpg" style="width: 450px; height: 194px;" />
<pre>
<strong>Input:</strong> head = [4,2,1,3]
<strong>Output:</strong> [1,2,3,4]
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/09/14/sort_list_2.jpg" style="width: 550px; height: 184px;" />
<pre>
<strong>Input:</strong> head = [-1,5,3,4,0]
<strong>Output:</strong> [-1,0,3,4,5]
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> head = []
<strong>Output:</strong> []
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the list is in the range <code>[0, 5 * 10<sup>4</sup>]</code>.</li>
	<li><code>-10<sup>5</sup> &lt;= Node.val &lt;= 10<sup>5</sup></code></li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong> Can you sort the linked list in <code>O(n logn)</code> time and <code>O(1)</code> memory (i.e. constant space)?</p>


## Solutions


### Java

```Java
// @Title: 排序链表 (Sort List)
// @Author: robert.sunq
// @Date: 2021-06-10 23:22:22
// @Runtime: 2680 ms
// @Memory: 42.8 MB

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
    public ListNode sortList(ListNode head) {
        if(head == null) return null;
        ListNode newhead = new ListNode(-1);
        ListNode pre ,p;
        newhead.next = head;
        head = head.next;
        // 注意 需要将现在尾节点 next 设为空，避免产生环
        newhead.next.next = null;
        while(head != null){
            pre = newhead;
            p = pre.next;
            while(p != null && p.val < head.val ) {
                pre = pre.next;
                p = p.next;
            }
            pre.next = head;
            head = head.next;
            pre.next.next = p;
        }
        return newhead.next;
    }
}
```



## Related Topics

- [Linked List](https://leetcode.cn//tag/linked-list)
- [Two Pointers](https://leetcode.cn//tag/two-pointers)
- [Divide and Conquer](https://leetcode.cn//tag/divide-and-conquer)
- [Sorting](https://leetcode.cn//tag/sorting)
- [Merge Sort](https://leetcode.cn//tag/merge-sort)

## Similar Questions

- [Merge Two Sorted Lists](../merge-two-sorted-lists/README_EN.md)
- [Sort Colors](../sort-colors/README_EN.md)
- [Insertion Sort List](../insertion-sort-list/README_EN.md)
