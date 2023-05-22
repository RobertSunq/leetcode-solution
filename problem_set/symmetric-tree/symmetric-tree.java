
```
// @Title: 对称二叉树 (Symmetric Tree)
// @Author: robert.sunq
// @Date: 2021-06-09 23:09:16
// @Runtime: 0 ms
// @Memory: 36.6 MB

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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return recur(root.left,root.right);
    }
    boolean recur(TreeNode left,TreeNode right){
        // 左右子树都为空 则是对称的
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        // 两颗子树当前值相等，才有继续对比的必要
        if(left.val == right.val){
            // 两颗树的左右子树，交叉对比
            return recur(left.left,right.right) && recur(left.right,right.left);
        }else{
            return false;
        }
    }
}
