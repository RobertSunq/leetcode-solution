
| [English](README_EN.md) | 简体中文 |

# [2. 两数相加](https://leetcode.cn//problems/add-two-numbers/)

## 题目描述

<p>给你两个 <strong>非空</strong> 的链表，表示两个非负的整数。它们每位数字都是按照 <strong>逆序</strong> 的方式存储的，并且每个节点只能存储 <strong>一位</strong> 数字。</p>

<p>请你将两个数相加，并以相同形式返回一个表示和的链表。</p>

<p>你可以假设除了数字 0 之外，这两个数都不会以 0 开头。</p>

<p> </p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2021/01/02/addtwonumber1.jpg" style="width: 483px; height: 342px;" />
<pre>
<strong>输入：</strong>l1 = [2,4,3], l2 = [5,6,4]
<strong>输出：</strong>[7,0,8]
<strong>解释：</strong>342 + 465 = 807.
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>l1 = [0], l2 = [0]
<strong>输出：</strong>[0]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
<strong>输出：</strong>[8,9,9,9,0,0,0,1]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li>每个链表中的节点数在范围 <code>[1, 100]</code> 内</li>
	<li><code>0 <= Node.val <= 9</code></li>
	<li>题目数据保证列表表示的数字不含前导零</li>
</ul>


## 题解


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



## 相关话题

- [递归](https://leetcode.cn//tag/recursion)
- [链表](https://leetcode.cn//tag/linked-list)
- [数学](https://leetcode.cn//tag/math)

## 相似题目


- [字符串相乘](../multiply-strings/README.md)
- [二进制求和](../add-binary/README.md)
- [两整数之和](../sum-of-two-integers/README.md)
- [字符串相加](../add-strings/README.md)
- [两数相加 II](../add-two-numbers-ii/README.md)
- [数组形式的整数加法](../add-to-array-form-of-integer/README.md)
