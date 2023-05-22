
```
// @Title: 把二叉搜索树转换为累加树 (Convert BST to Greater Tree)
// @Author: robert.sunq
// @Date: 2021-06-21 23:23:23
// @Runtime: 3 ms
// @Memory: 38.9 MB

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
    public TreeNode convertBST(TreeNode root) {
        if(root == null) return null;
        int res = 0;
        Stack<TreeNode> st = new Stack<>();
        TreeNode p = root;
        while(!st.isEmpty() || p != null){
            // 右节点一次进入树
            while(p != null){
                st.push(p);
                p = p.right;
            }
            if(!st.isEmpty()){
                // 访问当前顶
                p = st.pop();
                res = res + p.val;
                p.val = res;
                // 开始进入左子树
                p = p.left;
            }
        }
        return root;
    }
}
