
```
// @Title: 从上到下打印二叉树 (从上到下打印二叉树 LCOF)
// @Author: robert.sunq
// @Date: 2021-05-27 21:22:12
// @Runtime: 1 ms
// @Memory: 38.8 MB

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
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(root);
        List<Integer> result = new ArrayList<>();
        TreeNode p = new TreeNode(0);
        while(!queue.isEmpty()){
            p = queue.poll();
            result.add(p.val);
            if(p.left != null) queue.offer(p.left);
            if(p.right != null) queue.offer(p.right);
        }
        int[] s = new int[result.size()];
        for (int i =0;i<result.size();i++){
            s[i] = result.get(i);
        }
        return s;
    }
}
