
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer II 077. 链表排序](https://leetcode.cn//problems/7WHec2/)

## 题目描述

<p>给定链表的头结点&nbsp;<code>head</code>&nbsp;，请将其按 <strong>升序</strong> 排列并返回 <strong>排序后的链表</strong> 。</p>

<ul>
</ul>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2020/09/14/sort_list_1.jpg" style="width: 302px; " /></p>

<pre>
<b>输入：</b>head = [4,2,1,3]
<b>输出：</b>[1,2,3,4]
</pre>

<p><strong>示例 2：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2020/09/14/sort_list_2.jpg" style="width: 402px; " /></p>

<pre>
<b>输入：</b>head = [-1,5,3,4,0]
<b>输出：</b>[-1,0,3,4,5]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<b>输入：</b>head = []
<b>输出：</b>[]
</pre>

<p>&nbsp;</p>

<p><b>提示：</b></p>

<ul>
	<li>链表中节点的数目在范围&nbsp;<code>[0, 5 * 10<sup>4</sup>]</code>&nbsp;内</li>
	<li><code>-10<sup>5</sup>&nbsp;&lt;= Node.val &lt;= 10<sup>5</sup></code></li>
</ul>

<p>&nbsp;</p>

<p><b>进阶：</b>你可以在&nbsp;<code>O(n&nbsp;log&nbsp;n)</code> 时间复杂度和常数级空间复杂度下，对链表进行排序吗？</p>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 148&nbsp;题相同：<a href="https://leetcode-cn.com/problems/sort-list/">https://leetcode-cn.com/problems/sort-list/</a></p>


## 题解


### Java

```Java
// @Title: 链表排序 (链表排序)
// @Author: robert.sunq
// @Date: 2023-07-19 23:43:46
// @Runtime: 8 ms
// @Memory: 47.4 MB

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
    
    // 归并排序
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }
        int length = 0;
        ListNode p = head;
        // 计算链表长度
        while (p != null) {
            length++;
            p = p.next;
        }
        ListNode ans = new ListNode();
        ans.next = head;
        // 标记 子链长度
        for (int subLength = 1; subLength < length; ) {
            // 用于将 两个子链归并的结果 放回原链
            ListNode prev = ans;
            p = ans.next;

            while (p != null) {
                // 拆分指定长度的子链
                ListNode head1 = p;
                // 注意这里， 从 1 开始，因为现在 head1 已经有一个节点了, 
                // 注意 当p 存在的时候 p.next 也不能为null, 保证可以正常处理第二个子链, 这样就不用过多判断了
                for (int i = 1; i < subLength && p != null && p.next != null; i++) {
                    p = p.next;
                }
                ListNode head2 = p.next;
                p.next = null;
                p = head2;
            
                // 注意 当p 存在的时候 p.next 也不能为null
                for (int i = 1; i < subLength && p != null && p.next != null; i++) {
                    p = p.next;
                }

                // 如果此时 拆除两个子链后还有剩余， 则缓存下来做后续的继续拆两个 子链归并
                ListNode next = null;
                if (p != null) {
                    next = p.next;
                    p.next = null;
                }
                // 归并
                ListNode mergeResult = merge(head1, head2);
                // 将结果拼接会对应的位置, 
                prev.next = mergeResult;

                // 注意 prev 到当前归并结果的最后一个节点
                while (prev.next != null) {
                    prev = prev.next;
                }
                // 继续处理剩余的链条
                p = next;
            }
            subLength = subLength << 1;
        }

        return ans.next;

    }

    // 合并两个有序链表
    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode head = new ListNode();

        ListNode p = head;
        ListNode p1 = head1;
        ListNode p2 = head2;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if (p1 != null) {
            p.next = p1;
        } else {
            p.next = p2;
        }

        return head.next;
    }
}
```



## 相关话题

- [链表](https://leetcode.cn//tag/linked-list)
- [双指针](https://leetcode.cn//tag/two-pointers)
- [分治](https://leetcode.cn//tag/divide-and-conquer)
- [排序](https://leetcode.cn//tag/sorting)
- [归并排序](https://leetcode.cn//tag/merge-sort)

## 相似题目


