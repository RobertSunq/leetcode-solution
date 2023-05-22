
```
// @Title: 从上到下打印二叉树 III (从上到下打印二叉树 III LCOF)
// @Author: robert.sunq
// @Date: 2021-05-27 22:05:55
// @Runtime: 2 ms
// @Memory: 38.9 MB

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode> qu = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root == null ) return res;
        qu.add(root);
        // 用于标记打印方向， false为由左到右
        boolean  flag  = false;
        while(!qu.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            for(int i = qu.size(); i > 0; i--) {
                TreeNode node;
                node = qu.remove();
                temp.add(node.val);
                // 使得放入的顺序与下一行要访问的顺序相反。
                // 有右往左打印， 先放入右节点
                if(flag){
                    if(node.right != null) qu.add(node.right);                      
                    if(node.left != null) qu.add(node.left);
                }else{
                    // 由左到右，先放入左节点
                    if(node.left != null) qu.add(node.left);
                    if(node.right != null) qu.add(node.right);
                }
            }
            flag ^= true;
            res.add(temp);
            // 反转列表
            LinkedList<TreeNode> qu_temp = new LinkedList<>();
            for(TreeNode t:qu){
                qu_temp.addFirst(t);
            }
            qu = qu_temp;
        }
        return res;

    }
}
