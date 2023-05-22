
| English | [简体中文](README.md) |

# [25. Reverse Nodes in k-Group](https://leetcode.cn//problems/reverse-nodes-in-k-group/)

## Description

<p>Given the <code>head</code> of a linked list, reverse the nodes of the list <code>k</code> at a time, and return <em>the modified list</em>.</p>

<p><code>k</code> is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of <code>k</code> then left-out nodes, in the end, should remain as it is.</p>

<p>You may not alter the values in the list&#39;s nodes, only nodes themselves may be changed.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/03/reverse_ex1.jpg" style="width: 542px; height: 222px;" />
<pre>
<strong>Input:</strong> head = [1,2,3,4,5], k = 2
<strong>Output:</strong> [2,1,4,3,5]
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/03/reverse_ex2.jpg" style="width: 542px; height: 222px;" />
<pre>
<strong>Input:</strong> head = [1,2,3,4,5], k = 3
<strong>Output:</strong> [3,2,1,4,5]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the list is <code>n</code>.</li>
	<li><code>1 &lt;= k &lt;= n &lt;= 5000</code></li>
	<li><code>0 &lt;= Node.val &lt;= 1000</code></li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow-up:</strong> Can you solve the problem in <code>O(1)</code> extra memory space?</p>


## Solutions


### Java

```Java
// @Title: K 个一组翻转链表 (Reverse Nodes in k-Group)
// @Author: robert.sunq
// @Date: 2021-06-30 22:55:18
// @Runtime: 1 ms
// @Memory: 38.4 MB

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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k <= 1) return head;
        int i = 1;
        ListNode p = head;
        // nHead 头节点
        ListNode temp ,nHead = new ListNode() ;
        ListNode pre = nHead;
        nHead.next = head;
        while(p != null){
            // 开始反转
            if(i == k){
                // 保存下一节点，并断开链表
                // pre 指向需要开始反转链表的 第一个节点的前一个节点
                temp = p.next;
                p.next = null;
                // 反转
                recur(pre.next);
                // 恢复连接
                // 此时 pre.next 指向反转后的最后一个节点
                pre.next.next = temp;
                // temp 记录反转链表的最后一个节点
                temp = pre.next;
                // 此时 p记录的是头节点 ， 该部操作将前面的链表 与反转的链表恢复链接关系
                pre.next = p;
                // 开始新一轮的计数
                // pre 记录 下一个链表头节点的 前一个节点
                pre = temp;
                p = temp.next;
                i = 1;
            }else{
                p = p.next;
                i++;
            }
        } 
        return nHead.next;
    }

    ListNode recur(ListNode head ){
        if(head == null || head.next == null) return head;
        ListNode temp = recur(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }
}
```



## Related Topics

- [Recursion](https://leetcode.cn//tag/recursion)
- [Linked List](https://leetcode.cn//tag/linked-list)

## Similar Questions

- [Swap Nodes in Pairs](../swap-nodes-in-pairs/README_EN.md)
