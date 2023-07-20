
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer II 078. 合并排序链表](https://leetcode.cn//problems/vvXgSW/)

## 题目描述

<p>给定一个链表数组，每个链表都已经按升序排列。</p>

<p>请将所有链表合并到一个升序链表中，返回合并后的链表。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>lists = [[1,4,5],[1,3,4],[2,6]]
<strong>输出：</strong>[1,1,2,3,4,4,5,6]
<strong>解释：</strong>链表数组如下：
[
  1-&gt;4-&gt;5,
  1-&gt;3-&gt;4,
  2-&gt;6
]
将它们合并到一个有序链表中得到。
1-&gt;1-&gt;2-&gt;3-&gt;4-&gt;4-&gt;5-&gt;6
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>lists = []
<strong>输出：</strong>[]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>lists = [[]]
<strong>输出：</strong>[]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>k == lists.length</code></li>
	<li><code>0 &lt;= k &lt;= 10^4</code></li>
	<li><code>0 &lt;= lists[i].length &lt;= 500</code></li>
	<li><code>-10^4 &lt;= lists[i][j] &lt;= 10^4</code></li>
	<li><code>lists[i]</code> 按 <strong>升序</strong> 排列</li>
	<li><code>lists[i].length</code> 的总和不超过 <code>10^4</code></li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 23&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/merge-k-sorted-lists/">https://leetcode-cn.com/problems/merge-k-sorted-lists/</a></p>


## 题解


### Java

```Java
// @Title: 合并排序链表 (合并排序链表)
// @Author: robert.sunq
// @Date: 2023-07-20 22:30:39
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
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if (n < 1) {
            return null;
        }

        // 设置归并的步长
        for (int step =  1; step < n; ) {
            // 起始下标
            int indexHeadOne = 0;
            while (indexHeadOne < n) {
                // 获取需要归并的两个
                ListNode head1 = lists[indexHeadOne];
                // 第二个不存在就是null
                ListNode head2 = indexHeadOne + step < n ? lists[indexHeadOne + step] : null;

                // 合并两个
                ListNode merge = merge(head1, head2);

                // 放到随意是1的位置上上
                lists[indexHeadOne] = merge;

                // 下一个区间
                indexHeadOne = indexHeadOne + step + step;
            }
            step = step << 1;
        }

        return lists[0];
    }

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
        }
        if (p2 != null) {
            p.next = p2;
        }
        return head.next;
    }
}
```



## 相关话题

- [链表](https://leetcode.cn//tag/linked-list)
- [分治](https://leetcode.cn//tag/divide-and-conquer)
- [堆（优先队列）](https://leetcode.cn//tag/heap-priority-queue)
- [归并排序](https://leetcode.cn//tag/merge-sort)

## 相似题目



