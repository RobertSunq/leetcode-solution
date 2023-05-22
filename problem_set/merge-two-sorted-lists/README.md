
| [English](README_EN.md) | 简体中文 |

# [21. 合并两个有序链表](https://leetcode.cn//problems/merge-two-sorted-lists/)

## 题目描述

<p>将两个升序链表合并为一个新的 <strong>升序</strong> 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 </p>

<p> </p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/03/merge_ex1.jpg" style="width: 662px; height: 302px;" />
<pre>
<strong>输入：</strong>l1 = [1,2,4], l2 = [1,3,4]
<strong>输出：</strong>[1,1,2,3,4,4]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>l1 = [], l2 = []
<strong>输出：</strong>[]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>l1 = [], l2 = [0]
<strong>输出：</strong>[0]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li>两个链表的节点数目范围是 <code>[0, 50]</code></li>
	<li><code>-100 <= Node.val <= 100</code></li>
	<li><code>l1</code> 和 <code>l2</code> 均按 <strong>非递减顺序</strong> 排列</li>
</ul>


## 题解


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



## 相关话题

- [递归](https://leetcode.cn//tag/recursion)
- [链表](https://leetcode.cn//tag/linked-list)

## 相似题目


- [合并 K 个升序链表](../merge-k-sorted-lists/README.md)
- [合并两个有序数组](../merge-sorted-array/README.md)
- [排序链表](../sort-list/README.md)
- [最短单词距离 II](../shortest-word-distance-ii/README.md)
