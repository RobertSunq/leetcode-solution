
| English | [简体中文](README.md) |

# [117. Populating Next Right Pointers in Each Node II](https://leetcode.cn//problems/populating-next-right-pointers-in-each-node-ii/)

## Description

<p>Given a binary tree</p>

<pre>
struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
</pre>

<p>Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to <code>NULL</code>.</p>

<p>Initially, all next pointers are set to <code>NULL</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2019/02/15/117_sample.png" style="width: 500px; height: 171px;" />
<pre>
<strong>Input:</strong> root = [1,2,3,4,5,null,7]
<strong>Output:</strong> [1,#,2,3,#,4,5,7,#]
<strong>Explanation: </strong>Given the above binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with &#39;#&#39; signifying the end of each level.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> root = []
<strong>Output:</strong> []
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[0, 6000]</code>.</li>
	<li><code>-100 &lt;= Node.val &lt;= 100</code></li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow-up:</strong></p>

<ul>
	<li>You may only use constant extra space.</li>
	<li>The recursive approach is fine. You may assume implicit stack space does not count as extra space for this problem.</li>
</ul>


## Solutions


### Java

```Java
// @Title: 填充每个节点的下一个右侧节点指针 II (Populating Next Right Pointers in Each Node II)
// @Author: robert.sunq
// @Date: 2023-11-03 21:28:23
// @Runtime: 1 ms
// @Memory: 42 MB

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null ) {
            return root;
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);

        Node p;
        Node prv;
        while (!queue.isEmpty()) {
            prv = queue.peek();
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                p = queue.poll();
                prv.next = p;
                if (p.left != null) {
                    queue.offer(p.left);
                }
                if (p.right != null) {
                    queue.offer(p.right);
                }
                prv = p;
            }
            prv.next = null;
        }

        return root;

    }
}
```



## Related Topics

- [Tree](https://leetcode.cn//tag/tree)
- [Depth-First Search](https://leetcode.cn//tag/depth-first-search)
- [Breadth-First Search](https://leetcode.cn//tag/breadth-first-search)
- [Linked List](https://leetcode.cn//tag/linked-list)
- [Binary Tree](https://leetcode.cn//tag/binary-tree)

## Similar Questions

- [Populating Next Right Pointers in Each Node](../populating-next-right-pointers-in-each-node/README_EN.md)
