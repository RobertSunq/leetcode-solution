
```
// @Title: 二叉树的最近公共祖先 (Lowest Common Ancestor of a Binary Tree)
// @Author: robert.sunq
// @Date: 2023-09-06 21:36:53
// @Runtime: 6 ms
// @Memory: 42.3 MB

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

        // **** 本质上，这里是通过判断左右子树中返回的是否为null，判断节点是否在其中的子树中。

        // 如果左右子树中没找到，则表面 当前子树中 不含有两个点
        if ( left == null &&  right == null) return null;

        // 如果两个都不为空 则表示两个点在左右子树中  返回根
        else if(left != null && right != null) return root;

        // 否则 就返回 不为空的节点 表示其中一个节点的直系祖先
        // 注意，这里返回递归的结果，如果两个节点在当前子树中，这里拿到是 在一个子树中找到的根
        // 如果只有一个不为空，则说明有一个节点，在其中一棵树中，这里拿到的就是节点本身，
        // 递归返回后，不为null 证明节点在子树中
        return left != null ? left:right; 
    }
}
