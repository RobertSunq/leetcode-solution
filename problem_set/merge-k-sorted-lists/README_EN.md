
| English | [简体中文](README.md) |

# [23. Merge k Sorted Lists](https://leetcode.cn//problems/merge-k-sorted-lists/)

## Description

<p>You are given an array of <code>k</code> linked-lists <code>lists</code>, each linked-list is sorted in ascending order.</p>

<p><em>Merge all the linked-lists into one sorted linked-list and return it.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> lists = [[1,4,5],[1,3,4],[2,6]]
<strong>Output:</strong> [1,1,2,3,4,4,5,6]
<strong>Explanation:</strong> The linked-lists are:
[
  1-&gt;4-&gt;5,
  1-&gt;3-&gt;4,
  2-&gt;6
]
merging them into one sorted list:
1-&gt;1-&gt;2-&gt;3-&gt;4-&gt;4-&gt;5-&gt;6
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> lists = []
<strong>Output:</strong> []
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> lists = [[]]
<strong>Output:</strong> []
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>k == lists.length</code></li>
	<li><code>0 &lt;= k &lt;= 10<sup>4</sup></code></li>
	<li><code>0 &lt;= lists[i].length &lt;= 500</code></li>
	<li><code>-10<sup>4</sup> &lt;= lists[i][j] &lt;= 10<sup>4</sup></code></li>
	<li><code>lists[i]</code> is sorted in <strong>ascending order</strong>.</li>
	<li>The sum of <code>lists[i].length</code> will not exceed <code>10<sup>4</sup></code>.</li>
</ul>


## Solutions


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



## Related Topics

- [Linked List](https://leetcode.cn//tag/linked-list)
- [Divide and Conquer](https://leetcode.cn//tag/divide-and-conquer)
- [Heap (Priority Queue)](https://leetcode.cn//tag/heap-priority-queue)
- [Merge Sort](https://leetcode.cn//tag/merge-sort)

## Similar Questions

- [Merge Two Sorted Lists](../merge-two-sorted-lists/README_EN.md)
- [Ugly Number II](../ugly-number-ii/README_EN.md)
