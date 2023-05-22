
| [English](README_EN.md) | 简体中文 |

# [23. 合并 K 个升序链表](https://leetcode.cn//problems/merge-k-sorted-lists/)

## 题目描述

<p>给你一个链表数组，每个链表都已经按升序排列。</p>

<p>请你将所有链表合并到一个升序链表中，返回合并后的链表。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>lists = [[1,4,5],[1,3,4],[2,6]]
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

<pre><strong>输入：</strong>lists = []
<strong>输出：</strong>[]
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>lists = [[]]
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


## 题解


### Java

```Java
// @Title: 合并 K 个升序链表 (Merge k Sorted Lists)
// @Author: robert.sunq
// @Date: 2021-07-08 22:14:24
// @Runtime: 1 ms
// @Memory: 40 MB

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
        if(lists.length <= 0) return null;
        // 两两进行归并排序
        return recur(lists,0,lists.length-1);
    }
    ListNode recur(ListNode[] lists , int start,int end){
        // 指向同一个链表 返回
        if(start == end) return lists[start];
        // 分别合并左右两边链表
        ListNode left = recur(lists,start,(start + end)/2);
        ListNode right = recur(lists,(start+end)/2+1,end);
        return merge(left,right);
    }
    // 合并两个链表
    ListNode merge(ListNode left,ListNode right){
        ListNode head = new ListNode(),l,r;
        l = left;
        r = right;
        ListNode p = head;
        while(l !=null && r != null){
            if(l.val<=r.val){
                p.next = l;
                p = l;
                l = l.next;
            }else{
                p.next = r;
                p = r;
                r = r.next; 
            }
        }
        if(l != null){
            p.next = l;
        }
        if(r != null){
            p.next = r;
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


- [合并两个有序链表](../merge-two-sorted-lists/README.md)
- [丑数 II](../ugly-number-ii/README.md)
