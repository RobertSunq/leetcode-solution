
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer II 027. 回文链表](https://leetcode.cn//problems/aMhZSa/)

## 题目描述

<p>给定一个链表的 <strong>头节点&nbsp;</strong><code>head</code><strong>&nbsp;，</strong>请判断其是否为回文链表。</p>

<p>如果一个链表是回文，那么链表节点序列从前往后看和从后往前看是相同的。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><strong><img alt="" src="https://pic.leetcode-cn.com/1626421737-LjXceN-image.png" /></strong></p>

<pre>
<strong>输入:</strong> head = [1,2,3,3,2,1]
<strong>输出:</strong> true</pre>

<p><strong>示例 2：</strong></p>

<p><strong><img alt="" src="https://pic.leetcode-cn.com/1626422231-wgvnWh-image.png" style="width: 138px; height: 62px;" /></strong></p>

<pre>
<strong>输入:</strong> head = [1,2]
<strong>输出:</strong> false
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li>链表 L 的长度范围为 <code>[1, 10<sup><span style="font-size: 9.449999809265137px;">5</span></sup>]</code></li>
	<li><code>0&nbsp;&lt;= node.val &lt;= 9</code></li>
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong>能否用&nbsp;O(n) 时间复杂度和 O(1) 空间复杂度解决此题？</p>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 234&nbsp;题相同：<a href="https://leetcode-cn.com/problems/palindrome-linked-list/">https://leetcode-cn.com/problems/palindrome-linked-list/</a></p>


## 题解


### Java

```Java
// @Title: 回文链表 (回文链表)
// @Author: robert.sunq
// @Date: 2023-06-26 22:56:59
// @Runtime: 3 ms
// @Memory: 57.8 MB

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
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        ListNode slowP = head, fastP = head;
        while (fastP != null && fastP.next != null) {
            slowP = slowP.next;
            fastP = fastP.next.next;
        }

        if (fastP != null) {
            slowP = slowP.next;
        }
        fastP = head;
        slowP = reverseList(slowP);
        while (slowP != null) {
            if (slowP.val != fastP.val) {
                return false;
            }
            slowP = slowP.next;
            fastP = fastP.next;
        }

        return true;
    }

    private ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode p = head.next;
            ListNode pre = head;
            ListNode tmp = p;
            head.next = null;
            while (p != null) {
                tmp = p.next;
                p.next = pre;
                pre = p;
                p = tmp;
            }

            return pre;
        }
}
```



## 相关话题

- [栈](https://leetcode.cn//tag/stack)
- [递归](https://leetcode.cn//tag/recursion)
- [链表](https://leetcode.cn//tag/linked-list)
- [双指针](https://leetcode.cn//tag/two-pointers)

## 相似题目



