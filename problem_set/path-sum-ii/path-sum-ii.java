
```
// @Title: 路径总和 II (Path Sum II)
// @Author: robert.sunq
// @Date: 2021-07-08 22:25:35
// @Runtime: 1 ms
// @Memory: 38.7 MB

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

    List<List<Integer>> res;
    List<Integer> temp;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();
        temp = new ArrayList<>();
        recur(root,targetSum);
        return res;
    }
    void recur(TreeNode root,int targetSum){
        if(root == null) return ;
        temp.add(root.val);
        if(root.val == targetSum){
            // 如果是根节点
            if(root.left == null && root.right == null){
                // 注意 此处为new一个新的，做深拷贝
                res.add(new ArrayList<Integer>(temp));
            }
        }
        // 遍历访问左右节点
        recur(root.left,targetSum-root.val);
        recur(root.right,targetSum-root.val);
        // 从路径表中删除当前节点
        temp.remove(temp.size()-1);
    }
}
