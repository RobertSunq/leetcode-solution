
| [English](README_EN.md) | 简体中文 |

# [83. 删除排序链表中的重复元素](https://leetcode.cn//problems/remove-duplicates-from-sorted-list/)

## 题目描述

<p>给定一个已排序的链表的头<meta charset="UTF-8" />&nbsp;<code>head</code>&nbsp;，&nbsp;<em>删除所有重复的元素，使每个元素只出现一次</em>&nbsp;。返回 <em>已排序的链表</em>&nbsp;。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/04/list1.jpg" style="height: 160px; width: 200px;" />
<pre>
<strong>输入：</strong>head = [1,1,2]
<strong>输出：</strong>[1,2]
</pre>

<p><strong>示例 2：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/04/list2.jpg" style="height: 123px; width: 300px;" />
<pre>
<strong>输入：</strong>head = [1,1,2,3,3]
<strong>输出：</strong>[1,2,3]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li>链表中节点数目在范围 <code>[0, 300]</code> 内</li>
	<li><code>-100 &lt;= Node.val &lt;= 100</code></li>
	<li>题目数据保证链表已经按升序 <strong>排列</strong></li>
</ul>


## 题解


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



## 相关话题

- [链表](https://leetcode.cn//tag/linked-list)

## 相似题目


- [删除排序链表中的重复元素 II](../remove-duplicates-from-sorted-list-ii/README.md)
