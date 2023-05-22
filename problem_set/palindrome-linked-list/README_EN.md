
| English | [简体中文](README.md) |

# [234. Palindrome Linked List](https://leetcode.cn//problems/palindrome-linked-list/)

## Description

<p>Given the <code>head</code> of a singly linked list, return <code>true</code><em> if it is a </em><span data-keyword="palindrome-sequence"><em>palindrome</em></span><em> or </em><code>false</code><em> otherwise</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/03/pal1linked-list.jpg" style="width: 422px; height: 62px;" />
<pre>
<strong>Input:</strong> head = [1,2,2,1]
<strong>Output:</strong> true
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/03/pal2linked-list.jpg" style="width: 182px; height: 62px;" />
<pre>
<strong>Input:</strong> head = [1,2]
<strong>Output:</strong> false
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the list is in the range <code>[1, 10<sup>5</sup>]</code>.</li>
	<li><code>0 &lt;= Node.val &lt;= 9</code></li>
</ul>

<p>&nbsp;</p>
<strong>Follow up:</strong> Could you do it in <code>O(n)</code> time and <code>O(1)</code> space?

## Solutions


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



## Related Topics

- [Stack](https://leetcode.cn//tag/stack)
- [Recursion](https://leetcode.cn//tag/recursion)
- [Linked List](https://leetcode.cn//tag/linked-list)
- [Two Pointers](https://leetcode.cn//tag/two-pointers)

## Similar Questions

- [Palindrome Number](../palindrome-number/README_EN.md)
- [Valid Palindrome](../valid-palindrome/README_EN.md)
- [Reverse Linked List](../reverse-linked-list/README_EN.md)
