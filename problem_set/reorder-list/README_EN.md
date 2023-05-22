
| English | [简体中文](README.md) |

# [143. Reorder List](https://leetcode.cn//problems/reorder-list/)

## Description

<p>You are given the head of a singly linked-list. The list can be represented as:</p>

<pre>
L<sub>0</sub> &rarr; L<sub>1</sub> &rarr; &hellip; &rarr; L<sub>n - 1</sub> &rarr; L<sub>n</sub>
</pre>

<p><em>Reorder the list to be on the following form:</em></p>

<pre>
L<sub>0</sub> &rarr; L<sub>n</sub> &rarr; L<sub>1</sub> &rarr; L<sub>n - 1</sub> &rarr; L<sub>2</sub> &rarr; L<sub>n - 2</sub> &rarr; &hellip;
</pre>

<p>You may not modify the values in the list&#39;s nodes. Only nodes themselves may be changed.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/04/reorder1linked-list.jpg" style="width: 422px; height: 222px;" />
<pre>
<strong>Input:</strong> head = [1,2,3,4]
<strong>Output:</strong> [1,4,2,3]
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/09/reorder2-linked-list.jpg" style="width: 542px; height: 222px;" />
<pre>
<strong>Input:</strong> head = [1,2,3,4,5]
<strong>Output:</strong> [1,5,2,4,3]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the list is in the range <code>[1, 5 * 10<sup>4</sup>]</code>.</li>
	<li><code>1 &lt;= Node.val &lt;= 1000</code></li>
</ul>


## Solutions


### Java

```Java
// @Title: 重排链表 (Reorder List)
// @Author: robert.sunq
// @Date: 2021-07-08 22:03:17
// @Runtime: 2 ms
// @Memory: 42.1 MB

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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode fast,slow,pre = new ListNode();
        fast = head;
        slow = head;
        // 快慢指针找到中点
        while(true){
            if(fast == null || fast.next == null){
                break;
            }
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // 反转后半段，并拆成两个链表
        pre.next = null;
        ListNode p = head,rp;
        rp = recur(slow);
        // 合并两个链表，且后半段链表长度必 大于等于前半段，故如果最后后半段有结余 放到整个链表最后面
        // 这里也可以将前半段  前插的方式放到后半段中
        while(rp != null && p!=null){
            // 拼接
            ListNode temp = rp.next;
            rp.next = p.next;
            p.next = rp;
            p = rp.next;
            // 保留最后边节点的前一个节点
            pre = rp;
            rp = temp;
        }
        if(rp != null){
            pre.next = rp;
        }
        
    }
    // 反转链表
    ListNode recur(ListNode p){
        if(p == null || p.next == null){
            return p;
        }
        ListNode temp = recur(p.next);
        p.next.next = p;
        p.next = null;
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


