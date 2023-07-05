
```
// @Title: 二叉树剪枝 (二叉树剪枝)
// @Author: robert.sunq
// @Date: 2023-07-05 21:57:32
// @Runtime: 0 ms
// @Memory: 39.3 MB

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
    public TreeNode pruneTree(TreeNode root) {
        TreeNode pre = new TreeNode(1);
        pre.left = root;
        dfs(pre, root);

        return pre.left;
    }

    // 后续遍历，最后判断，根需不需要删除
    public void dfs(TreeNode pre, TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root, root.left);
        dfs(root, root.right);
        // 后续遍历，最后判断，根需不需要删除
        if (root.val == 1) {
            return;
        }

        if (root.left == null && root.right == null) {
            if (pre.left == root) {
                pre.left = null;
            } else {
                pre.right = null;
            }
        }
    }
}
