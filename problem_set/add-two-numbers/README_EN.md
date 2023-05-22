
| English | [简体中文](README.md) |

# [2. Add Two Numbers](https://leetcode.cn//problems/add-two-numbers/)

## Description

<p>You are given two <strong>non-empty</strong> linked lists representing two non-negative integers. The digits are stored in <strong>reverse order</strong>, and each of their nodes contains a single digit. Add the two numbers and return the sum&nbsp;as a linked list.</p>

<p>You may assume the two numbers do not contain any leading zero, except the number 0 itself.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/02/addtwonumber1.jpg" style="width: 483px; height: 342px;" />
<pre>
<strong>Input:</strong> l1 = [2,4,3], l2 = [5,6,4]
<strong>Output:</strong> [7,0,8]
<strong>Explanation:</strong> 342 + 465 = 807.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> l1 = [0], l2 = [0]
<strong>Output:</strong> [0]
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
<strong>Output:</strong> [8,9,9,9,0,0,0,1]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in each linked list is in the range <code>[1, 100]</code>.</li>
	<li><code>0 &lt;= Node.val &lt;= 9</code></li>
	<li>It is guaranteed that the list represents a number that does not have leading zeros.</li>
</ul>


## Solutions


### Java

```Java
// @Title: 两数相加 (Add Two Numbers)
// @Author: robert.sunq
// @Date: 2021-06-01 21:36:40
// @Runtime: 2 ms
// @Memory: 38.9 MB

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
        ListNode res = new ListNode(0);
        ListNode p ;
        p = res;
        int ad = 0;
        while(l1 != null && l2 != null){
            int t = l1.val+l2.val + ad;
            ListNode temp = new ListNode(t % 10);
            ad = t/10;
            p.next = temp;
            p = p.next;
            l1 = l1.next;
            l2 = l2.next; 
        }
        while(l1 != null){
            int t = l1.val+ad;
            ListNode temp = new ListNode(t % 10);
            ad = t/10;
            p.next = temp;
            l1 = l1.next;
            p = p.next;
        }
        while(l2 != null){
            int t = l2.val+ad;
            ListNode temp = new ListNode(t % 10);
            ad = t/10;
            p.next = temp;
            l2 = l2.next;
            p = p.next;
        }
        if(ad != 0){
            ListNode temp = new ListNode(ad % 10);
            ad = ad/10;
            p.next = temp;
        }
        return res.next;
    }
}
```



## Related Topics

- [Recursion](https://leetcode.cn//tag/recursion)
- [Linked List](https://leetcode.cn//tag/linked-list)
- [Math](https://leetcode.cn//tag/math)

## Similar Questions

- [Multiply Strings](../multiply-strings/README_EN.md)
- [Add Binary](../add-binary/README_EN.md)
- [Sum of Two Integers](../sum-of-two-integers/README_EN.md)
- [Add Strings](../add-strings/README_EN.md)
- [Add Two Numbers II](../add-two-numbers-ii/README_EN.md)
- [Add to Array-Form of Integer](../add-to-array-form-of-integer/README_EN.md)
