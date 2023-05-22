
```
// @Title: 二叉树中和为某一值的路径 (二叉树中和为某一值的路径 LCOF)
// @Author: robert.sunq
// @Date: 2021-05-27 23:38:55
// @Runtime: 2 ms
// @Memory: 39.1 MB

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
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if(root == null) return res; 
        recur(root,target,0);
        return res;
    }
    void recur(TreeNode root ,int target , int now){
        int sum = root.val+now;
        temp.add(root.val);
        if(sum == target && root.left == null && root.right == null) {
            List<Integer> temp1 = new ArrayList<>();
            // 做深拷贝
            for(Integer i:temp) temp1.add(i);
            // 恢复路径表
            res.add(temp1);

            temp.remove(temp.size()-1);
            return;
        }
        if(root.left != null) recur(root.left,target,sum);
        if(root.right != null) recur(root.right,target,sum);
        // 恢复路径表
        temp.remove(temp.size()-1);
        return;
    }
}
