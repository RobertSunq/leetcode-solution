
```
// @Title: 平衡二叉树 (Balanced Binary Tree)
// @Author: robert.sunq
// @Date: 2021-08-01 20:21:50
// @Runtime: 0 ms
// @Memory: 38.3 MB

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
    public boolean isBalanced(TreeNode root) {
        return recur(root) != -1;

    }

    public int recur(TreeNode root){
        if(root == null) return 0;
        int left = recur(root.left);
        if(left == -1) return -1;
        int right = recur(root.right);
        if(right == -1) return -1;
        return Math.abs(left -right) < 2? Math.max(left,right)+1:-1;
    }
}
