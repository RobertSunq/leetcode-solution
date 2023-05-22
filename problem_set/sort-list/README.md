
| [English](README_EN.md) | 简体中文 |

# [148. 排序链表](https://leetcode.cn//problems/sort-list/)

## 题目描述

<p>给你链表的头结点&nbsp;<code>head</code>&nbsp;，请将其按 <strong>升序</strong> 排列并返回 <strong>排序后的链表</strong> 。</p>

<ul>
</ul>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/09/14/sort_list_1.jpg" style="width: 450px;" />
<pre>
<b>输入：</b>head = [4,2,1,3]
<b>输出：</b>[1,2,3,4]
</pre>

<p><strong>示例 2：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/09/14/sort_list_2.jpg" style="width: 550px;" />
<pre>
<b>输入：</b>head = [-1,5,3,4,0]
<b>输出：</b>[-1,0,3,4,5]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<b>输入：</b>head = []
<b>输出：</b>[]
</pre>

<p>&nbsp;</p>

<p><b>提示：</b></p>

<ul>
	<li>链表中节点的数目在范围&nbsp;<code>[0, 5 * 10<sup>4</sup>]</code>&nbsp;内</li>
	<li><code>-10<sup>5</sup>&nbsp;&lt;= Node.val &lt;= 10<sup>5</sup></code></li>
</ul>

<p>&nbsp;</p>

<p><b>进阶：</b>你可以在&nbsp;<code>O(n&nbsp;log&nbsp;n)</code> 时间复杂度和常数级空间复杂度下，对链表进行排序吗？</p>


## 题解


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



## 相关话题

- [链表](https://leetcode.cn//tag/linked-list)
- [双指针](https://leetcode.cn//tag/two-pointers)
- [分治](https://leetcode.cn//tag/divide-and-conquer)
- [排序](https://leetcode.cn//tag/sorting)
- [归并排序](https://leetcode.cn//tag/merge-sort)

## 相似题目


- [合并两个有序链表](../merge-two-sorted-lists/README.md)
- [颜色分类](../sort-colors/README.md)
- [对链表进行插入排序](../insertion-sort-list/README.md)
