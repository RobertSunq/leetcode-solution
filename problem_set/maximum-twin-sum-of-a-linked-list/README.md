
| [English](README_EN.md) | 简体中文 |

# [2130. 链表最大孪生和](https://leetcode.cn//problems/maximum-twin-sum-of-a-linked-list/)

## 题目描述

<p>在一个大小为&nbsp;<code>n</code>&nbsp;且 <code>n</code>&nbsp;为&nbsp;<strong>偶数</strong> 的链表中，对于&nbsp;<code>0 &lt;= i &lt;= (n / 2) - 1</code>&nbsp;的 <code>i</code>&nbsp;，第&nbsp;<code>i</code>&nbsp;个节点（下标从 <strong>0</strong>&nbsp;开始）的孪生节点为第&nbsp;<code>(n-1-i)</code>&nbsp;个节点 。</p>

<ul>
	<li>比方说，<code>n = 4</code>&nbsp;那么节点&nbsp;<code>0</code>&nbsp;是节点 <code>3</code>&nbsp;的孪生节点，节点 <code>1</code>&nbsp;是节点 <code>2</code>&nbsp;的孪生节点。这是长度为 <code><span style="">n = 4</span></code>&nbsp;的链表中所有的孪生节点。</li>
</ul>

<p><strong>孪生和</strong>&nbsp;定义为一个节点和它孪生节点两者值之和。</p>

<p>给你一个长度为偶数的链表的头节点&nbsp;<code>head</code>&nbsp;，请你返回链表的 <strong>最大孪生和</strong>&nbsp;。</p>

<p>&nbsp;</p>

<p><strong>示例&nbsp;1：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2021/12/03/eg1drawio.png" style="width: 250px; height: 70px;"></p>

<pre><b>输入：</b>head = [5,4,2,1]
<b>输出：</b>6
<strong>解释：</strong>
节点 0 和节点 1 分别是节点 3 和 2 的孪生节点。孪生和都为 6 。
链表中没有其他孪生节点。
所以，链表的最大孪生和是 6 。
</pre>

<p><strong>示例 2：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2021/12/03/eg2drawio.png" style="width: 250px; height: 70px;"></p>

<pre><b>输入：</b>head = [4,2,2,3]
<b>输出：</b>7
<strong>解释：</strong>
链表中的孪生节点为：
- 节点 0 是节点 3 的孪生节点，孪生和为 4 + 3 = 7 。
- 节点 1 是节点 2 的孪生节点，孪生和为 2 + 2 = 4 。
所以，最大孪生和为 max(7, 4) = 7 。
</pre>

<p><strong>示例 3：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2021/12/03/eg3drawio.png" style="width: 200px; height: 88px;"></p>

<pre><b>输入：</b>head = [1,100000]
<b>输出：</b>100001
<strong>解释：</strong>
链表中只有一对孪生节点，孪生和为 1 + 100000 = 100001 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li>链表的节点数目是&nbsp;<code>[2, 10<sup>5</sup>]</code>&nbsp;中的&nbsp;<strong>偶数</strong>&nbsp;。</li>
	<li><code>1 &lt;= Node.val &lt;= 10<sup>5</sup></code></li>
</ul>


## 题解


### Java

```Java
// @Title: 链表最大孪生和 (Maximum Twin Sum of a Linked List)
// @Author: robert.sunq
// @Date: 2023-09-02 16:57:42
// @Runtime: 9 ms
// @Memory: 66.3 MB

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
    public int pairSum(ListNode head) {
        int n = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            n++;
        }

        int i = 0;
        ListNode head1;
        int size = n / 2;
        p = head;
        while(i < size) {
            p = p.next;
            i++;
        }
        head1 = reserveDFS(p);

        int ans = 0;
        p = head;
        while (head1 != null) {
            int tmp = p.val + head1.val;
            ans = Math.max(tmp, ans);
            p = p.next;
            head1 = head1.next;
        }

        return ans;
    }

    private ListNode reserveDFS(ListNode head){
        if (head.next == null) {
            return head;
        }
        ListNode newHead = reserveDFS(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
```



## 相关话题

- [栈](https://leetcode.cn//tag/stack)
- [链表](https://leetcode.cn//tag/linked-list)
- [双指针](https://leetcode.cn//tag/two-pointers)

## 相似题目



