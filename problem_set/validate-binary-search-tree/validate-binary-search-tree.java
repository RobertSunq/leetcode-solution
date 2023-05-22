
```
// @Title: 验证二叉搜索树 (Validate Binary Search Tree)
// @Author: robert.sunq
// @Date: 2021-06-09 23:00:03
// @Runtime: 3 ms
// @Memory: 38.1 MB

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
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        Stack<TreeNode> st = new Stack<>();
        TreeNode p = root;
        TreeNode pre = null;
        while(p != null || !st.isEmpty()){
            while(p != null){
                st.push(p);
                p = p.left;
            }
            if(!st.isEmpty()){
                p = st.pop();
                if(pre != null){
                    if(pre.val >= p.val) return false;
                }
                pre = p;
                p = p.right;
            }
        }

        return true;
    }
}
