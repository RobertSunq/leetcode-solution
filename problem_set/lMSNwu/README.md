
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer II 025. 链表中的两数相加](https://leetcode.cn//problems/lMSNwu/)

## 题目描述

<p>给定两个 <strong>非空链表</strong> <code>l1</code>和 <code>l2</code>&nbsp;来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。</p>

<p>可以假设除了数字 0 之外，这两个数字都不会以零开头。</p>

<p>&nbsp;</p>

<p><strong>示例1：</strong></p>

<p><img alt="" src="https://pic.leetcode-cn.com/1626420025-fZfzMX-image.png" style="width: 302px; " /></p>

<pre>
<strong>输入：</strong>l1 = [7,2,4,3], l2 = [5,6,4]
<strong>输出：</strong>[7,8,0,7]
</pre>

<p><strong>示例2：</strong></p>

<pre>
<strong>输入：</strong>l1 = [2,4,3], l2 = [5,6,4]
<strong>输出：</strong>[8,0,7]
</pre>

<p><strong>示例3：</strong></p>

<pre>
<strong>输入：</strong>l1 = [0], l2 = [0]
<strong>输出：</strong>[0]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li>链表的长度范围为<code> [1, 100]</code></li>
	<li><code>0 &lt;= node.val &lt;= 9</code></li>
	<li>输入数据保证链表代表的数字无前导 0</li>
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong>如果输入链表不能修改该如何处理？换句话说，不能对列表中的节点进行翻转。</p>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 445&nbsp;题相同：<a href="https://leetcode-cn.com/problems/add-two-numbers-ii/">https://leetcode-cn.com/problems/add-two-numbers-ii/</a></p>


## 题解


### Java

```Java
// @Title: 链表中的两数相加 (链表中的两数相加)
// @Author: robert.sunq
// @Date: 2023-06-25 23:13:46
// @Runtime: 1 ms
// @Memory: 41.9 MB

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }
        
        ListNode p1 = l1, p2 = l2;
        int n = 0, m  = 0;
        while (p1 != null) {
            p1 = p1.next;
            n++;
        }
        while (p2 != null) {
            p2 = p2.next;
            m++;
        }

        p1 = l1;
        p2 = l2;
        if (n < m) {
            p1 = l2;
            p2 = l1;
            int tmp = n;
            n = m;
            m = tmp;
        }

        ListNode ans = add(p1, p2, n - m);
        return ans.val > 0 ? ans : ans.next; 
    }

    private ListNode add(ListNode l1, ListNode l2, int n) {
        if (n > 0) {
            ListNode p = add(l1.next, l2, --n);
            int tmp = p.val + l1.val;
            ListNode ans  = new ListNode(tmp / 10);
            p.val = tmp % 10;
            ans.next = p;
            return ans;
        }
        if (l1.next == null) {
            int tmp = l1.val + l2.val;
            ListNode ans  = new ListNode(tmp / 10);
            ans.next = new ListNode(tmp % 10);
            return ans;
        }
        ListNode p = add(l1.next, l2.next, n);
        int tmp = p.val + l1.val + l2.val;
        ListNode ans  = new ListNode(tmp / 10);
        p.val = tmp % 10;
        ans.next = p;
        return ans;
    }
}
```



## 相关话题

- [栈](https://leetcode.cn//tag/stack)
- [链表](https://leetcode.cn//tag/linked-list)
- [数学](https://leetcode.cn//tag/math)

## 相似题目



