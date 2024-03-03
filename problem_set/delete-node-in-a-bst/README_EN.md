
| English | [简体中文](README.md) |

# [450. Delete Node in a BST](https://leetcode.cn//problems/delete-node-in-a-bst/)

## Description

<p>Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return <em>the <strong>root node reference</strong> (possibly updated) of the BST</em>.</p>

<p>Basically, the deletion can be divided into two stages:</p>

<ol>
	<li>Search for a node to remove.</li>
	<li>If the node is found, delete the node.</li>
</ol>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/09/04/del_node_1.jpg" style="width: 800px; height: 214px;" />
<pre>
<strong>Input:</strong> root = [5,3,6,2,4,null,7], key = 3
<strong>Output:</strong> [5,4,6,2,null,null,7]
<strong>Explanation:</strong> Given key to delete is 3. So we find the node with value 3 and delete it.
One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
Please notice that another valid answer is [5,2,6,null,4,null,7] and it&#39;s also accepted.
<img alt="" src="https://assets.leetcode.com/uploads/2020/09/04/del_node_supp.jpg" style="width: 350px; height: 255px;" />
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> root = [5,3,6,2,4,null,7], key = 0
<strong>Output:</strong> [5,3,6,2,4,null,7]
<strong>Explanation:</strong> The tree does not contain a node with value = 0.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> root = [], key = 0
<strong>Output:</strong> []
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[0, 10<sup>4</sup>]</code>.</li>
	<li><code>-10<sup>5</sup> &lt;= Node.val &lt;= 10<sup>5</sup></code></li>
	<li>Each node has a <strong>unique</strong> value.</li>
	<li><code>root</code> is a valid binary search tree.</li>
	<li><code>-10<sup>5</sup> &lt;= key &lt;= 10<sup>5</sup></code></li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong> Could you solve it with time complexity <code>O(height of tree)</code>?</p>


## Solutions


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



## Related Topics

- [Tree](https://leetcode.cn//tag/tree)
- [Binary Search Tree](https://leetcode.cn//tag/binary-search-tree)
- [Binary Tree](https://leetcode.cn//tag/binary-tree)

## Similar Questions

- [Split BST](../split-bst/README_EN.md)
