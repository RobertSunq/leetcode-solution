
```
// @Title: 二叉树的直径 (Diameter of Binary Tree)
// @Author: robert.sunq
// @Date: 2021-06-21 23:45:06
// @Runtime: 26 ms
// @Memory: 38.2 MB

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
    int deep = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        // recur(root);
        // return deep;

        //  这种方法的弊端是进行了多次重复计算，可以将子树的计算放入迭代中，将最大值设置为类变量即可
        // 左子树中的路径
        int left = diameterOfBinaryTree(root.left);
        // 右子树中的路径
        int right = diameterOfBinaryTree(root.right);
        // 和穿过根的路径最大值， 不加一，是因为路径，是节点数 -1
        return Math.max(recur(root.left) + recur(root.right) , Math.max(left,right)) ;
    }

    int recur(TreeNode root){
        if(root == null) return 0;
        // 左右子树中的最深度
        int left = recur(root.left);
        int right = recur(root.right);
        // deep 保存迭代中遇到的树的 最大路径
        deep = Math.max(deep,left+right);
        // 返回树的深度
        return Math.max(left, right) +1;
    }
}
