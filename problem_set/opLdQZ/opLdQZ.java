
```
// @Title: 二叉搜索树中两个节点之和 (二叉搜索树中两个节点之和)
// @Author: robert.sunq
// @Date: 2023-07-10 23:22:18
// @Runtime: 7 ms
// @Memory: 42.6 MB

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
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        List<Integer> list = new ArrayList<>();

        TreeNode cur = root;
        Stack<TreeNode> st = new Stack<>();
        while (cur != null || !st.isEmpty()) {
            while (cur != null) {
                st.push(cur);
                cur = cur.left;
            }
            cur = st.pop();
            list.add(cur.val);
            cur = cur.right;
        }

        int i = 0;
        int j = list.size() - 1;
        int tmp;
        while (i < j) {
            tmp = list.get(i) + list.get(j);
            if (tmp == k) {
                return true;
            } else if (tmp > k) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
