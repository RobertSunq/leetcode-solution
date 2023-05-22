
```
// @Title: 二叉树的镜像 (二叉树的镜像  LCOF)
// @Author: robert.sunq
// @Date: 2021-05-26 23:16:36
// @Runtime: 0 ms
// @Memory: 36.1 MB

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
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null) return null;
        // 直接交换左右子树
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        // 采用递归发遍历
        mirrorTree(root.right);
        mirrorTree(root.left);
        // 返回当前节点
        return root;
    }
}
