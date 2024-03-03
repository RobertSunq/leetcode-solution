
```
// @Title: 二叉树中的伪回文路径 (Pseudo-Palindromic Paths in a Binary Tree)
// @Author: robert.sunq
// @Date: 2023-11-25 19:59:01
// @Runtime: 18 ms
// @Memory: 68 MB

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
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] count = new int[10];
        return dfs(root, count);
    }

    private boolean isPalindromic(int[] count) {
        int single = 0;
        for (int i : count) {
            if (i % 2 == 1) {
                single++;
            }
        }
        return single < 2;
    }


    private int dfs(TreeNode root, int[] count) {
        if (root == null) {
            return 0;
        }

        count[root.val]++;

        int ans = 0;
        if (root.left == null && root.right == null) {
            if (isPalindromic(count)) {
                ans = 1;
            }
        } else {
            ans = dfs(root.left, count) + dfs(root.right, count); 
        }
        count[root.val]--;
        return ans;
    }
}
