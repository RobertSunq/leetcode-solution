
```
// @Title: 二叉树中的最大路径和 (Binary Tree Maximum Path Sum)
// @Author: robert.sunq
// @Date: 2021-07-11 21:53:29
// @Runtime: 0 ms
// @Memory: 40.4 MB

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
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        recur(root);
        return res;

    }
    int recur(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = Math.max(recur(root.left),0);
        int right = Math.max(recur(root.right),0);
        int temp = Math.max(left,right);
        // 最大的路径为，过根节点的左右子树单一路径和加根，或者左右子树中的最大路径即不过根节点
        res = Math.max(res,left+right+root.val);
        return temp+root.val;
    }
}
