
```
// @Title: 从前序与中序遍历序列构造二叉树 (Construct Binary Tree from Preorder and Inorder Traversal)
// @Author: robert.sunq
// @Date: 2021-06-14 23:58:26
// @Runtime: 3 ms
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

    Map<Integer,Integer> mp = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode();
        if(preorder.length <=0) return null;
        // 创造数值与坐标的映射关系，因为不存在相同元素，若存在可以在迭代中查找
        for(int i=0;i<inorder.length;i++){
            mp.put(inorder[i],i);
        }
        return recur(preorder,inorder,0,0,inorder.length-1);

    }

    /**
    * rootIndex   中序遍历中 根节点位置
    * inorStart   前序遍历中 当前子树起点
    * inorEnd     前序遍历中 前端子树终点
     */
    TreeNode recur(int[] preorder,int[] inorder, int rootIndex,int inorStart,int inorEnd){
        if(rootIndex >= preorder.length || inorStart > inorEnd) return null;
        // 当前的根节点
        TreeNode root = new TreeNode(preorder[rootIndex]);
        // 前序中根节点 在中序中的位置
        int inorIndex = mp.get(preorder[rootIndex]);
        // 左子树
        root.left = recur(preorder,inorder,rootIndex+1,inorStart,inorIndex-1);
        // 右子树
        root.right = recur(preorder,inorder,rootIndex+(inorIndex-inorStart)+1 , inorIndex+1,inorEnd);

        return root;
    }
}
