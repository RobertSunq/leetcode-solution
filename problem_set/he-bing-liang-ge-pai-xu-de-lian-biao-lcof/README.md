
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer 25. 合并两个排序的链表](https://leetcode.cn//problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/)

## 题目描述

<p>输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。</p>

<p><strong>示例1：</strong></p>

<pre><strong>输入：</strong>1-&gt;2-&gt;4, 1-&gt;3-&gt;4
<strong>输出：</strong>1-&gt;1-&gt;2-&gt;3-&gt;4-&gt;4</pre>

<p><strong>限制：</strong></p>

<p><code>0 &lt;= 链表长度 &lt;= 1000</code></p>

<p>注意：本题与主站 21 题相同：<a href="https://leetcode-cn.com/problems/merge-two-sorted-lists/">https://leetcode-cn.com/problems/merge-two-sorted-lists/</a></p>


## 题解


### Java

```Java
// @Title: 合并两个排序的链表 (合并两个排序的链表  LCOF)
// @Author: robert.sunq
// @Date: 2021-05-26 22:43:32
// @Runtime: 1 ms
// @Memory: 38.6 MB

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        head.next = null;
        ListNode p = head;
        while(l1 != null && l2!= null){
            if(l1.val <= l2.val) {
                p.next = l1;
                l1= l1.next;
            }else{
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if(l1 != null) p.next = l1;
        if(l2 != null) p.next = l2;
        return head.next;
    }
}
```



## 相关话题

- [递归](https://leetcode.cn//tag/recursion)
- [链表](https://leetcode.cn//tag/linked-list)

## 相似题目



