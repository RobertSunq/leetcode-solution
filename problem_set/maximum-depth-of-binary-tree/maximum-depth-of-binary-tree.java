
```
// @Title: 二叉树的最大深度 (Maximum Depth of Binary Tree)
// @Author: robert.sunq
// @Date: 2021-06-14 23:31:14
// @Runtime: 0 ms
// @Memory: 38.2 MB

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
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left) , maxDepth(root.right) ) + 1;
    }
}
