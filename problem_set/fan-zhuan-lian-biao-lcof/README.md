
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer 24. 反转链表](https://leetcode.cn//problems/fan-zhuan-lian-biao-lcof/)

## 题目描述

<p>定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。</p>

<p>&nbsp;</p>

<p><strong>示例:</strong></p>

<pre><strong>输入:</strong> 1-&gt;2-&gt;3-&gt;4-&gt;5-&gt;NULL
<strong>输出:</strong> 5-&gt;4-&gt;3-&gt;2-&gt;1-&gt;NULL</pre>

<p>&nbsp;</p>

<p><strong>限制：</strong></p>

<p><code>0 &lt;= 节点个数 &lt;= 5000</code></p>

<p>&nbsp;</p>

<p><strong>注意</strong>：本题与主站 206 题相同：<a href="https://leetcode-cn.com/problems/reverse-linked-list/">https://leetcode-cn.com/problems/reverse-linked-list/</a></p>


## 题解


### Java

```Java
// @Title: 反转链表 (反转链表 LCOF)
// @Author: robert.sunq
// @Date: 2021-08-03 22:07:32
// @Runtime: 0 ms
// @Memory: 38.4 MB

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        /**
        if(head == null) return null;
        // 头节点
        ListNode pre = new ListNode(head.val);
        ListNode p = head;
        while(p != null) {
            // 前插法
            ListNode temp = p.next;
            p.next = pre.next;
            pre.next = p;
            p = temp;
        }
        return pre.next;
         */
         if(head == null || head.next == null) return head;
         ListNode res = reverseList(head.next);
         head.next.next = head;
         head.next = null;
         return res;
    }
}
```



## 相关话题

- [递归](https://leetcode.cn//tag/recursion)
- [链表](https://leetcode.cn//tag/linked-list)

## 相似题目



