
```
// @Title: 路径总和 (Path Sum)
// @Author: robert.sunq
// @Date: 2021-07-06 23:41:55
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // 由于存在节点值存在负的，所以要遍历到每个根节点
        if(root == null) return false;
        // 当值相等的时候，判断当前节点是否相等
        if(root.val == targetSum){
            // 判断是否是叶子
            if(root.left == null && root.right == null){
                return true;
            }
        }
        // 遍历左右子树
        return hasPathSum(root.left,targetSum-root.val) || hasPathSum(root.right,targetSum-root.val);
    }
}
