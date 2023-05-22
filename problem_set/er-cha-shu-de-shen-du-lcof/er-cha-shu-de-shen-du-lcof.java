
```
// @Title: 二叉树的深度 (二叉树的深度 LCOF)
// @Author: robert.sunq
// @Date: 2021-05-30 18:01:24
// @Runtime: 0 ms
// @Memory: 38.4 MB

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
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right)) +1;
    }
}
