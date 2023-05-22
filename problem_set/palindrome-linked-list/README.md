
| [English](README_EN.md) | 简体中文 |

# [234. 回文链表](https://leetcode.cn//problems/palindrome-linked-list/)

## 题目描述

<p>给你一个单链表的头节点 <code>head</code> ，请你判断该链表是否为回文链表。如果是，返回 <code>true</code> ；否则，返回 <code>false</code> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/03/pal1linked-list.jpg" style="width: 422px; height: 62px;" />
<pre>
<strong>输入：</strong>head = [1,2,2,1]
<strong>输出：</strong>true
</pre>

<p><strong>示例 2：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/03/pal2linked-list.jpg" style="width: 182px; height: 62px;" />
<pre>
<strong>输入：</strong>head = [1,2]
<strong>输出：</strong>false
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li>链表中节点数目在范围<code>[1, 10<sup>5</sup>]</code> 内</li>
	<li><code>0 &lt;= Node.val &lt;= 9</code></li>
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong>你能否用&nbsp;<code>O(n)</code> 时间复杂度和 <code>O(1)</code> 空间复杂度解决此题？</p>


## 题解


### Java

```Java
// @Title: 回文链表 (Palindrome Linked List)
// @Author: robert.sunq
// @Date: 2021-06-17 22:52:19
// @Runtime: 17 ms
// @Memory: 51 MB

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
    // 快慢指针 找到中点
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode low = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            low = low.next;
        }
        fast = recur(low.next);
        ListNode p = head;
        ListNode p1 = fast;
        boolean res = true;
        while(res && p1 != null){
            if(p.val != p1.val){
                res =  false;
            }
            p1 = p1.next;
            p = p.next;
        }
        // 还原列表
        low = recur(fast);
        return res;

    }

    // 反转后半段列表
    ListNode recur(ListNode head){
        // 找到最后一个 就是反转后的新头部
        if(head == null || head.next == null) return head;
        ListNode temp = recur(head.next);
        // 下一个节点的 next 指向当前节点
        head.next.next = head; 
        // 避免环，删掉当前节点与下一个节点的连接，即当前节点为目前的尾节点
        head.next = null;
        return temp;
    }
}
```



## 相关话题

- [栈](https://leetcode.cn//tag/stack)
- [递归](https://leetcode.cn//tag/recursion)
- [链表](https://leetcode.cn//tag/linked-list)
- [双指针](https://leetcode.cn//tag/two-pointers)

## 相似题目


- [回文数](../palindrome-number/README.md)
- [验证回文串](../valid-palindrome/README.md)
- [反转链表](../reverse-linked-list/README.md)
