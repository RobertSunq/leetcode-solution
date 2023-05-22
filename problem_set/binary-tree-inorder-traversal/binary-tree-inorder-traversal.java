
```
// @Title: 二叉树的中序遍历 (Binary Tree Inorder Traversal)
// @Author: robert.sunq
// @Date: 2021-06-09 21:46:43
// @Runtime: 1 ms
// @Memory: 36.8 MB

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode p = root;
        while(p != null || !st.isEmpty()){
            while(p != null){
                st.push(p);
                p = p.left;
            }
            if(!st.isEmpty()){
                p = st.pop();
                res.add(p.val);
                p = p.right;
            }
        }

        return res;
    }
}
