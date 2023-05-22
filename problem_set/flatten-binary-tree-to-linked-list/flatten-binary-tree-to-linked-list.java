
```
// @Title: 二叉树展开为链表 (Flatten Binary Tree to Linked List)
// @Author: robert.sunq
// @Date: 2021-06-15 00:39:40
// @Runtime: 2 ms
// @Memory: 37.7 MB

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
    public void flatten(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> st = new Stack<>();
        TreeNode head = new TreeNode();
        // pre 先序遍历的前一节点，p 当前节点
        TreeNode pre = head,p = root;
        st.push(root);
        while(!st.isEmpty() ){
            p = st.pop();
            // 前一个节点的“尾指针”指向当前节点
            pre.right = p;
            pre.left = null;
            // 保存下一轮的当前节点
            pre = pre.right;
            if(p.right != null) st.push(p.right);
            if(p.left != null) st.push(p.left); 
        }
        pre.left = null;

    }
}
