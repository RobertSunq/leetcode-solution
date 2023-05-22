
```
// @Title: 二叉树的锯齿形层序遍历 (Binary Tree Zigzag Level Order Traversal)
// @Author: robert.sunq
// @Date: 2021-06-30 23:22:48
// @Runtime: 1 ms
// @Memory: 38.4 MB

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        int deep = 1;
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        List<Integer> temp = new ArrayList<>();
        // 下一层的遍历顺序与填入的顺序反向访问  正好可以使用栈的特性
        Stack<TreeNode> st1 = new Stack<>(),st2 = new Stack<>();
        TreeNode p;
        st1.push(root);
        // 奇数层
        while(!st1.isEmpty() || !st2.isEmpty()){
            if(deep %2 == 1){
                // 遍历奇数层
                deep++;
                temp = new ArrayList<>();
                while(!st1.isEmpty()){
                    p = st1.pop();
                    temp.add(p.val);
                    // 下一层要从右往左，当前层是从左往右，所有下一层需要 是逆序访问，所有先放入左节点
                    if(p.left != null) st2.push(p.left);
                    if(p.right != null) st2.push(p.right);
                }
                res.add(temp);
            }else{
                // 遍历偶数层
                deep++;
                temp = new ArrayList<>();
                while(!st2.isEmpty()){
                    p = st2.pop();
                    temp.add(p.val);
                    // 下一层要从左往右，当前层是从右往左，所有下一层需要 是逆序访问，所有先放入右节点
                    if(p.right != null) st1.push(p.right);
                    if(p.left != null) st1.push(p.left);
                }
                res.add(temp);
            }

        }
        return res;
    }
}
