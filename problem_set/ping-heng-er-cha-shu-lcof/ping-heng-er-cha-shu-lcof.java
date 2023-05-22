
```
// @Title: 平衡二叉树 (平衡二叉树 LCOF)
// @Author: robert.sunq
// @Date: 2021-05-30 18:00:15
// @Runtime: 1 ms
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
    public boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }

    int recur(TreeNode root){
        // 叶子节点
        if(root == null) return 0;
        int left = recur(root.left);
        if ( left == -1) return -1;
        int right = recur(root.right);
        if(right == -1) return -1;
        // 两颗子树的深度差大于 1 则返回-1
        return Math.abs(left - right) > 1? -1:Math.max(left,right) + 1;
    }
}
