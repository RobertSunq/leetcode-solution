
```
// @Title: 检查平衡性 (Check Balance LCCI)
// @Author: robert.sunq
// @Date: 2021-08-02 23:19:44
// @Runtime: 1 ms
// @Memory: 38.6 MB

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
    public boolean isBalanced(TreeNode root) {
        return recur(root) >-1;
    }
    public int recur(TreeNode root){
        if(root == null) return 0;
        int left = recur(root.left);
        if(left == -1) return -1;
        int right = recur(root.right);
        if(right == -1) return -1;
        return Math.abs(left - right) >1 ? -1:Math.max(left , right) +1;
    }
}
