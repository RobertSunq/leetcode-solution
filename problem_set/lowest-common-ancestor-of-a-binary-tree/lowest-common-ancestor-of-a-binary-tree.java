
```
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
