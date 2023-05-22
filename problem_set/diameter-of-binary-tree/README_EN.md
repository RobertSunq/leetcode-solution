
| English | [简体中文](README.md) |

# [543. Diameter of Binary Tree](https://leetcode.cn//problems/diameter-of-binary-tree/)

## Description

<p>Given the <code>root</code> of a binary tree, return <em>the length of the <strong>diameter</strong> of the tree</em>.</p>

<p>The <strong>diameter</strong> of a binary tree is the <strong>length</strong> of the longest path between any two nodes in a tree. This path may or may not pass through the <code>root</code>.</p>

<p>The <strong>length</strong> of a path between two nodes is represented by the number of edges between them.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/06/diamtree.jpg" style="width: 292px; height: 302px;" />
<pre>
<strong>Input:</strong> root = [1,2,3,4,5]
<strong>Output:</strong> 3
<strong>Explanation:</strong> 3 is the length of the path [4,2,1,3] or [5,2,1,3].
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> root = [1,2]
<strong>Output:</strong> 1
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[1, 10<sup>4</sup>]</code>.</li>
	<li><code>-100 &lt;= Node.val &lt;= 100</code></li>
</ul>


## Solutions


### Java

```Java
// @Title: 二叉树的直径 (Diameter of Binary Tree)
// @Author: robert.sunq
// @Date: 2021-06-21 23:45:06
// @Runtime: 26 ms
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
    int deep = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        // recur(root);
        // return deep;

        //  这种方法的弊端是进行了多次重复计算，可以将子树的计算放入迭代中，将最大值设置为类变量即可
        // 左子树中的路径
        int left = diameterOfBinaryTree(root.left);
        // 右子树中的路径
        int right = diameterOfBinaryTree(root.right);
        // 和穿过根的路径最大值， 不加一，是因为路径，是节点数 -1
        return Math.max(recur(root.left) + recur(root.right) , Math.max(left,right)) ;
    }

    int recur(TreeNode root){
        if(root == null) return 0;
        // 左右子树中的最深度
        int left = recur(root.left);
        int right = recur(root.right);
        // deep 保存迭代中遇到的树的 最大路径
        deep = Math.max(deep,left+right);
        // 返回树的深度
        return Math.max(left, right) +1;
    }
}
```



## Related Topics

- [Tree](https://leetcode.cn//tag/tree)
- [Depth-First Search](https://leetcode.cn//tag/depth-first-search)
- [Binary Tree](https://leetcode.cn//tag/binary-tree)

## Similar Questions


