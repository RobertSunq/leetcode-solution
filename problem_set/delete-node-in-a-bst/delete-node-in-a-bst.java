
```
// @Title: 删除二叉搜索树中的节点 (Delete Node in a BST)
// @Author: robert.sunq
// @Date: 2023-09-07 23:09:04
// @Runtime: 0 ms
// @Memory: 43.9 MB

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
    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) {
            return null;
        }
        // 要删除的节点在左子树
        if (root.val > key) { 
            // 递归的结果就是删除节点后的树，所以连接到左子树，替代现在的数
            root.left = deleteNode(root.left, key);
            // 这里要返回root的原因就在于，删除节点后，返回当前子树的根
            return root;
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        }

        // 表示当前节点就是要删除的节点，返回替代该节点的节点
        if (root.val == key) {
            // 如果一个子节点为空，直接返回另一个子树，其实就是删除节点后的树
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.right == null) {
                return root.left;
            }
            if (root.left == null) {
                return root.right;
            }

            // 都存在时，两个方案，找左子树的最大点，即最右侧的点，
            // 找右子树最小点，即最左侧的点，相对而言，右子树好找点
            TreeNode tmp = root.right;
            // 先序，访问左左侧点
            while (tmp.left != null) {
                tmp = tmp.left;
            }
            // 从右子树中，删除需要拿出来替换的点
            root.right = deleteNode(root.right, tmp.val);

            // 用找到最左侧的点替换当前点
            tmp.right = root.right;
            tmp.left = root.left;

            // 返回当前新的根，提供给上层调用连接
            return tmp;
        }
        return root;
    }
}
