
```
// @Title: 二叉树的右视图 (Binary Tree Right Side View)
// @Author: robert.sunq
// @Date: 2023-09-06 21:39:07
// @Runtime: 1 ms
// @Memory: 39.8 MB

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        int i = 0;
        TreeNode p = root;
        q.offer(p);
        while(!q.isEmpty()){
            i = q.size();
            while(i>0){
                p = q.poll();
                if(p.left != null) q.offer(p.left);
                if(p.right != null) q.offer(p.right);
                i--;
                if(i==0){
                    res.add(p.val);
                }
            }
        }
        return res;
    }
}
