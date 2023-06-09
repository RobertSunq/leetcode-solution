
| English | [简体中文](README.md) |

# [94. Binary Tree Inorder Traversal](https://leetcode.cn//problems/binary-tree-inorder-traversal/)

## Description

<p>Given the <code>root</code> of a binary tree, return <em>the inorder traversal of its nodes&#39; values</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/09/15/inorder_1.jpg" style="width: 125px; height: 200px;" />
<pre>
<strong>Input:</strong> root = [1,null,2,3]
<strong>Output:</strong> [1,3,2]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> root = []
<strong>Output:</strong> []
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> root = [1]
<strong>Output:</strong> [1]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[0, 100]</code>.</li>
	<li><code>-100 &lt;= Node.val &lt;= 100</code></li>
</ul>

<p>&nbsp;</p>
<strong>Follow up:</strong> Recursive solution is trivial, could you do it iteratively?

## Solutions


### Java

```Java
// @Title: 二叉树的中序遍历 (Binary Tree Inorder Traversal)
// @Author: robert.sunq
// @Date: 2021-06-09 21:46:43
// @Runtime: 1 ms
// @Memory: 36.8 MB

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode p = root;
        while(p != null || !st.isEmpty()){
            while(p != null){
                st.push(p);
                p = p.left;
            }
            if(!st.isEmpty()){
                p = st.pop();
                res.add(p.val);
                p = p.right;
            }
        }

        return res;
    }
}
```



## Related Topics

- [Stack](https://leetcode.cn//tag/stack)
- [Tree](https://leetcode.cn//tag/tree)
- [Depth-First Search](https://leetcode.cn//tag/depth-first-search)
- [Binary Tree](https://leetcode.cn//tag/binary-tree)

## Similar Questions

- [Validate Binary Search Tree](../validate-binary-search-tree/README_EN.md)
- [Binary Tree Preorder Traversal](../binary-tree-preorder-traversal/README_EN.md)
- [Binary Tree Postorder Traversal](../binary-tree-postorder-traversal/README_EN.md)
- [Binary Search Tree Iterator](../binary-search-tree-iterator/README_EN.md)
- [Kth Smallest Element in a BST](../kth-smallest-element-in-a-bst/README_EN.md)
- [Closest Binary Search Tree Value II](../closest-binary-search-tree-value-ii/README_EN.md)
- [Inorder Successor in BST](../inorder-successor-in-bst/README_EN.md)
- [Convert Binary Search Tree to Sorted Doubly Linked List](../convert-binary-search-tree-to-sorted-doubly-linked-list/README_EN.md)
- [Minimum Distance Between BST Nodes](../minimum-distance-between-bst-nodes/README_EN.md)
