
```
// @Title: 二叉搜索树迭代器 (二叉搜索树迭代器)
// @Author: robert.sunq
// @Date: 2023-07-10 23:13:22
// @Runtime: 17 ms
// @Memory: 45.7 MB

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
class BSTIterator {

    private TreeNode cur;
    private Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        cur = root;
        st = new Stack<TreeNode>();
    }
    
    // 类似于使用栈的循环 中序遍历
    public int next() {
        while (cur != null) {
            st.push(cur);
            cur = cur.left;
        }

        cur = st.pop();
        int ans = cur.val;
        cur = cur.right;
        return ans;
    }
    
    public boolean hasNext() {
        return cur != null || !st.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
