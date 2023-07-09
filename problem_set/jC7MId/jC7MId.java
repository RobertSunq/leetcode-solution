
```
// @Title: 节点之和最大的路径 (节点之和最大的路径)
// @Author: robert.sunq
// @Date: 2023-07-09 22:30:39
// @Runtime: 1 ms
// @Memory: 42 MB

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

    // 记录和
    private int sum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return sum;
    }


    // 返回以当前节点  包含当前节点的  包含左右子树中一棵或者都不包含的最大值
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 遍历左子树，返回其单支最大值
        int left = dfs(root.left);
        // 遍历右子树， 返回其单只最大值
        int right = dfs(root.right);

        // 当前树中的最大路径和
        // 左右子树已经计算过最大值了，不用单独计算

        // 包含根节点和左右子树的最大值
        sum = Math.max(sum, left + right + root.val);
        // 左边树最大值
        sum = Math.max(sum, left + root.val);
        // 右边树最大值
        sum = Math.max(sum, right + root.val);
        // 或者只有当前节点
        sum = Math.max(sum, root.val);

        int rightSum = right + root.val;
        int leftSum = left + root.val;

        // 根节点的值 大于 从根节点到左右树某节点的最大值，则返回根节点值，为当前树的单支最大值
        if (root.val >= rightSum && root.val >= leftSum) {
            return root.val;
        }
        // 否则，返回包含根节点的左右子树之一
        return Math.max(rightSum, leftSum);
    }
}
