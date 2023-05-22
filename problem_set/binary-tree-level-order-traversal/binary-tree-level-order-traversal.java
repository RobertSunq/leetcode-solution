
```
// @Title: 二叉树的层序遍历 (Binary Tree Level Order Traversal)
// @Author: robert.sunq
// @Date: 2021-06-14 23:25:23
// @Runtime: 2 ms
// @Memory: 38.3 MB

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        List<Integer> temp;
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        int n = 0;
        while(!qu.isEmpty()){
            n = qu.size();
            temp = new ArrayList<>();
            while(n>0){
                n--;
                TreeNode t = qu.poll();
                temp.add(t.val);
                if(t.left != null) qu.offer(t.left);
                if(t.right != null) qu.offer(t.right);
            }
            res.add(temp);
        }
        return res;
    }
}
