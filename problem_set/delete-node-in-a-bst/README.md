
| [English](README_EN.md) | 简体中文 |

# [450. 删除二叉搜索树中的节点](https://leetcode.cn//problems/delete-node-in-a-bst/)

## 题目描述

<p>给定一个二叉搜索树的根节点 <strong>root </strong>和一个值 <strong>key</strong>，删除二叉搜索树中的&nbsp;<strong>key&nbsp;</strong>对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。</p>

<p>一般来说，删除节点可分为两个步骤：</p>

<ol>
	<li>首先找到需要删除的节点；</li>
	<li>如果找到了，删除它。</li>
</ol>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<p><img src="https://assets.leetcode.com/uploads/2020/09/04/del_node_1.jpg" style="width: 800px;" /></p>

<pre>
<strong>输入：</strong>root = [5,3,6,2,4,null,7], key = 3
<strong>输出：</strong>[5,4,6,2,null,null,7]
<strong>解释：</strong>给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
另一个正确答案是 [5,2,6,null,4,null,7]。

<img src="https://assets.leetcode.com/uploads/2020/09/04/del_node_supp.jpg" style="width: 350px;" />
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> root = [5,3,6,2,4,null,7], key = 0
<strong>输出:</strong> [5,3,6,2,4,null,7]
<strong>解释:</strong> 二叉树不包含值为 0 的节点
</pre>

<p><strong>示例 3:</strong></p>

<pre>
<strong>输入:</strong> root = [], key = 0
<strong>输出:</strong> []</pre>

<p>&nbsp;</p>

<p><strong>提示:</strong></p>

<ul>
	<li>节点数的范围&nbsp;<code>[0, 10<sup>4</sup>]</code>.</li>
	<li><code>-10<sup>5</sup>&nbsp;&lt;= Node.val &lt;= 10<sup>5</sup></code></li>
	<li>节点值唯一</li>
	<li><code>root</code>&nbsp;是合法的二叉搜索树</li>
	<li><code>-10<sup>5</sup>&nbsp;&lt;= key &lt;= 10<sup>5</sup></code></li>
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong> 要求算法时间复杂度为&nbsp;O(h)，h 为树的高度。</p>


## 题解


### Java

```Java
// @Title: 删除二叉搜索树中的节点 (Delete Node in a BST)
// @Author: robert.sunq
// @Date: 2023-09-07 23:09:04
// @Runtime: 0 ms
// @Memory: 43.9 MB

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
    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) {
            return null;
        }
        // 要删除的节点在左子树
        if (root.val > key) { 
            // 递归的结果就是删除节点后的树，所以连接到左子树，替代现在的数
            root.left = deleteNode(root.left, key);
            // 这里要返回root的原因就在于，删除节点后，返回当前子树的根
            return root;
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        }

        // 表示当前节点就是要删除的节点，返回替代该节点的节点
        if (root.val == key) {
            // 如果一个子节点为空，直接返回另一个子树，其实就是删除节点后的树
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.right == null) {
                return root.left;
            }
            if (root.left == null) {
                return root.right;
            }

            // 都存在时，两个方案，找左子树的最大点，即最右侧的点，
            // 找右子树最小点，即最左侧的点，相对而言，右子树好找点
            TreeNode tmp = root.right;
            // 先序，访问左左侧点
            while (tmp.left != null) {
                tmp = tmp.left;
            }
            // 从右子树中，删除需要拿出来替换的点
            root.right = deleteNode(root.right, tmp.val);

            // 用找到最左侧的点替换当前点
            tmp.right = root.right;
            tmp.left = root.left;

            // 返回当前新的根，提供给上层调用连接
            return tmp;
        }
        return root;
    }
}
```



## 相关话题

- [树](https://leetcode.cn//tag/tree)
- [二叉搜索树](https://leetcode.cn//tag/binary-search-tree)
- [二叉树](https://leetcode.cn//tag/binary-tree)

## 相似题目


- [拆分二叉搜索树](../split-bst/README.md)
