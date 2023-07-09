
```
// @Title: 二叉搜索树中的中序后继 (二叉搜索树中的中序后继)
// @Author: robert.sunq
// @Date: 2023-07-09 23:29:09
// @Runtime: 5 ms
// @Memory: 42.9 MB

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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode pre = null;
        TreeNode cur = root;

        // 非递归形式的 中序 dfs 
        while (!st.isEmpty() || cur != null) {
            while(cur != null) {
                st.push(cur);
                cur = cur.left;
            }
            cur = st.pop();
            if (pre == p) {
                return cur;
            }
            pre = cur;
            cur = cur.right;
        }
        return null;
    }
}
