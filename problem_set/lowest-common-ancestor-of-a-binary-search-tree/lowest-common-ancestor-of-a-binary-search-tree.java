
```
// @Title: 二叉搜索树的最近公共祖先 (Lowest Common Ancestor of a Binary Search Tree)
// @Author: robert.sunq
// @Date: 2021-06-17 23:01:56
// @Runtime: 6 ms
// @Memory: 39.5 MB

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
        int max = Math.max(p.val , q.val);
        int min = Math.min(p.val , q.val);
        // 最大值小于当前，则两个点都在左子树
        if ( max < root.val) return lowestCommonAncestor(root.left , p , q);
        // 最小值大于当前值，则两个点在右侧树
        else if ( min > root.val) return lowestCommonAncestor(root.right , p , q);
        // 两个字在两侧，则当前节点，即为最近祖先
        else return root;
    }
}
