
| [English](README_EN.md) | 简体中文 |

# [700. 二叉搜索树中的搜索](https://leetcode.cn//problems/search-in-a-binary-search-tree/)

## 题目描述

<p>给定二叉搜索树（BST）的根节点<meta charset="UTF-8" />&nbsp;<code>root</code>&nbsp;和一个整数值<meta charset="UTF-8" />&nbsp;<code>val</code>。</p>

<p>你需要在 BST 中找到节点值等于&nbsp;<code>val</code>&nbsp;的节点。 返回以该节点为根的子树。 如果节点不存在，则返回<meta charset="UTF-8" />&nbsp;<code>null</code>&nbsp;。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2021/01/12/tree1.jpg" style="height: 179px; width: 250px;" /><meta charset="UTF-8" /></p>

<pre>
<b>输入：</b>root = [4,2,7,1,3], val = 2
<b>输出：</b>[2,1,3]
</pre>

<p><strong>示例 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/12/tree2.jpg" style="height: 179px; width: 250px;" />
<pre>
<b>输入：</b>root = [4,2,7,1,3], val = 5
<b>输出：</b>[]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li>树中节点数在&nbsp;<code>[1, 5000]</code>&nbsp;范围内</li>
	<li><code>1 &lt;= Node.val &lt;= 10<sup>7</sup></code></li>
	<li><code>root</code>&nbsp;是二叉搜索树</li>
	<li><code>1 &lt;= val &lt;= 10<sup>7</sup></code></li>
</ul>


## 题解


### Java

```Java
// @Title: 二叉搜索树中的搜索 (Search in a Binary Search Tree)
// @Author: robert.sunq
// @Date: 2023-09-07 21:46:01
// @Runtime: 0 ms
// @Memory: 43.2 MB

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
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
}
```



## 相关话题

- [树](https://leetcode.cn//tag/tree)
- [二叉搜索树](https://leetcode.cn//tag/binary-search-tree)
- [二叉树](https://leetcode.cn//tag/binary-tree)

## 相似题目


- [最接近的二叉搜索树值](../closest-binary-search-tree-value/README.md)
- [二叉搜索树中的插入操作](../insert-into-a-binary-search-tree/README.md)