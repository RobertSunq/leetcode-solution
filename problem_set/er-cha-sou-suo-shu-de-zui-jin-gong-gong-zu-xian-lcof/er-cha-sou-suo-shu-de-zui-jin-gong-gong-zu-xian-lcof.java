
```
// @Title: 二叉搜索树的最近公共祖先 (二叉搜索树的最近公共祖先 LCOF)
// @Author: robert.sunq
// @Date: 2021-05-31 22:29:27
// @Runtime: 6 ms
// @Memory: 38.6 MB

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
        int max = Math.max(p.val,q.val);
        int min = Math.min(p.val,q.val);
        // 最大值小于根 ，则在左子树中
        if(max < root.val) return lowestCommonAncestor(root.left,p,q);
        // 最小值大于 根，则在右子树中
        else if (min > root.val) return lowestCommonAncestor(root.right,p,q);
        // 否则 当前节点就是所求节点
        return root;
    }
}
