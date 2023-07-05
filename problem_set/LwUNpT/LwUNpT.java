
```
// @Title: 二叉树最底层最左边的值 (二叉树最底层最左边的值)
// @Author: robert.sunq
// @Date: 2023-07-05 21:37:17
// @Runtime: 1 ms
// @Memory: 42.6 MB

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
    public int findBottomLeftValue(TreeNode root) {
        TreeNode left, right, p;
        Queue<TreeNode> q = new ArrayDeque<>();

        int ans = 0;
        q.offer(root);
        int size = 0;
        while (!q.isEmpty()) {
            size = q.size();
            ans = q.peek().val;
            while (size-- > 0) {
                p = q.poll();
                if (p.left != null) {
                    q.offer(p.left);
                }
                if (p.right != null) {
                    q.offer(p.right);
                }
            }
        }

        return ans;

    }
}
