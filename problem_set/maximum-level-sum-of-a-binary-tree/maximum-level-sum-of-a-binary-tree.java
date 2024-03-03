
```
// @Title: 最大层内元素和 (Maximum Level Sum of a Binary Tree)
// @Author: robert.sunq
// @Date: 2023-09-06 21:52:27
// @Runtime: 9 ms
// @Memory: 45.1 MB

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
    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int layout = 1;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int ans = 0;
        long max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            int i = queue.size();
            long tmp = 0;
            while (i-->0) {
                TreeNode p = queue.poll();
                tmp = tmp + p.val;
                if (p.left != null) {
                    queue.add(p.left);
                }
                if (p.right != null) {
                    queue.add(p.right);
                }
            }

            if (tmp > max) {
                ans = layout;
                max = tmp;
            }
            layout++;
        }

        return ans;
    }
}
