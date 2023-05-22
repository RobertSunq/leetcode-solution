
```
// @Title: 路径总和 III (Path Sum III)
// @Author: robert.sunq
// @Date: 2021-06-21 00:10:47
// @Runtime: 28 ms
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
    int num=0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return num;
        // 从当前结点开始访问，查找有多少个符合要求的路径
        recur(root,targetSum);
        // 由于不需要从根节点开始，所以要去其左右子树种继续查找
        pathSum(root.left,targetSum);
        pathSum(root.right,targetSum);

        return num;
    }

    void recur(TreeNode root,int targetSum ){
        if(root == null) return;
        targetSum = targetSum-root.val;
        if(targetSum == 0){
            num++;
        }
        // 由于不是以根节点为结束，所以去左右树种寻找相等路径
        recur(root.left,targetSum);
        recur(root.right,targetSum);
    }
}
