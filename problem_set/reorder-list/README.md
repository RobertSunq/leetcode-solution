
| [English](README_EN.md) | 简体中文 |

# [143. 重排链表](https://leetcode.cn//problems/reorder-list/)

## 题目描述

<p>给定一个单链表 <code>L</code><em> </em>的头节点 <code>head</code> ，单链表 <code>L</code> 表示为：</p>

<pre>
L<sub>0</sub> → L<sub>1</sub> → … → L<sub>n - 1</sub> → L<sub>n</sub>
</pre>

<p>请将其重新排列后变为：</p>

<pre>
L<sub>0</sub> → L<sub>n</sub> → L<sub>1</sub> → L<sub>n - 1</sub> → L<sub>2</sub> → L<sub>n - 2</sub> → …</pre>

<p>不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://pic.leetcode-cn.com/1626420311-PkUiGI-image.png" style="width: 240px; " /></p>

<pre>
<strong>输入：</strong>head = [1,2,3,4]
<strong>输出：</strong>[1,4,2,3]</pre>

<p><strong>示例 2：</strong></p>

<p><img alt="" src="https://pic.leetcode-cn.com/1626420320-YUiulT-image.png" style="width: 320px; " /></p>

<pre>
<strong>输入：</strong>head = [1,2,3,4,5]
<strong>输出：</strong>[1,5,2,4,3]</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li>链表的长度范围为 <code>[1, 5 * 10<sup>4</sup>]</code></li>
	<li><code>1 &lt;= node.val &lt;= 1000</code></li>
</ul>


## 题解


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



## 相关话题

- [栈](https://leetcode.cn//tag/stack)
- [递归](https://leetcode.cn//tag/recursion)
- [链表](https://leetcode.cn//tag/linked-list)
- [双指针](https://leetcode.cn//tag/two-pointers)

## 相似题目



