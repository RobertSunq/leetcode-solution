
| English | [简体中文](README.md) |

# [236. Lowest Common Ancestor of a Binary Tree](https://leetcode.cn//problems/lowest-common-ancestor-of-a-binary-tree/)

## Description

<p>Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.</p>

<p>According to the <a href="https://en.wikipedia.org/wiki/Lowest_common_ancestor" target="_blank">definition of LCA on Wikipedia</a>: &ldquo;The lowest common ancestor is defined between two nodes <code>p</code> and <code>q</code> as the lowest node in <code>T</code> that has both <code>p</code> and <code>q</code> as descendants (where we allow <b>a node to be a descendant of itself</b>).&rdquo;</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2018/12/14/binarytree.png" style="width: 200px; height: 190px;" />
<pre>
<strong>Input:</strong> root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
<strong>Output:</strong> 3
<strong>Explanation:</strong> The LCA of nodes 5 and 1 is 3.
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2018/12/14/binarytree.png" style="width: 200px; height: 190px;" />
<pre>
<strong>Input:</strong> root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
<strong>Output:</strong> 5
<strong>Explanation:</strong> The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> root = [1,2], p = 1, q = 2
<strong>Output:</strong> 1
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[2, 10<sup>5</sup>]</code>.</li>
	<li><code>-10<sup>9</sup> &lt;= Node.val &lt;= 10<sup>9</sup></code></li>
	<li>All <code>Node.val</code> are <strong>unique</strong>.</li>
	<li><code>p != q</code></li>
	<li><code>p</code> and <code>q</code> will exist in the tree.</li>
</ul>


## Solutions


### Java

```Java
// @Title: 二叉树的最近公共祖先 (Lowest Common Ancestor of a Binary Tree)
// @Author: robert.sunq
// @Date: 2021-06-17 23:12:48
// @Runtime: 7 ms
// @Memory: 40.6 MB

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        // 节点相等 表示当前子树根节点 为当前最近祖先
        if(root.val == p.val || root.val == q.val) return root;
        // 开始分别去左右子树中找
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        // 如果左右子树中没找到，则表面 当前子树中 不含有两个点
        if ( left == null &&  right == null) return null;
        // 如果两个都不为空 则表示两个点在左右子树中  返回根
        else if(left != null && right != null) return root;
        // 否则 就返回 不为空的节点 表示其中一个节点的直系祖先
        return left != null ? left:right; 
    }
}
```



### C++

```C++
// @Title: 二叉树的最近公共祖先 (Lowest Common Ancestor of a Binary Tree)
// @Author: robert.sunq
// @Date: 2020-05-13 12:39:00
// @Runtime: 20 ms
// @Memory: 14.2 MB

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if (root == NULL) return NULL;
        if(root == p) return p;
        if(root == q) return q;

        TreeNode *left = lowestCommonAncestor(root->left,p,q);
        TreeNode *right = lowestCommonAncestor(root->right,p,q);

        if(left == NULL) return right;
        if(right == NULL) return left;
        if(left && right) return root;
        
        return NULL;
    }
};
```



## Related Topics

- [Tree](https://leetcode.cn//tag/tree)
- [Depth-First Search](https://leetcode.cn//tag/depth-first-search)
- [Binary Tree](https://leetcode.cn//tag/binary-tree)

## Similar Questions

- [Lowest Common Ancestor of a Binary Search Tree](../lowest-common-ancestor-of-a-binary-search-tree/README_EN.md)
- [Smallest Common Region](../smallest-common-region/README_EN.md)
