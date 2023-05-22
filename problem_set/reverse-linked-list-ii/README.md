
| [English](README_EN.md) | 简体中文 |

# [92. 反转链表 II](https://leetcode.cn//problems/reverse-linked-list-ii/)

## 题目描述

给你单链表的头指针 <code>head</code> 和两个整数 <code>left</code> 和 <code>right</code> ，其中 <code>left <= right</code> 。请你反转从位置 <code>left</code> 到位置 <code>right</code> 的链表节点，返回 <strong>反转后的链表</strong> 。
<p> </p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/rev2ex2.jpg" style="width: 542px; height: 222px;" />
<pre>
<strong>输入：</strong>head = [1,2,3,4,5], left = 2, right = 4
<strong>输出：</strong>[1,4,3,2,5]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>head = [5], left = 1, right = 1
<strong>输出：</strong>[5]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li>链表中节点数目为 <code>n</code></li>
	<li><code>1 <= n <= 500</code></li>
	<li><code>-500 <= Node.val <= 500</code></li>
	<li><code>1 <= left <= right <= n</code></li>
</ul>

<p> </p>

<p><strong>进阶：</strong> 你可以使用一趟扫描完成反转吗？</p>


## 题解


### Java

```Java
// @Title: 反转链表 II (Reverse Linked List II)
// @Author: robert.sunq
// @Date: 2021-07-11 22:26:55
// @Runtime: 0 ms
// @Memory: 35.6 MB

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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int i = 1;
        ListNode p = head;
        // 记录开始的位置
        ListNode pl = new ListNode();
        // 记录开始位置的前一节点
        ListNode pre = new ListNode(),res;
        // 添加一个头节点
        pre.next = head;
        // 记录链表的开始，因为可能从第一个节点就开始反转，所以需要二维记忆
        res = pre;
        while(p != null){
            // 开始节点
            if(i == left){
                pl = p;
            }else if ( i > left && i <= right){
                // 中间交换的位置 ， 采用头插法
                pl.next = p.next;
                p.next = pre.next;
                pre.next = p;
                // 将p恢复到最后访问的位置
                p = pl;
            }else {
                // pre 记录开始的前一个节点
                pre = p;
            }
            i++;
            p = p.next;
        }
        return res.next;
    }
}
```



## 相关话题

- [链表](https://leetcode.cn//tag/linked-list)

## 相似题目


- [反转链表](../reverse-linked-list/README.md)
