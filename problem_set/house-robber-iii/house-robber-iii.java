
```
// @Title: 打家劫舍 III (House Robber III)
// @Author: robert.sunq
// @Date: 2021-06-20 00:02:32
// @Runtime: 0 ms
// @Memory: 37.8 MB

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
    public int rob(TreeNode root) {
        int[] res = recur(root);
        return Math.max(res[0],res[1]);
    }

    // [0] 当前节点不偷
    // [1] 当前节点偷
    int[] recur(TreeNode root){
        if(root == null) return new int[2];

        // 左右节点偷到的数值
        int[] left = recur(root.left);
        int[] right = recur(root.right);

        int[] res = new int[2];
        // 当前节点选择不偷的时候
        // 即 左右偷的最大值 要大于当前节点 (下一个节点偷不偷均无影响，所以是其中的最大值)
        res[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        // 偷当前节点的时候
        // 当前的金额 加上  左右子树中 不偷盗的金额
        res[1] = root.val + left[0] + right[0];
        return res;
    }
}
