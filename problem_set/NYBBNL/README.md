
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer II 052. 展平二叉搜索树](https://leetcode.cn//problems/NYBBNL/)

## 题目描述

<p>给你一棵二叉搜索树，请&nbsp;<strong>按中序遍历</strong> 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2020/11/17/ex1.jpg" style="width: 600px; height: 350px;" /></p>

<pre>
<strong>输入：</strong>root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
<strong>输出：</strong>[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
</pre>

<p><strong>示例 2：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2020/11/17/ex2.jpg" style="width: 300px; height: 114px;" /></p>

<pre>
<strong>输入：</strong>root = [5,1,7]
<strong>输出：</strong>[1,null,5,null,7]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li>树中节点数的取值范围是 <code>[1, 100]</code></li>
	<li><code>0 &lt;= Node.val &lt;= 1000</code></li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 897&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/increasing-order-search-tree/">https://leetcode-cn.com/problems/increasing-order-search-tree/</a></p>


## 题解


### Java

```Java
// @Title: 展平二叉搜索树 (展平二叉搜索树)
// @Author: robert.sunq
// @Date: 2023-07-09 22:54:12
// @Runtime: 0 ms
// @Memory: 38.7 MB

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

    TreeNode head = null;
    // 尾节点
    TreeNode tail = null;
    public TreeNode increasingBST(TreeNode root) {
        dfs(root);

        return head;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        // 中序遍历
        dfs(root.left);
        
        // 暂存右节点，避免丢失
        TreeNode right = root.right;
        if (head == null) {
            head = root;
            tail = root;
            tail.right = null;
        } else {
            root.left = null;
            root.right = null;
            tail.right = root;
            tail = root;
        }

        // 注意，这里使用的时之前缓存的节点信息
        dfs(right);
    }
}
```



## 相关话题

- [栈](https://leetcode.cn//tag/stack)
- [树](https://leetcode.cn//tag/tree)
- [深度优先搜索](https://leetcode.cn//tag/depth-first-search)
- [二叉搜索树](https://leetcode.cn//tag/binary-search-tree)
- [二叉树](https://leetcode.cn//tag/binary-tree)

## 相似题目



