
| English | [简体中文](README.md) |

# [114. Flatten Binary Tree to Linked List](https://leetcode.cn//problems/flatten-binary-tree-to-linked-list/)

## Description

<p>Given the <code>root</code> of a binary tree, flatten the tree into a &quot;linked list&quot;:</p>

<ul>
	<li>The &quot;linked list&quot; should use the same <code>TreeNode</code> class where the <code>right</code> child pointer points to the next node in the list and the <code>left</code> child pointer is always <code>null</code>.</li>
	<li>The &quot;linked list&quot; should be in the same order as a <a href="https://en.wikipedia.org/wiki/Tree_traversal#Pre-order,_NLR" target="_blank"><strong>pre-order</strong><strong> traversal</strong></a> of the binary tree.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/14/flaten.jpg" style="width: 500px; height: 226px;" />
<pre>
<strong>Input:</strong> root = [1,2,5,3,4,null,6]
<strong>Output:</strong> [1,null,2,null,3,null,4,null,5,null,6]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> root = []
<strong>Output:</strong> []
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> root = [0]
<strong>Output:</strong> [0]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[0, 2000]</code>.</li>
	<li><code>-100 &lt;= Node.val &lt;= 100</code></li>
</ul>

<p>&nbsp;</p>
<strong>Follow up:</strong> Can you flatten the tree in-place (with <code>O(1)</code> extra space)?

## Solutions


### Java

```Java
// @Title: 二叉树展开为链表 (Flatten Binary Tree to Linked List)
// @Author: robert.sunq
// @Date: 2021-06-15 00:39:40
// @Runtime: 2 ms
// @Memory: 37.7 MB

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> st = new Stack<>();
        TreeNode head = new TreeNode();
        // pre 先序遍历的前一节点，p 当前节点
        TreeNode pre = head,p = root;
        st.push(root);
        while(!st.isEmpty() ){
            p = st.pop();
            // 前一个节点的“尾指针”指向当前节点
            pre.right = p;
            pre.left = null;
            // 保存下一轮的当前节点
            pre = pre.right;
            if(p.right != null) st.push(p.right);
            if(p.left != null) st.push(p.left); 
        }
        pre.left = null;

    }
}
```



## Related Topics

- [Stack](https://leetcode.cn//tag/stack)
- [Tree](https://leetcode.cn//tag/tree)
- [Depth-First Search](https://leetcode.cn//tag/depth-first-search)
- [Linked List](https://leetcode.cn//tag/linked-list)
- [Binary Tree](https://leetcode.cn//tag/binary-tree)

## Similar Questions

- [Flatten a Multilevel Doubly Linked List](../flatten-a-multilevel-doubly-linked-list/README_EN.md)
