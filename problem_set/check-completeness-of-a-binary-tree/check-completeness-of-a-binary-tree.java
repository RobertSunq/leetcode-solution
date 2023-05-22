
```
// @Title: 二叉树的完全性检验 (Check Completeness of a Binary Tree)
// @Author: robert.sunq
// @Date: 2021-07-11 22:59:56
// @Runtime: 1 ms
// @Memory: 37.5 MB

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
    public boolean isCompleteTree(TreeNode root) {
        if(root == null) return true;
        // 表示未出现空
        boolean flag = true;
        Queue<TreeNode> qu = new LinkedList<TreeNode>();
        qu.offer(root);
        while(!qu.isEmpty()){
            // 第一个子节点为空后，后面不能再出现子节点
            TreeNode temp = qu.poll();
            if(temp.left== null){
                flag = false;
            }else{
                // 如果前面已经出现了空，则后面的节点存在子，则肯定不为完全
                if(flag){
                    qu.offer(temp.left);
                }else{
                    return false;
                }
            }
            if(temp.right == null){
                flag = false;
            }else{
               // 如果前面已经出现了空，则后面的节点存在子，则肯定不为完全
               if(flag){
                   qu.offer(temp.right);
               }else{
                   return false;
               }
            }
        }
        return true;
    }
}
