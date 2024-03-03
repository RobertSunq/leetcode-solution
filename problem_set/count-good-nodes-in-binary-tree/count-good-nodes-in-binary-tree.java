
```
// @Title: 统计二叉树中好节点的数目 (Count Good Nodes in Binary Tree)
// @Author: robert.sunq
// @Date: 2023-09-04 20:57:54
// @Runtime: 2 ms
// @Memory: 49.3 MB

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
    public int goodNodes(TreeNode root) {
        int ans = 0;
        if (root == null) {
            return ans;
        }

        return dfs(root, root.val);
    }

    private int dfs(TreeNode root, int i) {
        if (root == null) {
            return 0;
        }
        int ans = 0;
        if (root.val >= i) {
            ans = ans + 1;
            i = root.val;
        }

        ans = ans + dfs(root.left, i);
        ans = ans + dfs(root.right, i);
        return ans;
    }
}
