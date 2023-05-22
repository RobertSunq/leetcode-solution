
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer 35. 复杂链表的复制](https://leetcode.cn//problems/fu-za-lian-biao-de-fu-zhi-lcof/)

## 题目描述

<p>请实现 <code>copyRandomList</code> 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 <code>next</code> 指针指向下一个节点，还有一个 <code>random</code> 指针指向链表中的任意节点或者 <code>null</code>。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/01/09/e1.png"></p>

<pre><strong>输入：</strong>head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
<strong>输出：</strong>[[7,null],[13,0],[11,4],[10,2],[1,0]]
</pre>

<p><strong>示例 2：</strong></p>

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/01/09/e2.png"></p>

<pre><strong>输入：</strong>head = [[1,1],[2,1]]
<strong>输出：</strong>[[1,1],[2,1]]
</pre>

<p><strong>示例 3：</strong></p>

<p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/01/09/e3.png"></strong></p>

<pre><strong>输入：</strong>head = [[3,null],[3,0],[3,null]]
<strong>输出：</strong>[[3,null],[3,0],[3,null]]
</pre>

<p><strong>示例 4：</strong></p>

<pre><strong>输入：</strong>head = []
<strong>输出：</strong>[]
<strong>解释：</strong>给定的链表为空（空指针），因此返回 null。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>-10000 &lt;= Node.val &lt;= 10000</code></li>
	<li><code>Node.random</code>&nbsp;为空（null）或指向链表中的节点。</li>
	<li>节点数目不超过 1000 。</li>
</ul>

<p>&nbsp;</p>

<p><strong>注意：</strong>本题与主站 138 题相同：<a href="https://leetcode-cn.com/problems/copy-list-with-random-pointer/">https://leetcode-cn.com/problems/copy-list-with-random-pointer/</a></p>

<p>&nbsp;</p>


## 题解


### Java

```Java
// @Title: 复杂链表的复制 (复杂链表的复制  LCOF)
// @Author: robert.sunq
// @Date: 2021-05-28 00:03:19
// @Runtime: 4 ms
// @Memory: 38.4 MB

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node p = head;
        Node nhead = new Node(0);
        Node np = nhead;
        LinkedList<Node> temp = new  LinkedList<>();
        LinkedList<Node> ntemp =new  LinkedList<>();
        while(p != null) {
            np.next = new Node(p.val);
            temp.add(p);
            p = p.next;
            np = np.next;
            ntemp.add(np);
        }
        p = head;
        np = nhead.next;
        while(p != null){
            int index = temp.indexOf(p.random);
            if(index >= 0) np.random = ntemp.get(index);
            p = p.next;
            np = np.next;
        }
        return nhead.next;
    }
}
```



## 相关话题

- [哈希表](https://leetcode.cn//tag/hash-table)
- [链表](https://leetcode.cn//tag/linked-list)

## 相似题目



