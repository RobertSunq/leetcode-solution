
| [English](README_EN.md) | 简体中文 |

# [104. 二叉树的最大深度](https://leetcode.cn//problems/maximum-depth-of-binary-tree/)

## 题目描述

<p>给定一个二叉树，找出其最大深度。</p>

<p>二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。</p>

<p><strong>说明:</strong>&nbsp;叶子节点是指没有子节点的节点。</p>

<p><strong>示例：</strong><br>
给定二叉树 <code>[3,9,20,null,null,15,7]</code>，</p>

<pre>    3
   / \
  9  20
    /  \
   15   7</pre>

<p>返回它的最大深度&nbsp;3 。</p>


## 题解


### Java

```Java
// @Title: 二叉树的最大深度 (Maximum Depth of Binary Tree)
// @Author: robert.sunq
// @Date: 2021-06-14 23:31:14
// @Runtime: 0 ms
// @Memory: 38.2 MB

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
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left) , maxDepth(root.right) ) + 1;
    }
}
```



## 相关话题

- [树](https://leetcode.cn//tag/tree)
- [深度优先搜索](https://leetcode.cn//tag/depth-first-search)
- [广度优先搜索](https://leetcode.cn//tag/breadth-first-search)
- [二叉树](https://leetcode.cn//tag/binary-tree)

## 相似题目


- [平衡二叉树](../balanced-binary-tree/README.md)
- [二叉树的最小深度](../minimum-depth-of-binary-tree/README.md)
- [N 叉树的最大深度](../maximum-depth-of-n-ary-tree/README.md)
