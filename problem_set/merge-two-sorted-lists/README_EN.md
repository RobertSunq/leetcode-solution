
| English | [简体中文](README.md) |

# [21. Merge Two Sorted Lists](https://leetcode.cn//problems/merge-two-sorted-lists/)

## Description

<p>You are given the heads of two sorted linked lists <code>list1</code> and <code>list2</code>.</p>

<p>Merge the two lists in a one <strong>sorted</strong> list. The list should be made by splicing together the nodes of the first two lists.</p>

<p>Return <em>the head of the merged linked list</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/03/merge_ex1.jpg" style="width: 662px; height: 302px;" />
<pre>
<strong>Input:</strong> list1 = [1,2,4], list2 = [1,3,4]
<strong>Output:</strong> [1,1,2,3,4,4]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> list1 = [], list2 = []
<strong>Output:</strong> []
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> list1 = [], list2 = [0]
<strong>Output:</strong> [0]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in both lists is in the range <code>[0, 50]</code>.</li>
	<li><code>-100 &lt;= Node.val &lt;= 100</code></li>
	<li>Both <code>list1</code> and <code>list2</code> are sorted in <strong>non-decreasing</strong> order.</li>
</ul>


## Solutions


### Java

```Java
// @Title: 合并两个有序链表 (Merge Two Sorted Lists)
// @Author: robert.sunq
// @Date: 2021-06-02 22:24:00
// @Runtime: 1 ms
// @Memory: 38 MB

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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode p = res;
        while(l1 != null && l2!= null){
            if(l1.val <= l2.val) {
                p.next = l1;
                p = p.next;
                l1= l1.next;
            }else{
                p.next = l2;
                p = p.next;
                l2= l2.next;
            }
        }
        if(l1 != null){
            p.next = l1;
        }
        if(l2 != null){
            p.next = l2;
        }
        return res.next;

    }
}
```



## Related Topics

- [Recursion](https://leetcode.cn//tag/recursion)
- [Linked List](https://leetcode.cn//tag/linked-list)

## Similar Questions

- [Merge k Sorted Lists](../merge-k-sorted-lists/README_EN.md)
- [Merge Sorted Array](../merge-sorted-array/README_EN.md)
- [Sort List](../sort-list/README_EN.md)
- [Shortest Word Distance II](../shortest-word-distance-ii/README_EN.md)
