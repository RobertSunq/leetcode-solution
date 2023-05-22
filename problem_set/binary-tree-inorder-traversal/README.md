
| [English](README_EN.md) | 简体中文 |

# [94. 二叉树的中序遍历](https://leetcode.cn//problems/binary-tree-inorder-traversal/)

## 题目描述

<p>给定一个二叉树的根节点 <code>root</code> ，返回 <em>它的 <strong>中序</strong>&nbsp;遍历</em> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/09/15/inorder_1.jpg" style="height: 200px; width: 125px;" />
<pre>
<strong>输入：</strong>root = [1,null,2,3]
<strong>输出：</strong>[1,3,2]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>root = []
<strong>输出：</strong>[]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>root = [1]
<strong>输出：</strong>[1]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li>树中节点数目在范围 <code>[0, 100]</code> 内</li>
	<li><code>-100 &lt;= Node.val &lt;= 100</code></li>
</ul>

<p>&nbsp;</p>

<p><strong>进阶:</strong>&nbsp;递归算法很简单，你可以通过迭代算法完成吗？</p>


## 题解


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



## 相关话题

- [栈](https://leetcode.cn//tag/stack)
- [树](https://leetcode.cn//tag/tree)
- [深度优先搜索](https://leetcode.cn//tag/depth-first-search)
- [二叉树](https://leetcode.cn//tag/binary-tree)

## 相似题目


- [验证二叉搜索树](../validate-binary-search-tree/README.md)
- [二叉树的前序遍历](../binary-tree-preorder-traversal/README.md)
- [二叉树的后序遍历](../binary-tree-postorder-traversal/README.md)
- [二叉搜索树迭代器](../binary-search-tree-iterator/README.md)
- [二叉搜索树中第K小的元素](../kth-smallest-element-in-a-bst/README.md)
- [最接近的二叉搜索树值 II](../closest-binary-search-tree-value-ii/README.md)
- [二叉搜索树中的中序后继](../inorder-successor-in-bst/README.md)
- [将二叉搜索树转化为排序的双向链表](../convert-binary-search-tree-to-sorted-doubly-linked-list/README.md)
- [二叉搜索树节点最小距离](../minimum-distance-between-bst-nodes/README.md)
