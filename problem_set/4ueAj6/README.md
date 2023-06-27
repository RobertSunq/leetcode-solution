
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer II 029. 排序的循环链表](https://leetcode.cn//problems/4ueAj6/)

## 题目描述

<p>给定<strong>循环单调非递减列表</strong>中的一个点，写一个函数向这个列表中插入一个新元素&nbsp;<code>insertVal</code> ，使这个列表仍然是循环升序的。</p>

<p>给定的可以是这个列表中任意一个顶点的指针，并不一定是这个列表中最小元素的指针。</p>

<p>如果有多个满足条件的插入位置，可以选择任意一个位置插入新的值，插入后整个列表仍然保持有序。</p>

<p>如果列表为空（给定的节点是 <code>null</code>），需要创建一个循环有序列表并返回这个节点。否则。请返回原先给定的节点。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2019/01/19/example_1_before_65p.jpg" style="height: 149px; width: 250px;" /><br />
&nbsp;</p>

<pre>
<strong>输入：</strong>head = [3,4,1], insertVal = 2
<strong>输出：</strong>[3,4,1,2]
<strong>解释：</strong>在上图中，有一个包含三个元素的循环有序列表，你获得值为 3 的节点的指针，我们需要向表中插入元素 2 。新插入的节点应该在 1 和 3 之间，插入之后，整个列表如上图所示，最后返回节点 3 。

<img alt="" src="https://assets.leetcode.com/uploads/2019/01/19/example_1_after_65p.jpg" style="height: 149px; width: 250px;" />
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>head = [], insertVal = 1
<strong>输出：</strong>[1]
<strong>解释：</strong>列表为空（给定的节点是 <code>null</code>），创建一个循环有序列表并返回这个节点。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>head = [1], insertVal = 0
<strong>输出：</strong>[1,0]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>0 &lt;= Number of Nodes &lt;= 5 * 10^4</code></li>
	<li><code><font face="monospace">-10^6 &lt;= Node.val &lt;= 10^6</font></code></li>
	<li><code>-10^6 &lt;=&nbsp;insertVal &lt;= 10^6</code></li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 708&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/insert-into-a-sorted-circular-linked-list/">https://leetcode-cn.com/problems/insert-into-a-sorted-circular-linked-list/</a></p>


## 题解


### Java

```Java
// @Title: 排序的循环链表 (排序的循环链表)
// @Author: robert.sunq
// @Date: 2023-06-27 23:16:46
// @Runtime: 0 ms
// @Memory: 40.7 MB

/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        Node newNode = new Node(insertVal);
        if (head == null) {
            newNode.next = newNode;;
            return newNode;
        }

        if (head.next == head) {
            newNode.next = head.next;
            head.next.next = newNode;
            return head;
        }
        
        Node p = head.next;
        Node pre = head;

        // 找到交变点
        while(p != head) {
            if (p.val < pre.val) {
                break;
            }
            p = p.next;
            pre = pre.next;
        }
        // 拆循环连
        pre.next = null;
        Node last = pre;
        Node first = new Node();
        first.next = p;
        pre = first;

        while (p != null) {
            if (p.val >= insertVal) {
                pre.next = newNode;
                newNode.next = p;
                break;
            }
            p = p.next;
            pre = pre.next;
        }

        // 将循环链恢复， 如果p是null则插入值是最大值
        if (p == null) {
            pre.next = newNode;
            last = newNode;
        }

        last.next = first.next;

        return head;

    }
}
```



## 相关话题

- [链表](https://leetcode.cn//tag/linked-list)

## 相似题目



