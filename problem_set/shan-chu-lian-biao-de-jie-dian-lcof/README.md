
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer 18. 删除链表的节点](https://leetcode.cn//problems/shan-chu-lian-biao-de-jie-dian-lcof/)

## 题目描述

<p>给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。</p>

<p>返回删除后的链表的头节点。</p>

<p><strong>注意：</strong>此题对比原题有改动</p>

<p><strong>示例 1:</strong></p>

<pre><strong>输入:</strong> head = [4,5,1,9], val = 5
<strong>输出:</strong> [4,1,9]
<strong>解释: </strong>给定你链表中值为&nbsp;5&nbsp;的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -&gt; 1 -&gt; 9.
</pre>

<p><strong>示例 2:</strong></p>

<pre><strong>输入:</strong> head = [4,5,1,9], val = 1
<strong>输出:</strong> [4,5,9]
<strong>解释: </strong>给定你链表中值为&nbsp;1&nbsp;的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -&gt; 5 -&gt; 9.
</pre>

<p>&nbsp;</p>

<p><strong>说明：</strong></p>

<ul>
	<li>题目保证链表中节点的值互不相同</li>
	<li>若使用 C 或 C++ 语言，你不需要 <code>free</code> 或 <code>delete</code> 被删除的节点</li>
</ul>


## 题解


### Java

```Java
// @Title: 删除链表的节点 (删除链表的节点 LCOF)
// @Author: robert.sunq
// @Date: 2021-05-25 23:37:52
// @Runtime: 0 ms
// @Memory: 37.7 MB

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
       if(head.val == val) return head.next;
        ListNode pre = head, cur = head.next;
        // 找到第一个相等的点，保存其位置
        while(cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        // 如果该点存在，则删除该点。
        if(cur != null) pre.next = cur.next;
        return head;

    }
}
```



## 相关话题

- [链表](https://leetcode.cn//tag/linked-list)

## 相似题目



