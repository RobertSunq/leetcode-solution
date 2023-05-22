
| English | [简体中文](README.md) |

# [83. Remove Duplicates from Sorted List](https://leetcode.cn//problems/remove-duplicates-from-sorted-list/)

## Description

<p>Given the <code>head</code> of a sorted linked list, <em>delete all duplicates such that each element appears only once</em>. Return <em>the linked list <strong>sorted</strong> as well</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/04/list1.jpg" style="width: 302px; height: 242px;" />
<pre>
<strong>Input:</strong> head = [1,1,2]
<strong>Output:</strong> [1,2]
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/04/list2.jpg" style="width: 542px; height: 222px;" />
<pre>
<strong>Input:</strong> head = [1,1,2,3,3]
<strong>Output:</strong> [1,2,3]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the list is in the range <code>[0, 300]</code>.</li>
	<li><code>-100 &lt;= Node.val &lt;= 100</code></li>
	<li>The list is guaranteed to be <strong>sorted</strong> in ascending order.</li>
</ul>


## Solutions


### Java

```Java
// @Title: 删除排序链表中的重复元素 (Remove Duplicates from Sorted List)
// @Author: robert.sunq
// @Date: 2021-07-18 17:44:24
// @Runtime: 0 ms
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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode newHand = new ListNode(head.val,head);
        ListNode pre = newHand,p = head;
        while(p!=null){
            // 和前节点值相同，删除当前元素
            if(pre.val == p.val){
                pre.next=p.next;
                p = p.next;
            }else{
                pre = pre.next;
                p = p.next;
            }
        }
        return newHand;
    }
}
```



## Related Topics

- [Linked List](https://leetcode.cn//tag/linked-list)

## Similar Questions

- [Remove Duplicates from Sorted List II](../remove-duplicates-from-sorted-list-ii/README_EN.md)
