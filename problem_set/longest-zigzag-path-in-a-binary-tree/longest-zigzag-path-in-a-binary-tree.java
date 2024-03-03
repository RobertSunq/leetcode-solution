
```
// @Title: 二叉树中的最长交错路径 (Longest ZigZag Path in a Binary Tree)
// @Author: robert.sunq
// @Date: 2023-09-05 22:48:54
// @Runtime: 6 ms
// @Memory: 51.9 MB

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
    public int longestZigZag(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int ans = 0;
        ans = Math.max(ans, dfs(root.left, 1, true));
        ans = Math.max(ans, dfs(root.right, 1, false));

        return ans;
    }


    public int dfs(TreeNode root, int count, boolean isLeftChild) {
        if (root == null) {
            return 0;
        }
        int ans = 0;
        // 当前节点的交错长度，是上一个发下来的长度 + 1
        ans = Math.max(ans, count);

        // 是上一个左子树，则当前节点的下一个交错节点是当前的右
        if (isLeftChild) {
            ans = Math.max(ans, dfs(root.left, 1, true));
            ans = Math.max(ans, dfs(root.right, count + 1, false));
        } else {
            ans = Math.max(ans, dfs(root.left, count + 1, true));
            ans = Math.max(ans, dfs(root.right, 1, false));
        }

        return ans;
    }
}
