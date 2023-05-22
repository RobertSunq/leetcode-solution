
```
// @Title: 重建二叉树 (重建二叉树 LCOF)
// @Author: robert.sunq
// @Date: 2023-02-05 23:56:17
// @Runtime: 3 ms
// @Memory: 41.5 MB

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return builder(preorder, inorder, 0, 0, preorder.length);
    }

    /** 
    左闭右开
     */
    public TreeNode builder(int[] preorder, int[] inorder,int preIndex, int inorLeft, int inorRight) {
        if (inorLeft >= inorRight) {
            return null;
        }
        TreeNode head = new TreeNode(preorder[preIndex]);
        int inorHeadIndex = inorLeft;
        for (int i = inorLeft; i < inorRight; i++) {
            if (inorder[i] == preorder[preIndex]) {
                inorHeadIndex = i;
                break;
            }
        }
        TreeNode left = builder(preorder, inorder, preIndex + 1, inorLeft, inorHeadIndex);
        TreeNode right = builder(preorder, inorder, preIndex + (inorHeadIndex - inorLeft) + 1,inorHeadIndex + 1, inorRight);
        head.left = left;
        head.right = right;
        return head;
    }
}
