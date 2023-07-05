
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer II 047. 二叉树剪枝](https://leetcode.cn//problems/pOCWxh/)

## 题目描述

<p>给定一个二叉树 <strong>根节点</strong>&nbsp;<code>root</code>&nbsp;，树的每个节点的值要么是 <code>0</code>，要么是 <code>1</code>。请剪除该二叉树中所有节点的值为 <code>0</code> 的子树。</p>

<p>节点 <code>node</code> 的子树为&nbsp;<code>node</code> 本身，以及所有 <code>node</code>&nbsp;的后代。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> [1,null,0,0,1]
<strong>输出: </strong>[1,null,0,null,1] 
<strong>解释:</strong> 
只有红色节点满足条件&ldquo;所有不包含 1 的子树&rdquo;。
右图为返回的答案。

<img alt="" src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/04/06/1028_2.png" style="width:450px" />
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> [1,0,1,0,0,0,1]
<strong>输出: </strong>[1,null,1,null,1]
<strong>解释:</strong> 

<img alt="" src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/04/06/1028_1.png" style="width:450px" />
</pre>

<p><strong>示例 3:</strong></p>

<pre>
<strong>输入:</strong> [1,1,0,1,1,0,1,0]
<strong>输出: </strong>[1,1,0,1,1,null,1]
<strong>解释:</strong> 

<img alt="" src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/04/05/1028.png" style="width:450px" />
</pre>

<p>&nbsp;</p>

<p><strong>提示:</strong></p>

<ul>
	<li>二叉树的节点个数的范围是 <code>[1,200]</code></li>
	<li>二叉树节点的值只会是 <code>0</code> 或 <code>1</code></li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 814&nbsp;题相同：<a href="https://leetcode-cn.com/problems/binary-tree-pruning/">https://leetcode-cn.com/problems/binary-tree-pruning/</a></p>


## 题解


### Java

```Java
// @Title: 二叉树剪枝 (二叉树剪枝)
// @Author: robert.sunq
// @Date: 2023-07-05 21:57:32
// @Runtime: 0 ms
// @Memory: 39.3 MB

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
    public TreeNode pruneTree(TreeNode root) {
        TreeNode pre = new TreeNode(1);
        pre.left = root;
        dfs(pre, root);

        return pre.left;
    }

    // 后续遍历，最后判断，根需不需要删除
    public void dfs(TreeNode pre, TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root, root.left);
        dfs(root, root.right);
        // 后续遍历，最后判断，根需不需要删除
        if (root.val == 1) {
            return;
        }

        if (root.left == null && root.right == null) {
            if (pre.left == root) {
                pre.left = null;
            } else {
                pre.right = null;
            }
        }
    }
}
```



## 相关话题

- [树](https://leetcode.cn//tag/tree)
- [深度优先搜索](https://leetcode.cn//tag/depth-first-search)
- [二叉树](https://leetcode.cn//tag/binary-tree)

## 相似题目



