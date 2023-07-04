
```
// @Title: 往完全二叉树添加节点 (往完全二叉树添加节点)
// @Author: robert.sunq
// @Date: 2023-07-04 23:02:46
// @Runtime: 14 ms
// @Memory: 42.4 MB

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
class CBTInserter {

    Queue<TreeNode> q;
    TreeNode root;
    int n;

    public CBTInserter(TreeNode root) {
        this.q = new ArrayDeque<>();
        this.n = 0;
        TreeNode p;
        TreeNode left, right;
        this.n++;
        q.add(root);
        this.root = root;
        // 广度遍历，遍历每一层
        while (!q.isEmpty()) {
            p = q.peek();
            left = p.left;
            right = p.right;
            // 将一个节点的左右子节点添加到队列
            if (left != null) {
                q.add(left);
                n++;
            }
            if (right != null) {
                q.add(right);
                n++;
            }
            // 左右子节点都有值，表示当前父节点是一个完全节点，可以抛出
            if (left != null && right != null) {
                q.remove();
            }
            // 存在一个子节点为空，则证明是最后一个需要遍历的父节点，同时该父节点不完全
            if (left == null || right == null) {
                break;
            }
        }
    }
    
    public int insert(int v) {
        TreeNode node = new TreeNode(v);
        TreeNode p = q.peek();
        q.add(node);
        if (p.left == null) {
            p.left = node;
            return p.val;
        } else {
            p.right = node;
            // 添加右枝之后，就是完全节点，可以抛出当前父节点了
            q.remove();
        }
        return p.val;
    }
    
    public TreeNode get_root() {
        return this.root;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(v);
 * TreeNode param_2 = obj.get_root();
 */
