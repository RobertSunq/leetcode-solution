
```
// @Title: 二叉搜索树的第k大节点 (二叉搜索树的第k大节点  LCOF)
// @Author: robert.sunq
// @Date: 2021-05-30 17:31:51
// @Runtime: 1 ms
// @Memory: 38.3 MB

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
    public int kthLargest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();
        if (root == null) return -1;
        TreeNode p = root;
        while(p!=null || !st.isEmpty()){
            while(p != null){
                st.push(p);
                p = p.right;
            }
            if(!st.isEmpty()){
                p = st.pop();
                k--;
                if(k == 0){
                    return p.val;
                }
                p = p.left;
            }
        }
        return -1;
    }
}
