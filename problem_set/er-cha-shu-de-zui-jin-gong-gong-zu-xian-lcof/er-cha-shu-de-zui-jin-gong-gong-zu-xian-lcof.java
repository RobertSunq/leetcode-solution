
```
// @Title: 二叉树的最近公共祖先 (二叉树的最近公共祖先 LCOF)
// @Author: robert.sunq
// @Date: 2021-05-31 23:05:31
// @Runtime: 8 ms
// @Memory: 39.7 MB

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
        // 如果root为空返回空。
        if (root == null) return null;
        // 如果等于根 则表示找到一个节点的祖先
        if (root.val == p.val || root.val == q.val) return root;
        // 否则在子树中进行查找

        // 后序遍历，即最后访问根节点
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        // 如果 左右中均不存在，则证明两节点不在该子树中
        if(right == null && left == null) return null;
        // 如果同时不为空则证明在左右子树中
        if(right != null && left != null) return root;
        // 如果左子树返回为空,右不为空，则证明在其中一点在左子树中，或者返回的时两棵树的最进父节点
        if(left == null) return right;
        // 右子树返回同理
        return left;
    }
}
